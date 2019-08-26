package com.hervey.thread;

/**
 * @program: thread
 * @description: 多线程
 * @author: hewen
 * @create: 2019-08-26 14:08
 **/
public class MyThread3 implements Runnable {

    private int num = 5;

    @Override
    public void run() {
        for (int i = 0; i< 10; i++) {
            if (this.num > 0) {
                System.out.println(Thread.currentThread().getName() + "num left:" + this.num --);
            }
        }
    }

    public static void main(String[] args) {
        // 创建线程任务
        MyThread3 m = new MyThread3();
        // 将任务分配给3个线程去执行
        new Thread(m, "Thread1").start(); // 线程start后，会放置线程等待队列，等待CPU调度，通过Thread调用run方法
        new Thread(m, "Thread2").start();
        new Thread(m, "Thread3").start();
    }
}
