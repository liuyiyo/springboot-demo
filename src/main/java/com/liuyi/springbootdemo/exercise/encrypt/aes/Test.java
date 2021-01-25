package com.liuyi.springbootdemo.exercise.encrypt.aes;

import org.apache.logging.log4j.util.Base64Util;
import org.springframework.util.Base64Utils;
import sun.misc.BASE64Decoder;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

/**
 * @ClassName Test
 * @description：
 * @author：liuyi
 * @Date：2021/1/14 17:49
 */
public class Test {
    public static void main(String[] args) throws IOException {

        String value = "alter table t_alarm_execute_log add column execute_detail varchar(60) COMMENT '执行详情'";
        System.out.println(value.length());
        System.out.println(encrypt(value));
    }

    private static final String key = "installer@2018qw";
    private static final String initVector = "0000000000000000";

    public static String encrypt(String value) throws IOException {
        value = Base64Utils.encodeToString(value.getBytes());
        value += "\0\0\0\0";
        System.out.println(value);
        try {
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

            byte[] encrypted = cipher.doFinal(value.getBytes());
            return bytesToHexString(encrypted);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public static String bytesToHexString(byte[] src){
        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }
}
