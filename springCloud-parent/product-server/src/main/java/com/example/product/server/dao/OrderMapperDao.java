package com.example.product.server.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.common.entity.Order;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * Created by Administrator on 2020/1/28.
 */
public interface OrderMapperDao extends BaseMapper<Order> {

    @Update("update sys_order set order_stock = #{num} where id = #{id}")
    void updateByStock(@Param("num") Integer num, @Param("id") String id);

}
