package com.liuyi.springbootdemo.exercise.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName ListDemo
 * @description：
 * @author：liuyi
 * @Date：2020/12/20 23:15
 */
public class ListDemo {
    public static void main(String[] args) {
        //ArrayList线程不安全
        //ArrayList底层是由数组实现的，查询效率高，但是插入和删除效率低，因为会有复制的过程
        //虽然添加的时候也会有复制的过程，但是如果是顺序添加，只有在扩容的时候才会进行复制，效率还是很高的
        //所以ArrayList适合顺序添加和随机访问的场景
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        //怎么确保一个集合不能被修改？
        //创建一个只读集合
        List<Integer> list = Collections.unmodifiableList(arrayList);
        list.add(2);




    }
}
