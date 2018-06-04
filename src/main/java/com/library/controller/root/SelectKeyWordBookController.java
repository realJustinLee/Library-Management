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
 * @Description: 模糊查询
 */
@Controller
public class SelectKeyWordBookController {
    @Autowired
    RootService rootService;

    /**
     * 模糊查询书籍
     */
    @RequestMapping(value = "/root/api/searchBookByKeyWord", produces = "text/html;charset=UTF-8;")
    @ResponseBody
    public String selectKeyWordBook(@RequestParam(value = "name", defaultValue = "null") String name) {
        name = "%"+name+"%";
        Object[] params = new Object[]{name};
        List<Book> books = null;
        try {
            books = rootService.searchBook(params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return JSON.toJSONString(books);
    }
}
