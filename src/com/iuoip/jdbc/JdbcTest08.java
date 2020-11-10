package com.iuoip.jdbc;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Scanner;

public class JdbcTest08 {
    public static void main(String[] args) {
        //1.保存输入的用户名和密码
        Map<String, String> userinfo = initUI();

        //2.校验用户名和密码
        boolean successLogin = login(userinfo);

        //3.提示信息
        System.out.println(successLogin ? "login success!" : "login failed");
    }

    /**
     * 校验用户输入的用户名和密码
     *
     * @param userinfo 用户输入的信息
     * @return　返回校验结果
     */
    private static boolean login(Map<String, String> userinfo) {
        boolean flag = false;
        String name = userinfo.get("username");
        String pwd = userinfo.get("password");

        //读取配置文件信息
        ResourceBundle resourceBundle = ResourceBundle.getBundle("jdbc");
        String driver = resourceBundle.getString("driver");
        String url = resourceBundle.getString("url");
        String user = resourceBundle.getString("user");
        String password = resourceBundle.getString("password");

        //数据库连接对象
        Connection conn = null;
        //数据库操作对象 - (PreparedStatement) 使用预编译sql语句防止　sql注入
        PreparedStatement pstmt = null;

        ResultSet resultSet = null;

        try {
            //1.
            Class.forName(driver);

            //2.
            conn = DriverManager.getConnection(url, user, password);

            //3. 使用预编译 提前把sql语句预编译(只编译一次)，后续只需把参数传入
            String sql = "select * from  userinfo where username=? and password=?";
            pstmt = conn.prepareStatement(sql);

            //4.传入预编译sql语句参数
            pstmt.setString(1, name);
            pstmt.setString(2, pwd);
            //直接执行查询方法，不用传入sql
            resultSet = pstmt.executeQuery();

            //5.
            if (resultSet.next())
                flag = true;

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

        return flag;
    }

    /**
     * 初始化界面，给用户输入界面
     *
     * @return 返回存储用户信息集合
     */
    private static Map<String, String> initUI() {
        Map<String, String> hashMap = new HashMap<>(); //存储用户输入的用户名和密码

        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入用户名：");
        String username = scanner.nextLine();
        System.out.print("请输入密码：");
        String password = scanner.nextLine();

        //将用户信息存入集合中
        hashMap.put("username", username);
        hashMap.put("password", password);

        return hashMap;
    }
}
