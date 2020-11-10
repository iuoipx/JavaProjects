package com.iuoip.jdbc;

import java.sql.*;
import java.util.ResourceBundle;

public class JdbcTest06 {
    public static void main(String[] args) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("jdbc");
        String driver = resourceBundle.getString("driver");
        String url = resourceBundle.getString("url");
        String user = resourceBundle.getString("user");
        String password = resourceBundle.getString("password");

        Connection conn = null;
        Statement stmt = null;
        ResultSet resultSet = null;

        try {
            //1.
            Class.forName(driver);

            //2.
            conn = DriverManager.getConnection(url, user, password);

            //3.
            stmt = conn.createStatement();

            //4.
            String sql = "select * from userinfo";
            resultSet = stmt.executeQuery(sql);  //查询使用executeQuery()

            //5.处理查询结果集
            while (resultSet.next()) {

                //5.1通过下标获取字段(从 1 开始)，通过String接收
//                String id = resultSet.getString(1);
//                String username = resultSet.getString(2);
//                String pwd = resultSet.getString(3);
//                String real = resultSet.getString(4);
//                String salary = resultSet.getString(5);

                //5.2 通过下标获取字段 通过指定类型接收
//                int id = resultSet.getInt(1);
//                String username = resultSet.getString(2);
//                String pwd = resultSet.getString(3);
//                String real = resultSet.getString(4);
//                double salary = resultSet.getDouble(5);

                //5.3通过字段名获取字段 通过String接收  (字段名是查询结果字段名)
//                String id = resultSet.getString("id");
//                String username = resultSet.getString("username");
//                String pwd = resultSet.getString("password");
//                String real = resultSet.getString("realname");
//                String salary = resultSet.getString("salary");

                //5.4 通过字段名获取字段 通过指定类型接收
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String pwd = resultSet.getString("password");
                String real = resultSet.getString("realname");
                double salary = resultSet.getDouble("salary");


                System.out.printf("%d  %s  %s  %s  %.2f\n", id, username, pwd, real, salary);
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //6.
            try {
                if (resultSet != null)
                    resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
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
