package com.example.common.customer.server.rabbit;

import com.example.common.constants.QueueConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 接收消息
 */
@Component
@RabbitListener(queues = QueueConstant.SAVE_USER_QUEUE_NAME)
@Slf4j
public class ReceiveMessage {


    int i = 0;

    @RabbitHandler
    public void receiveMessage(String userName) {

        log.info("customer-消息接收成功，用户名为：" + userName + "-------" + i);
        //可以添加自定义业务逻辑处理

    }


}
