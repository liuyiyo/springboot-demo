package com.liuyi.springbootdemo.exercise.juc.atomic;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName AtomicBooleanTest
 * @description：
 * 两个线程交叉打印A-Z和1-26
 * 使用AtomicBoolean
 * @author：liuyi
 * @Date：2021/5/21 10:21
 */
public class AtomicIntegerTest {
    private static AtomicInteger integer = new AtomicInteger(0);
    public static void main(String[] args) {
        //打印A-Z的线程
        Thread thread1 = new Thread(() -> {
            char c = 'A';
            for (int i = 0; i < 26; i++) {
                for (;;) {
                    if(integer.get()==1) break;
                }
                System.out.println(c);
                c++;
                integer.getAndDecrement();
            }
        });
        //打印1-26的线程
        Thread thread2 = new Thread(() -> {
            for (int i = 1; i <= 26; i++) {
                for (;;) {
                    if(integer.get()==0) break;
                }
                System.out.println(i);
                integer.getAndIncrement();
            }
        });
        thread1.start();
        thread2.start();
    }
}
