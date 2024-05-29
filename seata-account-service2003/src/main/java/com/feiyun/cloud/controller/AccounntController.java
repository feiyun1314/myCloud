package com.feiyun.cloud.controller;

import com.feiyun.cloud.resp.ResultData;
import com.feiyun.cloud.services.AccountService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author feiyun
 * @date 2024/5/27 17:47
 * @explain
 */

@Slf4j
@RestController
public class AccounntController {

    @Resource
    private AccountService accountService;

    @PostMapping("/account/decrease")
    public ResultData decrease(@RequestParam("userId") Long userId, @RequestParam("money") Long money){
        accountService.decrease(userId, money);
        return ResultData.success("扣减账户余额成功!");
    }
}
