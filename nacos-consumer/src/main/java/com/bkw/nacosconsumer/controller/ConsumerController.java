package com.bkw.nacosconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    private final RestTemplate restTemplate;
    @Autowired
    public ConsumerController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    // 注册中心实例
    @Autowired
    private DiscoveryClient discoveryClient;
    @GetMapping
    public String getConsumer() {
        return "我是服务消费者！";
    }
    @RequestMapping(value = "/call",method = RequestMethod.GET)
    public String callProider() {
        List<ServiceInstance> instances = discoveryClient.getInstances("nacos-provider");
        instances.stream().map(instance->instance.getUri().toString()+"provider").findFirst()
                .orElseThrow(()->new IllegalArgumentException("当前没有实例！"));
        String URL="http://nacos-provider/provider";// 用注册中心的服务名 代替ip+端口号
       return restTemplate.getForObject(URL,String.class)+"被consumer调用！";
    }
}
