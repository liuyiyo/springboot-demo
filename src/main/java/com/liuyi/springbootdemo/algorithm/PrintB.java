package com.liuyi.springbootdemo.algorithm;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ClassName PrintB
 * @description：
 * @author：liuyi
 * @Date：2021/5/6 9:59
 */

public class PrintB {
    //打印整数的二进制
    public static void print(int num){
        for (int i = 31; i >=0 ; i--) {
            System.out.print((num & (1 << i))==0?"0":"1");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        print(0x100);
        System.out.println(Long.MAX_VALUE);
//        int num = 4;
//        print(num);
//
////        System.out.println(Integer.MAX_VALUE);
//        //取反
//        print(~ num);
//        int a = 443435534;
//        int b = 1231435453;
//        System.out.println("=========");
//        print(a);
//        print(b);
//        System.out.println("=========");
//        // 或运算 只要有1就是1,00为0
//        print(a | b);
//        // 与运算 只有11为1，其他为0
//        print(a & b);
//        // 异或 相同为0，不同为1
//        print(a ^ b);

//        int c = Integer.MIN_VALUE;
//        print(c);
//        //带符号右移
//        print(c >> 1);
//        //不带符号右移
//        print(c >>> 1);
//
//        //一个正数对应的负数就等于正数取反+1
//        //同理一个负数对应的正数也等于负数取反+1
//        //负数最小的数不支持这个逻辑
//        int d = 5;
//        System.out.println(~ d + 1);
//
//        System.out.println(~ 0 + 1);

    }
}
