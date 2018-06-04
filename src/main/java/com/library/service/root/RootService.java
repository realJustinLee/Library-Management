package com.library.service.root;

import com.library.domain.book.Book;
import com.library.domain.book.User;

import java.sql.SQLException;
import java.util.List;

/**
 * @Description:
 */
public interface RootService {
    /**
     * 查询所有书籍
     */
    List<Book> rootSelectAllBooks() throws SQLException;

    /**
     * 修改书籍信息
     */
    boolean updateBookInfo(Object[] params) throws SQLException;

    /**
     * 删除书籍
     */
    boolean deleteBook(Object[] params) throws SQLException;

    /**
     * 增加书籍信息
     */
    boolean addBookInformation(Object[] params) throws SQLException;

    /**
     * 模糊查询书籍
     */
    List<Book> searchBook(Object[] params) throws SQLException;

    /**
     * 通过id查询书籍
     */
    List<Book> searchIdBook(Object[] params) throws SQLException;

    /**
     * 查询所有用户
     */
    List<User> selectAllUser() throws SQLException;

    /**
     * 根据id查询用户
     */
    List<User> selectUserById(Object[] params) throws SQLException;
}
