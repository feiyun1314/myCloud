package com.feiyun.cloud.service;

import com.feiyun.cloud.entities.Order;

/**
 * TODO
 *
 * @author feiyun
 * @date 2024/5/27 16:57
 * @explain
 */
public interface OrderService {

    /**
     * 创建订单
     *
     * @param order
     */
    void create(Order order);
}
