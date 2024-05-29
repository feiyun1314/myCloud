package com.feiyun.cloud.service.impl;

import com.feiyun.cloud.apis.AccountFeignApi;
import com.feiyun.cloud.apis.StorageFeignApi;
import com.feiyun.cloud.entities.Order;
import com.feiyun.cloud.mapper.OrderMapper;
import com.feiyun.cloud.service.OrderService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * TODO
 *
 * @author feiyun
 * @date 2024/5/27 16:57
 * @explain  下订单->减库存->扣余额->改(订单)状态
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Resource     ////订单微服务通过OpenFeign去调用账户微服务
    private AccountFeignApi accountFeignApi;


    @Resource //订单微服务通过OpenFeign去调用库存微服务
    private StorageFeignApi storageFeignApi;


    @GlobalTransactional(name = "zzyy-create-order",rollbackFor = Exception.class)//AT
    @Override
    public void create(Order order) {

        //xis全局事务id的检查，重要
        String xid = RootContext.getXID();

        //1.新建订单
        log.info("==================>开始新建订单"+"\t"+"xid_order:" +xid);
        //订单新建时默认初始化订单为0
        order.setStatus(0);
        int result = orderMapper.insertSelective(order);
        //        //插入订单成功后获得插入mysql的实体对象
        Order orderFromDB=null;
        if(result>0){
            //从Mysql里面查出刚插入的数据
            orderFromDB= orderMapper.selectOne(order);
            log.info("-------> 新建订单成功，orderFromDB info: "+orderFromDB);
            System.out.println();
            //2.扣减库存
            log.info("-------> 订单微服务开始调用Storage库存，做扣减count");

            storageFeignApi.decrease(orderFromDB.getProductId(),orderFromDB.getCount());
            //3.扣减账户余额
            log.info("-------> 订单微服务开始调用Account账号，做扣减money");
            accountFeignApi.decrease(orderFromDB.getUserId(),orderFromDB.getMoney());
            log.info("-------> 订单微服务结束调用Account账号，做扣减完成");
            System.out.println();

            //4.修改订单状态
            //订单状态status：0：创建中；1：已完结
            log.info("-------> 修改订单状态");
            orderFromDB.setStatus(1);

            Example whereCondition=new Example(Order.class);
            Example.Criteria criteria=whereCondition.createCriteria();
            criteria.andEqualTo("userId",orderFromDB.getUserId());
            criteria.andEqualTo("status",0);

            int updateResult = orderMapper.updateByExampleSelective(orderFromDB, whereCondition);

            log.info("-------> 修改订单状态完成"+"\t"+updateResult);
            log.info("-------> orderFromDB info: "+orderFromDB);



        }
        System.out.println();
        log.info("==================>结束新建订单"+"\t"+"xid_order:" +xid);
    }
}
