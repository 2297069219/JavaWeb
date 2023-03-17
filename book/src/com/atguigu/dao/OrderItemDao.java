package com.atguigu.dao;

import com.atguigu.pojo.OrderItem;

/**
 * ClassName: OrderItem
 * Package: com.atguigu.dao
 * Description:
 *
 * @Author: GuanYuJie
 * @Create:2023/3/17 - 21:38
 * Version: v1.0
 */
public interface OrderItemDao {

    public int saveOrderItem(OrderItem orderItem);

}
