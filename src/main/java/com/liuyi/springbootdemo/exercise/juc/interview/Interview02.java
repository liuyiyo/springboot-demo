package com.liuyi.springbootdemo.exercise.juc.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName Interview01
 * @description：面试题
 * //实现一个容器，实现两个方法，一个add，一个size
 * //写两个线程，线程1添加10个元素到容器中。线程2监控元素的个数，当个数到5给时，线程2给出提示并结束
 * 使用wait和notify实现
 * @author：liuyi
 * @Date：2021/1/10 14:41
 */
public class Interview02 {

    private List<Integer> list = Collections.synchronizedList(new ArrayList<>());
    private void add(Integer integer){
        list.add(integer);
    }
    private int size(){
        return list.size();
    }
    public static void main(String[] args) {
        Interview02 interview02 = new Interview02();
        final Object lock = new Object();
        new Thread(()->{
            synchronized (lock){
                System.out.println("T2------启动");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("T2-------结束");
                //监听结束要唤醒线程1，继续执行,这里不需要再调用wait方法释放锁了，因为当前线程已经执行完毕，会自动释放锁
                lock.notify();
            }
        }).start();
        //保证监听线程先启动
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            System.out.println("T1-------启动");
            for (int i = 0; i < 10; i++) {
                synchronized (lock){
                    interview02.add(i);
                    System.out.println("添加第"+i+"个元素");
                    if(interview02.size()==5){
                        //当添加的个数为5时候，唤醒线程2
                        //这里注意，notify是不能释放锁的，所以要将当前线程wait才能释放锁
                        lock.notify();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                System.out.println("T1-----结束");

            }
        }).start();


    }
}
