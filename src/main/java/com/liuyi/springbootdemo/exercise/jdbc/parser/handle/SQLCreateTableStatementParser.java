package com.liuyi.springbootdemo.exercise.jdbc.parser.handle;

import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.ast.statement.SQLCreateTableStatement;
import com.liuyi.springbootdemo.exercise.jdbc.parser.entity.ParserResult;
import com.liuyi.springbootdemo.exercise.jdbc.parser.constant.ParserTypeEnum;

/**
 * @ClassName SQLCreateTableStatementFormat
 * @description：CreateTable语句解析类
 * @author：liuyi
 * @Date：2021/1/26 17:22
 */
public class SQLCreateTableStatementParser implements MysqlFormat {
    @Override
    public void format(SQLStatement sqlStatement, ParserResult formatResult) {
        SQLCreateTableStatement sqlCreateTableStatement = (SQLCreateTableStatement)sqlStatement;
        //设置表类型
        formatResult.setDbType(sqlCreateTableStatement.getDbType());
        //设置解析类型
        formatResult.setParserType(ParserTypeEnum.CREATE_TABLE);
        //设置表名
        formatResult.setTableName(sqlCreateTableStatement.getTableName());
    }
}
