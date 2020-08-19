package com.bqw.nacosprovider;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
// 注册中心注解
@EnableDiscoveryClient
@EnableFeignClients
// 文档工具注解    @LKADocument(basePackages="com.lkad.api",projectName="Lkadoc测试项目",description="智能、便捷、高效",version="1.0",serverNames="租房系统-192.168.0.77:9010,缴费系统-192.168.0.77:8888",enabled=true)
//@SpringBootApplication  代替 application.yml 文件
public class NacosproviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(NacosproviderApplication.class, args);
    }

}
