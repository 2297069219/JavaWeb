package com.atguigu.filter;

import com.atguigu.utils.JdbcUtils;

import javax.servlet.*;
import java.io.IOException;

/**
 * ClassName: TransactionFilter
 * Package: com.atguigu.filter
 * Description:
 *
 * @Author: GuanYuJie
 * @Create:2023/3/18 - 14:12
 * Version: v1.0
 */
public class TransactionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        try {
            filterChain.doFilter(servletRequest,servletResponse);
            JdbcUtils.commitAndClose();
        }catch (Exception e) {
            JdbcUtils.rollbackAndClose();
            e.printStackTrace();
            //把异常抛给Tomcat管理展示友好错误页面
            throw new RuntimeException(e);
        }

    }

    @Override
    public void destroy() {

    }
}
