package com.atguigu.dao;

import com.atguigu.pojo.Book;

import java.util.List;

/**
 * ClassName: BookDao
 * Package: com.atguigu.dao
 * Description:
 *
 * @Author: GuanYuJie
 * @Create:2023/3/14 - 19:28
 * Version: v1.0
 */
public interface BookDao {

    public int addBook(Book book);

    public int deleteBookById(Integer id);

    public int updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();

    Integer queryForPageTotalCount();

    List<Book> queryForPageItems(int begin, int pageSize);

    Integer queryForPageTotalCountByPrice(int min, int max);

    List<Book> queryForPageItemsByPrice(int begin, int pageSize, int min, int max);
}
