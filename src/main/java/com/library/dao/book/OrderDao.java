package com.library.dao.book;

import java.sql.SQLException;
/**
 * @Author: lixin
 * @Date:   Created in 2018/4/16 19:02
 * @Description:
 * @Email: JustinDellAdam@live.com
 */
public interface OrderDao {
    /**
     * 增加
     */
    boolean addQuery(String sql, Object[] params) throws SQLException;
}
