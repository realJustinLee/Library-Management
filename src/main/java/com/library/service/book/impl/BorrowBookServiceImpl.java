package com.library.service.book.impl;

import com.library.dao.book.BookDao;
import com.library.dao.book.BorrowDao;
import com.library.dao.book.OrderDao;
import com.library.service.book.BorrowBookService;
import com.library.utils.JdbcUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Service
public class BorrowBookServiceImpl implements BorrowBookService {
    @Autowired
    BorrowDao borrowDao;

    @Autowired
    BookDao bookDao;
    @Autowired
    OrderDao orderDao;

    String sql;

    /**
     * 还书
     */
    public boolean returnBook(Object[] bookParams, Object[] borrowParams) throws SQLException {
        boolean returnBookSuccess = true;
        //修改borrow表的书籍
        String changeBorrowSql = "update tbl_borrow set borrow_return_time = ?,borrow_is_return = 'true' where book_id= ? and user_id = ?";
        //修改book表的书籍剩余量
        String changeBookSql = "update tbl_book set remain_num = remain_num + 1 where id = ?";
        Connection connection = JdbcUtils.getConnection();
        try {
            //开启事务
            connection.setAutoCommit(false);
            borrowDao.updateQuery(changeBorrowSql, borrowParams);
            bookDao.updateQuery(changeBookSql, bookParams);
            //手动提交
            connection.commit();
            //重新关闭事物
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
            returnBookSuccess = false;
            //事物回滚
            connection.rollback();
        }
        return returnBookSuccess;
    }

    /**
     * 借书
     */
    public boolean borrowBook(Object[] bookParams, Object[] borrowParams, Object[] orderParams) throws SQLException {
        boolean borrowBookSuccess = true;
        //修改borrow表的书籍
        String changeBorrowSql = "insert into tbl_borrow(book_id,user_id,borrow_start_time,borrow_end_time,borrow_return_time,borrow_is_return) values(?,?,?,?,?,?)";
        //修改book表的书籍剩余量
        String changeBookSql = "update tbl_book set remain_num = remain_num - 1 where id = ?";
        //修改order表的信息
        String changeOrderSql = "insert into tbl_order(order_userid,order_book_id,order_number,order_time) values(?,?,?,?)";
        Connection connection = JdbcUtils.getConnection();
        try {
            //开启事务
            connection.setAutoCommit(false);
            bookDao.updateQuery(changeBookSql, bookParams);
            borrowDao.updateQuery(changeBorrowSql, borrowParams);
            orderDao.addQuery(changeOrderSql, orderParams);
            //手动提交
            connection.commit();
            //重新关闭事物
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
            borrowBookSuccess = false;
            //事物回滚
            connection.rollback();
        }
        return borrowBookSuccess;
    }

    /**
     * 根据id查询用户已借书籍
     */
    public List getUserBorrowBooks(Object[] params) throws SQLException {
        sql = "select tbl_book.name,tbl_borrow.book_id, tbl_borrow.borrow_start_time,tbl_borrow.borrow_end_time from tbl_book,tbl_borrow where tbl_borrow.user_id = ? and tbl_borrow.borrow_is_return = 'false'and tbl_book.id = tbl_borrow.book_id";
        List list = borrowDao.selectQueryInfo(sql, params);
        return list;
    }
}
