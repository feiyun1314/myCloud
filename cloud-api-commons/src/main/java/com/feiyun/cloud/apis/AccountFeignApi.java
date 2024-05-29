package com.feiyun.cloud.apis;

import com.feiyun.cloud.resp.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * TODO
 *
 * @author feiyun
 * @date 2024/5/27 16:36
 * @explain
 */
@FeignClient(value = "seata-account-service")
public interface AccountFeignApi {
    //扣减账户余额
    @PostMapping("/account/decrease")
    ResultData decrease(@RequestParam("userId") Long userId, @RequestParam("money") Long money);
}
