package com.liuyi.springbootdemo.exercise.guava;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName GuavaTest
 * @description：
 * @author：liuyi
 * @Date：2020/12/30 10:45
 */
public class GuavaTest {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name",null);
        String toJSON = JSON.toJSONString(map, SerializerFeature.WRITE_MAP_NULL_FEATURES, SerializerFeature.QuoteFieldNames);
        System.out.println(toJSON);
    }
}
