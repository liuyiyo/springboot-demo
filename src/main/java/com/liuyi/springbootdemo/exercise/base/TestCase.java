package com.liuyi.springbootdemo.exercise.base;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public class TestCase {

  public static void main(String[] args) {
//    //1.short到字节数组的转换.
//    short sot = 258;
//    System.out.println(Arrays.toString(shortToByte(sot)));
//
//    System.out.println(byteToShort(new byte[]{2,1}));
      ByteBuffer b = ByteBuffer.wrap(new byte[4]);

      b.order(ByteOrder.BIG_ENDIAN);

      b.putInt(0x01020304);

      System.out.println("Big-Endian: " + Arrays.toString(b.array()));

      b = ByteBuffer.wrap(new byte[4]);

      b.order(ByteOrder.LITTLE_ENDIAN);

      b.putInt(0x01020304);

      System.out.println("Little-Endian: " + Arrays.toString(b.array()));
  }

    /**
     * short到字节数组的转换.
     */
    public static byte[] shortToByte(short number) {
        int temp = number;
        byte[] b = new byte[2];
        for (int i = 0; i < b.length; i++) {
            b[i] = new Integer(temp & 0xff).byteValue();// 将最低位保存在最低位
            temp = temp >> 8;// 向右移8位
        }
        return b;
    }

    /**
     * 字节数组到short的转换.
     */
    public static short byteToShort(byte[] b) {
        short s = 0;
        short s0 = (short) (b[0] & 0xff);// 最低位
        short s1 = (short) (b[1] & 0xff);
        s1 <<= 8;
        s = (short) (s0 | s1);
        return s;
    }


    /**
     * int到字节数组的转换.
     */
    public static byte[] intToByte(int number) {
        int temp = number;
        byte[] b = new byte[4];
        for (int i = 0; i < b.length; i++) {
            b[i] = new Integer(temp & 0xff).byteValue();// 将最低位保存在最低位
            temp = temp >> 8;// 向右移8位
        }
        return b;
    }

    /**
     * 字节数组到int的转换.
     */
    public static int byteToInt(byte[] b) {
        int s = 0;
        int s0 = b[0] & 0xff;// 最低位
        int s1 = b[1] & 0xff;
        int s2 = b[2] & 0xff;
        int s3 = b[3] & 0xff;
        s3 <<= 24;
        s2 <<= 16;
        s1 <<= 8;
        s = s0 | s1 | s2 | s3;
        return s;
    }


    /**
     * long类型转成byte数组
     */
    public static byte[] longToByte(long number) {
        long temp = number;
        byte[] b = new byte[8];
        for (int i = 0; i < b.length; i++) {
            b[i] = new Long(temp & 0xff).byteValue();// 将最低位保存在最低位 temp = temp
            // >> 8;// 向右移8位
        }
        return b;
    }

    /**
     * 字节数组到long的转换.
     */
    public static long byteToLong(byte[] b) {
        long s = 0;
        long s0 = b[0] & 0xff;// 最低位
        long s1 = b[1] & 0xff;
        long s2 = b[2] & 0xff;
        long s3 = b[3] & 0xff;
        long s4 = b[4] & 0xff;// 最低位
        long s5 = b[5] & 0xff;
        long s6 = b[6] & 0xff;
        long s7 = b[7] & 0xff;

        // s0不变
        s1 <<= 8;
        s2 <<= 16;
        s3 <<= 24;
        s4 <<= 8 * 4;
        s5 <<= 8 * 5;
        s6 <<= 8 * 6;
        s7 <<= 8 * 7;
        s = s0 | s1 | s2 | s3 | s4 | s5 | s6 | s7;
        return s;
    }

    /**
     * double到字节数组的转换.
     */
    public static byte[] doubleToByte(double num) {
        byte[] b = new byte[8];
        long l = Double.doubleToLongBits(num);
        for (int i = 0; i < 8; i++) {
            b[i] = new Long(l).byteValue();
            l = l >> 8;
        }
        return b;
    }

    /**
     * 字节数组到double的转换.
     */
    public static double getDouble(byte[] b) {
        long m;
        m = b[0];
        m &= 0xff;
        m |= ((long) b[1] << 8);
        m &= 0xffff;
        m |= ((long) b[2] << 16);
        m &= 0xffffff;
        m |= ((long) b[3] << 24);
        m &= 0xffffffffl;
        m |= ((long) b[4] << 32);
        m &= 0xffffffffffl;
        m |= ((long) b[5] << 40);
        m &= 0xffffffffffffl;
        m |= ((long) b[6] << 48);
        m &= 0xffffffffffffffl;
        m |= ((long) b[7] << 56);
        return Double.longBitsToDouble(m);
    }


    /**
     * float到字节数组的转换.
     */
    public static void floatToByte(float x) {
        //先用 Float.floatToIntBits(f)转换成int
    }

    /**
     * 字节数组到float的转换.
     */
    public static float getFloat(byte[] b) {
        // 4 bytes
        int accum = 0;
        for (int shiftBy = 0; shiftBy < 4; shiftBy++) {
            accum |= (b[shiftBy] & 0xff) << shiftBy * 8;
        }
        return Float.intBitsToFloat(accum);
    }

    /**
     * char到字节数组的转换.
     */
    public static byte[] charToByte(char c) {
        byte[] b = new byte[2];
        b[0] = (byte) ((c & 0xFF00) >> 8);
        b[1] = (byte) (c & 0xFF);
        return b;
    }

    /**
     * 字节数组到char的转换.
     */
    public static char byteToChar(byte[] b) {
        char c = (char) (((b[0] & 0xFF) << 8) | (b[1] & 0xFF));
        return c;
    }

    /**
     * string到字节数组的转换.
     */
    public static byte[] stringToByte(String str) throws UnsupportedEncodingException {
        return str.getBytes("GBK");
    }

    /**
     * 字节数组到String的转换.
     */
    public static String bytesToString(byte[] str) {
        String keyword = null;
        try {
            keyword = new String(str, "GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return keyword;
    }


    /**
     * object到字节数组的转换
     */
    public static void testObject2ByteArray() throws IOException,
            ClassNotFoundException {
        // Object obj = "";
        Integer[] obj = {1, 3, 4};

        // // object to bytearray
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream oo = new ObjectOutputStream(bo);
        oo.writeObject(obj);
        byte[] bytes = bo.toByteArray();
        bo.close();
        oo.close();
        System.out.println(Arrays.toString(bytes));

        Integer[] intArr = (Integer[]) testByteArray2Object(bytes);
        System.out.println(Arrays.asList(intArr));


        byte[] b2 = intToByte(123);
        System.out.println(Arrays.toString(b2));

        int a = byteToInt(b2);
        System.out.println(a);

    }

    /**
     * 字节数组到object的转换.
     */
    private static Object testByteArray2Object(byte[] bytes) throws IOException,
            ClassNotFoundException {
        // byte[] bytes = null;
        Object obj;
        // bytearray to object
        ByteArrayInputStream bi = new ByteArrayInputStream(bytes);
        ObjectInputStream oi = new ObjectInputStream(bi);
        obj = oi.readObject();
        bi.close();
        oi.close();
        System.out.println(obj);
        return obj;
    }

} 
