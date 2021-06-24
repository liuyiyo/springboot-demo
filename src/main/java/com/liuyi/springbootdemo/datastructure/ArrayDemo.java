package com.liuyi.springbootdemo.datastructure;

/**
 * @ClassName ArrayDemo
 * @description：创建数据的三种方式
 * @author：liuyi
 * @Date：2021/6/17 16:33
 */
public class ArrayDemo {
    public static void main(String[] args) {
        int[] arr = new int[3];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("----------------------------------");
        int arr2[] = new int[3];
        arr2[0] = 1;
        arr2[1] = 2;
        arr2[2] = 3;
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(arr2[i]);
        }
        System.out.println("----------------------------------");
        int[] arr3 = new int[]{1,2,3};
        arr3[0] = 1;
        arr3[1] = 2;
        arr3[2] = 3;
        for (int i = 0; i < arr3.length; i++) {
            System.out.println(arr3[i]);
        }
    }
}
