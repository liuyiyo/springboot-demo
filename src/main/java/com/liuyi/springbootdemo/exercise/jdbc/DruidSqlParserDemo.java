package com.liuyi.springbootdemo.exercise.jdbc;

import com.alibaba.druid.DbType;
import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLDataType;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.ast.statement.*;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlCreateTableStatement;
import com.alibaba.druid.util.JdbcConstants;

import java.util.List;

/**
 * @ClassName DruidSqlParserDemo
 * @description：druid sql解析器
 * @author：liuyi
 * @Date：2021/1/25 16:55
 */
public class DruidSqlParserDemo {
    public static void main(String[] args) {
        DbType dbType = JdbcConstants.MYSQL; // 可以是ORACLE、POSTGRESQL、SQLSERVER、ODPS等
        String sql = "alter table student modify s_name varchar(40) collate utf8mb4_unicode_ci not null comment 'modify修改的名称';";
        List<SQLStatement> stmtList = SQLUtils.parseStatements(sql, dbType);
        SQLStatement sqlStatement = stmtList.get(0);
        System.out.println(sqlStatement.getClass().getSimpleName());

        SQLCreateTableStatement mysql = new MySqlCreateTableStatement();
        SQLColumnDefinition definition = new SQLColumnDefinition();
        definition.setDbType(DbType.mysql);
        definition.setName("test2");
        definition.setComment("测试字段2");
        SQLCharacterDataType dataType = new SQLCharacterDataType("varchar",70);
        definition.setDataType(dataType);
        mysql.addColumn(definition);
        System.out.println(stmtList.size());
    }
}
