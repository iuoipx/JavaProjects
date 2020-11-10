package com.iuoip.jdbc;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * 模拟用户登录
 */
public class JdbcTest07 {
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
        //数据库操作对象
        Statement stmt = null;
        //返回结果集
        ResultSet resultSet = null;

        try {
            //1.
            Class.forName(driver);

            //2.
            conn = DriverManager.getConnection(url, user, password);

            //3.
            stmt = conn.createStatement();

            //4.使用　'or' 1 '=' 1　操作系统固定返回true
            String sql = "select * from  userinfo where username='" + name + "' and password='" + pwd + "'";
            resultSet = stmt.executeQuery(sql);

            //5.
            while (resultSet.next())
                flag = true;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //6.
            try {
                if(resultSet!= null)
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
