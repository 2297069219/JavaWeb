package com.atguigu.LIstener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * ClassName: MyServletContextLIstenerImpl
 * Package: com.atguigu.LIstener
 * Description:
 *
 * @Author: GuanYuJie
 * @Create:2023/3/14 - 11:06
 * Version: v1.0
 */
public class MyServletContextListenerImpl implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("ServletContext对象创建了");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("销毁了");
    }
}
