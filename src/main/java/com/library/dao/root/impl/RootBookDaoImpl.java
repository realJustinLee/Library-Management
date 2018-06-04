package com.library.dao.root.impl;

import com.library.dao.root.RootBookDao;
import com.library.domain.book.Book;
import com.library.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Repository
public class RootBookDaoImpl extends QueryRunner implements RootBookDao {
    Connection connection = null;

    /**
     * 从数据库连接池获取连接
     */
    public RootBookDaoImpl() {
        try {
            connection = JdbcUtils.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 增加
     */
    public boolean addQuery(String sql, Object[] params){
        boolean addSuccess = true;
        try {
            super.update(connection,sql,params);
        } catch (SQLException e) {
            addSuccess = false;
            e.printStackTrace();
        }
        return addSuccess;
    }

    /**
     * 删除
     */
    public boolean deleteQuery(String sql, Object[] params){
        boolean deleteSuccess = true;
        try {
            super.update(connection,sql,params);
        } catch (SQLException e) {
            deleteSuccess = false;
            e.printStackTrace();
        }
        return deleteSuccess;
    }

    /**
     * 更新
     */
    public boolean updateQuery(String sql, Object[] params){
        boolean updateSuccess = true;
        try {
            super.update(connection,sql,params);
        } catch (SQLException e) {
            updateSuccess = false;
            e.printStackTrace();
        }
        return updateSuccess;
    }

    /**
     * 查询
     */
    public List<Book> selectQuery(String sql, Object[] params) throws SQLException {
        List<Book> books = (List<Book>) super.query(connection, sql, params, new BeanListHandler(Book.class));
        return books;
    }
}
