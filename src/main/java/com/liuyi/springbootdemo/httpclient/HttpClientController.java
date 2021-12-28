package com.liuyi.springbootdemo.httpclient;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
public class HttpClientController {
 
    @Resource
    private HttpAPIService httpAPIService;
 
    @RequestMapping("httpclient")
    public String test() throws Exception {
//        String str = httpAPIService.doGet("http://www.baidu.com");
        Map<String,Object> map = new HashMap<>();
        map.put("appKey","meeerunHome188888804112362595");
        map.put("appSecret","meeerunHome505888388436075875");
        HttpResult httpResult = httpAPIService.doPost("http://iot.gooorun.com:8282/uis/smartHotel/getToken", map);
        return httpResult.getBody();
    }
}