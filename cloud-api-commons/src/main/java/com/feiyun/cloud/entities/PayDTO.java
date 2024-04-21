package com.feiyun.cloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * TODO
 *
 * @author feiyun
 * @date 2024/4/18 15:50
 * @explain
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayDTO implements Serializable {

    private Integer id;
    //支付流水号
    private String payNo;
    //订单流水号
    private String orderNo;
    //用户账号ID
    private Integer userId;
    //交易金额
    private BigDecimal amount;
}
