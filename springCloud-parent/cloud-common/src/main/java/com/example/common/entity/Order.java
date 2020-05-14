package com.example.common.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * Created by Administrator on 2020/1/28.
 */
@Data
@TableName("sys_order")
public class Order extends BaseEntity {

    private String orderName;

    private String orderCode;

    private Integer orderStock;

    private String orderState;


}
