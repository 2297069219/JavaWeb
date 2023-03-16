package com.atguigu.dao.impl;

import com.atguigu.dao.BookDao;
import com.atguigu.pojo.Book;
import org.junit.Test;

import java.util.List;

/**
 * ClassName: BookDaoImpl
 * Package: com.atguigu.dao.impl
 * Description:
 *
 * @Author: GuanYuJie
 * @Create:2023/3/14 - 19:30
 * Version: v1.0
 */
public class BookDaoImpl extends BaseDao implements BookDao {

    @Override
    public int addBook(Book book) {
        String sql="insert into t_book(`name`,`author`,`price`,`sales`,`stock`,`img_path`) values(?,?,?,?,?,?)";

        return update(sql,book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImgPath());

    }

    @Override
    public int deleteBookById(Integer id) {

        String sql="delete from t_book where id=?";

        return update(sql,id);
    }

    @Override
    public int updateBook(Book book) {
        String sql="update t_book set `name`=?,`author`=?,`price`=?,`sales`=?,`stock`=?,`img_path`=? where id=?";
        return update(sql,book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImgPath(),book.getId());
    }

    @Override
    public Book queryBookById(Integer id) {
        String sql = "select `id` , `name` , `author` , `price` , `sales` , `stock` , `img_path` imgPath from t_book where id = ?";
        return queryForOne(Book.class, sql,id);
    }

    @Override
    public List<Book> queryBooks() {
        String sql = "select `id`,`price`,`name`,`author`,`sales`,`stock`,`img_path` imgPath from t_book";
        return queryForList(Book.class, sql);
      }

/*     @Test
     public void test1(){
         for (Book queryBook : queryBooks()) {
             System.out.println(queryBook);
         }
     }*/

    @Override
    public Integer queryForPageTotalCount() {
        String sql="select count(*) from t_book";
        Number count= (Number)queryForSingleValue(sql);
        return count.intValue();
    }

    @Override
    public List<Book> queryForPageItems(int begin, int pageSize) {
        String sql="select `id`,`price`,`name`,`author`,`sales`,`stock`,`img_path` imgPath from t_book limit ?,?";
        return queryForList(Book.class,sql,begin,pageSize);
    }
}
