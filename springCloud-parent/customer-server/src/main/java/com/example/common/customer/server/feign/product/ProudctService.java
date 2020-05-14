//package com.example.common.customer.server.feign.product;
//
//import com.example.common.entity.UserYYY;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//@Component
//@FeignClient(value = "product-service")
//@RequestMapping("/product/test")
//public interface ProudctService {
//
//    @ResponseBody
//    @RequestMapping(value = "/one/{id}", method = RequestMethod.GET)
//    String getTestById(@PathVariable("id") Integer id);
//
//
//    @ResponseBody
//    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
//    UserYYY getUserById(@PathVariable("id") Integer id);
//
//
//    @RequestMapping(value = "/save", method = RequestMethod.POST)
//    String save();
//
//    @RequestMapping(value = "/delete", method = RequestMethod.GET)
//    String delete();
//
//    @RequestMapping(value = "/update", method = RequestMethod.GET)
//    String update();
//}
