package com.example.common.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * Created by Administrator on 2019/6/18.
 */
@Data
@TableName("tea_info")
public class Teacher extends BaseEntity{

    private String userCode;

    private String userName;

    private String userPassword;

    private String userState;

    private String classId;

}
