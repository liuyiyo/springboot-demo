package com.liuyi.springbootdemo.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CityMapper {

  @Select("SELECT * FROM USER WHERE id = #{id}")
  User findByState(@Param("id") String id);

}