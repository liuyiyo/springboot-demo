package com.liuyi.springbootdemo.mqtt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName MqttTest
 * @description：
 * @author：liuyi
 * @Date：2021/12/21 0021 0:02
 */
@RestController
public class MqttTest {

    @Autowired
    private MqttConsumer mqttConsumer;

    @GetMapping("mqtt/test")
    public void test(){
        String topic = "/smartHotel/down/南山网咖/900/powerCardNotification";
        mqttConsumer.subscribe(topic,1);
    }

}
