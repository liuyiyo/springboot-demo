package com.liuyi.springbootdemo.exercise.jdbc.parser.handle;

import com.alibaba.druid.sql.ast.SQLStatement;
import com.liuyi.springbootdemo.exercise.jdbc.parser.entity.ParserResult;

/**
 * @Author liuyi
 * @Description //mysql格式化接口
 * @Date 2021/1/26 16:59
 * @Param
 * @return
 **/
public interface MysqlFormat {

    //格式化方法
    public void format(SQLStatement sqlStatement, ParserResult formatResult);
}
