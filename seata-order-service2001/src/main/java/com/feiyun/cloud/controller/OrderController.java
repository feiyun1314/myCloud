package com.feiyun.cloud.controller;

import com.feiyun.cloud.entities.Order;
import com.feiyun.cloud.resp.ResultData;
import com.feiyun.cloud.service.OrderService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author feiyun
 * @date 2024/5/27 17:13
 * @explain
 */

@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    /**
     * 创建订单
     */
    @GetMapping("/order/create")
    public ResultData create(Order order)
    {
        orderService.create(order);
        return ResultData.success(order);
    }
}
