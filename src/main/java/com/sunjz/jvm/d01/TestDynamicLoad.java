package com.sunjz.jvm.d01;

/**
 * @author Sunny
 * @version 1.0
 * @date 2020-09-16 10:38
 * @package com.homecredit.gateway.core.jvm
 */
public class TestDynamicLoad {
    static {
        System.out.println("*************load TestDynamicLoad**************");
    }

    public static void main(String[] args){
        new A();
        System.out.println("*************load test**************");
        B b = null;
    }
}

class A{
    static {
        System.out.println("*************static A**************");
    }
    public A(){
        System.out.println("*************init A**************");
    }
}

class B{
    static {
        System.out.println("*************static B**************");
    }
    public B(){
        System.out.println("*************init B**************");
    }
}