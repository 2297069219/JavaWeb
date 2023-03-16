package com.atguigu.servlet;

import org.apache.commons.io.IOUtils;

import javax.management.remote.rmi.RMIConnectionImpl;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.Base64;

/**
 * ClassName: Download
 * Package: com.atguigu.servlet
 * Description:
 *
 * @Author: GuanYuJie
 * @Create:2023/3/14 - 15:13
 * Version: v1.0
 */
public class Download extends HttpServlet {
    //1、文件名
    public static void main(String[] args) {
        String content="内容";


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String downloadFileName="2.jpg";
        ServletContext servletContext = getServletContext();
        String mimeType = servletContext.getMimeType("/file/" + downloadFileName);
        System.out.println("文件类型"+mimeType);
        resp.setContentType(mimeType);
        //下载使用 Content-Disposition
        //attachment fujian
        if(req.getHeader("User-Agent").contains("Filefpx"))
        resp.setHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode("中国","UTF-8"));
        //服务器解析http://ip:port/工程名/ web

        InputStream resourceAsStream = servletContext.getResourceAsStream("/file" + downloadFileName);
        ServletOutputStream outputStream = resp.getOutputStream();
        //获取响应的输出流
        //byte[] buffer=new byte[1024];
        //复制给输出流，输出给客户端
        IOUtils.copy(resourceAsStream,outputStream);
    }
}
