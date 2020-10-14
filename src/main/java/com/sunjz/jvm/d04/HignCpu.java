package com.sunjz.jvm.d04;


public class HignCpu {

    public static final int initData = 666;

    public int compute(){
        int a = 1;
        int b = 2;
        int c = (a + b) * 10;
        return c;
    }

    public static void main(String[] args) {
        HignCpu cpu = new HignCpu();
        while (true){
            cpu.compute();
        }
    }
}
