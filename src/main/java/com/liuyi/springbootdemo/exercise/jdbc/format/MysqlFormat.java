package com.liuyi.springbootdemo.exercise.jdbc.format;

import com.alibaba.druid.sql.ast.SQLStatement;

/**
 * @Author liuyi
 * @Description //mysql格式化接口
 * @Date 2021/1/26 16:59
 * @Param
 * @return
 **/
public interface MysqlFormat {

    //格式化方法
    public FormatResult format(SQLStatement sqlStatement);
}
