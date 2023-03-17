package com.atguigu.dao;

import com.atguigu.pojo.Order;

/**
 * ClassName: OrderDao
 * Package: com.atguigu.dao
 * Description:
 *
 * @Author: GuanYuJie
 * @Create:2023/3/17 - 21:37
 * Version: v1.0
 */
public interface OrderDao {

    public int saveOrder(Order order);

}
