package com.atguigu.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * ClassName: UploadServlet
 * Package: com.atguigu.servlet
 * Description:
 *
 * @Author: GuanYuJie
 * @Create:2023/3/14 - 14:44
 * Version: v1.0
 */
public class UploadServlet extends HttpServlet {
    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
/*
        System.out.println("上传成功");

        ServletInputStream inputStream = req.getInputStream();

        byte[] buffer=new byte[1024000];
        int read = inputStream.read(buffer);
        System.out.println(new String(buffer,0,read));

*/
        //1、判断是否多段数据 多段数据 文件
        if(ServletFileUpload.isMultipartContent(req)){
            //工厂类
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            //创建用于解析数据的工具类ServletFileUpload类
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);

            try {
                List<FileItem> list=servletFileUpload.parseRequest(req);
                //表单项
                for (FileItem fileItem : list) {

                    if(fileItem.isFormField()){
                        System.out.println("name:"+fileItem.getFieldName());
                        System.out.println("value:"+fileItem.getString("utf-8"));
                    }else{
                        System.out.println("属性值"+fileItem.getFieldName());
                        System.out.println("name"+fileItem.getName());
                        //fileItem.write(new File("e:\\"+fileItem.getName()));

                    }
                }
            } catch (FileUploadException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
