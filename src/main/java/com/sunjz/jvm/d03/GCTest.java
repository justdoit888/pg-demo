package com.sunjz.jvm.d03;

/**
 * @author Sunny
 * @version 1.0
 * @date 2020-09-25 14:21
 * @package com.sunjz.jvm.d03
 */
public class GCTest {
    public static void main(String[] args) {
        //分配1M内存
        byte[]  a_1 = new byte[1000 * 1024];
        //分配6m内存
        byte[]  a_2 = new byte[1000 * 1024];
        byte[]  a_3 = new byte[1000 * 1024];
    }
}
