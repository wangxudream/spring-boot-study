package com.kataer.springbootdemo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


/**
 * 各类通知的执行顺序
 * 1、正常情情况
 * 环绕通知
 * 前置通知
 * 后置通知
 * 最终通知
 * around start----------->
 * before------------>
 * after return------------>
 * after------------>
 * around end----------->
 * 2、异常情况
 * 环绕通知
 * 前置通知
 * 异常通知
 * 最终通知
 * around start----------->
 * before------------>
 * throw------------>
 * java.lang.RuntimeException: 异常
 * after------------>
 * around end----------->
 * 总结
 * 1、环绕通知最先执行，最后结束
 * 2、后置通知在异常情况下不执行 afterreturn
 * 3、最终通知无论是否发生异常都执行 after
 */
@Component
@Aspect
@Slf4j
public class ControllerAspect {
    @Pointcut("this(com.kataer.springbootdemo.controller.AspectController)")
    public void ControllerAspect() {

    }

    /**
     * 前置通知
     *
     * @param joinPoint
     */
    @Before("ControllerAspect()")
    public void doBefore(JoinPoint joinPoint) {
        log.info("before------------>");
    }

    /**
     * 最终通知
     *
     * @param joinPoint
     */
    @After("ControllerAspect()")
    public void doAfter(JoinPoint joinPoint) {
        log.info("after------------>");
    }

    /**
     * 异常通知
     *
     * @param ex
     */
    @AfterThrowing(throwing = "ex", pointcut = "ControllerAspect()")
    public void afterThrow(Throwable ex) {
        log.info("throw------------>");
        log.info(ex.toString());
    }

    /**
     * 后置通知
     *
     * @param rv
     */
    @AfterReturning(returning = "rv", pointcut = "ControllerAspect()")
    public void afterReturn(Object rv) {
        log.info("after return------------>");
    }

    /**
     * 环绕通知
     *
     * @param joinPoint
     * @throws Throwable
     */
    @Around("ControllerAspect()")
    public void deAround(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("around start----------->");
        try {
            Object result = joinPoint.proceed();
        } catch (Exception e) {

        } finally {

        }
        log.info("around end----------->");
    }
}
