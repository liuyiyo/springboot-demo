package com.liuyi.springbootdemo.exercise.localdate;

import org.springframework.util.Assert;

import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

/**
 * @ClassName LocalDateTimeTest
 * @description：
 * @author：liuyi
 * @Date：2021/4/16 9:22
 */
public class LocalDateTimeTest {
    public static void main(String[] args) {
//        double d = 1618393118.002;
//        Date date = doubleToDate(1618393118.002);
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-mm-dd hh:mm:ss");
//        System.out.println(simpleDateFormat.format(date));

        System.out.println(timeToString(1618393118000L));

    }

    /**
     * 将Long类型的时间戳转换成String 类型的时间格式，时间格式为：yyyy-MM-dd HH:mm:ss
     */
    public static String timeToString(Long time){
        Assert.notNull(time, "time is null");
        DateTimeFormatter ftf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return ftf.format(LocalDateTime.ofInstant(Instant.ofEpochMilli(time), ZoneId.systemDefault()));
    }

    public static Date doubleToDate(Double dateTime) {
        Calendar base = Calendar.getInstance();
        //Delphi的日期类型从1899-12-30 开始
        base.set(1899, 11, 30, 0, 0, 0);
        base.add(Calendar.DATE, dateTime.intValue());
        base.add(Calendar.MILLISECOND,(int)((dateTime % 1) * 24 * 60 * 60 * 1000));
        return base.getTime();
    }

}
