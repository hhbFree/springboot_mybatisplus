package com.aisino.invoice.test;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class MySqlJdbcUtils {

    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://192.168.0.132:3306/xbDB?useUnicode=true&characterEncoding=utf-8";
    private static String name="tradingbp";
    private static String pwd="123456";
    
    /**
     * 
     * 获取链接
     *
     * @date   2017年8月31日
     * @return
     */
    public static Connection getOpenConnection(){
        Connection conn= null;
        try {
            //加载驱动
            Class.forName(driver);
            conn=(Connection) DriverManager.getConnection(url, name, pwd);
            System.out.println("获得数据库链接");
        } catch (ClassNotFoundException  e) {
             e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    
    public static void main(String[] args) {
        getOpenConnection();
    }
    
}