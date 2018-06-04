package com.library.dao.book.impl;

import com.library.dao.book.BookDao;
import com.library.domain.book.Book;
import com.library.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookDaoImpl extends QueryRunner implements BookDao {
    Connection connection = null;

    /**
     * 获取数据库连接
     */
    public BookDaoImpl() {
        try {
            connection = JdbcUtils.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 增加
     */
    public boolean addQuery(String sql, Object[] params) throws SQLException {
        return false;
    }

    /**
     * 删除
     */
    public boolean deleteQuery(String sql, Object[] params) throws SQLException {
        return false;
    }

    /**
     * 修改
     */
    public boolean updateQuery(String sql, Object[] params) throws SQLException {
        super.update(connection, sql, params);
        return true;
    }

    /**
     * 查询
     */
    public List<Book> selectQuery(String sql, Object[] params) throws SQLException {
        List<Book> books = (List<Book>) super.query(connection, sql, params, new BeanListHandler(Book.class));
        return books;
    }
}
