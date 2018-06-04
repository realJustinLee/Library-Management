package com.library.dao.root;

import com.library.domain.book.User;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author: lixin
 * @Date:   Created in 2018/4/16 19:02
 * @Description:
 * @Email: JustinDellAdam@live.com
 */
public interface RootUserDao {
    /**
     * 查询用户
     */
    List<User> selecetUser(String sql, Object[] params) throws SQLException;

    /**
     * 修改用户信息
     */
    boolean updateUser(String sql, Object[] params) throws SQLException;
}
