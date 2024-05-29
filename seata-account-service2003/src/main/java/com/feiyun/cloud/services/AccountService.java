package com.feiyun.cloud.services;

/**
 * TODO
 *
 * @author feiyun
 * @date 2024/5/27 17:43
 * @explain
 */
public interface AccountService {
    /**
     * 扣减库存
     */
    void decrease(Long userId, Long money);
}
