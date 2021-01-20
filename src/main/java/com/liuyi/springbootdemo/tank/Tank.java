package com.liuyi.springbootdemo.tank;

import java.awt.*;

import static com.alibaba.fastjson.JSONPatch.OperationType.move;

/**
 * @ClassName Tank
 * @description：
 * @author：liuyi
 * @Date：2021/1/18 20:40
 */
public class Tank {
    private int x,y;
    private Dir dir = null;
    private static final int SPEED = 5;
    private boolean moving = false;
    private TankFrame tf = null;
    //坦克的宽度和高度
    public static int WIDTH = ResourceMgr.tankD.getWidth(),HEIGHT = ResourceMgr.tankD.getHeight();
    public Tank(int x, int y, Dir dir,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public void paint(Graphics g) {
        switch (dir){
            case LEFT:
                g.drawImage(ResourceMgr.tankL,x,y,null);
                break;
            case UP:
                g.drawImage(ResourceMgr.tankU,x,y,null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.tankR,x,y,null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.tankD,x,y,null);
                break;
            default:
                break;
        }
        move();
    }

    private void move() {
        if(!moving) return;
        switch (dir){
            case LEFT:
                x -= SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
        }
    }

    public void fire() {
        int bx = this.x + Tank.WIDTH/2 - Bullet.WIDTH/2;
        int by = this.y + Tank.HEIGHT/2 - Bullet.HEIGHT/2;
        tf.bulletList.add(new Bullet(bx,by,this.dir,tf));
    }
}
