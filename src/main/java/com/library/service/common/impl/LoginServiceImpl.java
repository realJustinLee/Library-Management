package com.library.service.common.impl;

import com.library.dao.book.UserDao;
import com.library.domain.book.User;
import com.library.service.common.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: lixin
 * @Date:   Created in 2018/4/16 19:02
 * @Description:
 * @Email: JustinDellAdam@live.com
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    UserDao userDao;

    /**
     * 验证登陆
     */
    public List login(Object[] params) throws SQLException {
        //sql语句
        String sql = "select * from tbl_user where name = ? and password = ?";
        User user = userDao.selectQuery(sql, params);
        //如果返回的用户信息为空
        if (user == null) {
            return null;
        }
        Map<String, String> map = new HashMap<String, String>();
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        //组装传给前台的相关数据格式
        map.put("userId", String.valueOf(user.getId()));
        map.put("role", user.getRole());
        list.add(map);
        return list;
    }

    /**
     * 修改上次登录时间
     */
    public boolean changeLastLoginTime(Object[] params) throws SQLException {
        String sql = "update tbl_user set recently_login = ? where id =?";
        return userDao.updateQuery(sql,params);
    }
}
