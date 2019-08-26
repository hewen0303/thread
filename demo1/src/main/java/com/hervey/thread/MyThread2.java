package com.hervey.thread;

/**
 * @program: thread
 * @description:
 * @author: hewen
 * @create: 2019-08-26 10:56
 **/
public class MyThread2{


    class TestThread extends Thread {

        private int goodsNumber = 15;

        @Override
        public void run() {
            for (int i = 0; i <= 16; i++) {
                if (this.goodsNumber > 0) {
                    System.out.println(Thread.currentThread().getName() + "购买了一个,剩余：" + (this.goodsNumber --));
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // 开启一个线程任务
        TestThread tt = new MyThread2().new TestThread();
        // 将任务分配给2个线程去执行
        Thread t1 = new Thread(tt, "线程1");
        Thread t2 = new Thread(tt, "线程2");
        t1.start();
        t2.start();
    }
}
