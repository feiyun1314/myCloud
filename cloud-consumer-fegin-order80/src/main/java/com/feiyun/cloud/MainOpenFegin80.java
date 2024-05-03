package com.feiyun.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * TODO
 *
 * @author feiyun
 * @date 2024/5/3 9:06
 * @explain
 */
@SpringBootApplication
@EnableDiscoveryClient  //该注解用于向使用consul 为注册中心时注册服务
@EnableFeignClients //启动fegin 客户端，定义服务+绑定接口，以声明式的方式优雅而简单的实现服务调用
public class MainOpenFegin80 {
    public static void main(String[] args) {
        SpringApplication.run(MainOpenFegin80.class,args);
    }
}
