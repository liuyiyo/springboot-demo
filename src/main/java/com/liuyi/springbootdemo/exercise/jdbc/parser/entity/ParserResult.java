package com.liuyi.springbootdemo.exercise.jdbc.parser.entity;

import com.alibaba.druid.DbType;
import com.liuyi.springbootdemo.exercise.jdbc.parser.constant.AlterTableTypeEnum;
import com.liuyi.springbootdemo.exercise.jdbc.parser.constant.ParserTypeEnum;
import lombok.Data;


/**
 * @ClassName FormatResult
 * @description：格式化结果类
 * @author：liuyi
 * @Date：2021/1/26 17:03
 */
@Data
public class ParserResult {
    //数据库类型
    private DbType dbType;

    //表名
    private String tableName;

    //列名
    private String column;

    //索引
    private String index;

    //解析类型
    private ParserTypeEnum parserType;

    //ALTER_TABLE类型
    private AlterTableTypeEnum alterTableTypeEnum;

    //子sql
    private String subSql;


}
