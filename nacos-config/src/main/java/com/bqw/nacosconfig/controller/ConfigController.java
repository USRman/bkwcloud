package com.bqw.nacosconfig.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//自动获得配置信息
@RefreshScope
@RequestMapping("/nacosconfig")
public class ConfigController {
    @Value("${test.tname}")
    private String tname;
    @Value("${test.tage}")
    private String  tage;

    @RequestMapping("/get")
    public String nacosConfig() {
        return "name:"+tname+","+"age:"+tage;
    }

//    @Value("${useLocalCache:false}")
//    private boolean useLocalCache;
//
//    @RequestMapping("/get")
//    public boolean get() {
//        return useLocalCache;
//    }
}
