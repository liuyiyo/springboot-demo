package com.liuyi.springbootdemo.exercise.guava;

import java.util.List;

/**
 * @ClassName User1
 * @description：
 * @author：liuyi
 * @Date：2021/1/4 17:38
 */
public class User2 {
    private int age;
    private String name;
    private List<String> stringList;
    public User2() {
    }

    public User2(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getStringList() {
        return stringList;
    }

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    @Override
    public String toString() {
        return "User2{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", stringList=" + stringList +
                '}';
    }
}
