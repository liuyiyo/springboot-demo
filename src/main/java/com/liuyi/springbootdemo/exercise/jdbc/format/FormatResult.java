package com.liuyi.springbootdemo.exercise.jdbc.format;

import com.alibaba.druid.DbType;
import lombok.Data;

/**
 * @ClassName FormatResult
 * @description：格式化结果类
 * @author：liuyi
 * @Date：2021/1/26 17:03
 */
@Data
public class FormatResult {
    //数据库类型
    private DbType dbType;

    //表名
    private String tableName;

    //列名
    private String column;

    //解析类型(create_table,drop_table,alter_table,alter_index)
    private String parserType;

    //解析子类型(alter_table或者alter_index的add、drop、modify、change等)
    private String subParserType;

    //子sql
    private String subSql;
}
