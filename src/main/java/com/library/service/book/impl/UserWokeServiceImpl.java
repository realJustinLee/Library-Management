package com.library.service.book.impl;

import com.library.dao.book.BorrowDao;
import com.library.dao.book.UserDao;
import com.library.domain.book.User;
import com.library.service.book.UserWokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserWokeServiceImpl implements UserWokeService {
    @Autowired
    UserDao userDao;

    @Autowired
    BorrowDao borrowDao;

    String sql;

    /**
     * 查询判断是否能登陆
     */
    public User isLogin(Object[] params) throws SQLException {
        sql = "select * from tbl_user where number =? and password = ?";
        User user = userDao.selectQuery(sql, params);
        return user;
    }

    /**
     * 根据id查询个人信息
     */
    public Map<String, String> userInfo(Object[] params) throws SQLException {
        sql = "select * from tbl_user where id = ?";
        User user = userDao.selectQuery(sql, params);
        if (user == null) {
            return null;
        }
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", user.getName());
        map.put("nickname", user.getNickname());
        map.put("email", user.getEmail());
        map.put("phone", user.getNumber());
        map.put("role", user.getRole());
        return map;
    }

    /**
     * 修改个人信息
     */
    public boolean updateUserInfo(Object[] params) throws SQLException {
        sql = "update tbl_user set name = ? ,nickname = ?,email = ?,number = ?,password = md5(?) where id = ?";
        boolean isSuccess = userDao.updateQuery(sql, params);
        return isSuccess;
    }

    /**
     * 根据id查询用户姓名、上次登录以及已借书籍数目
     */
    public List userLoginedInfo(Object[] params) throws SQLException {
        sql = "select tbl_user.nickname name,tbl_user.recently_login lastLogin from tbl_user where id = ?";
        List list1 = userDao.selectUser(sql, params);
        sql = "select count(*) num from tbl_borrow WHERE user_id = ? and borrow_is_return = 'false'";
        List list2 = borrowDao.selectQueryInfo(sql, params);
        list1.add(list2.get(0));
        return list1;
    }
}
