package com.feiyun.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * TODO
 *
 * @author feiyun
 * @date 2024/5/2 11:01
 * @explain
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.feiyun.cloud.mapper")  //import tk.mybatis.spring.annotation.MapperScan;
@RefreshScope // 动态刷新
public class Main8002 {
    public static void main(String[] args) {
        SpringApplication.run(Main8002.class,args);

    }}
