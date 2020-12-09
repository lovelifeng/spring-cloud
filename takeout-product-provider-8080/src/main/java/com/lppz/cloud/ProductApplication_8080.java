package com.lppz.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@SpringBootApplication
@EnableDiscoveryClient  //该微服务的所有对外暴露的服务统一注册在nacos中
public class ProductApplication_8080 {
    public static void main(String[] args) {
        SpringApplication.run(ProductApplication_8080.class, args);
    }
}
