package com.feiyun.cloud.controller;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.unit.DataUnit;
import com.feiyun.cloud.apis.PayFeginApi;
import com.feiyun.cloud.entities.PayDTO;
import com.feiyun.cloud.resp.ResultData;
import com.feiyun.cloud.resp.ReturnCodeEnum;
import io.swagger.v3.oas.models.security.SecurityScheme;
import jakarta.annotation.Resource;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * TODO
 *
 * @author feiyun
 * @date 2024/5/34/21 9:23
 * @explain
 */
@RestController
public class OrderController {


    @Resource
    private PayFeginApi payFeginApi;

    @PostMapping(value = "/fegin/pay/add")
    public  ResultData addOrder(@RequestBody PayDTO payDTO){
        System.out.println("第一步：模拟本地addOrder新增订单成功(省略sql操作)，第二步：再开启addPay支付微服务远程调用");
        ResultData resultData = payFeginApi.addPay(payDTO);
        return resultData;
    }

    @GetMapping(value = "/fegin/pay/get/{id}")
    public ResultData getPayInfo(@PathVariable("id") Integer id){
        System.out.println("-------支付微服务远程调用，按照id查询订单支付流水信息");
        ResultData payInfo =null;
        try {
            System.out.println("开始调用----------："+ DateUtil.now());
            payInfo = payFeginApi.getPayInfo(id);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("调用结束：------------"+DateUtil.now());
            ResultData.fail(ReturnCodeEnum.RC500.getCode(), e.getMessage());
        }
        return payInfo;
    }

    /**
     * openfeign天然支持负载均衡演示
     * @return
     */
    @GetMapping(value = "/fegin/pay/mylb")
    public  String mylb(){
        String mylb = payFeginApi.mylb();
        return mylb;
    }
}
