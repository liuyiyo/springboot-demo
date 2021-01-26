package com.liuyi.springbootdemo.exercise.jdbc.format;

/**
 * @Author liuyi
 * @Description //对象工厂
 * @Date 2021/1/26 17:32
 **/
public enum BeanFactory {
    //传递一个类的全新类名来调用对象,将上述两种方案进行合体
    INSTANCE;
    //获取对象
    public MysqlFormat getBean(String className) {
        try {
            Class<? extends MysqlFormat> clz = (Class<? extends MysqlFormat>) Class.forName(className);
            MysqlFormat obj = clz.newInstance();
            return obj;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}