package com.example.product.server.service;

import com.example.common.entity.User;
import com.example.common.entity.UserYYY;
import com.example.common.utils.DataGrid;

/**
 * Created by Administrator on 2020/1/22.
 */
public interface UserService {

    DataGrid<String> saveUser(User user);

    User getUserById(String id);
}
