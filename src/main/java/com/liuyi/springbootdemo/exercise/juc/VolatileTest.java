package com.liuyi.springbootdemo.exercise.juc;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

/**
 * @ClassName VolatileTest
 * @description：
 * @author：liuyi
 * @Date：2021/1/9 23:09
 */
public class VolatileTest {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("创建一个线程");
        });
        thread.interrupt();

        AtomicInteger integer = new AtomicInteger();

        
    }
}
