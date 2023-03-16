package com.atguigu.test;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * ClassName: BookServiceTest
 * Package: com.atguigu.test
 * Description:
 *
 * @Author: GuanYuJie
 * @Create:2023/3/14 - 20:02
 * Version: v1.0
 */
public class BookServiceTest {

    private BookService bookService=new BookServiceImpl();

    @Test
    public void addBook() {
        bookService.addBook(new Book(null,"国哥在手，天下我有","11111",new BigDecimal(1111111),10000,0,null));

    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(22);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(22,"社会ok","11111",new BigDecimal(1111111),0,10000,null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(2));
    }

    @Test
    public void queryBooks() {
        for (Book queryBook : bookService.queryBooks()) {
            System.out.println(queryBook);
        }
    }
    @Test
    public void Page(){
        System.out.println(bookService.page(1, Page.PAGE_SIZE));
    }
    @Test
    public void PageByPrice(){
        System.out.println(bookService.pageByPrice(1, Page.PAGE_SIZE,10,50));
    }
}