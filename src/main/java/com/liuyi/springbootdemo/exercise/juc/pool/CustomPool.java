package com.liuyi.springbootdemo.exercise.juc.pool;

import java.util.concurrent.*;

/**
 * @ClassName CustomPool
 * @description：
 * @author：liuyi
 * @Date：2021/1/16 14:17
 */
public class CustomPool {
    public static void main(String[] args) {
        ThreadPoolExecutor cutom = new ThreadPoolExecutor(
                20,//核心线程数
                500,//最大线程数
                20,//线程空闲时间
                TimeUnit.SECONDS,//空闲时间单位
                new ArrayBlockingQueue<>(20),//任务队列
                Executors.defaultThreadFactory(),//创建线程的工厂方法（可以自定义线程名称）
                new RejectedExecutionHandler() {//拒绝策略，默认4个，一般都是自定义
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {

                    }
                });
    }
}
