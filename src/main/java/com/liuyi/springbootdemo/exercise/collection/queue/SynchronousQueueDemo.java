package com.liuyi.springbootdemo.exercise.collection.queue;

import java.util.Queue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TransferQueue;

/**
 * @ClassName SynchronousQueueDemo
 * @description：
 * @author：liuyi
 * @Date：2021/1/15 21:29
 */
public class SynchronousQueueDemo {
    public static void main(String[] args) {
        //用来给另外一个容器下达任务,容量为0
        SynchronousQueue<String> queue = new SynchronousQueue<>();
        new Thread(()->{
            try {
                System.out.println(queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        try {
            queue.put("aaa");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(queue.size());

    }
}
