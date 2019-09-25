package com.hervey.thread.synchronize;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: thread
 * @description: 测试volatile关键字
 * @author: hewen
 * @create: 2019-09-24 11:11
 **/
public class TestVolatile {

    public int num;

    public void reduce() throws InterruptedException {
        num -- ;
    }

    TestVolatile(int num) {
        this.num = num;
    }

    public static void main(String args[]) {

        TestVolatile t = new TestVolatile(10);

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        t.reduce();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "==>" + t.num);
                }
            });

        }

    }

}
