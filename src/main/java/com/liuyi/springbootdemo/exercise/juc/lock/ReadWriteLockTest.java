package com.liuyi.springbootdemo.exercise.juc.lock;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @ClassName ReadWriteLockTest
 * @description：读写锁
 * @author：liuyi
 * @Date：2021/1/10 13:07
 */
public class ReadWriteLockTest {
    static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    //读的时候，对写互斥，但是多个线程可以一起读
    static Lock readLock = readWriteLock.readLock();
    //写的时候，不管是读还是写都互斥
    static Lock writeLock = readWriteLock.writeLock();

}
