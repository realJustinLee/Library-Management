package com.library.dao.book.impl;

import com.library.dao.book.ContactDao;
import com.library.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.SQLException;

@Repository
public class ContactDaoImpl extends QueryRunner implements ContactDao {
    Connection connection = null;

    // 获取数据库连接
    public ContactDaoImpl(){
        try {
            connection = JdbcUtils.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 增加信息
     */
    public void addQuery(String sql, Object[] params) throws SQLException {
        super.update(connection, sql, params);
//        connection.close();
    }
}
