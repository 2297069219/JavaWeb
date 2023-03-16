package com.atguigu.test;

import com.atguigu.web.UserServlet;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * ClassName: UserServletTest
 * Package: com.atguigu.test
 * Description:
 *
 * @Author: GuanYuJie
 * @Create:2023/3/14 - 17:22
 * Version: v1.0
 */
public class UserServletTest {
    public void login(){
        System.out.println("login()");
    }
    public void regist(){
        System.out.println("regist()");
    }
    public void updateUser(){
        System.out.println("updateUser()");
    }
    public void updatePassword(){
        System.out.println("updatePassword()");
    }

    public static void main(String[] args) {
        String action="regist";

        try {
            //action 业务鉴别方法反射
            Method method = UserServletTest.class.getDeclaredMethod(action);
            System.out.println(method);

            method.invoke(new UserServletTest());

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

}
