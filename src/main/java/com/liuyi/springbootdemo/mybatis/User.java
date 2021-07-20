package com.liuyi.springbootdemo.mybatis;

import lombok.Data;

import java.util.List;

/**
 * @ClassName User
 * @description：
 * @author：liuyi
 * @Date：2021/6/11 13:42
 */
@Data
public class User {
    private int id;
    private String name;
    private int age;
    private Integer aaa;
    private byte[] bytes;
    private List<Boolean> list;
    private List<Integer> lis2;
    private List<byte[]> lis3;
}
