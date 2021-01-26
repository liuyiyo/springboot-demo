package com.liuyi.springbootdemo.exercise.jdbc.format.formatimpl;

import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.ast.statement.SQLCreateTableStatement;
import com.liuyi.springbootdemo.exercise.jdbc.format.FormatResult;
import com.liuyi.springbootdemo.exercise.jdbc.format.MysqlFormat;

/**
 * @ClassName SQLCreateTableStatementFormat
 * @description：
 * @author：liuyi
 * @Date：2021/1/26 17:22
 */
public class SQLCreateTableStatementFormat implements MysqlFormat {
    @Override
    public FormatResult format(SQLStatement sqlStatement) {
        FormatResult formatResult = new FormatResult();
        SQLCreateTableStatement sqlCreateTableStatement = (SQLCreateTableStatement)sqlStatement;
        formatResult.setDbType(sqlCreateTableStatement.getDbType());
        formatResult.setParserType("create_table");
        formatResult.setTableName(sqlCreateTableStatement.getTableName());
        return formatResult;
    }
}
