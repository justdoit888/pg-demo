package com.sunjz.common;

import lombok.Data;

import java.util.Objects;

/**
 * @author Sunny
 * @version 1.0
 * @date 2020-09-16 16:08
 * @package com.sunjz.jvm.d01
 */
public class User /*implements Comparable<User>*/{
    private String name;
    private Integer age;

    public User(){

    }

    public User(String name, Integer age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }

   /* @Override
    public boolean equals(User o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return name.equals(user.name) &&
                age.equals(user.age);
    }*/

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }


    /*@Override
    public int compareTo(User o) {
        return 0;
    }*/
}
