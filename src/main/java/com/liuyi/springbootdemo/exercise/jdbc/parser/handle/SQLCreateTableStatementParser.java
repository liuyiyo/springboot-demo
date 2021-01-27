package com.liuyi.springbootdemo.exercise.jdbc.parser.handle;

import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.ast.statement.SQLCreateTableStatement;
import com.liuyi.springbootdemo.exercise.jdbc.parser.FormatResult;
import com.liuyi.springbootdemo.exercise.jdbc.parser.MysqlFormat;
import com.liuyi.springbootdemo.exercise.jdbc.parser.ParserTypeEnum;

/**
 * @ClassName SQLCreateTableStatementFormat
 * @description：CreateTable语句解析类
 * @author：liuyi
 * @Date：2021/1/26 17:22
 */
public class SQLCreateTableStatementParser implements MysqlFormat {
    @Override
    public void format(SQLStatement sqlStatement,FormatResult formatResult) {
        SQLCreateTableStatement sqlCreateTableStatement = (SQLCreateTableStatement)sqlStatement;
        formatResult.setDbType(sqlCreateTableStatement.getDbType());
        formatResult.setParserType(ParserTypeEnum.CREATE_TABLE);
        formatResult.setTableName(sqlCreateTableStatement.getTableName());
    }
}
