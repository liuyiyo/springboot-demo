package com.liuyi.springbootdemo.exercise.jdbc;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName MysqlJdbcTest
 * @description：
 * @author：liuyi
 * @Date：2021/1/11 23:18
 */
public class MysqlJdbcTest {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/test_liuyi?" +
                    "user=root&password=123456");
            String s = JSONObject.toJSONString(conn);
            System.out.println(s);
            conn = (Connection) JSON.parse(s);
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
//        Map<String,Connection> map = new HashMap<>();
//        map.put("test1",conn);
//        new Thread(()->{
//            Connection test1 = map.get("test1");
//            try {
//                test1.close();
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
//        }).start();

        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT id FROM user");

            // or alternatively, if you don't know ahead of time that
            // the query will be a SELECT...

            if (stmt.execute("SELECT id FROM user")) {
                rs = stmt.getResultSet();
            }
            while (rs.next()){
                int anInt = rs.getInt(1);
                System.out.println(anInt);

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) {
                } // ignore
                rs = null;
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) {
                } // ignore
                stmt = null;
            }
        }

    }
}
