package com.example.product.server.controller;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.codingapi.txlcn.tc.annotation.TxcTransaction;
import com.example.common.entity.User;
import com.example.common.utils.CreateDataUtil;
import com.example.common.utils.DataGrid;
import com.example.product.server.service.SendMessageService;
import com.example.product.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SendMessageService sendMessageService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User get(@PathVariable("id") String id) {

        for (int i = 0; i < 100; i ++) {

            sendMessageService.sendMessage("yyyyy" + i);

        }

        return userService.getUserById(id);

    }

    @LcnTransaction
    @RequestMapping(value = "/lcn_save", method = RequestMethod.POST)
    public DataGrid<String> saveLCNUser(@RequestBody User user) {

        return userService.saveUser(user);
    }

}
