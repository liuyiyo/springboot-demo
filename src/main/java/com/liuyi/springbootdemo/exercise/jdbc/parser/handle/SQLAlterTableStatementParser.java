package com.liuyi.springbootdemo.exercise.jdbc.parser.handle;

import com.alibaba.druid.sql.ast.SQLIndexDefinition;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.ast.expr.SQLIdentifierExpr;
import com.alibaba.druid.sql.ast.statement.*;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlAlterTableChangeColumn;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlAlterTableModifyColumn;
import com.liuyi.springbootdemo.exercise.jdbc.parser.constant.AlterTableTypeEnum;
import com.liuyi.springbootdemo.exercise.jdbc.parser.entity.ParserResult;
import com.liuyi.springbootdemo.exercise.jdbc.parser.constant.ParserTypeEnum;
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
    public void format(SQLStatement sqlStatement, ParserResult formatResult) {
        SQLAlterTableStatement alterTableStatement = (SQLAlterTableStatement)sqlStatement;
        //设置数据库类型
        formatResult.setDbType(alterTableStatement.getDbType());
        //设置表名
        formatResult.setTableName(alterTableStatement.getTableName());
        //设置解析类型
        formatResult.setParserType(ParserTypeEnum.ALTER_TABLE);
        //设置子类型
        SQLAlterTableItem sqlAlterTableItem = alterTableStatement.getItems().get(0);
        String simpleName = sqlAlterTableItem.getClass().getSimpleName();
        switch (simpleName){
            case "MySqlAlterTableModifyColumn" :
                //处理modify列语句
                MySqlAlterTableModifyColumn column = (MySqlAlterTableModifyColumn)sqlAlterTableItem;
                SQLColumnDefinition newColumnDefinition = column.getNewColumnDefinition();
                //设置列名
                formatResult.setColumn(newColumnDefinition.getNameAsString());
                //设置子类型
                formatResult.setAlterTableTypeEnum(AlterTableTypeEnum.COLUMN_MODIFY);
                //设置子sql
                formatResult.setSubSql(newColumnDefinition.toString());
                break;
            case "MySqlAlterTableChangeColumn" :
                //处理change列语句
                MySqlAlterTableChangeColumn column2 = (MySqlAlterTableChangeColumn)sqlAlterTableItem;
                SQLColumnDefinition newColumnDefinition2 = column2.getNewColumnDefinition();
                //这种列名
                formatResult.setColumn(newColumnDefinition2.getNameAsString());
                //设置子类型
                formatResult.setAlterTableTypeEnum(AlterTableTypeEnum.COLUMN_CHANGE);
                //设置子sql
                formatResult.setSubSql(newColumnDefinition2.toString());
                break;
            case "SQLAlterTableAddColumn" :
                //处理添加列语句
                SQLAlterTableAddColumn column3 = (SQLAlterTableAddColumn)sqlAlterTableItem;
                SQLColumnDefinition definition = column3.getColumns().get(0);
                //设置列名
                formatResult.setColumn(definition.getColumnName());
                //设置子类型
                formatResult.setAlterTableTypeEnum(AlterTableTypeEnum.COLUMN_ADD);
                //设置子sql
                formatResult.setSubSql(definition.toString());
                break;
            case "SQLAlterTableDropColumnItem" :
                //处理删除列语句
                SQLAlterTableDropColumnItem column4 = (SQLAlterTableDropColumnItem)sqlAlterTableItem;
                SQLIdentifierExpr sqlIdentifierExpr = (SQLIdentifierExpr) column4.getColumns().get(0);
                //设置列名
                formatResult.setColumn(sqlIdentifierExpr.getName());
                //设置子类型
                formatResult.setAlterTableTypeEnum(AlterTableTypeEnum.COLUMN_DROP);
                break;
            case "SQLAlterTableAddIndex" :
                //处理添加索引语句
                SQLAlterTableAddIndex index1 = (SQLAlterTableAddIndex)sqlAlterTableItem;
                SQLIndexDefinition sqlIndexDefinition =  index1.getIndexDefinition();
                //设置索引名
                formatResult.setIndex(sqlIndexDefinition.getName().toString());
                //设置子类型
                formatResult.setAlterTableTypeEnum(AlterTableTypeEnum.INDEX_ADD);
                formatResult.setSubSql(sqlIndexDefinition.toString());
                break;
            default:
                log.error("AlterTable不存在这样的子语句:"+alterTableStatement.toString());
                throw new RuntimeException("AlterTable不存在这样的子语句:"+alterTableStatement.toString());
        }
    }
}
