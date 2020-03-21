package com.serviceone.serviceone.controller;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.List;


@RestController
public class testController {

    @Qualifier("eurekaRegistration")
    @Autowired
    private Registration registration; // 服务注册

    @Autowired
    private DiscoveryClient client; // 服务发现客户端

    @RequestMapping("/hello")
    public String hello() {
        // ServiceInstance instance = serviceInstance();
        //打印服务的服务id
        System.out.println("hello,this is hello-service  port:" + getLocalPort());
        return "hello,this is hello-service  port:" + getLocalPort();
    }



    //通过request获取端口
    public static String getLocalPort() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getServerPort() + "";
    }



    public ServiceInstance serviceInstance() {
        List<ServiceInstance> list = client.getInstances(registration.getServiceId());
        if (list != null && list.size() > 0) {
            for (ServiceInstance itm : list) {
                if (itm.getPort() == 2001)
                    return itm;
            }
        }
        return null;
    }
}
