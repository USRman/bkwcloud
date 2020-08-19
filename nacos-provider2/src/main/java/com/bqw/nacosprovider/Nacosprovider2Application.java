package com.bqw.nacosprovider;

import com.bqw.nacosprovider.controller.ProviderController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
// 注册中心注解
@EnableDiscoveryClient
@EnableFeignClients
public class Nacosprovider2Application {
    private  final static Logger logger= LoggerFactory.getLogger(ProviderController.class);

    public static void main(String[] args) {
        SpringApplication.run(Nacosprovider2Application.class, args);
        logger.info("服务2启动成功！");
    }

}
