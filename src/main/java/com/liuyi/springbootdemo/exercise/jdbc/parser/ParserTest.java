package com.liuyi.springbootdemo.exercise.jdbc.parser;

import com.alibaba.druid.DbType;
import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.util.JdbcConstants;
import com.liuyi.springbootdemo.exercise.jdbc.parser.constant.ParserTypeEnum;
import com.liuyi.springbootdemo.exercise.jdbc.parser.entity.BeanFactory;
import com.liuyi.springbootdemo.exercise.jdbc.parser.entity.ParserResult;
import com.liuyi.springbootdemo.exercise.jdbc.parser.handle.MysqlFormat;
import java.util.List;


/**
 * @ClassName FormatTest
 * @description：
 * @author：liuyi
 * @Date：2021/1/26 17:25
 */
public class ParserTest {
    public static void main(String[] args) {
        //设置数据库类型
        DbType dbType = JdbcConstants.MYSQL;
//        String sql = "alter table student modify s_name varchar(40) collate utf8mb4_unicode_ci not null comment 'modify修改的名称';";
//        String sql = "alter table student change s_name s_name1 varchar(40) collate utf8mb4_unicode_ci not null comment 'modify修改的名称';";
//        String sql = "drop table student;";
//        String sql = "alter table user drop name;";
//        String sql = "alter table user add NORMAL index idx_age (age);";
//        String sql = "alter table sys_user drop index idx_password;";
//        String sql = "INSERT INTO user (id,name,age,sex,address,status,create_user,create_time,modify_user,modify_time) VALUES ('?','?','?','?','?','?','?','?','?','?');";
        String sql = "CREATE TABLE testly2 (boolTest VtBool DEFAULT NULL," +
                "int8Test VtInt8 DEFAULT NULL," +
                "int16Test VtInt16 DEFAULT NULL," +
                "int32Test VtInt32 DEFAULT NULL," +
                "int64Test VtInt64 DEFAULT NULL," +
                "floatTest VtFloat DEFAULT NULL," +
                "doubleTest VtDouble DEFAULT NULL," +
                "datetimeTest VtDateTime DEFAULT NULL," +
                "stringTest VtString DEFAULT NULL," +
                "binaryTest VtBinary DEFAULT NULL," +
                "mapTest VtMap DEFAULT NULL," +
                "structureTest VtStructure DEFAULT NULL," +
                "arrayTest VtArray DEFAULT NULL," +
                "cluster VtString NOT NULL DEFAULT 'roewe')";
        List<SQLStatement> stmtList = SQLUtils.parseStatements(sql, dbType);
        SQLStatement sqlStatement = stmtList.get(0);
        String className = sqlStatement.getClass().getSimpleName();
        MysqlFormat mysqlFormat = BeanFactory.getBean(MysqlFormat.class,ParserTypeEnum.findClassName(className));
        if (mysqlFormat == null) {
            throw new RuntimeException("暂时不支持当前语法解析，className===="+className);
        }
        ParserResult formatResult = new ParserResult();
        mysqlFormat.format(sqlStatement,formatResult);
        System.out.println(formatResult);
    }
}
