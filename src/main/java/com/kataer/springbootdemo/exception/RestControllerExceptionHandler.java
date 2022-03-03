package com.kataer.springbootdemo.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 用于处理RestController的类抛出的异常
 */
@Slf4j
@RestControllerAdvice(annotations = RestController.class)
public class RestControllerExceptionHandler {
    @ExceptionHandler(BaseException.class)
    public JsonResult baseExceptionHandler(BaseException e) {
        log.info("RestControllerAdvice  baseExceptionHandler()------------->");
        return new JsonResult(e);
    }

    @ExceptionHandler(Exception.class)
    public JsonResult exceptionHandler(Exception e) {
        log.info("RestControllerAdvice  exception()------------->");
        return new JsonResult(e);
    }

}
