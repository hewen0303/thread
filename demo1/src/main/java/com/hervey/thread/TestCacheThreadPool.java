package com.hervey.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: thread
 * @description: 测试换成线程
 * @author: hewen
 * @create: 2019-09-05 15:01
 **/
public class TestCacheThreadPool {
    static class Test implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "正在执行");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i< 5; i++) {
            service.execute(new Test());
        }
        Thread.sleep(2000);
        System.out.println("沉睡2秒");
        for (int i = 0; i < 10; i++) {
            service.execute(new Test());
        }
    }
}
