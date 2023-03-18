package com.atguigu.threadLocal;

/**
 * ClassName: OrderService
 * Package: com.atguigu.threadLocal
 * Description:
 *
 * @Author: GuanYuJie
 * @Create:2023/3/18 - 9:11
 * Version: v1.0
 */
public class OrderService {

    public void createOrder(){
        String name = Thread.currentThread().getName();

        System.out.println("OrderService"+name+"当前保存的数据是【"+ThreadLocalTest.threadLocal.get());
        //传递到
        new OrderDao().saveOrder();
    }

}
