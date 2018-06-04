package com.library.controller.book;

import com.alibaba.fastjson.JSON;
import com.library.service.book.BorrowBookService;
import com.library.utils.OrderNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: lixin
 * @Description:
 * @Email: JustinDellAdam@live.com
 */
@Controller
@RequestMapping(value = "/book/api", produces = "text/html;charset=UTF-8;")
public class BorrowWokeController {
    @Autowired
    BorrowBookService borrowBookService;

    /**
     * 获取用户已借书籍
     */
    @RequestMapping("/getUserBorrowBooks")
    @ResponseBody
    public String getUserBorrowBooks(@RequestParam(value = "id", defaultValue = "null") int id) {
        Object[] params = new Object[]{id};
        List result = null;
        try {
            result = borrowBookService.getUserBorrowBooks(params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return JSON.toJSONString(result);
    }

    /**
     * 还书
     */
    @RequestMapping("/returnBook")
    @ResponseBody
    public String returnBook(@RequestParam(value = "userId", defaultValue = "null") int userId,
                             @RequestParam(value = "bookId", defaultValue = "null") int bookId) {
        //获取当前时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formatTime = sdf.format(new Date());
        Object[] borrowParams = new Object[]{formatTime, bookId, userId};
        Object[] bookParams = new Object[]{bookId};
        Map<String, String> map = new HashMap<String, String>();
        try {
            boolean returnBookSuccess = borrowBookService.returnBook(bookParams, borrowParams);
            map.put("returnBookSuccess", String.valueOf(returnBookSuccess));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return JSON.toJSONString(map);
    }

    /**
     * 借书
     */
    @RequestMapping("/borrowBook")
    @ResponseBody
    public String borrowBook(@RequestParam(value = "userId", defaultValue = "null") int userId,
                             @RequestParam(value = "bookId", defaultValue = "null") int bookId) {
        //获取当前时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String startTime = sdf.format(new Date());
        //获取15天后的时间
        OrderNumber orderNumber = new OrderNumber();
        String endTime = sdf.format(orderNumber.getNextDay(new Date(), 4));
        //获取业务流水号:223为借书业务号
        String order = orderNumber.getOrderNum("223");
        //设置参数
        Object[] borrowParams = new Object[]{bookId, userId, startTime, endTime, "", "false"};
        Object[] bookParams = new Object[]{bookId};
        Object[] orderParams = new Object[]{userId,bookId,order,startTime};
        Map<String, String> map = new HashMap<String, String>();

        try {
            boolean borrowBookSuccess = borrowBookService.borrowBook(bookParams, borrowParams,orderParams);
            map.put("borrowBookSuccess", String.valueOf(borrowBookSuccess));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return JSON.toJSONString(map);
    }
}
