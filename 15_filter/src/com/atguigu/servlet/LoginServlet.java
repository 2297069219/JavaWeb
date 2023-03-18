package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName: LoginServlet
 * Package: com.atguigu.servlet
 * Description:
 *
 * @Author: GuanYuJie
 * @Create:2023/3/18 - 8:00
 * Version: v1.0
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String user = req.getParameter("user");
        String password = req.getParameter("password");


        if("admin".equals(user)&&"admin".equals(password)){
            req.getSession().setAttribute("user",user);
            resp.getWriter().write("登录成功！！！");
        }else{
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
    }
}
