package com.liuyi.springbootdemo.exercise.juc.atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @ClassName AtomicIntegerFieldUpdaterTest
 * @description：AtomicIntegerFieldUpdater和AtomicInteger的区别在于
 * 前者是针对对象的某个属性，后者只能解决基本类型
 * @author：liuyi
 * @Date：2021/5/21 11:42
 */
public class AtomicIntegerFieldUpdaterTest {
    public static void main(String[] args) throws InterruptedException {
        AtomicIntegerFieldUpdater updater = AtomicIntegerFieldUpdater.newUpdater(Student.class,"num");
        Student student = new Student();
        Thread thread1 = new Thread(() ->{
            updater.set(student,10);
        });
        thread1.start();
        Thread thread2 = new Thread(() ->{
            updater.set(student,20);
        });
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(student.num);
    }
}

class Student{
    public volatile int num;
}
