package com.liuyi.springbootdemo.exercise.jdbc.parser;

import com.alibaba.druid.DbType;
import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.util.JdbcConstants;

import java.util.List;

/**
 * @ClassName FormatTest
 * @description：
 * @author：liuyi
 * @Date：2021/1/26 17:25
 */
public class ParserTest {
    public static void main(String[] args) {
        //设置数据库类型
        DbType dbType = JdbcConstants.MYSQL;
//        String sql = "alter table student modify s_name varchar(40) collate utf8mb4_unicode_ci not null comment 'modify修改的名称';";
        String sql = "drop table student;";
        List<SQLStatement> stmtList = SQLUtils.parseStatements(sql, dbType);
        SQLStatement sqlStatement = stmtList.get(0);
        String className = sqlStatement.getClass().getSimpleName();
        MysqlFormat mysqlFormat = BeanFactory.INSTANCE.getBean(ParserTypeEnum.findClassName(className));
        if (mysqlFormat == null) {
            throw new RuntimeException("暂时不支持当前语法解析，className===="+className);
        }
        FormatResult formatResult = new FormatResult();
        mysqlFormat.format(sqlStatement,formatResult);
        System.out.println(formatResult);

    }
}
