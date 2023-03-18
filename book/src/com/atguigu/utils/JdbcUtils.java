package com.atguigu.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * ClassName: JdbcUtils
 * Package: com.atguigu.utils
 * Description:
 *
 * @Author: GuanYuJie
 * @Create:2023/3/12 - 20:05
 * Version: v1.0
 */
public class JdbcUtils  {

    private static DruidDataSource dataSource;
    private static ThreadLocal<Connection> conns=new ThreadLocal<>();

    static {

        try {
            Properties properties=new Properties();
            //配置文件
            InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            //
            properties.load(inputStream);
            dataSource= (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    public static Connection getConnection(){
        //确保同一个连接
        Connection conn=conns.get();
        if(conn==null){
            try {
                //从数据库连接池中获取连接
                conn=dataSource.getConnection();
                //保存到ThreadLocal对象中 供后面的jdbc使用
                conns.set(conn);
                //设置为手动管理事务
                conn.setAutoCommit(false);

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return conn;
/*        Connection conn=null;

        try {
            conn=dataSource.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return conn;*/
    }


    /**
     * 提交事务并释放连接
     */
    public static void commitAndClose(){
        Connection connection = conns.get();
        if(connection!=null){
            //不为空
            try {
                connection.commit();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        //一定要执行remove Tomcat底层使用了线程池
        conns.remove();
    }

    /**
     * 回滚事务并关闭释放连接
     */
    public static void rollbackAndClose(){
        Connection connection = conns.get();
        if(connection!=null){
            //不为空
            try {
                //回滚事务
                connection.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        //一定要执行remove Tomcat底层使用了线程池
        conns.remove();
    }
//    /**
//     * 关闭
//     * @param conn
//     */
//    public static void close(Connection conn){
//        if (conn != null) {
//            try {
//                conn.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }

}
