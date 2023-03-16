package com.atguigu.servlet;

import com.atguigu.pojo.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Seach
 * Package: com.atguigu.servlet
 * Description:
 *
 * @Author: GuanYuJie
 * @Create:2023/3/14 - 10:37
 * Version: v1.0
 */
public class SearchStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数
        //sql数据查询信息
        List<Student> studentList=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int t=i+1;
            studentList.add(new Student(t,"name"+t,18+t,"phone"+t));

        }
        //保存结果
        req.setAttribute("stuList",studentList);
        //请求转发发哦showStudent.jsp页面
        req.getRequestDispatcher("/test/showStudent.jsp").forward(req,resp);
    }
}
