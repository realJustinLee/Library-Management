package com.library.service.book;

import com.library.domain.book.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @Author: lixin
 * @Date:   Created in 2018/4/16 19:02
 * @Description:
 * @Email: JustinDellAdam@live.com
 */
public interface UserWokeService {
    /**
     * 判断是否能登陆
     */
    User isLogin(Object[] params) throws SQLException;

    /**
     * 根据id查询个人信息
     */
    Map<String, String> userInfo(Object[] params) throws SQLException;

    /**
     * 修改个人信息
     */
    boolean updateUserInfo(Object[] params) throws SQLException;

    /**
     * 根据id查询用户姓名、上次登录以及已借书籍数目
     */
    List userLoginedInfo(Object[] params) throws SQLException;
}
