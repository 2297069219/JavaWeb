package com.atguigu.dao.impl;

import com.atguigu.dao.OrderDao;
import com.atguigu.pojo.Order;

/**
 * ClassName: OrderDaoImpl
 * Package: com.atguigu.dao.impl
 * Description:
 *
 * @Author: GuanYuJie
 * @Create:2023/3/17 - 21:39
 * Version: v1.0
 */
public class OrderDaoImpl extends BaseDao implements OrderDao {


    @Override
    public int saveOrder(Order order) {

        System.out.println("saveOrder 程序在【"+Thread.currentThread().getName()+"】中");

        String sql="insert into t_order(`order_id`,`create_time`,`price`,`status`,`user_id`) values(?,?,?,?,?)";
        return  update(sql,order.getOrderId(),order.getCreateTime(),order.getPrice(),order.getStatus(),order.getUserId());
    }
}
