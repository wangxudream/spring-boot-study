package com.kataer.springbootdemo.exception;

public class PasswordException extends BaseException {
    public PasswordException() {
        super(1001, "密码错误");
    }
}
