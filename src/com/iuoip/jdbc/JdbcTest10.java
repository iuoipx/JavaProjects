package com.iuoip.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 *
 */
public class JdbcTest10 {
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

            String sql = "update userinfo set salary = ?  where username = ?";
            pstmt = conn.prepareStatement(sql);

            pstmt.setDouble(1, 44444);
            pstmt.setString(2, "sad");

            int count = pstmt.executeUpdate();

            //当此时发生异常时，只会执行上一个sql语句
            String str = null;
            str.length();

            pstmt.setDouble(1,-12345);
            pstmt.setString(2,"102339");
            count += pstmt.executeUpdate();

            System.out.println(count==2?"修改成功":"修改失败");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try{
                if(pstmt != null)
                    pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try{
                if(conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
