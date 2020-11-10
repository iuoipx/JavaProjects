package com.iuoip.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 封装查询的数据
 */
public class JdbcUserTest {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;

        try {
            conn = JDBCUtils.getConnection();

            String sql = "select * from userinfo";
            pstmt = conn.prepareStatement(sql);

            resultSet = pstmt.executeQuery();
            List<User> userList = new ArrayList<>();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setRealname(resultSet.getString("realname"));
                user.setSalary(resultSet.getDouble("salary"));
                userList.add(user);
            }

            Iterator<User> iterator = userList.iterator();
            while (iterator.hasNext()) {
                User user = iterator.next();
                System.out.println(user.getUsername() + " " + user.getRealname());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, pstmt, resultSet);
        }
    }
}
