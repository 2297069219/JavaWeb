package com.atguigu.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * ClassName: AdminFilter
 * Package: com.atguigu.filter
 * Description:
 *
 * @Author: GuanYuJie
 * @Create:2023/3/18 - 7:44
 * Version: v1.0
 */
public class AdminFilter implements Filter {

    public AdminFilter(){
        System.out.println("1、构造器方法AdminFilter（）");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init()");
    }

    /**
     * doFilter方法 ，专门用来权限检查
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter()");
        HttpServletRequest httpServletRequest= (HttpServletRequest) servletRequest;

        HttpSession session=httpServletRequest.getSession();
        Object user=session.getAttribute("user");
        if(user==null){
            servletRequest.getRequestDispatcher("/index.jsp").forward(servletRequest,servletResponse);
            return;
        }else{
            //让程序继续访问目标资源
            filterChain.doFilter(servletRequest,servletResponse);
        }

    }


    @Override
    public void destroy() {
        System.out.println("destroy()");
    }
}
