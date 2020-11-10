package com.iuoip.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * 银行转账业务演示事务的提交
 */
public class JdbcTest11 {
    public static void main(String[] args) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("jdbc");
        String driver = resourceBundle.getString("driver");
        String url = resourceBundle.getString("url");
        String user = resourceBundle.getString("user");
        String pwd = resourceBundle.getString("password");

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            Class.forName(driver);

            conn = DriverManager.getConnection(url, user, pwd);

            //将数据库连接对象事务自动提交改为手动提交
            conn.setAutoCommit(false);

            String sql = "update userinfo set salary=? where username=?";
            pstmt = conn.prepareStatement(sql);

            pstmt.setDouble(1, 44000);
            pstmt.setString(2, "inori");
            int count = pstmt.executeUpdate();

            String str= null;
            str.length();  //异常

            pstmt.setDouble(1, 44444);
            pstmt.setString(2, "shinobu");
            count += pstmt.executeUpdate();
            System.out.println(count == 2 ? "success" : "failed");

            conn.commit();
        } catch (Exception e) {
            try{
                if(conn!= null)
                    conn.rollback(); //程序发生异常后事务回滚之前状态
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
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
