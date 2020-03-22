package com.consumerservice.consumerservice.Controller;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.Random;

public class MyRule implements IRule {

    private ILoadBalancer lb;
    public static  int c;
    public Server choose(Object key) {
        Random r = new Random();
        int randomNum = r.nextInt(10);
        List<Server> servers = lb.getAllServers();
        c=randomNum;
        if(randomNum > 7) {
            Server s = getServerByPort(servers, 8084);
            return s;
        }
        return getServerByPort(servers, 8989);
    }



    private Server getServerByPort(List<Server> servers, int port) {
        for(Server s : servers) {
            if(s.getPort() == port) {
                return s;
            }
        }
        return null;
    }

    public void setLoadBalancer(ILoadBalancer lb) {
        this.lb = lb;
    }

    public ILoadBalancer getLoadBalancer() {
        return lb;
    }

}
