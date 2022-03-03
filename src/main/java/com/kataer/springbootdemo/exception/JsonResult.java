package com.kataer.springbootdemo.exception;

import lombok.Data;

/**
 * 定义Json返回数据的格式
 */
@Data
public class JsonResult<T> {
    private int code;
    private String msg;
    private T data;

    public static JsonResult ok() {
        return new JsonResult(200, "操作成功");
    }

    public static JsonResult error() {
        return new JsonResult(500, "系统异常");
    }


    public JsonResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public JsonResult(int code, String msg, T data) {
        this(code, msg);
        this.data = data;
    }

    public JsonResult(T data) {
        this(200, "操作成功");
        this.data = data;
    }

    /**
     * 传入异常的钩爪函数
     *
     * @param e
     */
    public JsonResult(Exception e) {
        if (e instanceof BaseException) {
            this.code = ((BaseException) e).getCode();
            this.msg = e.getMessage();
        } else {
            this.code = 9999;
            this.msg = e.getMessage();
        }
    }
}
