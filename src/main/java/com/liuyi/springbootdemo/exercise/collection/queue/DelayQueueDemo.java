package com.liuyi.springbootdemo.exercise.collection.queue;

import java.util.PriorityQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName DelayQueueDemo
 * @description：
 * @author：liuyi
 * @Date：2021/1/15 21:13
 */
public class DelayQueueDemo {
    public static void main(String[] args) {
        //队列中的任务按指定的时间执行，常用来作任务调度

    }

}
class MyTask implements Delayed {

    private String name;

    private int time;

    public MyTask(String name, int time) {
        this.name = name;
        this.time = time;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return 0;
    }

    @Override
    public int compareTo(Delayed o) {
        return 0;
    }
}