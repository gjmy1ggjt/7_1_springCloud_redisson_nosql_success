package com.example.product.server.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**  说明: 继承RabbitTemplate.ConfirmCallback接口，而ConfirmCallback接口是用来回调消息发送成功后的方法，
    * 当一个消息被成功写入到RabbitMQ服务端时，会自动的回调RabbitTemplate.ConfirmCallback接口内的confirm方法完成通知
*/
public interface SendMessageService extends RabbitTemplate.ConfirmCallback {

    /**
     * 发送消息方法
     *
     * @param message 发送内容
     */
    void sendMessage(Object message);
}
