package com.atguigu.web;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItem;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.utils.WebUtils;

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

    private BookService bookService=new BookServiceImpl();


    /**
     * 删除商品项
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //编号发送给服务器
        int id=WebUtils.parseInt(req.getParameter("id"),0);
        //获取购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if(cart!=null){
            //删除购物车商品项
            cart.deleteItem(id);
            //重定向原来页面
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    /**
     * 清空购物车
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取购物车对象
        Cart cart=(Cart) req.getSession().getAttribute("cart");
        if(cart!=null) {
            cart.clear();
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    /**
     * 修改上商品数量
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数 商品编号 商品数量
        int id=WebUtils.parseInt(req.getParameter("id"),0);
        int count=WebUtils.parseInt(req.getParameter("count"),1);
        Cart cart=(Cart)req.getSession().getAttribute("cart");
        if(cart!=null){
            //修改商品数量
            cart.updateCount(id,count);
            //刷新页面
            resp.sendRedirect(req.getHeader("Referer"));
        }

    }


    /**
     * 加入购物车
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数 编号"
        int id= WebUtils.parseInt(req.getParameter("id"), 0);
        Book book = bookService.queryBookById(id);
        CartItem cartItem=new CartItem(book.getId(),book.getName(),1,book.getPrice(),book.getPrice());
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if(cart==null){
            cart=new Cart();
            req.getSession().setAttribute("cart",cart);
        }
        cart.addItem(cartItem);

        System.out.println(cart);

        System.out.println(req.getHeader("Referer"));
        //重定向到原来的页面
        resp.sendRedirect(req.getHeader("Referer"));
        //最后一个商品的名称
        req.getSession().setAttribute("lastName",cartItem.getName());

    }
}
