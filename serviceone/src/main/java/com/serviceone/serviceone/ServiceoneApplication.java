package com.serviceone.serviceone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/***
 *
 * @EnableDiscoveryClient
 * 让服务使用eureka服务器
 * 实现服务注册和发现
 *
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ServiceoneApplication {

    public static void main(String[] args)
    {
        SpringApplication.run(ServiceoneApplication.class, args);
    }

}
