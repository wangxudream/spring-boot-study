package com.kataer.springbootdemo.exception;

import lombok.Data;

/**
 * 自定义异常
 */
@Data
public class BaseException extends Exception {
    private int code;
    private String msg;

    public BaseException(int code, String msg) {
        super(msg);
        this.code = code;
    }


}
