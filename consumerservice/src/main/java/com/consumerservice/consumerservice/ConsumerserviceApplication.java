package com.consumerservice.consumerservice;

import com.consumerservice.consumerservice.Controller.MyRule;
import com.netflix.loadbalancer.IRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
@Configuration
@EnableDiscoveryClient
@SpringBootApplication
public class ConsumerserviceApplication {

    @Bean
    public IRule getRule(){
        return new MyRule();
    }

    //@Bean 应用在方法上，用来将方法返回值设为为bean
    @Bean
    @LoadBalanced  //@LoadBalanced实现负载均衡
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


    public static void main(String[] args) {
        SpringApplication.run(ConsumerserviceApplication.class, args);
    }

}
