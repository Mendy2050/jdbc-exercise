package com.itheima.jdbc;

import org.junit.Test;

import java.sql.*;

/**
 * @author Mendy
 * @create 2023-03-23 9:28
 */
public class JDBCDemo {

    @Test
    public void test1() throws Exception {
        //1、注册驱动_Mysql 5以后可以省略
//        Class.forName("com.mysql.jdbc.Driver");

        //2、获取连接
        String url="jdbc:mysql://127.0.0.1:3306/db1?useSSL=false&useServerPrepStmts=true";
        String username="root";
        String password="123456";
        Connection conn = DriverManager.getConnection(url, username, password);

        //接收用户输入 用户名和密码
        String name= "mamama";
        int age = 20;

        //3、定义sql
        String sql = "select * from employee where name = ? and age = ?";
        
        //4、获取执行sql语句的对象 pstmt对象
        PreparedStatement pstmt = conn.prepareStatement(sql);
        
        // 设置？的值
        pstmt.setString(1,name);
        pstmt.setInt(2,age);

        //5、执行sql
        ResultSet rs = pstmt.executeQuery();


        //判断是否成功
        if(rs.next()){
            System.out.println("成功");
        }else{
            System.out.println("失败");
        }

        //7、释放资源——————先释放后建的
        rs.close();
        pstmt.close();
        conn.close();


    }

}
