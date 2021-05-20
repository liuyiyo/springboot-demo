package com.liuyi.springbootdemo.exercise.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName Server
 * @description：
 * @author：liuyi
 * @Date：2021/5/19 14:16
 */
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket socket = new ServerSocket(19504);
            Socket client = socket.accept();
            //先发送100
            OutputStream outputStream = client.getOutputStream();
            outputStream.write(new byte[]{100});
            InputStream inputStream = client.getInputStream();
            int value;
            while ((value = inputStream.read())!=-1){
                System.out.println(value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
