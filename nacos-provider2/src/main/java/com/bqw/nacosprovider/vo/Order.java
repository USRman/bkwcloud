package com.bqw.nacosprovider.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class Order {
    @ApiModelProperty(value = "主键id")
    private String id;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "订单信息")
    private String orderDate;
}
