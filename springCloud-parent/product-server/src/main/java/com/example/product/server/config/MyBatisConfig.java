package com.example.product.server.config;

@org.springframework.context.annotation.Configuration
public class MyBatisConfig {

//    @Bean
//    public ConfigurationCustomizer configurationCustomizer() {
//        return new ConfigurationCustomizer() {
//
//            @Override
//            public void customize(Configuration configuration) {
//                configuration.setMapUnderscoreToCamelCase(true);
//            }
//        };
//    }

    /*import com.baomidou.mybatisplus.entity.GlobalConfiguration;
import com.github.pagehelper.PageHelper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.Properties;

    @Configuration
    @MapperScan("com.paic.ocss.gateway.dao.mapper*")
    @Import(value = { com.paic.ocss.monitor.cat.mybatis.SpringCloudCatMybatisConfig.class })
    public class MybatisConfig {

        @Bean
        public GlobalConfiguration globalConfiguration() {
            GlobalConfiguration global = new GlobalConfiguration();
            global.setDbType("mysql");
            return global;
        }

        *//**
     * 配置mybatis的分页插件pageHelper
     * @return
     *//*
        @Bean
        public PageHelper pageHelper(){
            PageHelper pageHelper = new PageHelper();
            Properties properties = new Properties();
            properties.setProperty("offsetAsPageNum","true");
            properties.setProperty("rowBoundsWithCount","true");
            properties.setProperty("reasonable","true");
            //配置mysql数据库的方言
            properties.setProperty("dialect","mysql");
            pageHelper.setProperties(properties);
            return pageHelper;
        }

    }*/
}
