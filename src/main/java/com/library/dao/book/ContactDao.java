package com.library.dao.book;

import java.sql.SQLException;

/**
 * @Author: lixin
 * @Date:   Created in 2018/4/16 19:02
 * @Description:
 * @Email: JustinDellAdam@live.com
 */
public interface ContactDao {
    /**
     * 增加信息
     */
    void addQuery(String sql, Object[] params) throws SQLException;
}