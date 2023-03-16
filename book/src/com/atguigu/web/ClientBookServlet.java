package com.atguigu.web;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * ClassName: ClientBookServlet
 * Package: com.atguigu.web
 * Description:
 *
 * @Author: GuanYuJie
 * @Create:2023/3/15 - 18:03
 * Version: v1.0
 */
public class ClientBookServlet extends BaseServlet{

    private BookService bookService=new BookServiceImpl();

    /**
     * 处理分页功能
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、获取请求参数pageNo pageSize
        int pageNo= WebUtils.parseInt(req.getParameter("pageNo"),1);
        int pageSize=WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        //2、调用page（pageNo，pageSize）
        Page<Book> page=bookService.page(pageNo,pageSize);
        page.setUrl("client/bookServlet?action=page");

        //3、保存到Request
        req.setAttribute("page",page);
        //4、请求转发到book_manage.jsp
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);

    }

   /**
     * 处理分页功能
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、获取请求参数pageNo pageSize
        int pageNo= WebUtils.parseInt(req.getParameter("pageNo"),1);
        int pageSize=WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        int min=WebUtils.parseInt(req.getParameter("min"),0);
        int max=WebUtils.parseInt(req.getParameter("max"),Integer.MAX_VALUE);

        //2、调用page（pageNo，pageSize）
        Page<Book> page=bookService.pageByPrice(pageNo,pageSize,min,max);
        StringBuilder sb=new StringBuilder("client/bookServlet?action=pageByPrice");
        //if min append
        if(req.getParameter("min")!=null){
            sb.append("&min=").append(req.getParameter("min"));
        }
        if(req.getParameter("max")!=null){
            sb.append("&max=").append(req.getParameter("max"));
        }

        page.setUrl(sb.toString());

        //3、保存到Request
        req.setAttribute("page",page);
        //4、请求转发到book_manage.jsp
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);

    }



}
