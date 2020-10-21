package com.sunjz.mybatis.d01;

import java.sql.*;

public class JdbcApplication {

    public static void main(String[] args) {

        //所有处理数据库相关的都是如下几步，都采用的jdbc技术
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            //加载数据库驱动
            Class.forName("com.mysql.jdbc.Driver");
            //通过驱动管理类获取数据库链接
            connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/tech_shop?characterEncoding=utf-8","root", "root");
            // ? 表示占位符
            String sql = "select * from tech_user where user_id = ?";
            //获取预处理 statement
            preparedStatement = connection.prepareStatement(sql);
            //设置参数，第一个参数为 sql 语句中参数的序号（从 1 开始），第二个参数为设置的 参数值
            preparedStatement.setLong(1, 0);
            //preparedStatement.setString(2, "sunjz");
            //向数据库发出 sql 执行查询，查询出结果集
            resultSet =  preparedStatement.executeQuery();
            //遍历查询结果集
            while(resultSet.next()){
                System.out.println("==========" + resultSet.getString("user_id"));
                System.out.println("==========" + resultSet.getString("user_name"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(resultSet != null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
