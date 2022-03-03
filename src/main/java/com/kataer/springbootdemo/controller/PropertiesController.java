package com.kataer.springbootdemo.controller;

import com.kataer.springbootdemo.config.UserConfig;
import com.kataer.springbootdemo.config.WxmpParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试配置文件的注入
 */
@Slf4j
@RestController
public class PropertiesController {
    @Autowired
    private UserConfig userConfig;

    @Autowired
    private WxmpParam wxmpParam;

    @Value("${warning}")
    private String str;

    @GetMapping("/show")
    public void showUser() {
        log.info("user-->{}", userConfig.toString());
        log.info("str--{}", str);
        log.info("wxmpParam-->{}", wxmpParam);
    }
}
