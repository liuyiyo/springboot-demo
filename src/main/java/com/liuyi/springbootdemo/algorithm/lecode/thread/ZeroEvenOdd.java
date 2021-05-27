package com.liuyi.springbootdemo.algorithm.lecode.thread;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.IntConsumer;

class ZeroEvenOdd {

    AtomicBoolean even = new AtomicBoolean(false);
    AtomicBoolean odd = new AtomicBoolean(false);

    private int n;
    
    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        //一共输出n个0
        for (int i = 1; i <= n; i++) {
            for (;;) {
                if(!even.get()&&!odd.get()) break;
            }
            printNumber.accept(0);
            //如果是偶数，则将even设置为true
            if(i%2==0){
                even.set(true);
            }else {
                odd.set(true);
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i+=2) {
            for (;;) {
                if(even.get()) break;
            }
            printNumber.accept(i);
            even.set(false);
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i+=2) {
            for (;;) {
                if(odd.get()) break;
            }
            printNumber.accept(i);
            odd.set(false);
        }
    }
}