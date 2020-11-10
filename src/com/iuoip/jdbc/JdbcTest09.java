package com.iuoip.jdbc;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * 使用PreparedStatement进行增、删、改
 */
public class JdbcTest09 {
    public static void main(String[] args) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("jdbc");
        String driver = resourceBundle.getString("driver");
        String url = resourceBundle.getString("url");
        String user = resourceBundle.getString("user");
        String pwd = resourceBundle.getString("password");

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        try {
            Class.forName(driver);

            conn = DriverManager.getConnection(url, user, pwd);

            String sql = "insert into userinfo(username,password,realname,salary) values (?,?,?,?)";
            String sql2 = "delete userinfo where username=? or realname=?";
            String sql3 = "update userinfo set realname=? where realname=?";
            String sql4 = "select username,password,realname,salary from userinfo where salary<?";
            pstmt = conn.prepareStatement(sql);
            pstmt = conn.prepareStatement(sql2);
            pstmt = conn.prepareStatement(sql3);
            pstmt = conn.prepareStatement(sql4);

//            pstmt.setString(1,"shinobu");
//            pstmt.setString(2,"13113123");
//            pstmt.setString(3,"gxsb");
//            pstmt.setDouble(4,5555);

//            pstmt.setString(1, "xcm");
//            pstmt.setString(2, "xcm");

//            pstmt.setString(1,"GXSB");
//            pstmt.setString(2,"gxsb");

//            int count = pstmt.executeUpdate();
//            System.out.println(count);

            pstmt.setDouble(1, 1000);

            resultSet = pstmt.executeQuery();

            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String real = resultSet.getString("realname");
                double salary = resultSet.getDouble("salary");
                System.out.printf("  %s   %s  %.2f\n", username, real, salary);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null)
                    resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (pstmt != null)
                    pstmt.close();
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
