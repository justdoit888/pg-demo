package com.sunjz.jvm.d03;

import com.sunjz.common.User;

import javax.xml.bind.SchemaOutputResolver;

/**
 * @author Sunny
 * @version 1.0
 * @date 2020-09-25 10:33
 * @package com.sunjz.jvm.d03
 */
public class AllotOnStack {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for(int i = 0; i < 1000000000; i++){
           alloc();
        }
        long end = System.currentTimeMillis();
        System.out.println("时间" + (end - start));
    }

    public static void alloc(){
        User user = new User();
        user.setName("====zhangsan===");
        user.setAge(10);
    }
}
