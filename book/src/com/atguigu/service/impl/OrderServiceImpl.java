package com.atguigu.service.impl;

import com.atguigu.dao.BookDao;
import com.atguigu.dao.OrderDao;
import com.atguigu.dao.OrderItemDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.dao.impl.OrderDaoImpl;
import com.atguigu.dao.impl.OrderItemDaoImpl;
import com.atguigu.pojo.*;
import com.atguigu.service.OrderService;

import java.util.Date;
import java.util.Map;

/**
 * ClassName: OrderServiceImpl
 * Package: com.atguigu.service.impl
 * Description:
 *
 * @Author: GuanYuJie
 * @Create:2023/3/17 - 22:11
 * Version: v1.0
 */
public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao=new OrderDaoImpl();
    private OrderItemDao orderItemDao=new OrderItemDaoImpl();
    private BookDao bookDao=new BookDaoImpl();

    @Override
    public String createOrder(Cart cart, Integer userId) {

        System.out.println("OrderServiceImpl程序在【"+Thread.currentThread().getName()+"】中");

        //唯一性时间戳
        String orderId=System.currentTimeMillis()+""+userId;
        //创建一个订单对象
        Order order=new Order(orderId,new Date(),cart.getTotalPrice(),0,userId);

        //保存订单
        orderDao.saveOrder(order);

        //int i=12/0;

        //遍历购物车中每一个商品项 保存到数据库中
        for(Map.Entry<Integer, CartItem> entry:cart.getItems().entrySet()){
            //获取每一个商品项
            CartItem cartItem=entry.getValue();
            // 转换为订单项
            OrderItem orderItem=new OrderItem(null,cartItem.getName(),cartItem.getCount(),cartItem.getPrice(),cartItem.getTotalPrice(),orderId);
            //保存订单到数据库
            orderItemDao.saveOrderItem(orderItem);
            //
            Book book = bookDao.queryBookById(cartItem.getId());
            book.setSales(book.getSales()+cartItem.getCount());
            book.setStock(book.getStock()-cartItem.getCount());
            bookDao.updateBook(book);


        }
        cart.clear();
        return orderId;
    }
}
