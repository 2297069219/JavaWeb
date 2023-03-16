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
 * ClassName: BookServlet
 * Package: com.atguigu.web
 * Description:
 *
 * @Author: GuanYuJie
 * @Create:2023/3/14 - 20:12
 * Version: v1.0
 */
public class BookServlet extends BaseServlet{

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
        int pageNo=WebUtils.parseInt(req.getParameter("pageNo"),1);
        int pageSize=WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        //2、调用page（pageNo，pageSize）
        Page<Book> page=bookService.page(pageNo,pageSize);

        page.setUrl("manager/bookServlet?action=page");

        //3、保存到Request
        req.setAttribute("page",page);
        //4、请求转发到book_manage.jsp
        req.getRequestDispatcher("//pages/manager/book_manager.jsp").forward(req,resp);

    }


    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo=WebUtils.parseInt(req.getParameter("pageNo"),0);
        pageNo+=1;
        //1、查询全部图书
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        //2、保存到Request域中
        bookService.addBook(book);
        //请求转发
        //bug 表单重复提交 浏览器会记录最后一次请求的全部信息，用户按下f5 就会发起最后一次请求
//        req.getRequestDispatcher("/manager/bookServlet?action=list");
        //重定向
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=page&pageNo="+pageNo);
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id=WebUtils.parseInt(req.getParameter("id"),0);
        bookService.deleteBookById(id);
        //重定向
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=page&pageNo="+req.getParameter("pageNo"));
    }


    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book=WebUtils.copyParamToBean(req.getParameterMap(),new Book());
        bookService.updateBook(book);
        //重定向
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=page&pageNo="+req.getParameter("pageNo"));

    }

    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、获取请求参数和图书编号
        int id=WebUtils.parseInt(req.getParameter("id"),0);
        //2、查询图书
        Book book = bookService.queryBookById(id);
        //3、保存
        req.setAttribute("book",book);
        //4、请求转发
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req,resp);
    }


    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //通过bookServlet查询全部
        List<Book> books = bookService.queryBooks();
        //2、信息保存到Request域中
        req.setAttribute("books",books);
        //3、请求转发
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);



    }


}
