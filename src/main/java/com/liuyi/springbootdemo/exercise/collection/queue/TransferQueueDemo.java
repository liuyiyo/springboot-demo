package com.liuyi.springbootdemo.exercise.collection.queue;

import java.util.concurrent.LinkedTransferQueue;

/**
 * @ClassName TransferQueueDemo
 * @description：
 * @author：liuyi
 * @Date：2021/1/15 21:42
 */
public class TransferQueueDemo {
    public static void main(String[] args) {
        //等待某个事情有反馈，再继续
        LinkedTransferQueue<String> queue = new LinkedTransferQueue<>();
        new Thread(()->{
            try {
                System.out.println(queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        try {
            //transfer方法装入队列，会阻塞，直到有其他线程取走该数据
            queue.transfer("aaa");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
