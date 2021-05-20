package com.liuyi.springbootdemo.exercise.jdbc;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @ClassName SocketTest
 * @description：
 * @author：liuyi
 * @Date：2021/4/28 14:57
 */
public class SocketTest {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket();
        InetSocketAddress address = new InetSocketAddress(InetAddress.getByName("node01"),3306);
        socket.connect(address);
        System.out.println("连接成功");
    }
}
