package com.kataer.springbootdemo.controller;

import com.kataer.springbootdemo.redis.VisitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试redis
 */
@Slf4j
@RestController
public class RedisController {
    @Autowired
    private VisitService visitService;


    @GetMapping("/visit")
    public void visit() {
        visitService.addCount();
        log.info("访问前次数:{}", visitService.getVisitCount());
        visitService.addCount();
        log.info("访问后次数:{}", visitService.getVisitCount());
    }
}
