package com.liuyi.springbootdemo.tank;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName T
 * @description：
 * @author：liuyi
 * @Date：2021/1/18 17:14
 */
public class T_Main {
    public static void main(String[] args) {
        //创建一个创建
        TankFrame tf = new TankFrame();
        //组装5个坦克
        for (int i = 1; i < 6; i++) {
            TankFrame.tankList.add(new Tank(50+i*80,200,Dir.DOWN,tf));
        }
        while (true){
            try {
                TimeUnit.MILLISECONDS.sleep(50);
                tf.repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
