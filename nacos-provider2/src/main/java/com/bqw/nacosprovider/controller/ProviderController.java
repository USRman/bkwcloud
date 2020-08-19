package com.bqw.nacosprovider.controller;

import com.alibaba.fastjson.JSONObject;
import com.bqw.nacosprovider.vo.Order;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.DynamicParameter;
import com.github.xiaoymin.knife4j.annotations.DynamicParameters;
import com.github.xiaoymin.knife4j.annotations.DynamicResponseParameters;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Slf4j
@Api(tags = "服务提供者！")
@RestController
//@FeignClient 用在service接口中
@RequestMapping("/provider")
public class ProviderController {
    private  final static Logger logger= LoggerFactory.getLogger(ProviderController.class);
    @Value("${server.port}")
    private String serverPort;





    @ApiOperation(value = "调用服务提供者")
    @GetMapping
    public String getProvider() {
        logger.debug("成功被消费者调用！");
        return ""+serverPort+":我是服务提供者！";
    }

    /**
     * 只要使用了ApiOperationSupport注解中的responses属性,
     * 不管接口返回是什么类,在增强中都会覆盖该接口的返回类型,
     * 动态重新生成新的Class以替代接口中返回的Type
     *  响应示例 @@@
     * @return
     */
    @ApiOperationSupport(
            responses = @DynamicResponseParameters(properties = {
                    @DynamicParameter(value = "编号",name = "id"),
                    @DynamicParameter(value = "名称",name = "name"),
                    @DynamicParameter(value = "订单",name = "orderDate",dataTypeClass = String.class)
            })
    )
    @ApiOperation(value = "响应JSONObject类型")
    @GetMapping("/jsonObject")
    public JSONObject jsonObjectxxxx(){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("name","xx");
        return jsonObject;
    }

    /**
     *  ignoreParameters 文档忽律 字段呈现
     * @param uptModel
     * @return
     */

    @ApiOperation(value = "新增Model接口1")
    @ApiOperationSupport(ignoreParameters = {"id","orderDate.id"})
    @PostMapping("/insertMode1l")
    public List<Order> insertModel1(Order uptModel){
        List<Order> r =new ArrayList<>();
        r.add(uptModel);
        return r;
    }

    /**
     *  请求示例！
     * @param map
     * @return
     */
    @PostMapping("/createOrder426")
    @ApiOperation(value = "jdk-HashMap-动态创建显示参数-无@RequestBody")
    @DynamicParameters(name = "CreateOrderHashMapModel",properties = {
            @DynamicParameter(name = "",value = "注解id",example = "X000111",required = true,dataTypeClass = Integer.class),
            @DynamicParameter(name = "name3",value = "订单编号-gson"),
            @DynamicParameter(name = "name1",value = "订单编号1-gson"),
    })
    public List<HashMap> createOrder1235332(@RequestBody HashMap map){
        List<HashMap> r=new ArrayList<>();
        r.add(map);
        return r;
    }


}
