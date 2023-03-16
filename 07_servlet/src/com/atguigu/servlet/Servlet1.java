package com.atguigu.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName: Servlet1
 * Package: com.atguigu.servlet
 * Description:
 *
 * @Author: GuanYuJie
 * @Create:2023/3/12 - 16:29
 * Version: v1.0
 */
public class Servlet1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        System.out.println("材料 参数:"+username);
        //域数据 盖章
        req.setAttribute("key1","柜台一的章");

        //问路/打头 http://ip:poer/工程名/  映射到web目录
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/servlet2");

        requestDispatcher.forward(req,resp);
    }
}
