package com.library.controller.root;

import com.alibaba.fastjson.JSON;
import com.library.domain.book.Book;
import com.library.service.root.RootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.sql.SQLException;
import java.util.List;

/**
 * @author lixin
 * @Description:
 */

@Controller
@RequestMapping(value = "/root/api", produces = "text/html;charset=UTF-8;")
public class SelectAllBookInfoController {
    @Autowired
    RootService rootService;
    /**
     * 请求所有书籍信息
     */
    @RequestMapping("/selectAllBooksInfo")
    @ResponseBody
    public String selectAllBook() {
        List<Book> books = null;
        try {
            books = rootService.rootSelectAllBooks();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return JSON.toJSONString(books);
    }
}
