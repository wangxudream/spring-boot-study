package com.kataer.springbootdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;


/**
 * 日志记录切面
 * 学习切面表达式
 */
@Component
@Aspect //标注为切面
public class LogAspect {
    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    //切入点表达式，表示切入点为控制器中所有方法
    @Pointcut("within(com.kataer.springbootdemo.controller..*)")
    public void LogAspect() {

    }

    @Before("LogAspect()")
    public void doBefore(JoinPoint joinPoint) {
        logger.info("访问时间{},访问方法{}", new Date(), joinPoint.getSignature());
    }

    @After("LogAspect()")
    public void doAfter(JoinPoint joinPoint) {
        logger.info("跳出方法{}", joinPoint.getSignature());
    }
}
