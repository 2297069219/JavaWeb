package com.atguigu.service;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;

import java.util.List;

/**
 * ClassName: BookService
 * Package: com.atguigu.service
 * Description:
 *
 * @Author: GuanYuJie
 * @Create:2023/3/14 - 19:55
 * Version: v1.0
 */
public interface BookService {

    public void addBook(Book book);

    public void deleteBookById(Integer id);

    public void updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();

    Page<Book> page(int pageNo, int pageSize);
}
