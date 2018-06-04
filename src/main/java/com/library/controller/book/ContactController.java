package com.library.controller.book;

import com.library.service.book.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: lixin
 * @Email: JustinDellAdam@live.com
 */
@Controller
public class ContactController {
    @Autowired
    ContactService contactService;

    @RequestMapping("/book/api/contact")
    @ResponseBody
    public void contact(@RequestParam(value = "name", defaultValue = "null") String name,
                        @RequestParam(value = "email", defaultValue = "null") String email,
                        @RequestParam(value = "phone", defaultValue = "null") String phone,
                        @RequestParam(value = "message", defaultValue = "null") String message) {
        //获取当前时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formatTime = sdf.format(new Date());
        //整合参数
        Object[] params = new Object[]{name, email, phone, message, formatTime};
        //执行业务
        try {
            contactService.addMessage(params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
