package com.kataer.springbootdemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试过滤器的controller
 */
@Slf4j
@RestController
public class InterceptorController {
    @GetMapping("/login")
    public void login(String username, String password) {
        log.info("执行login()------------>");
    }
}
