package com.sunjz.jvm.d04;

import lombok.Synchronized;

public class DeadLock {

    public static Object LOCK_1 = new Object();
    public static Object LOCK_2 = new Object();
    public static void main(String[] args) throws Exception{
        new Thread(() ->{
            synchronized(LOCK_1){
                System.out.println("线程1获取锁一，thread-1 begin");
                try {
                    Thread.sleep(5000L);
                }catch (Exception e){

                }
                synchronized(LOCK_2){
                    System.out.println("线程1获取锁二， thread-1 end");
                }
            }
        }, "**********线程一***********").start();
        new Thread(() ->{
            synchronized(LOCK_2){
                System.out.println("线程2获取锁二， thread-2 begin");
                try {
                    Thread.sleep(5000L);
                }catch (Exception e){

                }
                synchronized(LOCK_1){
                    System.out.println("线程2获取锁一，thread-1 end");
                }
            }
        }, "**********线程二***********").start();
    }
}
