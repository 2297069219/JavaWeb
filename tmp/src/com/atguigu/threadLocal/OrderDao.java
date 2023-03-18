package com.atguigu.threadLocal;

/**
 * ClassName: OrderDao
 * Package: com.atguigu.threadLocal
 * Description:
 *
 * @Author: GuanYuJie
 * @Create:2023/3/18 - 9:15
 * Version: v1.0
 */
public class OrderDao {

    public void saveOrder(){
        String name = Thread.currentThread().getName();
        System.out.println("OrderDao["+name+"]当前保存的数据是"+ThreadLocalTest.threadLocal.get());

    }

}
