package com.liuyi.springbootdemo.exercise.collection.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @ClassName QueueDemo
 * @description：队列
 * @author：liuyi
 * @Date：2020/12/21 22:24
 */
public class QueueDemo {
    public static void main(String[] args) {
        //BlockingQueue是一个队列接口
        //BlockingQueue主要用于实现生产者消费者模式
        //poll和remove方法的区别：两者都是从队列中取数据，区别在于如果队列没有元素，poll会返回null，remove会抛出异常
        BlockingQueue queue = new ArrayBlockingQueue(10);


    }
}
