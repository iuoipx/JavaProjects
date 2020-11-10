package com.iuoip.jdbc;

import java.sql.*;
import java.util.ResourceBundle;

public class JdbcTest05 {
    public static void main(String[] args) {
        //获取配置文件中的数据库信息
        ResourceBundle resourceBundle = ResourceBundle.getBundle("jdbc");
        String driver = resourceBundle.getString("driver");
        String url = resourceBundle.getString("url");
        String user = resourceBundle.getString("user");
        String password = resourceBundle.getString("password");

        Connection conn = null;
        Statement stmt = null;

        try {
            //1.注册驱动
            Class.forName(driver);

            //2.
            conn = DriverManager.getConnection(url, user, password);

            //3.
            stmt = conn.createStatement();

            //4.
            String sql = "insert into userinfo(username,password,realname,salary)" +
                    "values('shinobu','2131231','gxSB',";
            String sql1 = "update userinfo set realname='GX' where realname='gxSB'";
            String sql2 = "delete from userinfo where realname='GX'";
            int count = 0;
            for (int i = 0; i < 5; i++) {
                count = stmt.executeUpdate(sql+i+")");
            }
            stmt.executeUpdate(sql1);
            stmt.executeUpdate(sql2);
            System.out.println(count);

            //5.

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
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
