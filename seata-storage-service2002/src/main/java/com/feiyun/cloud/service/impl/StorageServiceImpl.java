package com.feiyun.cloud.service.impl;

import com.feiyun.cloud.mapper.StorageMapper;
import com.feiyun.cloud.service.StorageService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @author feiyun
 * @date 2024/5/27 17:21
 * @explain
 */

@Slf4j
@Service
public class StorageServiceImpl implements StorageService {


    @Resource
    private StorageMapper storageMapper;

    @Override
    public void decrease(Long productId, Integer count) {
        log.info("------->storage-service中扣减库存开始");
        storageMapper.decrease(productId,count);
        log.info("------->storage-service中扣减库存结束");

    }
}
