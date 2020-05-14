package com.example.product.server.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Slf4j
@Configuration
public class RabbitMQConfig {

    @Value("${spring.rabbitmq.host}")
    private String host;

    @Value("${spring.rabbitmq.port}")
    private String port;

    @Value("${spring.rabbitmq.username}")
    private String username;

    @Value("${spring.rabbitmq.password}")
    private String password;

    @Value("${spring.rabbitmq.virtual-host}")
    private String vhost;

    @Value("${spring.rabbitmq.publisher-confirms}")
    private boolean isConfirm;

    @Value("${spring.rabbitmq.publisher-returns}")
    private boolean isReturn;

    @Value("${spring.rabbitmq.template.mandatory}")
    private boolean isMandatory;

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setAddresses(host + ":" + port);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        connectionFactory.setVirtualHost(vhost);
        //设置才能调用接口 RabbitTemplate.ConfirmCallback
        connectionFactory.setPublisherConfirms(isConfirm);

        connectionFactory.setPublisherReturns(isReturn);

        return connectionFactory;
    }

//    @Bean
//    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//    //有不同的回调机制的情况下才设置为原型
//    public RabbitTemplate rabbitTemplate() {
//        RabbitTemplate template = new RabbitTemplate(connectionFactory());
//        template.setMandatory(isMandatory);
//        template.setMessageConverter(jsonMessageConverter());
//        return template;
//    }
//
//    @Bean(name = "rabbitTemplate2")
//    //有不同的回调机制的情况下才设置为原型
//    public RabbitTemplate RabbitTemplate2() {
//        RabbitTemplate template = new RabbitTemplate(connectionFactory());
//        template.setMandatory(isMandatory);
//        return template;
//    }

    @Bean
    public RabbitAdmin amqpAdmin() {
        return new RabbitAdmin(connectionFactory());
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }




}
