package com.example.product.server.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.example.common.entity.User;
import com.example.common.utils.CreateDataUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by Administrator on 2020/1/25.
 */

@Component
@Slf4j
public class MetaHandler implements MetaObjectHandler {

    /**
     * 新增数据执行
     *
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
//        SysUserEntity userEntity = ShiroUtil.getUser();
        User user = CreateDataUtil.createUserData(0);

        Date date = new Date();
        this.setFieldValByName("createTime", date, metaObject);
        this.setFieldValByName("createBy", user.getUserName(), metaObject);
        this.setFieldValByName("updateTime", date, metaObject);
        this.setFieldValByName("updateBy", user.getUserName(), metaObject);
    }

    /**
     * 更新数据执行
     *
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
//        SysUserEntity userEntity = ShiroUtil.getUser();
        User user = CreateDataUtil.createUserData(0);
        this.setFieldValByName("updateTime", new Date(), metaObject);
        this.setFieldValByName("updateBy", user.getUserName(), metaObject);
    }
}
