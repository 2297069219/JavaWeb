package com.atguigu.test;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItem;
import com.atguigu.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * ClassName: OrderServiceTest
 * Package: com.atguigu.test
 * Description:
 *
 * @Author: GuanYuJie
 * @Create:2023/3/17 - 22:20
 * Version: v1.0
 */
public class OrderServiceTest {

    @Test
    public void createOrder() {
        Cart cart=new Cart();
        cart.addItem(new CartItem(1,"Java从入门到精通",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1,"Java从入门到精通",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(2,"数据结构与算法",1,new BigDecimal(100),new BigDecimal(100)));

        OrderServiceImpl orderService = new OrderServiceImpl();

        System.out.println(orderService.createOrder(cart,1));

    }
}