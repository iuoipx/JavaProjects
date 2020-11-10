package com.iuoip.homework04;

import java.io.*;
import java.sql.*;

public class Test03 {
    public static void main(String[] args) {
        String filePath1 = "out.txt";
        String filePath2 = "copy.txt";
        File file1 = new File(filePath1);
        File file2 = new File(filePath2);
        InputStream inputStream = null;
        OutputStream outputStream = null;

        //定义数据库操作需要的对象
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;

        try {
            inputStream = new FileInputStream(file1);
            outputStream = new FileOutputStream(file2, true);
            byte[] bytes = new byte[(int) file1.length()];
            //将文件数据写入byte数组
            int length = inputStream.read(bytes);
            //将bytes数据转为String数据并按换行符分割成字符串数组
            String[] data = new String(bytes).split("\r\n");
            //关闭连接
            inputStream.close();

            //注册驱动
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

            //获取连接
            String url = "jdbc:mysql://127.0.0.1:3306/stuinfo" +
                    "?serverTimezone=GMT&useSSL=false&characterEncoding=utf-8";
            String user = "root";
            String password = "123456";
            conn = DriverManager.getConnection(url, user, password);

            int count = 0;
            for (String str : data) {
                //预编译sql语句
                String sql = "insert into classInfo(schoolName,class,studentNum,classroom) values(?,?,?,?)";
                pstmt = conn.prepareStatement(sql);
                String[] s = str.split("，");
                for (int i = 0; i < s.length; i++)
                    //传入sql语句参数
                    pstmt.setString(i + 1, s[i]);
                //执行方法
                count += pstmt.executeUpdate();
            }
            System.out.println("影响的数据条目:" + count);


            //查询数据库所有数据
            String sql2 = "select * from classInfo";
            pstmt = conn.prepareStatement(sql2);
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                String schoolName = resultSet.getString("schoolName");
                String className = resultSet.getString("class");
                int studentNum = resultSet.getInt("studentNum");
                String classroom = resultSet.getString("classroom");
                //拼接成字符串并转为byte数组
                byte[] lineData = (schoolName + "，" + className + "，" + studentNum + "，" + classroom + "\n").getBytes();
                outputStream.write(lineData);
            }
            System.out.println("数据写入成功");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null)
                    inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (outputStream != null)
                    outputStream.close();
            } catch (IOException e) {
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
