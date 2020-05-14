package com.example.product.server.service.impl;

import com.example.common.entity.Order;
import com.example.common.utils.DataGrid;
import com.example.product.server.dao.OrderMapperDao;
import com.example.product.server.service.OrderService;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

/**
 * Created by Administrator on 2020/1/28.
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    int i = 10;

    @Autowired
    private RedissonClient redissonClient;

    @Autowired
    private OrderMapperDao orderMapperDao;

    @Override
    public DataGrid seckillProduct(String id) {

        String key = "seckill_stock_lock_" + id;

        RLock lock = redissonClient.getLock(key);

        try {

            //获取分布式锁
            lock.lock();

            Order order = orderMapperDao.selectById(id);

            if (order.getOrderStock() > 0) {

                Integer newStock = order.getOrderStock() - 1;

                orderMapperDao.updateByStock(newStock, id);

            } else {

                return new DataGrid(false, "库存不足");

            }

        } catch (Exception e) {
            e.printStackTrace();

        } finally {

            lock.unlock();

        }

        return new DataGrid(true, "秒杀成功");

    }

    @Override
    public DataGrid seckillProductNoRedisson(String id) {

        Order order = orderMapperDao.selectById(id);

        if (order.getOrderStock() > 0) {

            Integer newStock = order.getOrderStock() - 1;

            orderMapperDao.updateByStock(newStock, id);

        } else {

            return new DataGrid(false, "库存不足");

        }
        return new DataGrid(true, "秒杀成功");

    }

    @Override
    public DataGrid seckillNoDbAndNoRedisson(String id) {


        if (i < 20) {

            i ++;
        }

        System.out.println(i);

        return new DataGrid(true, "");
    }

    @Override
    public DataGrid seckillNoDb(String id) {

        String key = "seckill_stock_lock_" + i;

        RLock lock = redissonClient.getLock(key);

        try {

            //获取分布式锁
            lock.lock();

            if (i < 20) {

                i ++;

            }

            System.out.println(i);

        } catch (Exception e) {
            e.printStackTrace();

        } finally {

            lock.unlock();

        }

        return new DataGrid(true, "秒杀成功");

    }

    @Override
    public DataGrid<String> saveOrder(Order order) {
        return new DataGrid<>(true, orderMapperDao.insert(order));
    }
}
