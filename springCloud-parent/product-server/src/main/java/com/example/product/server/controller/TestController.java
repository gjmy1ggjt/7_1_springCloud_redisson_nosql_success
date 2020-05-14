package com.example.product.server.controller;


import com.example.common.entity.UserYYY;
import com.example.product.server.service.SendMessageService;
import com.example.product.server.service.impl.TestServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@RestController
@RequestMapping(value = "/test")
@Slf4j
public class TestController {

    @Autowired
    private TestServiceImpl testService;

    @Autowired
    private RedissonClient redissonClient;

    @RequestMapping(value = "/one/{id}", method = RequestMethod.GET)
    public String get(@PathVariable("id") Integer id) {
        return testService.getTestById(id);

    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public UserYYY getUser(@PathVariable("id") Integer id) {
        return testService.getUserById(id);

    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save() {

        testService.save();

        return "success22";
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String delete() {

        testService.delete();

        return "success3";

    }

    @RequestMapping(value = "update", method = RequestMethod.GET)
    public String update() {

        testService.delete();

        return "success3";

    }


    // 请求总数
    public static int clientTotal = 5000;
    // 同时并发执行的线程数
    public static int threadTotal = 200;
    public static int count = 0;

//    http://localhost:8763/product/test/bingfa

    @RequestMapping(value = "/bingfa/{flag}", method = RequestMethod.GET)
    public void main(@PathVariable("flag") String flag) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        //信号量，此处用于控制并发的线程数
        final Semaphore semaphore = new Semaphore(threadTotal);
        //闭锁，可实现计数器递减
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);


        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    //执行此方法用于获取执行许可，当总计未释放的许可数不超过200时，
                    //允许通行，否则线程阻塞等待，直到获取到许可。
                    semaphore.acquire();

                    if ("true".equals(flag)) {

                        add();

                    } else {

                        add_noRedis();
                    }

                    //释放许可
                    semaphore.release();
                } catch (Exception e) {
                    //log.error("exception", e);
                    e.printStackTrace();
                }
                //闭锁减一
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();//线程阻塞，直到闭锁值为0时，阻塞才释放，继续往下执行
        executorService.shutdown();
        log.info("count:{}", count);
    }
    private void add_noRedis() {
        count++;
    }

//    private static void add() {
//        count.incrementAndGet();
//    }

    private void add() {

        String key = "seckill_stock_lock_" + 2;

        RLock lock = redissonClient.getLock(key);

        try {

            //获取分布式锁
            lock.lock();

            count++;

        } catch (Exception e) {
            e.printStackTrace();

        } finally {

            lock.unlock();

        }


    }


}
