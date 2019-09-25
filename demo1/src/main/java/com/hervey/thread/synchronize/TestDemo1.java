package com.hervey.thread.synchronize;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: thread
 * @description: synchronized错误示例
 * @author: hewen
 * @create: 2019-09-21 14:13
 **/
public class TestDemo1 implements Runnable {


    static int x = 0;
    @Override
    public void run() {
        for(int i=1;i<=1000;i++){
            synchronized (this){
                x++;
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Runnable run = new TestDemo1();
        Thread addThread1 = new Thread(run);
        Thread addThread2 = new Thread(run);
        addThread1.start();
        addThread2.start();
        //让主线程等待上面两个线程执行完毕
        addThread1.join();
        addThread2.join();
        System.out.println(x);
    }
}
