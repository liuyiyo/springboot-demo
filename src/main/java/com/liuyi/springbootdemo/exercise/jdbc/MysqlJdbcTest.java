package com.liuyi.springbootdemo.exercise.jdbc;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.*;

/**
 * @ClassName MysqlJdbcTest
 * @description：
 * @author：liuyi
 * @Date：2021/1/11 23:18
 */
public class MysqlJdbcTest {
    public static void main(String[] args){
//        selectTest();
//        batchInsert();
    }

    public static void batchInsert(){
        Connection conn = null;
        try {
            conn = getConnection();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        PreparedStatement ptmt  = null;
        ResultSet rs = null;
        try {
            //预编译SQL，减少sql执行，防止sql注入
            ptmt  = conn.prepareStatement("INSERT INTO `test`.`user` (\n" +
                    "\t`id`,\n" +
                    "\t`name`,\n" +
                    "\t`age`,\n" +
                    "\t`sex`,\n" +
                    "\t`address`,\n" +
                    "\t`status`,\n" +
                    "\t`create_user`,\n" +
                    "\t`create_time`,\n" +
                    "\t`modify_user`,\n" +
                    "\t`modify_time`\n" +
                    ") VALUES (?,?,?,?,?,?,?,?,?,?)");
            //传参
            for (int i = 1; i < 10; i++) {
                ptmt.setInt(1, i+1);
                ptmt.setString(2,"ly"+i);
                ptmt.setByte(3,(byte)i);
                ptmt.setString(4,"女");
                ptmt.setString(5,"重庆市南岸区"+i);
                ptmt.setByte(6,(byte)i);
                ptmt.setInt(7,i);
                ptmt.setDate(8,new Date(System.currentTimeMillis()));
                ptmt.setInt(9,i);
                ptmt.setDate(10,new Date(System.currentTimeMillis()));
                ptmt.addBatch();
            }
            //执行
            ptmt.executeBatch();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            close(conn,ptmt,rs);
        }
    }

    //查询测试
    public static void selectTest(Connection conn){
//        Connection conn = null;
//        try {
//            conn = getConnection();
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }

        PreparedStatement ptmt  = null;
        ResultSet rs = null;
        try {
            //预编译SQL，减少sql执行，防止sql注入
            ptmt  = conn.prepareStatement("SELECT id,name FROM user where id = ?");
            //传参
            ptmt.setInt(1, 1);
            //执行
            rs = ptmt.executeQuery();
            while (rs.next()){
                int anInt = rs.getInt(1);
                String name = rs.getString(2);
                System.out.println(anInt+":"+name);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            close(conn,ptmt,rs);
        }
    }


    //获取连接
    private static Connection getConnection() throws SQLException {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://node01/test");
        config.setUsername("root");
        config.setPassword("123456");
        HikariDataSource ds = new HikariDataSource(config);
        Connection conn = ds.getConnection();
        return conn;
    }
    //关闭连接
    private static void close(Connection conn,Statement ptmt,ResultSet rs){
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException sqlEx) {
            } // ignore
            rs = null;
        }
        if (ptmt != null) {
            try {
                ptmt.close();
            } catch (SQLException sqlEx) {
            } // ignore
            ptmt = null;
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
