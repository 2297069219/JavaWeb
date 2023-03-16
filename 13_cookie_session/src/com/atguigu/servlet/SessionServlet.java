package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * ClassName: SessionServlet
 * Package: com.atguigu.servlet
 * Description:
 *
 * @Author: GuanYuJie
 * @Create:2023/3/16 - 19:53
 * Version: v1.0
 */
public class SessionServlet extends BaseServlet{

    protected void createOrGetSession(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        boolean aNew = session.isNew();
        String id=session.getId();
        resp.getWriter().write("得到Session id: "+id+"<br>");
        resp.getWriter().write("得到Session isNew: "+aNew+"<br>");
    }

    /**
     * 往Session保存数据
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void setAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("key1","value1");
        resp.getWriter().write("保存数据了");


    }

    /**
     * 往Session设置数据
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void getAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object attribute = req.getSession().getAttribute("key1");
        resp.getWriter().write("获取了数据"+attribute);

    }

    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int maxInactiveInterval = req.getSession().getMaxInactiveInterval();
        //默认超时时长
        resp.getWriter().write("Session默认超时时长为："+maxInactiveInterval+"秒");

    }
    protected void life3(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取Session对象
        HttpSession session = req.getSession();
        session.setMaxInactiveInterval(3);
        resp.getWriter().write("3秒后销毁");
    }
    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取Session对象
        HttpSession session = req.getSession();
        session.invalidate();
        resp.getWriter().write("Session已经超时了");
    }
}
