package com.kataer.springbootdemo.ioc;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @ClassName Student
 * @Description: TODO
 * @Author kataer
 * @Date 2020/12/27 22:11
 * @Version V1.0
 **/
@Component
public class Student implements InitializingBean, DisposableBean {
    private String name;
    private Integer age;

    public Student() {
        System.out.println("Student无参构造");
    }


    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @PostConstruct
    public void init() {
        System.out.println("Student PostConstruct注解初始化方法");
        this.name = "李四";
        this.age = 19;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Student InitializingBean初始化方法");
        this.name = "张三";
        this.age = 18;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Student DisposableBean销毁方法");
    }

    @PreDestroy
    public void preDestroy() throws Exception {
        System.out.println("Student PreDestroy销毁方法");
    }
}
