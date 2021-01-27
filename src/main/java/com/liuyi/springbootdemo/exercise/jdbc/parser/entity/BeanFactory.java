package com.liuyi.springbootdemo.exercise.jdbc.parser.entity;

import com.liuyi.springbootdemo.exercise.jdbc.parser.handle.MysqlFormat;

/**
 * @Author liuyi
 * @Description //对象工厂
 * @Date 2021/1/26 17:32
 **/
public enum BeanFactory {

    //传递一个类的全新类名来调用对象
    INSTANCE;

    /**
     * @Author liuyi
     * @Description //获取对象
     * @Date 2021/1/27 15:54
     * @Param [className]
     * @return com.liuyi.springbootdemo.exercise.jdbc.parser.handle.MysqlFormat
     **/
    public MysqlFormat getBean(String className) {
        try {
            Class clz = Class.forName(className);
            MysqlFormat obj = (MysqlFormat)clz.newInstance();
            return obj;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}