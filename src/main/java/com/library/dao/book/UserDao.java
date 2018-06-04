package com.library.dao.book;

import com.library.domain.book.User;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author: lixin
 * @Date:   Created in 2018/4/16 19:02
 * @Description:
 * @Email: JustinDellAdam@live.com
 */
public interface UserDao {
    /**
     * 增加
     */
    boolean addQuery(String sql, Object[] params) throws SQLException;

    /**
     * 查询
     */
    User selectQuery(String sql, Object[] params) throws SQLException;

    /**
     * 多表查询用户信息
     */
    List selectUser(String sql, Object[] params) throws SQLException;

    /**
     * 修改
     */
    boolean updateQuery(String sql, Object[] params) throws SQLException;

    /**
     * 删除
     */
    boolean deleteQuery(String sql, Object[] params) throws SQLException;
}
