package com.liuyi.springbootdemo.algorithm;

import java.util.Arrays;

/**
 * @ClassName SortDemo
 * @description：
 * @author：liuyi
 * @Date：2021/5/6 11:39
 */
public class SortDemo {

    //交换
    public static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,5,5,4,9,2,3,6};
//        bubbleSort(arr);
//        System.out.println(Arrays.toString(arr));
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    //冒泡排序
    //每两个数字比较，将大的往后面移动
    public static void bubbleSort(int[] arr){
        //0 n-1
        //0 n-2
        //0 end
        int n = arr.length-1;
        for (int i = n; i >=0 ; i--) {
            for (int j = 0; j < i && arr[j]>arr[j+1]; j++) {
                swap(arr,j,j+1);
            }
        }
    }

    //插入排序
    //跟玩纸牌一样，将一个数放到数组对应的位置
    public static void insertSort(int[] arr){
        //0 1
        //0 2
        //0 3
        //0 n
        int n = arr.length -1;
        for (int i = 0; i < n ; i++) {
            for (int j = i; j>=0; j--) {
                if(arr[j+1]<arr[j]){
                    swap(arr,j,j+1);
                }
            }
        }
    }

}
