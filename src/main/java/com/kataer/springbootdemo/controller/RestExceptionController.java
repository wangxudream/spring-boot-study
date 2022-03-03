package com.kataer.springbootdemo.controller;

import com.kataer.springbootdemo.exception.JsonResult;
import com.kataer.springbootdemo.exception.PasswordException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;


@RestController
@RequestMapping("/restcontroller")
public class RestExceptionController {
    @GetMapping("/normal")
    public JsonResult normal() {
        return new JsonResult(new ArrayList<>());
    }

    @GetMapping("PasswordException")
    public JsonResult passwordException() throws PasswordException {
        if (true) {
            throw new PasswordException();// 抛出定义的异常
        }
        return JsonResult.ok();
    }

    @GetMapping("Exception")
    public JsonResult exception() {
        int a = 1 / 0;// 模拟异常
        return JsonResult.ok();
    }

}
