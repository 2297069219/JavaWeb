package com.atguigu.web;

import com.atguigu.dao.impl.BaseDao;
import com.atguigu.pojo.Cart;
import com.atguigu.pojo.User;
import com.atguigu.service.OrderService;
import com.atguigu.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName: OrderServlet
 * Package: com.atguigu.web
 * Description:
 *
 * @Author: GuanYuJie
 * @Create:2023/3/17 - 22:24
 * Version: v1.0
 */
public class OrderServlet extends BaseServlet {

    private OrderService orderService=new OrderServiceImpl();

    /**
     * 生成订单
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //调用orderService.createOrder(Cart,UserId);
        //获取购物车对象
        Cart cart=(Cart) req.getSession().getAttribute("cart");
        //获取UserId
        User loginUser= (User) req.getSession().getAttribute("user");
        if(loginUser==null){
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
            return ;
        }
        Integer userId = loginUser.getId();

        String orderId = orderService.createOrder(cart, userId);

//        req.setAttribute("orderId",orderId);

//        req.getRequestDispatcher("/pages/cart/checkout.jsp").forward(req,resp);

        req.getSession().setAttribute("orderId",orderId);
        resp.sendRedirect(req.getContextPath()+"/pages/cart/checkout.jsp");
    }
}
