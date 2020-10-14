package com.sunjz.jvm.d01;

/**
 * @author Sunny
 * @version 1.0
 * @date 2020-09-16 16:08
 * @package com.sunjz.jvm.d01
 */
public class User {
    private String name;
    public User(){

    }
    public void sout() {
        System.out.println("=======自己的加载器加载类调用方法=======");
    }

    public static void main(String[] args) {
        User user = new User();
    }
}
