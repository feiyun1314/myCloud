package com.feiyun.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * TODO
 *
 * @author feiyun
 * @date 2024/5/22 18:47
 * @explain
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Main9002 {
    public static void main(String[] args) {
        SpringApplication.run(Main9002.class,args);
    }
}
