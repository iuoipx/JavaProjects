package com.iuoip.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 执行更新与删除
 */
public class JdbcTest02 {
    public static void main(String[] args) {

        Connection conn = null;
        Statement stms = null;
        try {
            //1.注册驱动
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

            //2.获取连接
            String url = "jdbc:mysql://192.168.8.121:3306/hbnu?serverTimezone=GMT" +
                    "&useSSL=false&characterEncoding=utf-8";
            String user = "hbnujixin";
            String password = "123456";
            conn = DriverManager.getConnection(url, user, password);

            //3.获取数据库操作对象
            stms = conn.createStatement();

            //4.执行sql语句
            String sql = "update userinfo set salary=69999,username='shinobu' " +
                    "where realname='gxsb'" ;
            String sql2 = "update userinfo set salary=1000000 where salary=69999";
            int count2 = stms.executeUpdate(sql2);

            System.out.println("影响数据库数目：" + count2);

            //5.处理查询结果

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (stms != null)
                    stms.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if(conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }
}
