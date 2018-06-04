package com.library.dao.book.impl;

import com.library.dao.book.BookDao;
import com.library.dao.book.BorrowDao;
import com.library.domain.book.Borrow;
import com.library.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BorrowDaoImpl extends QueryRunner implements BorrowDao {
    @Autowired
    BookDao bookDao;
    public Connection connection = null;

    /**
     * 获取链接
     */
    public BorrowDaoImpl() {
        try {
            connection = JdbcUtils.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 增加
     */
    public boolean addQuery(String sql, Object[] params) {
        boolean addSuccess = true;
        try {
            super.update(connection, sql, params);
        } catch (SQLException e) {
            addSuccess = false;
            e.printStackTrace();
        }
        return addSuccess;
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
        boolean updateSuccesss = true;
        try {
            super.update(connection, sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
            updateSuccesss = false;
        }
        return updateSuccesss;
    }

    /**
     * 查询
     */
    public List<Borrow> selectQuery(String sql, Object[] params) throws SQLException {
        return null;
    }

    /**
     * 根据id查询用户已借书籍信息
     */
    public List selectQueryInfo(String sql, Object[] params) throws SQLException {
        List list = (List) super.query(connection, sql, params, new MapListHandler());
        return list;
    }
}
