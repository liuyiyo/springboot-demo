package com.liuyi.springbootdemo.mybatisplus.controller;

import com.liuyi.springbootdemo.mybatisplus.entity.User;
import com.liuyi.springbootdemo.mybatisplus.mapper.UserMapper;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName MybatisPlusController
 * @description：
 * @author：liuyi
 * @Date：2021/12/7 13:39
 */
@RestController
public class MybatisPlusController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("test")
    public void test(){
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }
}
