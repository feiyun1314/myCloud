package com.feiyun.cloud.test;

import java.time.ZonedDateTime;

/**
 * TODO
 *
 * @author feiyun
 * @date 2024/5/15 15:33
 * @explain
 */
public class ZonedDateTimeDemo {
    public static void main(String[] args)
    {
        ZonedDateTime zbj = ZonedDateTime.now(); // 默认时区
        System.out.println(zbj);
    }
}
