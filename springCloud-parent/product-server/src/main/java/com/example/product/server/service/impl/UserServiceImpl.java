package com.example.product.server.service.impl;

import com.codingapi.txlcn.tc.annotation.DTXPropagation;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.codingapi.txlcn.tc.annotation.TxcTransaction;
import com.example.common.entity.User;
import com.example.common.entity.UserYYY;
import com.example.common.utils.DataGrid;
import com.example.product.server.dao.UserMapperDao;
import com.example.product.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2020/1/22.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapperDao userMapperDao;

    //    @TxcTransaction
    @LcnTransaction
//    @LcnTransaction(propagation = DTXPropagation.SUPPORTS)
    @Override
    public DataGrid<String> saveUser(User user) {
        return new DataGrid<>(true, userMapperDao.insert(user));
    }

    @Override
    public User getUserById(String id) {
        return userMapperDao.selectById(id);
    }
}
