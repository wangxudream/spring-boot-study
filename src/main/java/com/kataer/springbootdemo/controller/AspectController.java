package com.kataer.springbootdemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试Aspect的执行顺序
 */
@Slf4j
@RestController
public class AspectController {
    @GetMapping("/aspect")
    public String testAspect() {
        try {
//            int i = 1 / 0;
            return "normal";
        } catch (Exception e) {
            throw new RuntimeException("异常", e);
        }
    }
}
