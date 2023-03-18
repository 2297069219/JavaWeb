package com.atguigu.threadLocal;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ClassName: ThreadLocalTest
 * Package: com.atguigu.threadLocal
 * Description:
 *
 * @Author: GuanYuJie
 * @Create:2023/3/18 - 8:58
 * Version: v1.0
 */
public class ThreadLocalTest {
    //当前关联数据 Map
    public final static Map<String,Object> data=new ConcurrentHashMap<>();
    //高并发使用的ConcurrentHashMap
    //key 是自己的线程
    public static ThreadLocal<Object> threadLocal=new ThreadLocal<>();
    public static ThreadLocal<Object> threadLocal2=new ThreadLocal<>();
    private static Random random=new Random();

    public static class Task implements Runnable{
        @Override
        public void run() {
//            //随机生成一个变量 线程关联动1数据 key vlaue
//            Integer i = random.nextInt();
////            获取当前线程名
//            String name=Thread.currentThread().getName();
//            System.out.println("线程【"+name+"】生成的随机数："+i);
//            //data.put(name,i);
//            threadLocal.set(i);
//
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            new OrderService(). createOrder();
//            //run 打印 是否可以去出操作
//            //Object o = data.get(name);
//            Object o=threadLocal.get();
//            System.out.println("在线程["+name+"】快结束时取出关联数据是:"+o);
            threadLocal.set("abc");
            threadLocal2.set("bbc");
            //以最后的为准 覆盖掉
            //多个线程 static 销毁了

        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(new Task()).start();
        }
    }


}
