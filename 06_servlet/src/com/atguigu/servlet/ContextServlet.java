package com.atguigu.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName: ${NAME}
 * Package: ${PACKAGE_NAME}
 * Description:
 *
 * @Author: GuanYuJie
 * @Create:2023/3/11 - 18:31
 * Version: v1.0
 */
public class ContextServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletConfig().getServletContext();
        String username = context.getInitParameter("username");
        System.out.println(username);
        System.out.println(context.getInitParameter("password"));
        System.out.println(context.getContextPath());
        System.out.println("部署路径"+context.getRealPath("/"));



    }
}
