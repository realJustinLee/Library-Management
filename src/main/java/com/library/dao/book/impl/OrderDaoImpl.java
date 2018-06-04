package com.library.dao.book.impl;

import com.library.dao.book.OrderDao;
import com.library.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.SQLException;

@Repository
public class OrderDaoImpl extends QueryRunner implements OrderDao {

    Connection connection = null;

    //获取连接
    public OrderDaoImpl() {
        try {
            connection = JdbcUtils.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 增加流水号
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
}
