package com.library.controller.root;

import com.alibaba.fastjson.JSON;
import com.library.domain.book.User;
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
@RequestMapping(value = "/root/api", produces = "text/html;charset=utf-8;")
public class RootUserWokeController {
    @Autowired
    RootService rootService;

    /**
     * 查询所有用户
     */
    @RequestMapping("/selectAllUser")
    @ResponseBody
    public String selectAllUser() {
        List<User> users = null;
        try {
            users = rootService.selectAllUser();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return JSON.toJSONString(users);
    }

    /**
     * 根据id查询用户
     */
    @RequestMapping("/selectUserById")
    @ResponseBody
    public String selectUserById(@RequestParam(value = "id", defaultValue = "null") String id) {
        List<User> users = null;
        Object[] params = new Object[]{id};
        try {
            users = rootService.selectUserById(params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return JSON.toJSONString(users);
    }

}
