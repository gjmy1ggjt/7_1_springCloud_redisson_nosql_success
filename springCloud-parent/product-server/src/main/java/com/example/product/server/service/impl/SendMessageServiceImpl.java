package com.example.product.server.service.impl;


import com.example.common.constants.QueueActionConstant;
import com.example.common.constants.QueueConstant;
import com.example.product.server.service.SendMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;


@Component
@Slf4j
public class SendMessageServiceImpl implements SendMessageService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void sendMessage(Object message) {

        rabbitTemplate.setConfirmCallback(this);
        //构建回调返回的数据
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());

        rabbitTemplate.convertAndSend(QueueConstant.SAVE_USER_EXCHANGE_NAME, QueueConstant.SAVE_USER_QUEUE_ROUTE_KEY, message, correlationData);

        log.info("SendMessageServiceImpl() >>> 发送消息到RabbitMQ, 消息内容: " + message);
    }

    //    消息回调确认方法
    @Override
    public void confirm(CorrelationData correlationData, boolean isSendSuccess, String s) {

        log.info("confirm回调方法>>>>>>>>>>>>>回调消息ID为: " + correlationData.getId());
        if (isSendSuccess) {
            log.info("confirm回调方法>>>>>>>>>>>>>消息发送成功");
        } else {
            log.info("confirm回调方法>>>>>>>>>>>>>消息发送失败" + s);
        }
    }
}
