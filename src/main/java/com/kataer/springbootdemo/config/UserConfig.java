package com.kataer.springbootdemo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 配置项自动注入对象
 */
@Data
@Component //注册为组件
@EnableConfigurationProperties //启动配置注入功能
@ConfigurationProperties(prefix = "user") //指定类对应的配置前缀
public class UserConfig {
    private String name;
    private String sex;
    private Integer age;
    private String address;
}
