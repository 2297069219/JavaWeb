package com.atguigu.web;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName: ReigstServlet
 * Package: com.atguigu.web
 * Description:
 *
 * @Author: GuanYuJie
 * @Create:2023/3/13 - 8:22
 * Version: v1.0
 */
public class RegistServlet  extends HttpServlet {

    private UserService userService=new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");
        //写死
        if("abcde".equalsIgnoreCase(code)){

            if(userService.existsUsername(username)){
                //不可用
                System.out.println("用户名["+username+"]存在");
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
            }else{

                userService.registUser(new User(null,username,password,email));
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req,resp);
            }
        }else{
            //回显信息保存到Request域中 回显信息Request域中
            req.setAttribute("msg","用户名已存在！");
            req.setAttribute("username",username);
            req.setAttribute("email",email);

            System.out.println("验证码["+code+"]错误");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
        }


    }
}
