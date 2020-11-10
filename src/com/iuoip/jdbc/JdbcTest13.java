package com.iuoip.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 悲观锁
 */
public class JdbcTest13 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;

        try {
            conn = JDBCUtils.getConnection();
            conn.setAutoCommit(false);

            String sql = "select usernam,realname from userinfo where username=? for update";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1,"sad");
            resultSet = pstmt.executeQuery();

            while (resultSet.next()){

            }

            conn.commit();
        } catch (SQLException e) {
            try {
                if(conn != null)
                    conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn,pstmt,resultSet);
        }
    }
}
