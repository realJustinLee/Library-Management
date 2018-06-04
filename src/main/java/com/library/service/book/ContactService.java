package com.library.service.book;

import java.sql.SQLException;

/**
 * @Author: lixin
 * @Date:   Created in 2018/4/16 19:02
 * @Description:
 * @Email: JustinDellAdam@live.com
 */
public interface ContactService {
    /**
     * 增加联系我们信息
     */
    void addMessage(Object[] params) throws SQLException;
}
