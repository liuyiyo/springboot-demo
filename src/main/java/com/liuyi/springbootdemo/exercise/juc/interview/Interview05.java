package com.liuyi.springbootdemo.exercise.juc.interview;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName Interview05
 * @description：生产者消费者问题
 * 通过wait和notify实现
 * @author：liuyi
 * @Date：2021/1/10 19:42
 */
public class Interview05 {


    public static void main(String[] args) {
        //生产者和消费者问题是线程模型中的经典问题：生产者和消费者在同一时间段内共用同一个存储空间。
        //生产者向空间里存放数据，而消费者取用数据，如果不加以协调可能会出现以下情况：
        //存储空间已满，而生产者占用着它，消费者等着生产者让出空间从而去除产品，生产者等着消费者消费产品，
        //从而向空间中添加产品。互相等待，从而发生死锁

        //创建一个仓库
        Depot<Integer> depot = new Depot<>(100);
        //创建10个生产者线程
        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                new Thread(new Producer<>(depot, i)).start();
            }
        }).start();
        //创建2个消费者线程
        new Thread(()->{
            for (int i = 0; i < 2; i++) {
                new Thread(new Consumer<>(depot, (t) -> System.out.println("消费一个物品" + t))).start();
            }
        }).start();

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(new Producer<>(depot, 999)).start();

    }
}


//仓库
class Depot<T>{

    //仓库最大容量
    private int maxSize;

    private LinkedList<T> list = new LinkedList<>();

    //当前容量
    private int count;

    public Depot(int maxSize) {
        this.maxSize = maxSize;
    }

    public synchronized void put(T t){
        while (list.size()==10){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.add(t);
        System.out.println("生产一个物品"+t);
        count++;
        this.notifyAll();
    }

    public synchronized T get(){
        while (list.size()==0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        T t = list.removeFirst();
        count++;
        this.notifyAll();
        return t;
    }

}

//生产者线程
class Producer<T> implements Runnable{

    private Depot depot;

    private T t;

    public Producer(Depot depot, T t) {
        this.depot = depot;
        this.t = t;
    }

    @Override
    public void run() {
        depot.put(t);
    }
}
//消费者
class Consumer<T> implements Runnable{
    private Depot depot;

    private CallBack callBack;

    public Consumer(Depot depot, CallBack callBack) {
        this.depot = depot;
        this.callBack = callBack;
    }

    @Override
    public void run() {
        while (true){
            callBack.call(depot.get());
        }
    }
}
//消费者回调函数
@FunctionalInterface
interface CallBack<T>{
    public void call(T t);
}
