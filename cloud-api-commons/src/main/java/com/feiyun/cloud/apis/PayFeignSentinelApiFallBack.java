package com.feiyun.cloud.apis;

import com.feiyun.cloud.resp.ResultData;
import com.feiyun.cloud.resp.ReturnCodeEnum;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author feiyun
 * @date 2024/5/25 17:18
 * @explain 报错异常类
 */
@Component
public class PayFeignSentinelApiFallBack implements PayFeignSentinelApi{
    @Override
    public ResultData getPayByOrderNo(String orderNo) {
        return ResultData.fail(ReturnCodeEnum.RC500.getCode(),"对方服务宕机或不可用，FallBack服务降级o(╥﹏╥)o");
    }
}
