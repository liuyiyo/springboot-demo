package com.liuyi.springbootdemo.exercise.io;

import java.io.*;

/**
 * @ClassName IOTest
 * @description：
 * @author：liuyi
 * @Date：2021/5/31 17:00
 */
public class IOTest {
    /**
     * 图片上传路径
     */
    public static final String FILEPATH = "D:\\IdeaProjects\\graduationDesign-master\\src\\main\\resources\\imgs\\other\\4.png";
    public static void main(String[] args) {
        File file = new File("D:\\upload_8f447066_234e_4c88_ba2f_5031dcac2ade_00000006.tmp");
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader buffer = new BufferedReader(fileReader);
            File file1 = new File(FILEPATH);
            if(!file1.exists()){
                file1.createNewFile();
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(file1));
            String readLine = null;
            while ((readLine=buffer.readLine())!=null){
                writer.write(readLine);
            }
            writer.close();
            buffer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
