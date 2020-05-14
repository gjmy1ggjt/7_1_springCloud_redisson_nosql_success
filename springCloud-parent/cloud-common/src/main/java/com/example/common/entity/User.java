package com.example.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * Created by Administrator on 2019/6/18.
 */
@Data
@TableName("sys_user")
public class User extends BaseEntity{

    private String userCode;

    private String userName;

    private String userPassword;

    private String userState;

}
