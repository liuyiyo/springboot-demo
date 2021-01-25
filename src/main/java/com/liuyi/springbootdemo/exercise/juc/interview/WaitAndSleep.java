package com.liuyi.springbootdemo.exercise.juc.interview;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName WaitAndSleep
 * @description：wait和sleep的区别
 * @author：liuyi
 * @Date：2021/1/18 11:18
 */
public class WaitAndSleep {

    static WaitAndSleep lock = new WaitAndSleep();

    public static void main(String[] args) {
        //wait和sleep的区别
        //1.wait是Object的方法，sleep是Thread的静态方法
        //2,作用都是阻塞线程的执行，但是wait会释放锁，sleep不会
        //3,wait方法调用后，线程不会自动苏醒，需要其他的线程调用notify或者notifyAll进行唤醒，
        //而Sleep方法可以指定一段时间之后自动苏醒。所以wait常常用来进行线程之间的交互和通信，
        //sleep通常用于暂停执行一段时间。
        //以下例子的结果可以，两个线程都打印了开始运行，说明wait是会释放锁的，并且只有其他线程释放了锁才会继续执行
        for (int i = 0; i < 2; i++) {
            final int a = i;
            new Thread(()->{
                synchronized (lock){
                    System.out.println("开始运行第"+a+"个线程");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("结束运行第"+a+"个线程");
                }
            }).start();
        }
        try {
            TimeUnit.SECONDS.sleep(5);
            synchronized (lock){
                lock.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //以下示例的执行结果可以说明sleep是不会释放锁的，
//        for (int i = 0; i < 2; i++) {
//            final int a = i;
//            new Thread(()->{
//                synchronized (lock){
//                    System.out.println("开始运行第"+a+"个线程");
//                    try {
//                        Thread.sleep(10000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println("结束运行第"+a+"个线程");
//                }
//            }).start();
//        }
    }
}
