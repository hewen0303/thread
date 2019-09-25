package com.hervey.thread.synchronize;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: thread
 * @description: 测试同步
 * @author: hewen
 * @create: 2019-09-06 16:48
 **/
public class TestSynchronize2{

    public synchronized void test1() throws InterruptedException {Thread.sleep(5000);}

    public void test2() {
        synchronized (this) {
            System.out.println("123123");
        }
    }

    public static void main(String args[]) {

        TestSynchronize2 t = new TestSynchronize2();

        ExecutorService es = Executors.newSingleThreadExecutor();

        ExecutorService es1 = Executors.newSingleThreadExecutor();

        es.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    t.test1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        es1.execute(new Runnable() {
            @Override
            public void run() {
                t.test2();
            }
        });
    }
}
