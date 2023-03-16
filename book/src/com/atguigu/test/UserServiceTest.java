package com.atguigu.test;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * ClassName: UserServiceTest
 * Package: com.atguigu.test
 * Description:
 *
 * @Author: GuanYuJie
 * @Create:2023/3/13 - 7:36
 * Version: v1.0
 */
public class UserServiceTest {

    UserService userService=new UserServiceImpl();

    @Test
    public void registUser() {
        userService.registUser(new User(null,"w1168","13456","1677@qq.com"));


    }

    @Test
    public void login() {
        System.out.println(userService.login(new User(null,"abc123","666666",null)));

    }

    @Test
    public void existsUsername() {

        if(userService.existsUsername("abc123")){
            System.out.println("exists");
        }else{
            System.out.println("可用");
        }
    }
}