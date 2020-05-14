package com.example.common.utils;

import com.example.common.entity.Order;
import com.example.common.entity.Teacher;
import com.example.common.entity.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2020/1/26.
 */
public class CreateDataUtil {

    public static User createUserData(Integer i){

        User user = new User();

        user.setId(UUID.randomUUID().toString());

        user.setUserName("假数据");

        user.setUserPassword(UUID.randomUUID().toString());

        user.setUserCode(UUID.randomUUID().toString());

        user.setUserState(i.toString());

        user.setCreateBy("假数据");

        user.setCreateTime(new Date());

        user.setUpdateBy("假数据");

        user.setUpdateTime(new Date());

        return user;
    }

    public static User createUserDataByDB(Integer i){

        User user = new User();

        user.setUserName("假数据");

        user.setUserPassword(UUID.randomUUID().toString());

        user.setUserCode(UUID.randomUUID().toString());

        user.setUserState(i.toString());

        return user;
    }

    public static Order createOrderDataByDB(Integer i){

        Order order = new Order();

        order.setOrderName("秒杀假数据");

        order.setOrderCode(UUID.randomUUID().toString());

        order.setOrderState(i.toString());

        order.setOrderStock(20);

        return order;
    }

    public static Teacher createTeacherDataByDB(Integer i){

        Teacher teacher = new Teacher();

        teacher.setUserName("假数据");

        teacher.setUserPassword(UUID.randomUUID().toString());

        teacher.setUserCode(UUID.randomUUID().toString());

        return teacher;
    }

    public static List<User> createListUserData(Integer size){

        List<User> listUser = new ArrayList<>();

        for (int i = 0; i < size; i ++) {

            listUser.add(createUserData(i));

        }

        return listUser;

    }


}
