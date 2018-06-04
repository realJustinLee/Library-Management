package com.library.dao.book.impl;

import com.library.dao.book.UserDao;
import com.library.domain.book.User;
import com.library.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDaoImpl extends QueryRunner implements UserDao {
    Connection connection = null;

    /**
     * 获取数据库连接
     */
    public UserDaoImpl() {
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
            //如果异常则增加失败
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
     * 查询
     */
    public User selectQuery(String sql, Object[] params) throws SQLException {
        User user = (User) super.query(connection, sql, params, new BeanHandler(User.class));
        return user;
    }

    /**
     * 多表查询用户信息
     */
    public List selectUser(String sql, Object[] params) throws SQLException {
        List list = (List) super.query(connection, sql, params, new MapListHandler());
        return list;
    }

    /**
     * 修改
     */
    public boolean updateQuery(String sql, Object[] params) {
        boolean isSuccess = false;
        try {
            super.update(connection, sql, params);
            isSuccess = true;
        } catch (SQLException e) {
            e.printStackTrace();
            isSuccess = false;
        }
        return isSuccess;
    }

}
