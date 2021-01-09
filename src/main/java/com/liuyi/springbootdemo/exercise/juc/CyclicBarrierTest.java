package com.liuyi.springbootdemo.exercise.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @ClassName CycliBarriarTest
 * @description：栅栏同步工具类
 * @author：liuyi
 * @Date：2020/12/29 21:17
 */
public class CyclicBarrierTest {
    public static void main(String[] args) {

        //限流实际当中使用Guava RateLimiter

        //使用场景，当需要20个线程都执行完毕之后，再取执行某个操作，就需要使用CyclicBarrier
        //比如一个复杂的操作，需要访问数据库、网络、文件等，为了提高效率，可能需要并发执行，开启不同的线程去执行不同的操作
        //必须要这几个操作对应对应的线程都执行完毕之后，才能继续下一步操作，这个时候就需要使用CyclicBarrier
        //一般需要传入两个参数，第一个多少个线程积满触发，第二个是触发之后的操作
        CyclicBarrier barrier = new CyclicBarrier(20, () -> System.out.println("满人发车"));

        for (int i = 0; i < 100 ; i++) {
            new Thread(()->{
                try {
                    barrier.await();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();

        }
    }
}
