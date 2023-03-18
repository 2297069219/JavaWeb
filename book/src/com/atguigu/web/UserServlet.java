package com.atguigu.web;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;
import com.atguigu.utils.WebUtils;
import com.google.gson.Gson;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * ClassName: UserServlet
 * Package: com.atguigu.web
 * Description:
 *
 * @Author: GuanYuJie
 * @Create:2023/3/14 - 17:01
 * Version: v1.0
 */
public class UserServlet extends BaseServlet {
    private UserService userService=new UserServiceImpl();

    protected void ajaxExistsUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //
        String username = req.getParameter("username");
        boolean existsUsername = userService.existsUsername(username);
        //封装为map对象
        Map<String,Object> resultMap=new HashMap<>();
        resultMap.put("existsUsername",existsUsername);

        Gson gson=new Gson();
        String resultMapJsonString = gson.toJson(resultMap);
        resp.getWriter().write(resultMapJsonString);

    }


        /**
         * 处理登录的功能
         * @param req
         * @param resp
         * @throws ServletException
         * @throws IOException
         */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User loginUser = userService.login(new User(null, username, password, null));

        if(loginUser==null){
            //错误 回显表单 保存到request
            req.setAttribute("mas","用户名或密码错误");
            req.setAttribute("username",username);
            //跳回登录页面
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);

        }else{
            //保存用户登录信息
            req.getSession().setAttribute("user",loginUser);

            //login_success.jsp
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);

        }


    }
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);

        //1请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        User user=(User)WebUtils.copyParamToBean(req.getParameterMap(),new User());

        //写死
        if(token!=null&&token.equalsIgnoreCase(code)){

            if(userService.existsUsername(username)){
                //不可用
                System.out.println("用户名["+username+"]存在");
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
            }else{

                userService.registUser(new User(null,username,password,email));
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req,resp);
            }
        }else{
            //回显信息保存到Request域中 回显信息Request域中
            req.setAttribute("msg","用户名已存在！");
            req.setAttribute("username",username);
            req.setAttribute("email",email);

            System.out.println("验证码["+code+"]错误");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
        }

    }

    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、销毁Session
        //2、重定向
        req.getSession().invalidate();
        resp.sendRedirect(req.getContextPath());

    }

    /**
     * 处理注册的功能
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */

}
