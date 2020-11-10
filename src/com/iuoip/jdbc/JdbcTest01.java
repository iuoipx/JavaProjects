package com.iuoip.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 注册驱动与获取连接
 */
public class JdbcTest01 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stms = null;
        try {
            //１．注册驱动
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

            //２．获取连接
            String url = "jdbc:mysql://192.168.8.121:3306/hbnu?" +
                    //serverTimezone时区  useSSL安全协议
                    "serverTimezone=GMT&useSSL=false&characterEncoding=utf-8";
            String user = "hbnujixin";
            String password = "123456";
            conn = DriverManager.getConnection(url, user, password);

            //３．获取数据库操作对象
            stms = conn.createStatement();

            //４．执行sql语句
            String sql = "insert into userInfo(username,password,realname,salary)" +
                    " values('jixin1811','1811','gxsb','79999')";
            //对于增、删、改这些数据库操作，执行sql语句时,调用executeUpdate（）方法；
            int count = stms.executeUpdate(sql);
            System.out.println("影响数据库数目：" + count);

            //5.处理查询结果值
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //6.释放资源
            try {
                //ctrl + alt + t 选中执行操作
                if (stms != null)
                    stms.close();
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
