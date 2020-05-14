package com.example.product.server.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.common.entity.UserYYY;
import com.example.product.server.bean.Test;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;


public interface TestMapperDao extends BaseMapper<Test>{

    Test selectByPrimaryKey(@Param("id") Integer id);

    String getTestById(@Param("id") Integer id);

    UserYYY getUserById(@Param("id") Integer id);


//    /**
//     *
//     * 如果自定义的方法还希望能够使用MP提供的Wrapper条件构造器，则需要如下写法
//     *
//     * @param userWrapper
//     * @return
//     */
//    @Select("SELECT * FROM user ${ew.customSqlSegment}")
//    List<User> selectByMyWrapper(@Param(Constants.WRAPPER) Wrapper<User> userWrapper);
//
//    /**
//     * 和Mybatis使用方法一致
//     * @param name
//     * @return
//     */
//    @Select("SELECT * FROM user where name = #{name}")
//    List<User> selectByName(@Param("name") String name);

//    @Update("update from sys_order set order_stock = #{num}")
//   void updateByStock(@Param("num") Integer num);


}
