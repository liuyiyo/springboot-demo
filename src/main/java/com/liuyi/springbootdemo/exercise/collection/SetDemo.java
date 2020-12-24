package com.liuyi.springbootdemo.exercise.collection;

import java.util.HashSet;

/**
 * @ClassName SetDemo
 * @description：
 * @author：liuyi
 * @Date：2020/12/20 22:57
 */
public class SetDemo {
    public static void main(String[] args) {
        //HashSet由HashMap实现，存放的值对应的就是hashMap的key值
        //HashSet可以存放null
        //HashSet存放的元素是不重复的，HashSet通过计算对象hashCode值确定在数组节点得位置，
        //如果两个对象相等，则hashCode一定是相同的
        //如果hashCode相同，在通过equals比较两个对象是否相等，以确保元素不重复。
        //存入HashSet的值同样必须要重写hashCode和equals，尽量避免出现hash冲突，提高查询效率
        HashSet<String> set = new HashSet<>();
        set.add(null);
        set.add(null);
        set.add("123");
        System.out.println(set.size());

    }
}
