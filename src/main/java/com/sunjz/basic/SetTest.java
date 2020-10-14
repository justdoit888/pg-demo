package com.sunjz.basic;

import com.sunjz.common.User;

import java.util.*;

public class SetTest {

    public static void main(String[] args) {
        // 2 9 1 0 --  0 1 2 9
        // a d c e -- a c d e
        /*Set<String> set = new TreeSet<>();
        set.add("d");
        set.add("a");
        set.add("c");
        set.add("b");
        for(String str : set){
           System.out.println(str);
        }*/

        Set<User> userSet = new TreeSet<>(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
               return  o1.getName().charAt(0) -  o2.getName().charAt(0);
            }
        });
        userSet.add(new User("lilei", 20));
        userSet.add(new User("hanmeimei", 28));
        userSet.add(new User("xanhan", 23));
        for(User user : userSet){
            System.out.println(user);
        }
        System.out.println("=================================");
        Set<User> userAgeSet = new TreeSet<>(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return  o1.getAge() -  o2.getAge();
            }
        });
        userAgeSet.add(new User("lilei", 20));
        userAgeSet.add(new User("hanmeimei", 28));
        userAgeSet.add(new User("xanhan", 23));
        for(User ageuser : userAgeSet){
            System.out.println(ageuser);
        }

        /*ArrayList<String> list = new ArrayList<String>();
        list.add("cba");
        list.add("aba");
        list.add("sba");
        list.add("nba");
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.charAt(0) - o1.charAt(0);
            }
        });
        System.out.println(list);*/

        Map<String,String> map = new HashMap(32);
        map.put("a", "a");
        map.size();
        Hashtable hashtable = new Hashtable();
        /**
         * map -- hashmap  -- 最常用的，线程不安全  k - v  k是唯一 v可不唯一
         *        hashtable -- 线程安全的--效率太低
         *        LinkedHashMap --  a-1 b-2   输出 a-1 b-2
         *        ConcurrentHashMap -- 线程安全的hashmap，多线程范畴
         *
         *
         */
    }
}
