package com.atguigu.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName: CartServlet
 * Package: com.atguigu.web
 * Description:
 *
 * @Author: GuanYuJie
 * @Create:2023/3/16 - 22:42
 * Version: v1.0
 */
public class CartServlet extends BaseServlet{
    /**
     * 加入购物车
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ok");
    }
}
