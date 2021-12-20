package com.liuyi.springbootdemo;

import com.liuyi.springbootdemo.mqtt.MqttConsumer;
import com.liuyi.springbootdemo.mybatis.CityMapper;
import com.liuyi.springbootdemo.mybatis.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class SpringbootDemoApplication implements CommandLineRunner {

    @Autowired
    private MqttConsumer mqttConsumer;

    private final CityMapper cityMapper;

    public SpringbootDemoApplication(CityMapper cityMapper) {
        this.cityMapper = cityMapper;
    }

    public static void main(String[] args) { SpringApplication.run(SpringbootDemoApplication.class, args);}

    @Override
    public void run(String... args) throws Exception {
//        User byState = cityMapper.findByState("1");
//        System.out.println(byState);
        String topic = "/smartHotel/down/南山网咖/900/powerCardNotification";
        mqttConsumer.subscribe(topic,1);
    }
}
