package com.atguigu.servlet;

import com.atguigu.utils.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName: CookieServlet
 * Package: com.atguigu.servlet
 * Description:
 *
 * @Author: GuanYuJie
 * @Create:2023/3/16 - 18:18
 * Version: v1.0
 */
public class CookieServlet extends BaseServlet{

    protected void testPath(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie cookie=new Cookie("path1","path1");
        cookie.setPath(req.getContextPath()+"/abc");
        resp.addCookie(cookie);
        resp.getWriter().write("Path路径的Cookie");

    }

    protected void updateCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        //创建一个Cookie同名
//        Cookie cookie = new Cookie("key1", "newValue1");
//        resp.addCookie(cookie);
//        resp.getWriter().write("修改完成");

        Cookie cookie=CookieUtils.findCookie("key2",req.getCookies());
        if(cookie!=null){
            cookie.setValue("newValue2");
            resp.addCookie(cookie);
            resp.getWriter().write("修改成功");
        }
    }

    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //找到Cookie对象
        Cookie cookie=CookieUtils.findCookie("key3",req.getCookies());
        if(cookie!=null){
            cookie.setMaxAge(0);//马上删除
            resp.addCookie(cookie);
            resp.getWriter().write("马上删除Cookie key3");
        }
        //调用setMaxAge（0）；
    }

    protected void life3600(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie cookie = new Cookie("life3600", "life3600");
        cookie.setMaxAge(3600);
        resp.addCookie(cookie);
        resp.getWriter().write("创建一个存活一小时的Cookie");


    }

    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie cookie=new Cookie("defaultLife","defaultLife");
        cookie.setMaxAge(-1);
        resp.addCookie(cookie);

    }


        protected void getCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        Cookie iWant= CookieUtils.findCookie("key1",cookies);
//        for (Cookie cookie : cookies) {
//            //key value
//            resp.getWriter().write("Cookie[" + cookie.getName() + "=" + cookie.getValue() + "]<br>");
//            if ("key2".equals(cookie.getName())) {
//                iWant = cookie;
//            }
//        }
        if(iWant!=null){
            resp.getWriter().write("找到需要的Cookie");
        }

    }

    protected void createCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //对象
        Cookie cookie1 = new Cookie("key1", "value1");
        Cookie cookie2 = new Cookie("key2", "value2");
        Cookie cookie3 = new Cookie("key3", "value3");
        //客户端保存Cookie
        resp.addCookie(cookie1);
        resp.addCookie(cookie2);
        resp.addCookie(cookie3);

        resp.getWriter().write("cookie创建成功");


    }
}
