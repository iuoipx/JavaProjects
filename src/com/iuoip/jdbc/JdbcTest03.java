package com.iuoip.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTest03 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            //1.注册驱动
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

            //2.获取连接
            String url = "jdbc:mysql://192.168.8.121:3306/hbnu" +
                    "?serverTimezone=GMT&useSSL=false&characterEncoding=utf-8";
            String user = "hbnujixin";
            String password = "123456";
            conn = DriverManager.getConnection(url, user, password);

            //3.
            stmt = conn.createStatement();

            //4.
            String sql = "insert into userInfo(username,password,realname,salary)" +
                    " values('shinobuwqrq','123456','gxsb','79999')";
            String sql2 = "update userinfo set password = '4444' where realname = 'gxsb'";
            int count = stmt.executeUpdate(sql2); //增删改
            System.out.println("修改的数据条数：" + count);

            //5.

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
