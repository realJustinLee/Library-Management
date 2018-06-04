package com.library.service.book.impl;

import com.library.dao.book.BookDao;
import com.library.dao.book.impl.BookDaoImpl;
import com.library.domain.book.Book;
import com.library.service.book.BookInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class BookInfoServiceImpl implements BookInfoService {
    @Autowired
    BookDao bookDao;

    List<Book> books = null;
    String sql;

    /**
     * 查询最热门的10本书
     */
    public List<Book> selectTop10Book(Object[] params) throws SQLException {
        sql = "select * from tbl_book order by borrow_num desc limit ?,?";
        bookDao = new BookDaoImpl();
        books = bookDao.selectQuery(sql, params);
        return books;
    }

    /**
     * 查询所有书籍
     */
    public List<Book> selectAllBook() throws SQLException {
        return null;
    }

    /**
     * 分页查询所有书籍
     */
    public List<Book> selectLimitBook(Object[] params) throws SQLException {
        sql = "select * from tbl_book limit ?,?";
        bookDao = new BookDaoImpl();
        books = bookDao.selectQuery(sql, params);
        return books;
    }

    /**
     * 查询相似书籍
     */
    public List<Book> selectSameBook(Object[] params) throws SQLException {
        sql = "select * from tbl_book where classes = (SELECT tbl_book.classes from tbl_book where id = ? ) and id not in (?) limit 0,6";
        return bookDao.selectQuery(sql, params);
    }

    /**
     * 查询最新的三本书
     */
    public List<Book> selectNewBook() throws SQLException {
        sql = "select * from tbl_book order by id desc limit 0,3";
        Object[] params = new Object[]{};
        books = bookDao.selectQuery(sql, params);
        return books;
    }

    /**
     * 用户模糊查找书籍
     */
    public List<Book> selectVagueBook(Object[] params) throws SQLException {
        sql = "select * from tbl_book where name like ?";
        books = bookDao.selectQuery(sql, params);
        return books;
    }

    /**
     * 特色书籍
     */
    public List<Book> selectSpecialBook(Object[] params) throws SQLException {
        sql = "select * from tbl_book where classes = ? limit 0,3";
        books = bookDao.selectQuery(sql, params);
        return books;
    }

    /**
     * 根据id查找书籍相关信息
     */
    public List<Book> selectBookDetail(Object[] params) throws SQLException {
        sql = "select * from tbl_book where id = ?";
        List<Book> book = bookDao.selectQuery(sql, params);
        return book;
    }

    /**
     * 获取书籍总数
     */
    public int bookNumber() throws SQLException {
        sql = "select * from tbl_book";
        Object[] params = new Object[]{};
        books = bookDao.selectQuery(sql, params);
        return books.size();
    }

    /**
     * 热门作者
     */
    public List<Book> topAuthor() throws SQLException {
        sql = "select DISTINCT * from tbl_book order by borrow_num DESC limit 0,10";
        Object[] params = new Object[]{};
        books = bookDao.selectQuery(sql, params);
        return books;
    }
}
