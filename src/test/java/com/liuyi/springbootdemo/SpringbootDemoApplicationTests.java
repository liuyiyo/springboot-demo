package com.liuyi.springbootdemo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.liuyi.springbootdemo.redis.RedisUtil;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.security.RunAs;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
class SpringbootDemoApplicationTests {

    @Autowired
    private RedisUtil redisUtil;
    @Test
    void contextLoads() {
        redisUtil.set("test123","liuyi",60);

        System.out.println(redisUtil.get("test123"));

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection conn = null;
        try {
            System.out.println("啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊");
            Connection conn1 = DriverManager.getConnection("jdbc:mysql://localhost/test_liuyi?" +
                    "user=root&password=123456");
            redisUtil.set("connection_001", JSONObject.toJSONString(conn1),60);
            System.out.println("aaaaaaaaaaaaa"+redisUtil.get("connection_001").toString());
            conn = (Connection) JSON.parse(redisUtil.get("connection_001").toString());
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.createStatement();
            stmt.cancel();
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

        String str = "\0";
        System.out.println(str);

    }

}
