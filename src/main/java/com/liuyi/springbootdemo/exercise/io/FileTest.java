package com.liuyi.springbootdemo.exercise.io;

import javax.xml.transform.Source;
import java.io.*;
import java.net.URL;

/**
 * @ClassName FileTEST
 * @description：
 * @author：liuyi
 * @Date：2021/7/20 9:58
 */
public class FileTest {
    public static void main(String[] args) throws Exception {
        //获取resources下面的文件
//        URL resource = FileTest.class.getClassLoader().getResource("");
//        System.out.println(resource.getPath());
//        FileReader fileReader = new FileReader(resource.getPath()+"test.txt");
//        BufferedReader bufferedReader = new BufferedReader(fileReader);
//        System.out.println(bufferedReader.readLine());
//        bufferedReader.close();
//        fileReader.close();

        InputStream resourceAsStream = FileTest.class.getClassLoader().getResourceAsStream("test.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(resourceAsStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        System.out.println(bufferedReader.readLine());
        bufferedReader.close();
        inputStreamReader.close();
        resourceAsStream.close();
    }
}
