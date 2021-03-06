package com.liuyi.springbootdemo.algorithm.lecode.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/**
 * @Author liuyi
 * @Description 两个不同的线程将会共用一个 FooBar实例。其中一个线程将会调用foo()方法，另一个线程将会调用bar()方法。
 * 请设计修改程序，以确保 "foobar" 被输出 n 次。
 * @Date 2021/5/20 16:30
 * @Param
 * @return
 **/
//示例 1:
//        输入: n = 1
//        输出: "foobar"
//        解释: 这里有两个线程被异步启动。其中一个调用 foo() 方法, 另一个调用 bar() 方法，"foobar" 将被输出一次。
//示例 2:
//        输入: n = 2
//        输出: "foobarfoobar"
//        解释: "foobar" 将被输出两次。
class FooBar {
    final Object lock = new Object();

    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            synchronized (lock){
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                lock.wait();
                lock.notify();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            synchronized (lock){
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                lock.notify();
                lock.wait();
            }
        }
    }
}