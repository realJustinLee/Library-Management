package com.library.controller.book;

import com.alibaba.fastjson.JSON;
import com.library.service.book.UserWokeService;
import com.library.service.book.impl.UserWokeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: lixin
 * @Description: myaccount.html
 * @Email: JustinDellAdam@live.com
 */
@Controller
@RequestMapping(value = "/book/api", produces = "text/html;charset=UTF-8;")
public class MyAccountController {
    @Autowired
    UserWokeService userWokeService;

    /**
     * 根据id获取用户信息
     */
    @RequestMapping("/getUserInfo")
    @ResponseBody
    public String getUserInfo(@RequestParam(value = "id", defaultValue = "null") int id) {
        Object[] params = new Object[]{id};
        Map<String, String> map = new HashMap<String, String>();
        try {
            map = userWokeService.userInfo(params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return JSON.toJSONString(map);
    }

    /**
     * 修改用户信息
     */
    @RequestMapping("/updateUserInfo")
    @ResponseBody
    public String updateUserInfo(@RequestParam(value = "id", defaultValue = "null") int id,
                                 @RequestParam(value = "name", defaultValue = "null") String name,
                                 @RequestParam(value = "nickname", defaultValue = "null") String nickname,
                                 @RequestParam(value = "email", defaultValue = "null") String email,
                                 @RequestParam(value = "number", defaultValue = "null") String number,
                                 @RequestParam(value = "password", defaultValue = "null") String password) {
        Object[] params = new Object[]{name, nickname, email, number, password, id};
        boolean isSuccess = false;
        Map<String, String> map = new HashMap<String, String>();
        try {
            isSuccess = userWokeService.updateUserInfo(params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        map.put("isSuccess", String.valueOf(isSuccess));
        return JSON.toJSONString(map);
    }
}
