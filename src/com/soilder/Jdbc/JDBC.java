package com.soilder.Jdbc;

import java.sql.*;

public class JDBC {
        //加载驱动
        static{
            String DiverName="com.mysql.cj.jdbc.Driver";
            try {
                Class.forName(DiverName);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        //进行数据库的连接
        public static Connection getConnection()
        {
            Connection conn=null;
            try {
                conn= DriverManager.getConnection("jdbc:mysql://localhost/supermarket"+
                        "?serverTimezone=GMT%2B8&characterEncoding=UTF-8","root","*******");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return conn;
        }

        //关闭连接
        public static void close(ResultSet rs, PreparedStatement preparedStatement, Connection conn)
        {
            if(rs==null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(preparedStatement==null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn==null)
            {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
}
