package com.kataer.springbootdemo.controller;

import com.kataer.springbootdemo.exception.PasswordException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/controller")
public class ExceptionController {
    @GetMapping("/normal")
    public String normal() {
        return "goods";
    }

    @GetMapping("PasswordException")
    public String passwordException() throws PasswordException {
        if (true) {
            throw new PasswordException();// 抛出定义的异常
        }
        return "goods";
    }

    @GetMapping("Exception")
    public String exception() {
        int a = 1 / 0;// 模拟异常
        return "goods";
    }

}
