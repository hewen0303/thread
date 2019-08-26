package com.hervey.thread;

/**
 * @program: thread
 * @description: 非
 * @author: hewen
 * @create: 2019-08-26 09:55
 **/
public class MyThread extends Thread{

    private String threadName;
    // 控制循环的数量
    private int num = 1000;

    // 定义商品总数
    private int goodsNum = 15;

    MyThread(String name) {
        this.threadName = name;
    }

    @Override
    public void run() {
        for (int i = 0; i< num; i++) {
            if (this.goodsNum > 0) {
                this.goodsNum -- ;
                System.out.println(threadName + "购买了一个，剩余" + this.goodsNum);
            }
        }
    }

    public static void main (String[] args) {
        // 线程启动需new2个线程实例，
        MyThread mt = new MyThread("线程1");
        MyThread mt1 = new MyThread("线程2");
        mt.start();
        mt1.start();
    }
}
