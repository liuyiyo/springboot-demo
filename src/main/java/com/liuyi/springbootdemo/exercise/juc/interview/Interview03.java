package com.liuyi.springbootdemo.exercise.juc.interview;

import org.checkerframework.checker.units.qual.C;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName Interview01
 * @description：面试题
 * //实现一个容器，实现两个方法，一个add，一个size
 * //写两个线程，线程1添加10个元素到容器中。线程2监控元素的个数，当个数到5给时，线程2给出提示并结束
 * 使用CountDownLatch实现
 * @author：liuyi
 * @Date：2021/1/10 14:41
 */
public class Interview03 {

    private List<Integer> list = Collections.synchronizedList(new ArrayList<>());
    private void add(Integer integer){
        list.add(integer);
    }
    private int size(){
        return list.size();
    }
    public static void main(String[] args) {
        Interview03 interview03 = new Interview03();
        //使用两个门栓
        //countDownLatch1用来控制监控线程是否执行
        //countDownLatch2用来控制添加线程是否执行
        CountDownLatch countDownLatch1 = new CountDownLatch(1);
        CountDownLatch countDownLatch2 = new CountDownLatch(1);
        new Thread(()->{
            System.out.println("监控线程启动");
            try {
                countDownLatch1.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch2.countDown();
            System.out.println("监控线程结束");
        }).start();
        new Thread(()->{
            System.out.println("添加线程启动");
            for (int i = 0; i < 10; i++) {
                interview03.add(i);
                System.out.println("添加第"+i+"个元素");
                if(i==4){
                    countDownLatch1.countDown();
                    try {
                        countDownLatch2.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }
}
