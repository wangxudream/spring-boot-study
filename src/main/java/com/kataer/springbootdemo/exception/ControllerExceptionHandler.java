package com.kataer.springbootdemo.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * 控制器异常处理类
 * 所有的异常抛到控制器层集中处理
 * 对应的控制器需使用Controller注解
 */
@Slf4j
@ControllerAdvice(annotations = Controller.class)
public class ControllerExceptionHandler {
    /**
     * 处理
     *
     * @return
     */
    @ExceptionHandler({BaseException.class})// 当发生BaseException类(及其子类)的异常时，进入该方法
    public ModelAndView baseExceptionHandler(BaseException e) {
        log.info("ControllerAdvice  baseExceptionHandler()------------->");
        ModelAndView mv = new ModelAndView();
        mv.addObject("code", e.getCode());
        mv.addObject("message", e.getMessage());
        mv.setViewName("myerror");// 跳转到resource/templates/myerror.html页面
        return mv;
    }

    @ExceptionHandler({Exception.class})
    public ModelAndView exceptionHandler(Exception e) {// 当发生Exception类的异常时，进入该方法
        log.info("ControllerAdvice exceptionHandler()------------->");
        ModelAndView mv = new ModelAndView();
        mv.addObject("code", 9999);
        mv.addObject("message", e.getMessage());
        mv.setViewName("myerror");// 跳转到resource/templates/myerror.html页面
        return mv;
    }
}
