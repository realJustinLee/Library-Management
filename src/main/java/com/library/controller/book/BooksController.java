package com.library.controller.book;

import com.alibaba.fastjson.JSON;
import com.library.domain.book.Book;
import com.library.service.book.BookInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: lixin
 * @Description: Book.html页面的Controller
 * @Email: JustinDellAdam@live.com
 */
@Controller
@RequestMapping(value = "/book/api", produces = "text/html;charset=UTF-8;")
public class BooksController {
    @Autowired
    BookInfoService bookInfoService;

    List<Book> books = null;

    /**
     * 获取书籍数目
     */
    @RequestMapping("/bookNumber")
    @ResponseBody
    public String bookNumber() {
        Map<String, String> map = new HashMap<String, String>();
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        try {
            int dataNum = bookInfoService.bookNumber();
            map.put("dataNum", String.valueOf(dataNum));
            list.add(map);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return JSON.toJSONString(list);
    }

    /**
     * 所有书籍页面： 分页页号发生改变
     */
    @RequestMapping("/booksPageChange")
    @ResponseBody
    public String pageChange(@RequestParam(value = "pageIndex", defaultValue = "1") int pageIndex) {
        //一页数据条数
        int pageSize = 12;
        // 查询数据库开始下标
        int beginIndex = (pageIndex - 1) * pageSize;
        Object[] params = new Object[]{beginIndex, pageSize};
        //执行业务
        try {
            books = bookInfoService.selectLimitBook(params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return JSON.toJSONString(books);
    }

    /**
     * 用户模糊查询书籍
     */
    @RequestMapping("/searchBook")
    @ResponseBody
    public String vagueBook(@RequestParam(value = "name", defaultValue = "null") String name) {
        name = "%"+name+"%";
        Object[] params = new Object[]{name};
        try {
            books = bookInfoService.selectVagueBook(params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return JSON.toJSONString(books);
    }


    /**
     * 首页：最新的三本书
     */
    @RequestMapping("/newBooks3")
    @ResponseBody
    public String newBooks() {
        try {
            books = bookInfoService.selectNewBook();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return JSON.toJSONString(books);
    }

    /**
     * 首页：特色书籍
     */
    @RequestMapping("/specialBook")
    @ResponseBody
    public String specialBooks() {
        Object[] params = new Object[]{"科学"};
        try {
            books = bookInfoService.selectSpecialBook(params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return JSON.toJSONString(books);
    }


    /**
     * 热门作者
     */
    @RequestMapping("/topAuthor")
    @ResponseBody
    public String topAuthor() {
        try {
            books = bookInfoService.topAuthor();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return JSON.toJSONString(books);
    }

    /**
     * 根据书籍id查书籍详情
     */
    @RequestMapping("/bookDetail")
    @ResponseBody
    public String bookDetail(@RequestParam(value = "bookId", defaultValue = "null") String bookId) {
        Object[] params = new Object[]{bookId};
        List<Book> book = null;
        try {
            book = bookInfoService.selectBookDetail(params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return JSON.toJSONString(book);
    }

    /**
     * 根据书籍id查书籍详情
     */
    @RequestMapping("/relevantBook")
    @ResponseBody
    public String relevantBook(@RequestParam(value = "bookId", defaultValue = "null") String bookId) {
        Object[] params = new Object[]{bookId,bookId};
        List<Book> book = null;
        try {
            book = bookInfoService.selectSameBook(params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return JSON.toJSONString(book);
    }
}
