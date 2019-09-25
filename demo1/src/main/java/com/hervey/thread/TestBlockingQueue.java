package com.hervey.thread;

import java.util.concurrent.*;

/**
 * @program: thread
 * @description: 测试
 * @author: hewen
 * @create: 2019-09-06 17:11
 **/
public class TestBlockingQueue {

    static BlockingQueue<Object> blockingQueue = new ArrayBlockingQueue<Object>(5);

    private static volatile boolean flag = true;

    static class Produce implements Runnable {

        @Override
        public void run() {
            int i = 1;
            while (flag && i<5) {
                blockingQueue.add(i++);
            }
        }
    }

    static class Consume implements Runnable {

        private String consumeName;

        Consume(String consumeName) {
            this.consumeName = consumeName;
        }

        @Override
        public void run() {
          while (!blockingQueue.isEmpty()) {
              try {
                  System.out.println(consumeName + "正在消费：" + blockingQueue.take());
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
          }
        }
    }

    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(20);
        service.execute(new Produce());
        service.execute(new Consume("消费者1"));
        service.execute(new Consume("消费者2"));
        service.execute(new Consume("消费者3"));

    }
}
