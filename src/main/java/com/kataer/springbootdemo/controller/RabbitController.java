package com.kataer.springbootdemo.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用来测试消息队列
 * 向消息队列发送消息
 */
@RestController
public class RabbitController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/rabbit")
    public void test() {
        // 发送消息 参数分别为：交换机名称、路由键、消息内容
        rabbitTemplate.convertAndSend("exchange-topic", "apple", "苹果来了10斤");
        rabbitTemplate.convertAndSend("exchange-topic", "banana", "香蕉来了5斤");
        rabbitTemplate.convertAndSend("exchange-topic", "apple.banana", "苹果来了8斤;香蕉来了20斤");
    }
}
