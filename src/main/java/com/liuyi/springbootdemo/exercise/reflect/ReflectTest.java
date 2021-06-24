package com.liuyi.springbootdemo.exercise.reflect;

import com.liuyi.springbootdemo.mybatis.User;

import java.lang.reflect.Field;

/**
 * @ClassName ReflectTest
 * @description：
 * @author：liuyi
 * @Date：2021/6/23 9:45
 */
public class ReflectTest {
    public static void main(String[] args) {
        Class classz = User.class;
        Field[] fields = classz.getFields();
        System.out.println(fields.length);
        Field[] declaredFields = classz.getDeclaredFields();
        System.out.println(declaredFields.length);
    }
}
