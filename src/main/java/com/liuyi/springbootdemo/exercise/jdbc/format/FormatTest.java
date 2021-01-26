package com.liuyi.springbootdemo.exercise.jdbc.format;

import com.alibaba.druid.DbType;
import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.ast.statement.SQLCreateTableStatement;
import com.alibaba.druid.util.JdbcConstants;
import com.liuyi.springbootdemo.exercise.jdbc.format.formatimpl.SQLAlterTableStatementFormat;
import com.liuyi.springbootdemo.exercise.jdbc.format.formatimpl.SQLCreateTableStatementFormat;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * @ClassName FormatTest
 * @description：
 * @author：liuyi
 * @Date：2021/1/26 17:25
 */
public class FormatTest {
    public static void main(String[] args) {
        DbType dbType = JdbcConstants.MYSQL; // 可以是ORACLE、POSTGRESQL、SQLSERVER、ODPS等
        String sql = "alter table student modify s_name varchar(40) collate utf8mb4_unicode_ci not null comment 'modify修改的名称';";
        List<SQLStatement> stmtList = SQLUtils.parseStatements(sql, dbType);
        SQLStatement sqlStatement = stmtList.get(0);
        String className = sqlStatement.getClass().getName();
        SQLAlterTableStatementFormat mysqlFormat = new SQLAlterTableStatementFormat();
//        MysqlFormat mysqlFormat = BeanFactory.INSTANCE.getBean(className);
        if (mysqlFormat == null) {
            throw new RuntimeException("暂时不支持当前语法解析，className===="+className);
        }
        FormatResult format = mysqlFormat.format(sqlStatement);
        System.out.println(format);

    }
}
