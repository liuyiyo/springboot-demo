package com.liuyi.springbootdemo.exercise.juc.pool;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName CallableDemo
 * @description：
 * @author：liuyi
 * @Date：2021/1/16 13:14
 */
public class CallableDemo {
    public static void main(String[] args) {
        //有返回值
        FutureTask futureTask = new FutureTask(()->{
            TimeUnit.SECONDS.sleep(2);
            return "啊啊啊啊";
        });
        new Thread(futureTask).start();
        Object o = null;
        try {
            o = futureTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(o);



    }
}
