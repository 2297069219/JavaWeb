package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * ClassName: BaseServlet
 * Package: com.atguigu.web
 * Description:
 *
 * @Author: GuanYuJie
 * @Create:2023/3/14 - 17:39
 * Version: v1.0
 */
public abstract class BaseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //post 中中文乱码问题
        req.setCharacterEncoding("UTF-8");
        //响应中中文乱码问题
        resp.setContentType("text/html; charset=utf-8");

        String action=req.getParameter("action");

        try {
            Method method = this.getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);

            method.invoke(this,req,resp);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }


}
