package com.kataer.springbootdemo.timeTask;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 简单使用cron(计时程序)
 * 说明：
 * 1、共有6为
 * 2、分别为 秒 分 时 日 月 星期
 * 3、以秒为例
 * 0 代表在第0秒执行
 * * 代表在任意秒执行
 * ？表示取值不影响定时任务
 * 由于月份中的日和星期可能会发生意义冲突，所以日、 星期中需要有一个配置为 ?
 * todo 了解cron https://www.jianshu.com/p/e9ce1a7e1ed1
 * todo  Quartz 框架
 */
@Slf4j
@Component
@EnableAsync //开启多线程
public class CronTimeTask {

    @Async //声明方法为异步调用
    @Scheduled(cron = "0 * * * * ?") //每分钟的第0秒调用
    public void cron1() {
        log.info("执行任务cron1()时间---->{}", new Date());
    }

    @Async //声明方法为异步调用
    @Scheduled(cron = "0 33 * * * ?") //每小时的33分调用一次
    public void cron2() {
        log.info("执行任务cron2()时间---->{}", new Date());
    }
}
