package com.kataer.springbootdemo.ioc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @ClassName CarFactory
 * @Description: TODO
 * @Author kataer
 * @Date 2020/12/27 20:39
 * @Version V1.0
 **/
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("student".equals(beanName)){
            System.out.println("before初始化方法:"+beanName);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if ("student".equals(beanName)){
            System.out.println("after初始化方法:"+beanName);
        }
        return bean;
    }
}
