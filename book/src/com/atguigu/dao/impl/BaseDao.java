/*
package com.atguigu.dao.impl;

import com.atguigu.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

*/
/**
 * ClassName: BaseDao
 * Package: com.atguigu.dao.impl
 * Description:
 *
 * @Author: GuanYuJie
 * @Create:2023/3/12 - 20:48
 * Version: v1.0
 *//*

public abstract class BaseDao {

    private QueryRunner queryRunner=new QueryRunner();
    */
/**
     * update() sql
     * @return  -1 执行失败 影响的rows
     *//*

    public int update(String sql,Object... args){
        Connection connection = JdbcUtils.getConnection();
        try {
           return queryRunner.update(connection,sql,args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }//第一个问题 没有finally  close connection

        return -1;

    }

    */
/**
     * 查询javaBean sql
     * @param type 对象
     * @param sql   sql
     * @param args 参数
     * @param <T> 泛型
     * @return
     *//*

    public <T> T  queryForone(Class<T> type, String sql,Object... args){
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection,sql,new BeanHandler<T>(type),args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.close(connection);
        }
        return null;
    }
    */
/**
     * 查询多个javaBean sql
     * @param type 对象
     * @param sql   sql
     * @param args 参数
     * @param <T> 泛型
     * @return
     *//*

    public <T> List<T> queryForList(Class<T> type, String sql,Object... args) {
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection,sql,new BeanListHandler<T>(type),args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.close(connection);
        }
        return null;

    }



    */
/**
     * 返回一行一列sql
     * @param sql sql
     * @param args 参数
     * @return row
     *//*

    public Object queryForSingleValue(String sql,Object...args){

        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection,sql,new ScalarHandler(),args);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(connection);
        }
        return null;
    }

}
*/
package com.atguigu.dao.impl;

import com.atguigu.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDao {

    //使用DbUtils操作数据库
    private QueryRunner queryRunner = new QueryRunner();

    /**
     * update() 方法用来执行：Insert\Update\Delete语句
     *
     * @return 如果返回-1,说明执行失败<br/>返回其他表示影响的行数
     */
    public int update(String sql, Object... args) {
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.update(connection, sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
//        finally {
//            JdbcUtils.close(connection);
//        }

    }

    /**
     * 查询返回一个javaBean的sql语句
     *
     * @param type 返回的对象类型
     * @param sql  执行的sql语句
     * @param args sql对应的参数值
     * @param <T>  返回的类型的泛型
     * @return
     */
    public <T> T queryForOne(Class<T> type, String sql, Object... args) {
        Connection con = JdbcUtils.getConnection();
        try {
            return queryRunner.query(con, sql, new BeanHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
//        finally {
//            JdbcUtils.close(con);
//        }
    }

    /**
     * 查询返回多个javaBean的sql语句
     *
     * @param type 返回的对象类型
     * @param sql  执行的sql语句
     * @param args sql对应的参数值
     * @param <T>  返回的类型的泛型
     * @return
     */
    public <T> List<T> queryForList(Class<T> type, String sql, Object... args) {
        Connection con = JdbcUtils.getConnection();
        try {
            return queryRunner.query(con, sql, new BeanListHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);

        }
//        finally {
//            JdbcUtils.close(con);
//        }

    }

    /**
     * 执行返回一行一列的sql语句
     * @param sql   执行的sql语句
     * @param args  sql对应的参数值
     * @return
     */
    public Object queryForSingleValue(String sql, Object... args){

        Connection conn = JdbcUtils.getConnection();

        try {
            return queryRunner.query(conn, sql, new ScalarHandler(), args);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);

        }
//        finally {
//            JdbcUtils.close(conn);
//        }


    }

}
