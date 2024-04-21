package com.feiyun.cloud.controller;

import com.feiyun.cloud.entities.PayDTO;
import com.feiyun.cloud.resp.ResultData;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * TODO
 *
 * @author feiyun
 * @date 2024/4/21 1:15
 * @explain
 */
@RestController
public class OrderController {

/*
    public static final String PaymentSrv_URL ="http://localhost:8001";  //先写死，硬编码
*/

    public static final String PaymentSrv_URL = "http://cloud-payment-service";//服务注册中心上的微服务名称


    @Resource
    private RestTemplate restTemplate;

    //新增
    @GetMapping(value = "/consumer/pay/add")
    public ResultData addOrder(@RequestBody PayDTO payDTO){
       return restTemplate.postForObject(PaymentSrv_URL+"/pay/add",payDTO,ResultData.class);
    }

    //查询
    @GetMapping(value = "/consumer/pay/get/{id}")
    public  ResultData getPayInfo(@PathVariable("id") Integer id){
        return  restTemplate.getForObject(PaymentSrv_URL+"/pay/get/"+id,ResultData.class,id);
    }

    //删除

    @DeleteMapping(value = "/consumer/pay/delete/{id}")
    public ResultData deletePayById(@PathVariable("id") Integer id){
        restTemplate.delete(PaymentSrv_URL+"/pay/delete/"+id, id);
        return  ResultData.success("删除成功");
    }
    //修改
    @PutMapping(value = "/consumer/pay/update")
    public  ResultData updatePay(@RequestBody PayDTO payDTO){
         restTemplate.put(PaymentSrv_URL+"/pay/update",payDTO);
         return ResultData.success("修改成功");
    }
}
