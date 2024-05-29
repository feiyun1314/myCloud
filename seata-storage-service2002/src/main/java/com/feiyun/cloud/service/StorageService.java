package com.feiyun.cloud.service;

import com.feiyun.cloud.resp.ResultData;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * TODO
 *
 * @author feiyun
 * @date 2024/5/27 17:20
 * @explain
 */
public interface StorageService {


    /**
     * 扣减库存
     * @param productId
     * @param count
     */
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);

}
