package com.atguigu.service;

import com.atguigu.pojo.Cart;

/**
 * ClassName: OrderService
 * Package: com.atguigu.service
 * Description:
 *
 * @Author: GuanYuJie
 * @Create:2023/3/17 - 22:10
 * Version: v1.0
 */
public interface OrderService {

    public String createOrder(Cart cart,Integer userId);

}
