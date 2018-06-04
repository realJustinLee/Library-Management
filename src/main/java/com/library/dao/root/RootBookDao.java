package com.library.dao.root;

import com.library.domain.book.Book;
import java.sql.SQLException;
import java.util.List;
/**
 * @Author: lixin
 * @Date:   Created in 2018/4/16 19:02
 * @Description:
 * @Email: JustinDellAdam@live.com
 */
public interface RootBookDao {
    /**
     * 增加
     */
    boolean addQuery(String sql, Object[] params) throws SQLException;

    /**
     * 删除
     */
    boolean deleteQuery(String sql, Object[] params) throws SQLException;

    /**
     * 修改
     */
    boolean updateQuery(String sql, Object[] params) throws SQLException;

    /**
     * 查询
     */
    List<Book> selectQuery(String sql, Object[] params) throws SQLException;
}

