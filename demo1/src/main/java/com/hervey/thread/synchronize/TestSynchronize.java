package com.hervey.thread.synchronize;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @program: thread
 * @description: 测试同步
 * @author: hewen
 * @create: 2019-09-06 16:23
 **/
public class TestSynchronize {

    private synchronized static void method(String threadName) throws InterruptedException {
        System.out.println(threadName + "正在执行");
        Thread.sleep(5000);
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    method("t1");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    method("t2");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
    }
}
