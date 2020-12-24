package com.liuyi.springbootdemo.exercise.collection;

import java.util.*;

/**
 * @ClassName MapDemo
 * @description：
 * @author：liuyi
 * @Date：2020/12/20 21:59
 */
public class MapDemo {
    public static void main(String[] args) {
        //hashMap key和value都可以存null
        //java7，hashMap采用数组+链表实现
        //java8，hashMap采用数组+链表+红黑树实现
        //hash冲突出现的原因：hashMap是根据key值hashCode方法去计算在数组中的位置的，如果不同对象的hashCode相同，则会以链表的形式将这些对象追加下去。
        //这样就降低了hashMap的查询效率，这也是为什么java8引入红黑树的原因。
        //所以我们要尽量避免一个数组节点上，出现多个值，也就是要尽量避免hashCode相同的情况。
        //所以我们在重写equals时必须重写hashCode，就是为了尽量避免hash冲突的出现。

        //HashMap是如何进行扩容的?
        //①.在jdk1.8中，resize方法是在hashmap中的键值对大于阀值时或者初始化时，就调用resize方法进行扩容；
        //②.每次扩展的时候，都是扩展2倍；
        //③.扩展后Node对象的位置要么在原位置，要么移动到原偏移量两倍的位置。在putVal()中，我们看到在这个函数里面使用到了2次resize()方法，
        // resize()方法表示的在进行第一次初始化时会对其进行扩容，或者当该数组的实际大小大于其临界值值(第一次为12),这个时候在扩容的同时也会
        // 伴随的桶上面的元素进行重新分发，这也是JDK1.8版本的一个优化的地方，在1.7中，扩容之后需要重新去计算其Hash值，根据Hash值对其进行分
        // 发，但在1.8版本中，则是根据在同一个桶的位置中进行判断(e.hash & oldCap)是否为0，重新进行hash分配后，该元素的位置要么停留在原始位置，
        // 要么移动到原始位置+增加的数组大小这个位置上

        //HashMap 的长度为什么是2的幂次方？
        //作中如果除数是2的幂次则等价于与其除数减一的与(&)操作（也就是说
        //hash%length==hash&(length-1)的前提是 length 是2的 n 次方；）。” 并且 采用二进制位操作 &，相对于%能够提高运算效率，
        //这就解释了 HashMap 的长度为什么是2的幂次方。
        //那为什么是两次扰动呢？答：这样就是加大哈希值低位的随机性，使得分布更均匀，从而提高对应数组存储下标位置的随机性&均匀性，
        //终减少Hash冲突，两次就够了，已经达到了高位低位同时参与运算的目的
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put(null,null);
        System.out.println(hashMap.get(null));
        //TreeMap不可以存放value为null的值，因为null没办法排序
        //TreeMap底层是通过红黑树实现的，所以在效率上肯定没有HashMap快
        //在需要对值进行排序的情况下，使用TreeMap，其余情况尽量使用HashMap
        TreeMap<String,Object> treeMap = new TreeMap<>();
        treeMap.put("test",null);
        System.out.println(treeMap.get("test"));

    }
}
