package com.iuoip.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 模糊查询，使用JDBC工具类
 */
public class JdbcTest12 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        try {
            conn = JDBCUtils.getConnection();

            String sql = "select username,password,salary from userinfo where username like?";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, "_h%");
            resultSet = pstmt.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("username");
                String pwd = resultSet.getString("password");
                double salary = resultSet.getDouble("salary");
                System.out.printf("%s  %s  %.2f \n", name, pwd, salary);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, pstmt, resultSet);
        }
    }
}
