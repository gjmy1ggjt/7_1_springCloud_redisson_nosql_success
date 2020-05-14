package com.example.product.server.config;

import com.example.common.constants.QueueConstant;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Title: SaveUserQueueConfiguration
//        * @ProjectName springboot_rabbit_mq
//        * @Description: 保存用户RabbitMQ相关配置类
//        * @Author WeiShiHuai
//        * @Date 2018/9/20 14:41

@Configuration
public class UserQueueConfiguration {


    /**
     * 配置交换机实例
     *
     * @return
     */
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(QueueConstant.SAVE_USER_EXCHANGE_NAME);
    }

    @Bean
    public DirectExchange directExchangeUserDelete() {
        return new DirectExchange(QueueConstant.DELETE_USER_EXCHANGE_NAME);
    }

    /**
     * 配置队列实例，并且设置持久化队列
     *
     * @return
     */
    @Bean
    public Queue queue() {
        return new Queue(QueueConstant.SAVE_USER_QUEUE_NAME, true);
    }


    @Bean
    public Queue queueUserDelete() {
        return new Queue(QueueConstant.DELETE_USER_QUEUE_NAME, true);
    }

    /**
     * 将队列绑定到交换机上，并设置消息分发的路由键
     *
     * @return
     */
    @Bean
    public Binding binding() {
        //链式写法: 用指定的路由键将队列绑定到交换机
        return BindingBuilder.bind(queue()).to(directExchange()).with(QueueConstant.SAVE_USER_QUEUE_ROUTE_KEY);
    }


    @Bean
    public Binding bindingUserDelete() {
        //链式写法: 用指定的路由键将队列绑定到交换机
        return BindingBuilder.bind(queueUserDelete()).to(directExchangeUserDelete()).with(QueueConstant.DELETE_USER_QUEUE_ROUTE_KEY);
    }
}
