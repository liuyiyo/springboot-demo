package com.liuyi.springbootdemo.exercise.collection.queue;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @ClassName ConcurrentLinkedQueueDemo
 * @description：
 * @author：liuyi
 * @Date：2021/1/14 23:39
 */
public class ConcurrentLinkedQueueDemo {
    //模拟票容器
    private static final Queue<String> ticketList = new ConcurrentLinkedQueue<>();
    static {
        for (int i = 0; i < 1000; i++) {
            ticketList.add("编号为"+i+"的票");
        }
    }

    public static void main(String[] args) {
        //模拟10个窗口卖票
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                while (true){
                    String ticket = ticketList.poll();
                    if(ticket==null) break;
                    System.out.println("卖出"+ticket);
                }
            }).start();
        }
    }
}
