package com.library.service.book;

import com.library.domain.book.Book;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author: lixin
 * @Date:   Created in 2018/4/16 19:02
 * @Description:
 * @Email: JustinDellAdam@live.com
 */
public interface BookInfoService {
    /**
     * 查询最热门的10本书
     */
    List<Book> selectTop10Book(Object[] params) throws SQLException;

    /**
     * 查询所有书籍
     */
    List<Book> selectAllBook() throws SQLException;

    /**
     * 分页查询所有书籍
     */
    List<Book> selectLimitBook(Object[] params) throws SQLException;

    /**
     * 查询相似书籍
     */
    List<Book> selectSameBook(Object[] params) throws SQLException;

    /**
     * 查询最新的三本书
     */
    List<Book> selectNewBook() throws SQLException;

    /**
     * 用户模糊查找书籍
     */
    List<Book> selectVagueBook(Object[] params) throws SQLException;

    /**
     * 根据id查找书籍相关信息
     */
    List<Book> selectBookDetail(Object[] params) throws SQLException;

    /**
     * 获取书籍总数
     */
    int bookNumber() throws SQLException;

    /**
     * 热门作者
     */
    List<Book> topAuthor() throws SQLException;

    /**
     * 特色书籍
     */
    List<Book> selectSpecialBook(Object[] params) throws SQLException;
}
