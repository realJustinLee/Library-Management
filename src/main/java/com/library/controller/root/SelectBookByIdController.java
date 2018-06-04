package com.library.controller.root;

import com.alibaba.fastjson.JSON;
import com.library.domain.book.Book;
import com.library.service.root.RootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;
import java.util.List;
/**
 * @author lixin
 * @Description:
 */
@Controller
public class SelectBookByIdController {
    @Autowired
    RootService rootService;

    /**
     * 通过id查询书籍
     */
    @RequestMapping(value = "/root/api/searchBookById", produces = "text/html;charset=UTF-8;")
    @ResponseBody
    public String selectKeyWordBook(@RequestParam(value = "id", defaultValue = "null") String id) {
        Object[] params = new Object[]{id};
        List<Book> books = null;
        try {
            books = rootService.searchIdBook(params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return JSON.toJSONString(books);
    }
}
