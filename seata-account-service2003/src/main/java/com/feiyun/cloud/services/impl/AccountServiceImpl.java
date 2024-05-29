package com.feiyun.cloud.services.impl;

import com.feiyun.cloud.mapper.AccountMapper;
import com.feiyun.cloud.services.AccountService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * TODO
 *
 * @author feiyun
 * @date 2024/5/27 17:44
 * @explain
 */

@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountMapper accountMapper;

    @Override
    public void decrease(Long userId, Long money) {
        log.info("------->account-service中扣减账户余额开始");

        accountMapper.decrease(userId,money);

        //openFegin自动超时时间为60s  设置超时
        //myTimeOut();
        //int age = 10/0;
        log.info("------->account-service中扣减账户余额结束");

    }


    /**
     * 模拟超时异常，全局事务回滚
     */
    private static void myTimeOut()
    {
        try { TimeUnit.SECONDS.sleep(65); } catch (InterruptedException e) { e.printStackTrace(); }
    }


}
