package com.example.product.server.controller;

import com.example.common.utils.CreateDataUtil;
import com.example.common.utils.DataGrid;
import com.example.product.server.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2020/1/28.
 */

@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/salekill/{id}/{flag}", method = RequestMethod.GET)
    public DataGrid get(@PathVariable("id") String id, @PathVariable("flag") String flag) {

        if ("true".equals(flag)) {

            return orderService.seckillProduct(id);

        } else {

            return orderService.seckillProductNoRedisson(id);
        }

    }
//    ab -n 20000 -c 4400 http://localhost:8763/product/order/salekill/808c2e1363a54368ac9e9ae2ac9e8353/false


    @RequestMapping(value = "/salekill_noDB/{id}/{flag}", method = RequestMethod.GET)
    public DataGrid noDb(@PathVariable("id") String id, @PathVariable("flag") String flag) {

        if ("true".equals(flag)) {

            return orderService.seckillNoDb(id);

        } else {

            return orderService.seckillNoDbAndNoRedisson(id);
        }
    }

//    ab -n 200 -c 44 http://localhost:8763/product/order/salekill_noDB/808c2e1363a54368ac9e9ae2ac9e8353/false



        @RequestMapping(value = "/save", method = RequestMethod.POST)
    public DataGrid get() {
        return orderService.saveOrder(CreateDataUtil.createOrderDataByDB(0));

    }
}
