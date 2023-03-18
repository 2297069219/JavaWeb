package com.atguigu.servlet;

import com.atguigu.pojo.Person;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName: AjaxServlet
 * Package: com.atguigu.servlet
 * Description:
 *
 * @Author: GuanYuJie
 * @Create:2023/3/18 - 15:32
 * Version: v1.0
 */
public class AjaxServlet extends BaseServlet{


    protected void javaScriptAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //乱码
        System.out.println("请求过来了Ajax");

        Person person = new Person(1, "国哥");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //字符串
        Gson gson=new Gson();
        String personJsonString = gson.toJson(person);

        resp.getWriter().write(personJsonString);

    }

    protected void jQueryAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //乱码
        System.out.println("JQueryAjax==方法调用");

        Person person = new Person(1, "国哥");

        //字符串
        Gson gson=new Gson();
        String personJsonString = gson.toJson(person);

        resp.getWriter().write(personJsonString);

    }

    protected void jQueryGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //乱码
        System.out.println("JQueryAjax==方法调用");

        Person person = new Person(1, "国哥");

        //字符串
        Gson gson=new Gson();
        String personJsonString = gson.toJson(person);

        resp.getWriter().write(personJsonString);

    }

    protected void jQueryPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //乱码
        System.out.println("JQueryAjax==方法调用");

        Person person = new Person(1, "国哥");

        //字符串
        Gson gson=new Gson();
        String personJsonString = gson.toJson(person);

        resp.getWriter().write(personJsonString);

    }
    protected void jQueryGetJson(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //乱码
        System.out.println("jQueryGetJson ==方法调用");

        Person person = new Person(1, "国哥");

        //字符串
        Gson gson=new Gson();
        String personJsonString = gson.toJson(person);

        resp.getWriter().write(personJsonString);

    }

    protected void jQuerySerialize(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //乱码
        System.out.println("jQuerySerialize ==方法调用");

        System.out.println("用户名"+req.getParameter("username"));
        System.out.println("密码"+req.getParameter("password"));
        Person person = new Person(1, "国哥");

        //字符串
        Gson gson=new Gson();
        String personJsonString = gson.toJson(person);

        resp.getWriter().write(personJsonString);

    }

}
