package com.atguigu.test;

import com.atguigu.dao.OrderItemDao;
import com.atguigu.dao.impl.OrderItemDaoImpl;
import com.atguigu.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * ClassName: OrderItemDaoTest
 * Package: com.atguigu.test
 * Description:
 *
 * @Author: GuanYuJie
 * @Create:2023/3/17 - 21:53
 * Version: v1.0
 */
public class OrderItemDaoTest {

    @Test
    public void saveOrderItem() {
        OrderItemDao orderItemDao=new OrderItemDaoImpl();
        orderItemDao.saveOrderItem(new OrderItem(null,"Java",1,new BigDecimal(111),new BigDecimal(111),"111111"));
        orderItemDao.saveOrderItem(new OrderItem(null,"Java2",2,new BigDecimal(111),new BigDecimal(211),"111111"));
        orderItemDao.saveOrderItem(new OrderItem(null,"Java3",1,new BigDecimal(111),new BigDecimal(111),"111111"));


    }
}