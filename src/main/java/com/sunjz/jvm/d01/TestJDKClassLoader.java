package com.sunjz.jvm.d01;

import com.sun.crypto.provider.DESKeyFactory;
import sun.misc.Launcher;

import java.net.URL;

/**
 * @author Sunny
 * @version 1.0
 * @date 2020-09-16 11:17
 * @package com.sunjz.jvm.d01
 */
public class TestJDKClassLoader {
    public static void main(String[] args){
        //String类加载器null，引导类加载器是c++语言实现，所以打印出为null
        System.out.println("String类加载器" + String.class.getClassLoader());
        //DESKeyFactory加载器sun.misc.Launcher$ExtClassLoader@4617c264
        System.out.println("jdk包下的DESKeyFactory的加载器" + DESKeyFactory.class.getClassLoader());
        //类加载器sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println("自定义类的加载器" + TestJDKClassLoader.class.getClassLoader());

        ClassLoader appClassLoader = ClassLoader.getSystemClassLoader();
        ClassLoader extClassLoader = appClassLoader.getParent();
        ClassLoader bootstrapLoader = extClassLoader.getParent();
        System.out.println("the bootstrapLoader === " + bootstrapLoader);
        System.out.println("the extClassLoader === " + extClassLoader);
        System.out.println("the appClassLoader === " + appClassLoader);

        System.out.println("bootstrapLoader加载以下文件");
        URL[] urls = Launcher.getBootstrapClassPath().getURLs();
        for (int i = 0; i < urls.length; i++) {
             System.out.println(urls[i]);
        }

        System.out.println("extClassloader加载以下文件：");
        System.out.println(System.getProperty("java.ext.dirs"));

        System.out.println("appClassLoader加载以下文件：");
        System.out.println(System.getProperty("java.class.path"));
    }
}
