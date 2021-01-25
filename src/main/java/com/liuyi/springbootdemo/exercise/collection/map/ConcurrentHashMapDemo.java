package com.liuyi.springbootdemo.exercise.collection.map;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * @ClassName ConcurrentHashMapDemo
 * @description：
 * @author：liuyi
 * @Date：2021/1/14 23:13
 */
public class ConcurrentHashMapDemo {
    public static void main(String[] args) {
        Map<String,String> map = new ConcurrentHashMap<>();
        //跳表底层链表实现，多层级链表
        //
//        Map<String,String> map = new ConcurrentSkipListMap<>();//高并发并且排序

    }
}
