package com.atguigu.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * ClassName: Filter1
 * Package: com.atguigu.filter
 * Description:
 *
 * @Author: GuanYuJie
 * @Create:2023/3/18 - 8:29
 * Version: v1.0
 */
public class Filter1 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("前置代码");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("后置代码");
    }

    @Override
    public void destroy() {

    }
}
