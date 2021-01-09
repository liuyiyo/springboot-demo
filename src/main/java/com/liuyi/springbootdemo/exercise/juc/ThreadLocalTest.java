package com.liuyi.springbootdemo.exercise.juc;

/**
 * @ClassName ThreadLocalTest
 * @description：
 * @author：liuyi
 * @Date：2020/12/29 22:11
 */
public class ThreadLocalTest {
    public static void main(String[] args) {
        //ThreadLocal最常用的场景是在web应用中获取当前接口操作的用户信息
        //比如shiro、springsecurity中获取当前用户都是通过ThreadLocal实现的
        //还有spring的事务也是通过thradLocal实现的
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("123");
        String s = threadLocal.get();
        //ThreadLocal造成内存泄漏的原因
        //ThreadLocal的key为弱引用，value为强引用，如果外部没有value对应的强引用，则在gc回收的时候
        //只会回收key，value不会被回收，这个时候就可能会产生内存泄漏，ThreadLocal已经考虑过这种情况
        //在调用它的set、get、remove方法的时候会自动清理掉key为null的数据，但是最好还是在当前线程的
        //最后调用remove方法.
    }
}
