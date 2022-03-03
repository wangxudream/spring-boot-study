package com.kataer.springbootdemo.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 自定义配置文件
 */
@Data
@Component
//指定配置文件和编码格式
@PropertySource(value = "classpath:personal.properties", encoding = "utf8")
public class WxmpParam {
    @Value("${wxmp.appid}")
    private String appid;
    @Value("${wxmp.secret}")
    private String secret;
}
