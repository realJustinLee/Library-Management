package com.library.service.book;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author: lixin
 * @Date:   Created in 2018/4/16 19:02
 * @Description:
 * @Email: JustinDellAdam@live.com
 */
public interface BorrowBookService {
    /**
     * 还书
     */
    boolean returnBook(Object[] bookParams,Object[] borrowParams) throws SQLException;

    /**
     * 借书
     */
    boolean borrowBook(Object[] bookParams,Object[] borrowParams,Object[] orderParams) throws SQLException;

    /**
     * 根据id查询用户已借书籍
     */
    List getUserBorrowBooks(Object[] params) throws SQLException;
}
