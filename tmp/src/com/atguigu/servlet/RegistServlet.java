package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * ClassName: LoginServlet
 * Package: com.atguigu.servlet
 * Description:
 *
 * @Author: GuanYuJie
 * @Create:2023/3/16 - 20:56
 * Version: v1.0
 */
public class RegistServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
        String code = req.getParameter("code");

        //获取用户名和密码
        String username=req.getParameter("username");
        if(token!=null&&token.equalsIgnoreCase(code)){
            System.out.println("保存到数据库"+username);
//        req.getRequestDispatcher("/ok.jsp").forward(req,resp);

            resp.sendRedirect(req.getContextPath()+"/ok.jsp");

        }else{
            System.out.println("请不要重复提交表单");
        }

    }
}
