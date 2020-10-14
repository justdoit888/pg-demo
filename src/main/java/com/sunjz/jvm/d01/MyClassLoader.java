package com.sunjz.jvm.d01;

import java.io.FileInputStream;
import java.lang.reflect.Method;

/**
 * @author Sunny
 * @version 1.0
 * @date 2020-09-16 15:42
 * @package com.sunjz.jvm.d01
 */
public class MyClassLoader extends ClassLoader {
    private String classPath;
    public MyClassLoader(String classPath){
        this.classPath = classPath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException  {

        try {
            byte[] data = loadByte(name);
            //defineClass是把字节数组转换成一个class
            return defineClass(name, data, 0, data.length);
        }catch (Exception e){

        }
        return null;
    }

    private byte[] loadByte(String name) throws Exception{
        name = name.replaceAll("\\.", "/");
        FileInputStream fis = new FileInputStream(classPath + "/" + name + ".class");
        int len = fis.available();
        byte[] data = new byte[len];
        fis.read(data);
        fis.close();
        return data;
    }

    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException{
        synchronized (getClassLoadingLock(name)) {
            // First, check if the class has already been loaded
            Class<?> c = findLoadedClass(name);
            if (c == null) {
                long t0 = System.nanoTime();
               /* try {
                    if (parent != null) {
                        c = parent.loadClass(name, false);
                    } else {
                        c = findBootstrapClassOrNull(name);
                    }
                } catch (ClassNotFoundException e) {

                }*/

                if (c == null) {

                    long t1 = System.nanoTime();

                    //===========================================================
                    //打破双亲委派核心代码
                    if(!name.startsWith("com.sunjz.jvm")){
                        c = this.getParent().loadClass(name);
                    }else{
                        c = findClass(name);
                    }
                    //===========================================================


                    sun.misc.PerfCounter.getParentDelegationTime().addTime(t1 - t0);
                    sun.misc.PerfCounter.getFindClassTime().addElapsedTimeFrom(t1);
                    sun.misc.PerfCounter.getFindClasses().increment();
                }
            }
            if (resolve) {
                resolveClass(c);
            }
            return c;
        }
    }




    public static void main(String[] args) throws Exception {
        //初始化自定义类加载器，会先初始化父类ClassLoader，其中会把自定义类加载器的父加载
        //器设置为应用程序类加载器AppClassLoader
        MyClassLoader classLoader = new MyClassLoader("D:/test");
        //D盘创建 test/com/tuling/jvm 几级目录，将User类的复制类User1.class丢入该目录
        Class clazz = classLoader.loadClass("com.sunjz.common.User");
        Object obj = clazz.newInstance();
        Method method = clazz.getDeclaredMethod("sout", null);
        method.invoke(obj, null);
        System.out.println(clazz.getClassLoader().getClass().getName());
    }

}
