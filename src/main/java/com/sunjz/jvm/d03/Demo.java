package com.sunjz.jvm.d03;

import com.sunjz.common.User;
import org.openjdk.jol.info.ClassLayout;

/**
 * @author Sunny
 * @version 1.0
 * @date 2020-09-22 14:42
 * @package com.sunjz.jvm.d03
 */
public class Demo {

    public static void main(String[] args) {
        //计算对象大小
        User user = new User();
        user.setName("zhangsanshshhshfahfadfafadfadfasfadfafadfadfasdf");
        ClassLayout classLayoutUser = ClassLayout.parseInstance(user);
        System.out.println(classLayoutUser.toPrintable());
    }
}
