package com.library.controller.book;

import com.alibaba.fastjson.JSON;
import com.library.domain.book.Book;
import com.library.service.book.impl.BookInfoServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * @Author: lixin
 * @Date: Created in 2018/4/16 19:52
 * @Description:
 * @Email: JustinDellAdam@live.com
 */
@Controller
public class HotBookController {
    @RequestMapping(value = "/book/api/hotBook", produces = "text/html;charset=UTF-8;")
    @ResponseBody
    public String hotBook(@RequestParam(value = "pageIndex", defaultValue = "1") int pageIndex) {
        //一页数据条数
        int pageSize = 4;
        // 查询数据库开始下标
        int beginIndex = (pageIndex - 1) * pageSize;
        // 查询数据库条数
        int selectNum = pageIndex == 3 ? 2 : 4;
        Object[] params = new Object[]{beginIndex, selectNum};
        //执行业务
        List<Book> books = new ArrayList<Book>();
        BookInfoServiceImpl bookInfoServiceImpl = new BookInfoServiceImpl();
        try {
            books=bookInfoServiceImpl.selectTop10Book(params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return JSON.toJSONString(books);
    }
}
