package com.example.common.customer.server.service;

import com.example.common.entity.Teacher;
import com.example.common.utils.DataGrid;

import java.util.Map;

/**
 * Created by Administrator on 2020/1/25.
 */
public interface TeacherService {

    DataGrid<String> save(Teacher teacher);

    DataGrid<String> saveLcn(Map map);
}
