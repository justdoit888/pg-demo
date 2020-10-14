package com.sunjz.jvm.d05;

import java.util.ArrayList;
import java.util.List;

public class PoolOOM {

    public static void main(String[] args) {
        Integer integer = new Integer(12);
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < 10000000; i++) {
            String str = String.valueOf(i).intern();
            stringList.add(str);
        }
    }
}
