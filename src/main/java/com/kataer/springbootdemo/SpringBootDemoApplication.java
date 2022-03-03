package com.kataer.springbootdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling //开启定时任务
//@EnableAdminServer //开启Spring Boot Admin 监控管理功能
@EnableCaching //开启缓存
//@MapperScan("com.kataer.springbootdemo.mapper") // 指定MyBatis扫描的包，以便将数据访问接口注册为bean
public class SpringBootDemoApplication {

    public static void main(String[] args) {
        //保存动态生成的class
//        System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "\\cglib");
        SpringApplication.run(SpringBootDemoApplication.class, args);
    }

}

