package com.example.common.customer.server.controller.test;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.example.common.customer.server.feign.product.UserService;
import com.example.common.customer.server.service.TeacherService;
import com.example.common.customer.server.utils.RedisUtil;
import com.example.common.entity.Teacher;
import com.example.common.entity.User;
import com.example.common.utils.CreateDataUtil;
import com.example.common.utils.DataGrid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Administrator on 2020/1/22.
 */
@RestController
@RequestMapping(value = "/user")
public class CustomerController {

    @Autowired
    private UserService userService;

    @Autowired
    private TeacherService teacherService;

    @Resource
    private RedisUtil redisUtil;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable("id") String id) {

        return userService.getUserById(id);

    }

    @RequestMapping(value = "/get/{key}", method = RequestMethod.GET)
    public String getRedisByKey(@PathVariable("key") String key) {

        return redisUtil.get(key).toString();

    }

    @RequestMapping(value = "/teacher/save", method = RequestMethod.POST)

    public DataGrid<String> teacher() {

        Teacher teacher = new Teacher();

//        teacher.setId(UUID.randomUUID().toString());

        teacher.setUserCode(UUID.randomUUID().toString());

        teacher.setUserName("主键自动生成数据库保存");

        teacher.setUserPassword("1231231");

        teacher.setUserState("333");

        return teacherService.save(teacher);

    }

    @RequestMapping(value = "/teacher_lcn/save", method = RequestMethod.POST)
    public DataGrid<String> teacherLcn(@RequestBody Map map) {

        map.put("teacher", CreateDataUtil.createTeacherDataByDB(0));
        map.put("user", CreateDataUtil.createUserDataByDB(0));

        DataGrid<String> teacher = teacherService.saveLcn(map);

        return new DataGrid<>(true, "lcn");
    }


    public static void main(String[] args) {


    }
}
