package com.java.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

//数据库连接公共类
public class Db {
    // 类成员变量
    private static Connection connection;

    // 私有构造，单例
    private Db() {
    }

    static {
        Properties p = new Properties();
        try {
            p.load(Db.class.getClassLoader().getResourceAsStream("config/db.properties"));
            //读取属性文件
            String driver = p.getProperty("driver");
            String url = p.getProperty("url");
            String username = p.getProperty("username");
            String password = p.getProperty("password");
            //加载驱动器
            Class.forName(driver);
            //用驱动管理类获得连接
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //返回连接
    public static Connection getConn() {
        return connection;
    }
}
