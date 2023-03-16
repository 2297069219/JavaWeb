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
 * @Create:2023/3/12 - 14:40
 * Version: v1.0
 */
public class ContextServlet1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //servlet
        ServletContext context = getServletContext();

        System.out.println(context.getAttribute("key1"));

        context.setAttribute("key1","value1");
        System.out.println(context.getAttribute("key1"));
        System.out.println(context.getAttribute("key1"));


    }
}
