package com.liuyi.springbootdemo.exercise.jdbc.parser.constant;

import org.springframework.util.ObjectUtils;

/**
 * @Author liuyi
 * @Description //解析类型类枚举
 * @Date 2021/1/27 14:07
 **/
public enum ParserTypeEnum {

    //字段操作
    ALTER_TABLE("SQLAlterTableStatement","com.liuyi.springbootdemo.exercise.jdbc.parser.handle.SQLAlterTableStatementParser"),
    //创建操作
    CREATE_TABLE("SQLCreateTableStatement","com.liuyi.springbootdemo.exercise.jdbc.parser.handle.SQLCreateTableStatementParser"),
    //删除操作
    DROP_TABLE("SQLDropTableStatement","com.liuyi.springbootdemo.exercise.jdbc.parser.handle.SQLDropTableStatementParser");

    ParserTypeEnum(String statementClass, String className) {
        this.statementClass = statementClass;
        this.className = className;
    }

    private String statementClass;

    private String className;

    public String getClassName() {
        return className;
    }
    public void setClassName(String className) {
        this.className = className;
    }

    public String getStatementClass() {
        return statementClass;
    }

    public void setStatementClass(String statementClass) {
        this.statementClass = statementClass;
    }

    public static String findClassName(String statementClass){
        for (ParserTypeEnum parserTypeEnum : ParserTypeEnum.values()) {
            if(ObjectUtils.nullSafeEquals(parserTypeEnum.getStatementClass(),statementClass)){
                return parserTypeEnum.getClassName();
            }
        }
        return null;
    }
}
