package com.hervey.thread;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @program: thread
 * @description: 计划任务线程池
 * @author: hewen
 * @create: 2019-09-05 16:00
 **/
public class TestScheduledPool {

    static class Test implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "正在执行");
            System.out.println("结束执行 time:" + new Date().toLocaleString());
        }
    }

    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(3);
        System.out.println("开始执行 time:" + new Date().toLocaleString());
//        service.schedule(new Test(), 5000, TimeUnit.MILLISECONDS);


//        service.scheduleAtFixedRate(new Test(), 1000, 2000, TimeUnit.MILLISECONDS);

        service.scheduleWithFixedDelay(new Test(), 1000, 2000, TimeUnit.MILLISECONDS);
    }
}
