package com.hervey.thread.synchronize;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: thread
 * @description: 测试lock
 * @author: hewen
 * @create: 2019-09-21 14:59
 **/
public class TestLock {

    private Lock lock = new ReentrantLock();


    class Test implements Runnable {

        @Override
        public void run() {
            try {
                lock.lockInterruptibly();
                while (true) {
                    System.out.println(Thread.currentThread().getName() + "占有了锁，正在运行 time:" + new Date().toLocaleString());
                    Thread.sleep(50000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println(Thread.currentThread().getName() + "运行完毕 time:" + new Date().toLocaleString());
                lock.unlock();
            }
        }
    }

    class Test1 implements Runnable {
        @Override
        public void run() {
            synchronized (this) {
                while (true) {
                    System.out.println(Thread.currentThread().getName() + "占有了锁，正在运行 time:" + new Date().toLocaleString());
                    try {
                        Thread.sleep(50000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args)  {

        Test t = new TestLock().new Test();
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        t1.start();
        t2.start();
        t2.interrupt();
    }
}
