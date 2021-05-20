package com.liuyi.springbootdemo;

import java.sql.Statement;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName Test
 * @description：
 * @author：liuyi
 * @Date：2021/1/10 22:50
 */
public class Test {
    public static void main(String[] args) {
        String host = "jdbc:lighting://192.168.0.101:19504/dataBase";
        System.out.println(host.substring(host.lastIndexOf("/")+1));
    }
}


