package com.sunjz.mybatis.d01;

import com.alibaba.fastjson.JSONObject;
import com.sunjz.dao.TechUserMapper;
import com.sunjz.domain.TechUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MybatisApplication {
    public static void main(String[] args) throws Exception{
        testConnection();
    }

    public static void testConnection(){
        ExecutorService executorService = Executors.newFixedThreadPool(500);
        for(int i = 0; i < 500; i++){
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        //1.读取配置文件
                        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
                        //2.创建 SqlSessionFactory 的构建者对象  -- connection 连接工厂
                        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
                        //3.使用构建者创建工厂对象 SqlSessionFactory
                        SqlSessionFactory factory = builder.build(in);
                        //4.使用 SqlSessionFactory 生产 SqlSession 对象
                        SqlSession session = factory.openSession();
                        //5.使用 SqlSession 创建 dao 接口的代理对象
                        TechUserMapper techUserMapper = session.getMapper(TechUserMapper.class);
                        TechUser techUser = techUserMapper.queryOne(0L);
                        System.out.println("========" + JSONObject.toJSONString(techUser));

                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            });
        }

    }
}
