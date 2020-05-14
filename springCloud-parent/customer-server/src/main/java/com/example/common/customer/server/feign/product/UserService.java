package com.example.common.customer.server.feign.product;

import com.example.common.entity.User;
import com.example.common.utils.DataGrid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2020/1/22.
 */
@Component
@FeignClient(value = "product-service")
@RequestMapping("/product/user")
public interface UserService {

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    User getUserById(@PathVariable("id") String id);

    @ResponseBody
    @RequestMapping(value = "/lcn_save", method = RequestMethod.POST)
    DataGrid<String> saveLCNUser(@RequestBody User user);



}
