package com.liuyi.springbootdemo.exercise.jdbc.parser.handle;

import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.ast.statement.SQLAlterTableAddColumn;
import com.alibaba.druid.sql.ast.statement.SQLAlterTableItem;
import com.alibaba.druid.sql.ast.statement.SQLAlterTableStatement;
import com.alibaba.druid.sql.ast.statement.SQLColumnDefinition;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlAlterTableChangeColumn;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlAlterTableModifyColumn;
import com.liuyi.springbootdemo.exercise.jdbc.parser.FormatResult;
import com.liuyi.springbootdemo.exercise.jdbc.parser.MysqlFormat;
import com.liuyi.springbootdemo.exercise.jdbc.parser.ParserTypeEnum;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName SQLAlterTableStatementFormat
 * @description：AlterTable语句解析类
 * @author：liuyi
 * @Date：2021/1/26 18:37
 */
@Slf4j
public class SQLAlterTableStatementParser implements MysqlFormat {
    @Override
    public void format(SQLStatement sqlStatement,FormatResult formatResult) {
        SQLAlterTableStatement alterTableStatement = (SQLAlterTableStatement)sqlStatement;
        formatResult.setDbType(alterTableStatement.getDbType());
        formatResult.setTableName(alterTableStatement.getTableName());
        formatResult.setParserType(ParserTypeEnum.ALTER_TABLE);
        //设置子类型
        SQLAlterTableItem sqlAlterTableItem = alterTableStatement.getItems().get(0);
        String simpleName = sqlAlterTableItem.getClass().getSimpleName();
        switch (simpleName){
            case "MySqlAlterTableModifyColumn" :
                //处理modify语句
                MySqlAlterTableModifyColumn column = (MySqlAlterTableModifyColumn)sqlAlterTableItem;
                SQLColumnDefinition newColumnDefinition = column.getNewColumnDefinition();
                formatResult.setColumn(newColumnDefinition.getNameAsString());
                formatResult.setSubParserType("modify");
                formatResult.setSubSql(newColumnDefinition.toString());
                break;
            case "MySqlAlterTableChangeColumn" :
                //处理change语句
                MySqlAlterTableChangeColumn column2 = (MySqlAlterTableChangeColumn)sqlAlterTableItem;
                SQLColumnDefinition newColumnDefinition2 = column2.getNewColumnDefinition();
                formatResult.setColumn(newColumnDefinition2.getNameAsString());
                formatResult.setSubParserType("modify");
                formatResult.setSubSql(newColumnDefinition2.toString());
                break;
            case "SQLAlterTableAddColumn" :
                //处理添加语句
                SQLAlterTableAddColumn column3 = (SQLAlterTableAddColumn)sqlAlterTableItem;
                SQLColumnDefinition definition = column3.getColumns().get(0);
                formatResult.setColumn(definition.getColumnName());
                formatResult.setSubParserType("add");
                formatResult.setSubSql(definition.toString());
                break;
            default:
                log.info("不存在这样的子语句");
        }
    }
}
