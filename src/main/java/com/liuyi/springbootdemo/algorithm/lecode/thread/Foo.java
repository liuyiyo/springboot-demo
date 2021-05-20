package com.liuyi.springbootdemo.algorithm.lecode.thread;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @Author liuyi
 * @Description 三个不同的线程 A、B、C 将会共用一个 Foo 实例。
 *
 * 一个将会调用 first() 方法
 * 一个将会调用 second() 方法
 * 还有一个将会调用 third() 方法
 * 请设计修改程序，以确保 second() 方法在 first() 方法之后被执行，third() 方法在 second() 方法之后被执行。
 * @Date 2021/5/20 15:27
 * @Param
 * @return
 **/
class Foo {
    //通过Atomic保证执行顺序
    AtomicBoolean firstBoolean = new AtomicBoolean();
    AtomicBoolean secondBoolean = new AtomicBoolean();
    public Foo() {}

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        firstBoolean.set(true);
    }

    public void second(Runnable printSecond) throws InterruptedException {
        for (;;) {
            if(firstBoolean.get()) break;
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        secondBoolean.set(true);
    }

    public void third(Runnable printThird) throws InterruptedException {
        for (;;) {
            if(secondBoolean.get()) break;
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }

}