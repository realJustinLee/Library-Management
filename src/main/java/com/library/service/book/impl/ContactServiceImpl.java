package com.library.service.book.impl;

import com.library.dao.book.ContactDao;
import com.library.service.book.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    ContactDao contactDao;

    /**
     * 增加联系我们信息
     */
    public void addMessage(Object[] params) throws SQLException {
        String sql = "insert into tbl_contact(contact_name,contact_email,contact_phone,contact_message,contact_time) values(?,?,?,?,?)";

        //传入参数
        contactDao.addQuery(sql, params);
    }
}
