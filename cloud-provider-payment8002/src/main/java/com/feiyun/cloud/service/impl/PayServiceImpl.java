package com.feiyun.cloud.service.impl;

import com.feiyun.cloud.entities.Pay;
import com.feiyun.cloud.mapper.PayMapper;
import com.feiyun.cloud.service.PayService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO
 *
 * @author feiyun
 * @date 2024/4/18 15:54
 * @explain
 */
@Service
public class PayServiceImpl implements PayService {

    @Resource
    private PayMapper payMapper;
    @Override
    public int add(Pay pay) {
        return payMapper.insertSelective(pay);
    }

    @Override
    public int delete(Integer id) {
        return payMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int edit(Pay pay) {
        return payMapper.updateByPrimaryKeySelective(pay);
    }

    @Override
    public Pay getById(Integer id) {
        return payMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Pay> getAll() {
        return payMapper.selectAll();
    }
}
