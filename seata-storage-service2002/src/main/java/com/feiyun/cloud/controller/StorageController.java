package com.feiyun.cloud.controller;

import com.feiyun.cloud.resp.ResultData;
import com.feiyun.cloud.service.StorageService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author feiyun
 * @date 2024/5/27 17:30
 * @explain
 */
@Slf4j
@RestController
public class StorageController {
    @Resource
    private StorageService storageService;

    @PostMapping(value = "/storage/decrease")
    public ResultData decrease(Long productId, Integer count){
        storageService.decrease(productId,count);
        return ResultData.success("扣减库存成功!");
    }
}
