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
 * 使用volatile实现（不对）
 * @author：liuyi
 * @Date：2021/1/10 14:41
 */
public class Interview01 {
    //volatile最好不要修饰引用对象，修饰越简单的值越好
    volatile List<Integer> list = Collections.synchronizedList(new ArrayList<>());
    private void add(Integer integer){
        list.add(integer);
    }
    private int size(){
        return list.size();
    }
    public static void main(String[] args) {

        Interview01 list = new Interview01();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                list.add(i);
                System.out.println("添加第"+i+"个元素");
//                try {
//                    TimeUnit.SECONDS.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        });
        thread1.start();

        Thread thread2 = new Thread(() -> {
            while (true) {
                if (list.size() == 5) break;
            }
            System.out.println("t2结束");
        });
        thread2.start();

    }
}
