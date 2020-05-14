package com.example.product.server.service.impl;

import com.example.common.constants.QueueActionConstant;
import com.example.common.entity.UserYYY;
import com.example.product.server.dao.TestMapperDao;
import com.example.product.server.bean.Test;
import com.example.product.server.service.SendMessageService;
import com.example.common.service.product.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@Transactional
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapperDao testMapperDao;

    @Autowired
    private SendMessageService sendMessageService;

    @Override
    public String getTestById(Integer id) {
        return testMapperDao.getTestById(id);
    }

    @Override
    public UserYYY getUserById(Integer id) {
        return testMapperDao.getUserById(id);
    }

    @Override
    public void save() {
        Test test = new Test();

        test.setName("test");

        test.setNewMoney(BigDecimal.TEN);

        testMapperDao.insert(test);

        sendMessageService.sendMessage(test);
    }

    @Override
    public void delete() {
        testMapperDao.deleteById("6d4c3b75f1de4c978d58084868572f9f");
    }

    @Override
    public void update() {

//        Ent

//        testMapperDao.update()
    }
}
