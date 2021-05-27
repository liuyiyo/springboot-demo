package com.liuyi.springbootdemo.exercise.juc.atomic;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @ClassName AtomicBooleanTest
 * @description：
 * 两个线程交叉打印A-Z和1-26
 * 使用AtomicBoolean
 * @author：liuyi
 * @Date：2021/5/21 10:21
 */
public class AtomicBooleanTest {
    private static AtomicBoolean aBoolean = new AtomicBoolean(true);
    public static void main(String[] args) {
        //打印A-Z的线程
        Thread thread1 = new Thread(() -> {
            char c = 'A';
            for (int i = 0; i < 26; i++) {
                for (;;) {
                    if(aBoolean.get()) break;
                }
                System.out.println(c);
                c++;
                aBoolean.set(false);
            }
        });
        //打印1-26的线程
        Thread thread2 = new Thread(() -> {
            for (int i = 1; i <= 26; i++) {
                for (;;) {
                    if(!aBoolean.get()) break;
                }
                System.out.println(i);
                aBoolean.set(true);
            }
        });
        thread1.start();
        thread2.start();
    }
}
