package com.atguigu.service.impl;

import com.atguigu.dao.BookDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.BookService;

import java.math.BigDecimal;
import java.util.List;

/**
 * ClassName: BookServiceImpl
 * Package: com.atguigu.service.impl
 * Description:
 *
 * @Author: GuanYuJie
 * @Create:2023/3/14 - 19:58
 * Version: v1.0
 */
public class BookServiceImpl implements BookService {

    private BookDao bookDao=new BookDaoImpl();

    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDao.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }

    @Override
    public Page<Book> page(int pageNo, int pageSize) {
        Page<Book> page=new Page<>();


        page.setPageSize(pageSize);

        Integer pageTotalCount=bookDao.queryForPageTotalCount();
        page.setPageTotalCount(pageTotalCount);

        Integer pageTotal=(pageTotalCount+pageSize-1)/pageSize;
        page.setPageTotal(pageTotal);



        page.setPageNo(pageNo);
        int begin=(page.getPageNo()-1)*pageSize;
        List<Book> items=bookDao.queryForPageItems(begin,pageSize);
        page.setItems(items);

        return page;
    }

    @Override
    public Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max) {
        Page<Book> page=new Page<>();

        page.setPageSize(pageSize);

        Integer pageTotalCount=bookDao.queryForPageTotalCountByPrice(min,max);
        page.setPageTotalCount(pageTotalCount);

        Integer pageTotal=(pageTotalCount+pageSize-1)/pageSize;
        page.setPageTotal(pageTotal);



        page.setPageNo(pageNo);
        int begin=(page.getPageNo()-1)*pageSize;
        List<Book> items=bookDao.queryForPageItemsByPrice(begin,pageSize,min,max);
        page.setItems(items);

        return page;
    }
}
