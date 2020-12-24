package com.liuyi.springbootdemo.exercise.collection;

import com.google.common.primitives.Ints;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName ArrayTest
 * @description：数组demo
 * @author：liuyi
 * @Date：2020/12/20 19:38
 */
public class ArrayDemo {

    public static void main(String[] args) {
        //数组和集合的区别？
        //数组是固定长度的，集合是可变长度的。
        //数据可以存储基本数据类型，也可以存储引用类型。集合只能存储引用数据类型
        //数组存储的元素必须是同一数据类型，集合可以存储不同数据类型的元素。
        int[] ints = new int[]{1,2,3,4,5};
        //guava数组转list
        List<Integer> list = Ints.asList(ints);
        System.out.println(list);
        //list转数组
        int[] ints1 = Ints.toArray(list);
        System.out.println(ints1);
    }

}
