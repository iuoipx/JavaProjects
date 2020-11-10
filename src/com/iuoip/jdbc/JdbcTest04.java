package com.iuoip.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTest04 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stms = null;
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

            String url = "jdbc:mysql://192.168.8.121:3306/hbnu?" +
                    "serverTimezone=GMT&useSSL=false&characterEncoding=utf-8";
            String user = "hbnujixin";
            String password = "123456";
            conn = DriverManager.getConnection(url, user, password);

            stms = conn.createStatement();

            String sql = "delete from userinfo where username='1811' and password='1811'";
            int count = stms.executeUpdate(sql);

            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try{
                if(stms!=null)
                    stms.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try{
                if(conn!=null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
