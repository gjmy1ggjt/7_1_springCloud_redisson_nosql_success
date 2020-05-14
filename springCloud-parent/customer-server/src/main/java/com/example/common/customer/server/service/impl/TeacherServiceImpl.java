package com.example.common.customer.server.service.impl;

/**
 * Created by Administrator on 2020/1/25.
 */

import com.codingapi.txlcn.common.util.Transactions;
import com.codingapi.txlcn.tc.annotation.DTXPropagation;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.codingapi.txlcn.tracing.TracingContext;
import com.example.common.customer.server.dao.TeacherMapperDao;
import com.example.common.customer.server.feign.product.UserService;
import com.example.common.customer.server.service.TeacherService;
import com.example.common.entity.Teacher;
import com.example.common.entity.User;
import com.example.common.utils.DataGrid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapperDao teacherMapperDao;

    @Autowired
    private UserService userService;


    @Override
    public DataGrid<String> save(Teacher teacher) {
        return new DataGrid<>(true, teacherMapperDao.insert(teacher));
    }

    @LcnTransaction(propagation = DTXPropagation.REQUIRED)
    @Override
    public DataGrid<String> saveLcn(Map map) {

        String groupId = TracingContext.tracing().groupId();

        String applicationId = Transactions.getApplicationId();

        User user = (User) map.get("user");

        DataGrid<String> userDataGrid = userService.saveLCNUser(user);

        if ("true".equals(map.get("error"))) {

            int i = 0 / 0;

        }

        Teacher teacher = (Teacher)map.get("teacher");

        return new DataGrid<>(true, teacherMapperDao.insert(teacher));
    }


}
