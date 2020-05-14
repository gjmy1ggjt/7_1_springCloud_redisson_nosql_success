package com.example.product.server.service;

import com.example.common.entity.Order;
import com.example.common.utils.DataGrid;

/**
 * Created by Administrator on 2020/1/28.
 */
public interface OrderService {

    DataGrid seckillProduct(String id);

    DataGrid seckillProductNoRedisson(String id);

    DataGrid seckillNoDb(String id);

    DataGrid seckillNoDbAndNoRedisson(String id);

    DataGrid<String> saveOrder(Order order);
}
