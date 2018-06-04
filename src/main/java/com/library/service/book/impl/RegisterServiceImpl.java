package com.library.service.book.impl;

import com.library.dao.book.UserDao;
import com.library.service.book.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    UserDao userDao;

    /**
     * 注册业务
     */
    public boolean register(Object[] params) {
        String sql = "insert into tbl_user(name,nickname,email,number,password,role,is_borrow) values(?,?,?,?,md5(?),?,?)";
        boolean registerSuccess = false;
        try {
            registerSuccess = userDao.addQuery(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registerSuccess;
    }
}
