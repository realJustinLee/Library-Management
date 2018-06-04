package com.library.service.common;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author: lixin
 * @Date:   Created in 2018/4/16 19:02
 * @Description:
 * @Email: JustinDellAdam@live.com
 */
public interface LoginService {
    /**
     * 登陆验证
     */
    List login(Object[] params) throws SQLException;

    /**
     * 修改上次登录时间
     */
    boolean changeLastLoginTime(Object[] params) throws SQLException;
}
