//package com.example.common.customer.server.controller.test;
//
//import com.example.common.customer.server.feign.product.ProudctService;
//import com.example.common.entity.UserYYY;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping(value = "/test")
//public class TestController {
//
//    @Autowired
//    private ProudctService proudctService;
//
//    @RequestMapping(value = "/one/{id}", method = RequestMethod.GET)
//    public String get(@PathVariable("id") Integer id) {
//
//        return proudctService.getTestById(id);
//
//    }
//
//    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
//    public UserYYY getUserById(@PathVariable("id") Integer id) {
//
//        return proudctService.getUserById(id);
//
//    }
//}
