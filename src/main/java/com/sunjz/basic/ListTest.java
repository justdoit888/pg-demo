package com.sunjz.basic;

import com.sunjz.common.User;

import java.util.HashSet;
import java.util.Set;


public class ListTest {

    public static void main(String[] args) {
        User user1 = new User();
        user1.setName("wenjl");
        user1.setAge(18);

        User user2 = new User();
        user2.setName("wenjl");
        user2.setAge(18);

        //System.out.println(user1 == user2);      // false
        //System.out.println(user1.equals(user2)); //false  -- true

        Set<User> userSet = new HashSet<>();
        //set add添加元素的时候，底层调用的是hashcode和equals方法来判断两个对象是否相等
        boolean user = userSet.add(user1); // true
        boolean use = userSet.add(user2);  // false

        System.out.println(userSet.size());  // 1
    }
}
