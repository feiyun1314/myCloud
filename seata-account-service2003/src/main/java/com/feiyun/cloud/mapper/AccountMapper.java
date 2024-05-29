package com.feiyun.cloud.mapper;

import com.feiyun.cloud.entities.Account;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;


public interface AccountMapper extends Mapper<Account> {

    /**
     * 扣减账户余额
     * @param userId
     * @param money
     */
    void decrease(@Param("userId") Long userId, @Param("money") Long money);


}
