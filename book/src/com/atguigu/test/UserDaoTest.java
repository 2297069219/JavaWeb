package com.atguigu.test;

import com.atguigu.dao.UserDao;
import com.atguigu.dao.impl.UserDaoImpl;
import com.atguigu.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * ClassName: UserDaoTest
 * Package: com.atguigu.test
 * Description:
 *
 * @Author: GuanYuJie
 * @Create:2023/3/12 - 21:16
 * Version: v1.0
 */
public class UserDaoTest {
    UserDao userDao=new UserDaoImpl();

    @Test
    public void queryUserByUsername() {

        if(userDao.queryUserByUsername("admin")==null){
            System.out.println("可用");
        }else{
            System.out.println("exists");
        }
    }


    @Test
    public void queryUserByUsernameAndPassword() {
        if ( userDao.queryUserByUsernameAndPassword("admin","admin")==null) {
            System.out.println("错误,登录失败");
        } else {
            System.out.println("查询成功");
        }


    }

    @Test
    public void saveUser() {
        System.out.println(userDao.saveUser(new User(null,"wag1","1236","abc@atguigu.com")));


    }
}