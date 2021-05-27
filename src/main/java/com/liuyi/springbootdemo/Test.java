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
        String sql = "select sd,dsg,sdg from rest from";
        System.out.println(sql.indexOf("select"));
        System.out.println(sql.indexOf("from"));
        System.out.println("select * " + sql.substring(18));
        System.out.println(sql.substring(7,17));
    }
}


