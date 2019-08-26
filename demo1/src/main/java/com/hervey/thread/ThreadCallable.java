package com.hervey.thread;

import java.util.concurrent.*;

/**
 * @program: thread
 * @description: Callable线程
 * @author: hewen
 * @create: 2019-08-26 14:51
 **/
public class ThreadCallable {

    private int num = 10;

    /**
     * 实现Callable的线程
     */
    class TestCallable implements Callable<String> {
        @Override
        public String call() throws Exception {
            Thread.sleep(5000);
            return "hello";
        }
    }

    /**
     * 实现Runnable的线程
     */
    class TestRunnable implements Runnable {
        @Override
        public void run() {
            int sleepTime = 1000;
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("start");
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 创建线程池 数量为10
        ExecutorService es = Executors.newFixedThreadPool(10);
        // Callable线程可以有返回值
        Future<String> future = es.submit(new ThreadCallable().new TestCallable());
        // 在调用get方法的时候会阻塞线程池知道获取到了才会继续执行
        System.out.println(future.get());
        try {
            // 用于取消线程任务，传参表示是否取消正在执行的线程
            future.cancel(true);
            if (!future.isCancelled()) {
                // 此处通过设置超时时间，在一秒后如果future还未获取到返回值则直接结束
                System.out.println(future.get(10000, TimeUnit.MILLISECONDS));
            }
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        // isDone方法判断future是否完成即有没有获取到返回值
        System.out.println(future.isDone());

        // 执行Runnable线程
        es.submit(new ThreadCallable().new TestRunnable());

        if (!es.isShutdown()) {
            es.shutdown();
        }
    }
}
