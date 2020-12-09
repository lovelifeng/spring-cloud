package com.lppz.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient  //告诉feign客户端，具体的微服务
@EnableFeignClients(basePackages = "com.lppz.cloud") //open Feign的客户端负载均衡
public class Consumer_App_Feign_80 {

    public static void main(String[] args) {
        SpringApplication.run(Consumer_App_Feign_80.class, args);
    }

}