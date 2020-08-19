package com.bqw.nacosprovider.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@FeignClient 用在service接口中
@RequestMapping("/provider")
public class ProviderController {
    @Value("${server.port}")
    private String serverPort;
    @GetMapping
    public String getProvider(String name,String pwd) {
        return ""+serverPort+":我是服务提供者！"+"测试接口数据："+name+":name-"+pwd+":pwd";
    }
}
