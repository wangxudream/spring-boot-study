package com.kataer.springbootdemo.timeTask;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
//@Component //定时@Scheduled需在Compent类内使用(先注释掉)
@EnableAsync //开启多线程
public class TimeTask {
    /**
     * 固定频率执行
     *
     * @throws Exception
     */
    @Async //声明方法为异步调用
    @Scheduled(fixedRate = 2000) //每2秒执行一次
    public void fixedRateMethod() throws Exception {
        Thread.sleep(1000);
        log.info("fixedRateMethod---->{}", new Date());
    }

    /**
     * 固定间隔执行
     *
     * @throws Exception
     */
    @Scheduled(fixedDelay = 2000) //执行完成后间隔2秒
    public void fixedDelayMethod() throws Exception {
        Thread.sleep(1000);
        log.info("fixedDelayMethod---->{}", new Date());
    }
}
