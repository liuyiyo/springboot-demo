package com.liuyi.springbootdemo.exercise.juc.lock;

import java.util.concurrent.Semaphore;

/**
 * @ClassName SemaphoreTest
 * @description：限流
 * @author：liuyi
 * @Date：2021/1/10 13:49
 */
public class SemaphoreTest {
    public static void main(String[] args){
        //限流，意思是同时只能2个线程一起执行,比如收费站，有多少个收费窗口就只能同时过多少个车
        Semaphore semaphore = new Semaphore(2);
        new Thread(()->{
            try {
                semaphore.acquire();
                System.out.println("t1-------start");
                Thread.sleep(100);
                System.out.println("t1-------end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                semaphore.release();
            }
        }).start();
        new Thread(()->{
            try {
                semaphore.acquire();
                System.out.println("t2-------start");
                Thread.sleep(100);
                System.out.println("t2-------end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                semaphore.release();
            }
        }).start();
    }
}
