package com.library.dao.root.impl;

import com.library.dao.root.RootUserDao;
import com.library.domain.book.User;
import com.library.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Repository
public class RootUserDaoImpl extends QueryRunner implements RootUserDao {
    Connection connection = null;
    List<User> users;

    /**
     * 获取连接
     */
    public RootUserDaoImpl() {
        try {
            connection = JdbcUtils.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询所有用户
     */
    public List<User> selecetUser(String sql, Object[] params) throws SQLException {
        users = (List<User>) super.query(connection, sql, params, new BeanListHandler(User.class));
        return users;
    }

    /**
     * 根据id查询用户
     */
    public boolean updateUser(String sql, Object[] params) throws SQLException {
        return false;
    }
}
