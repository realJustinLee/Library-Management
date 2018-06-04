package com.library.controller.book;

import com.alibaba.fastjson.JSON;
import com.library.service.book.UserWokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.sql.SQLException;
import java.util.List;


/**
 * @author lixin
 */
@Controller
@RequestMapping(value = "/book/api", produces = "text/html;charset=UTF-8;")
public class UserWokeController {

    @Autowired
    UserWokeService userWokeService;
    /**
     * 根据id查询用户姓名、上次登录以及已借书籍数目
     */
    @RequestMapping("/loginedUserInfo")
    @ResponseBody
    public String getLoginInfo(@RequestParam(value = "id",defaultValue = "null") int id){
        Object[] params = new Object[]{id};
        List list = null;
        try {
            list = userWokeService.userLoginedInfo(params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return JSON.toJSONString(list);
    }
}
