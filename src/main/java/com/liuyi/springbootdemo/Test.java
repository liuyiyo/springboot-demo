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
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("sdgdsgdsgsdgs")
                .append(",");
        String substring = stringBuffer.substring(0, stringBuffer.length() - 1);
        System.out.println(substring);
    }
}


