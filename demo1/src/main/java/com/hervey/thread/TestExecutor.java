package com.hervey.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: thread
 * @description: 测试Executor
 * @author: hewen
 * @create: 2019-09-04 17:53
 **/
public class TestExecutor {


    static class Animal implements Runnable {

        private String animalTalk;

        Animal(String animalSpeak) {
            this.animalTalk = animalSpeak;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " :是谁再叫, is " + animalTalk);
        }
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        ExecutorService service1 = Executors.newFixedThreadPool(5);
        for (int i = 1; i< 10; i++) {
            service.execute(new Animal("cat"));
            service1.execute(new Animal("dog"));
        }
    }
}
