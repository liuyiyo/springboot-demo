package com.liuyi.springbootdemo.exercise.jdbc.parser.handle;

import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.ast.statement.SQLDropTableStatement;
import com.liuyi.springbootdemo.exercise.jdbc.parser.entity.ParserResult;
import com.liuyi.springbootdemo.exercise.jdbc.parser.constant.ParserTypeEnum;

/**
 * @ClassName SQLDropTableStatementFormat
 * @description：删除表语句解析类
 * @author：liuyi
 * @Date：2021/1/27 15:22
 */
public class SQLDropTableStatementParser implements MysqlFormat {
    @Override
    public void format(SQLStatement sqlStatement, ParserResult formatResult) {
        SQLDropTableStatement sqlDropTableStatement = (SQLDropTableStatement)sqlStatement;
        //设置解析类型
        formatResult.setParserType(ParserTypeEnum.DROP_TABLE);
        //设置表名
        formatResult.setTableName(sqlDropTableStatement.getTableSources().get(0).getTableName());
    }
}
