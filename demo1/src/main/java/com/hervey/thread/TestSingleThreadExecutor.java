package com.hervey.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: thread
 * @description: 测试singleThread
 * @author: hewen
 * @create: 2019-09-05 14:14
 **/
public class TestSingleThreadExecutor {

    static class Test implements Runnable {
        private Integer num;
        private String threadType;

        Test(Integer param, String threadType) {
            this.num = param;
            this.threadType = threadType;
        }

        @Override
        public void run() {
            System.out.println(threadType + "num=" + num + "==>" + Thread.currentThread().getName() + "线程计算=" + num / (num - 2));
        }
    }

    public static void main(String args[]) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        ExecutorService service1 = Executors.newFixedThreadPool(4);
        for (int i = 10; i >= 1; i--) {
            service.execute(new Test(i, "newSingleThreadExecutor"));
//            service1.execute(new Test(i, "newFixedThreadPool"));
        }
    }
}
