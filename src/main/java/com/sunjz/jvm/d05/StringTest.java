package com.sunjz.jvm.d05;

public class StringTest {

    public static void main(String[] args) {
        //堆中存在 he、llo、hello, 常量池中存在he、llo
        String s1 = new String("he") + new String("llo");
        //由于常量池中没有hello字符串，则将堆中的引用放入常量池，并返回，实际返回的为堆中的引用
        String s2 = s1.intern();
        System.out.println(s1 == s2); //true

        //在堆中创建一个字符串，在常量池中创建一个，返回堆中的引用
        String s3 = new String("1234");
        //常量池中有，则直接返回常量池中的引用
        String s4 = s3.intern();
        System.out.println(s3 == s4); //false
        //返回常量池中的引用
        String s5 = "1234";
        System.out.println(s3 == s5); //false
        System.out.println(s4 == s5); //true

    }
}
