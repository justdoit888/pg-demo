package com.sunjz.jvm.d02;

import java.util.concurrent.TimeUnit;

/**
 * @author Sunny
 * @version 1.0
 * @date 2020-09-17 10:01
 * @package com.sunjz.jvm.d02
 */
public class Math {

    public static int compute() throws Exception{
        int a = 1;
        int b = 2;
        int c = (a + b) * 10;
        Byte[] bytes = new Byte[1024*1024];
        return c;
    }

    public static void main(String[] args) throws Exception {
        //compute();
        new Thread(() -> {
            try {
                Thread.sleep(100000L);
            }catch (Exception e){

            }
            System.out.println("子线程");
        }, "====子线程===").start();

        Thread.sleep(10000L);
        System.out.println("主线程");
    }
}
