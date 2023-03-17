package com.atguigu.test;

import com.atguigu.dao.OrderDao;
import com.atguigu.dao.impl.OrderDaoImpl;
import com.atguigu.pojo.Order;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * ClassName: OrderDaoTest
 * Package: com.atguigu.test
 * Description:
 *
 * @Author: GuanYuJie
 * @Create:2023/3/17 - 21:47
 * Version: v1.0
 */
public class OrderDaoTest {


    @Test
    public void saveOrder() {
        OrderDao orderDao=new OrderDaoImpl();
        orderDao.saveOrder(new Order("111111",new Date(),new BigDecimal(1111),0,1));

    }
}