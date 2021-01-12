package com.liuyi.springbootdemo.exercise.juc.atomic;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName CountDownLatch
 * @description：
 * @author：liuyi
 * @Date：2020/12/29 21:39
 */
public class CountDownLatchTest {
    public static void main(String[] args) {
        //CyclicBarrier和CountDownLatch的区别
        //CyclicBarrier可以循环触发，CountDownLatch只能触发一次
        Thread[] threads = new Thread[100];
        CountDownLatch latch = new CountDownLatch(threads.length);
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(()-> {
                System.out.println("当前线程执行完毕");
                //没执行完一个线程，countDown一下
                latch.countDown();
            });
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }

        try {
            //阻塞，直到100个线程执行完毕
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("所有的线程都执行完毕");

    }
}
