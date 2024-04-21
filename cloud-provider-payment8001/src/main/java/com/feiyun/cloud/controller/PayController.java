package com.feiyun.cloud.controller;

import cn.hutool.core.bean.BeanUtil;
import com.feiyun.cloud.entities.Pay;
import com.feiyun.cloud.entities.PayDTO;
import com.feiyun.cloud.resp.ResultData;
import com.feiyun.cloud.resp.ReturnCodeEnum;
import com.feiyun.cloud.service.impl.PayServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * TODO
 *
 * @author feiyun
 * @date 2024/4/18 15:58
 * @explain
 */
@RestController
@Tag(name = "支付微服务模块",description = "支付CRUD")
public class PayController {


    @Value("${server.port}")
    private  String port;

    @Resource
    private PayServiceImpl payService;

    @Operation(summary = "新增",description = "新增支付流水方法,json串做参数")
    @PostMapping(value = "/pay/add")
    public ResultData<String> addPay(@RequestBody Pay pay){
        System.out.printf(pay.toString());
        int i=payService.add(pay);

        return ResultData.success("成功插入记录，返回值"+i);
    }

    @DeleteMapping(value = "/pay/delete/{id}")
    @Operation(summary = "删除",description = "删除支付流水方法")
    public ResultData<Integer> deletePay(@PathVariable("id") Integer id){
        int i=payService.delete(id);
        return ResultData.success(i);
    }


    @PutMapping(value = "/pay/update")
    @Operation(summary = "修改",description = "修改支付流水方法")
    public ResultData<String> updatePay(@RequestBody PayDTO payDTO){
        Pay pay =new Pay();
        BeanUtils.copyProperties(payDTO,pay);

        int i= payService.edit(pay);
        if(i<0){
            return ResultData.fail(ReturnCodeEnum.RC204.getCode(),"修改失败");
        }
        return ResultData.success("成功修改记录，返回值："+i);

    }

    @GetMapping(value = "/pay/get/{id}")
    @Operation(summary = "查询",description = "查询一条支付流水方法")
    public  ResultData<Pay> getById(@PathVariable("id") Integer id){
        if(id <0) {
            throw new RuntimeException("id不能为负数");
        }

        Pay pay = payService.getById(id);
        return ResultData.success(pay);
    }

    @GetMapping(value = "/pay/getAll")
    @Operation(summary = "查询",description = "查询所有支付流水方法")
    public  ResultData<List<Pay>> getAll(){
        List<Pay> pay= payService.getAll();
        return ResultData.success(pay);
    }


    @GetMapping(value = "/pay/error")
    public ResultData<Integer> getPayError(){
        Integer integer = Integer.valueOf(200);
        try{
            System.out.println("come in payerror test");
            int age =10/0;
        }catch (Exception e ) {
            e.printStackTrace();
            return ResultData.fail(ReturnCodeEnum.RC500.getCode(),e.getMessage());
        }
        return ResultData.success(integer);
    }


    @GetMapping(value = "/pay/get/info")
    public String getInfoByConsul(@Value("${atguigu.info}") String atguiguInfo){
        return "atguiguInfo:"+atguiguInfo+"\t"+"port:"+port;
    }
}
