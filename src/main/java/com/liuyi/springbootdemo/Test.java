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
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 1000_000_000; i++) {
                System.out.println(i);
            }
        });
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();

    }
}


