package com.hervey.thread.synchronize;

/**
 * @program: thread
 * @description: 测试同步
 * @author: hewen
 * @create: 2019-09-06 16:48
 **/
public class TestSynchronize1 implements Runnable{
    private String name;

    private Integer num = 7;

    TestSynchronize1(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        print1(name);
    }

    public synchronized void print(String name) {
        System.out.println(name + "正在调用,开始睡眠");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + "结束调用");
    }

    public void print1(String name) {

        synchronized (num) {
            System.out.println(Thread.currentThread().getName() + "=>" + num --);
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new TestSynchronize1("t1"));
        for (int i = 0; i< 10; i++) {
            Thread t2 = new Thread(t1);
            t2.start();
        }

        for (int j = 0; j< 10; j++) {
            Thread t3 = new Thread(t1);
            t3.start();
        }
    }
}
