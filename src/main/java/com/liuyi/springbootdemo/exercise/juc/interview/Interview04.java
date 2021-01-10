package com.liuyi.springbootdemo.exercise.juc.interview;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName Interview04
 * @description：面试题
 * 两个线程交叉打印A-Z和1-26
 * 使用wait和notify实现
 * @author：liuyi
 * @Date：2021/1/10 16:54
 */
public class Interview04 {
    public static void main(String[] args) {
        final Object lock = new Object();
        //打印A-Z的线程
        Thread thread1 = new Thread(() -> {
            char c = 'A';
            for (int i = 0; i < 26; i++) {
                synchronized (lock){
                    System.out.println(c);
                    c++;
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    lock.notify();
                }
            }
        });
        //打印1-26的线程
        Thread thread2 = new Thread(() -> {
            for (int i = 1; i <= 26; i++) {
                synchronized (lock){
                    System.out.println(i);
                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                }

            }
        });
        thread1.start();
        thread2.start();
    }
}
