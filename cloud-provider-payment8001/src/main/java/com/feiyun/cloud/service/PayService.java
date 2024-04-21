package com.feiyun.cloud.service;

import com.feiyun.cloud.entities.Pay;
import io.swagger.v3.oas.annotations.servers.Server;

import java.util.List;

/**
 * TODO
 *
 * @author feiyun
 * @date 2024/4/18 15:51
 * @explain
 */
public interface PayService {
    public int add(Pay pay);
    public int delete(Integer id);

    public int edit(Pay pay);

    public Pay getById(Integer id);

    public List<Pay> getAll();
}

