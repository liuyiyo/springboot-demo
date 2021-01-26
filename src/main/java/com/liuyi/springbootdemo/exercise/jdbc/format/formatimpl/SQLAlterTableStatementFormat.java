package com.liuyi.springbootdemo.exercise.jdbc.format.formatimpl;

import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.ast.statement.SQLAlterTableItem;
import com.alibaba.druid.sql.ast.statement.SQLAlterTableStatement;
import com.alibaba.druid.sql.ast.statement.SQLColumnDefinition;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlAlterTableModifyColumn;
import com.liuyi.springbootdemo.exercise.jdbc.format.FormatResult;
import com.liuyi.springbootdemo.exercise.jdbc.format.MysqlFormat;

/**
 * @ClassName SQLAlterTableStatementFormat
 * @description：
 * @author：liuyi
 * @Date：2021/1/26 18:37
 */
public class SQLAlterTableStatementFormat implements MysqlFormat {
    @Override
    public FormatResult format(SQLStatement sqlStatement) {
        FormatResult formatResult = new FormatResult();
        SQLAlterTableStatement alterTableStatement = (SQLAlterTableStatement)sqlStatement;
        formatResult.setDbType(alterTableStatement.getDbType());
        formatResult.setTableName(alterTableStatement.getTableName());
        formatResult.setParserType("alter_table");
        //设置子类型
        SQLAlterTableItem sqlAlterTableItem = alterTableStatement.getItems().get(0);
        String simpleName = sqlAlterTableItem.getClass().getSimpleName();

        switch (simpleName){
            case "MySqlAlterTableModifyColumn" :
                MySqlAlterTableModifyColumn column = (MySqlAlterTableModifyColumn)sqlAlterTableItem;
                SQLColumnDefinition newColumnDefinition = column.getNewColumnDefinition();
                formatResult.setColumn(newColumnDefinition.getNameAsString());
                formatResult.setSubParserType("modify");
                formatResult.setSubSql(newColumnDefinition.toString());
                break;
        }

        return formatResult;
    }
}
