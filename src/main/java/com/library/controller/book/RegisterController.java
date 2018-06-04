package com.library.controller.book;

import com.alibaba.fastjson.JSON;
import com.library.service.book.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: lixin
 * @Description:
 * @Email: JustinDellAdam@live.com
 */
@Controller
public class RegisterController {
    @Autowired
    RegisterService registerService;

    @RequestMapping(value = "/api/register", produces = "text/html;charset=UTF-8;")
    @ResponseBody
    public String register(@RequestParam(value = "username", defaultValue = "null") String name,
                           @RequestParam(value = "nickname", defaultValue = "null") String nickname,
                           @RequestParam(value = "password", defaultValue = "null") String password,
                           @RequestParam(value = "number", defaultValue = "null") String number,
                           @RequestParam(value = "email", defaultValue = "null") String email) {


        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        Map<String, String> map = new HashMap<String, String>(1);
        //插入参数
        Object[] params = new Object[]{name, nickname, email, number, password, "user", "true"};
        //执行业务
        boolean registerSuccess = registerService.register(params);
        //组装json格式数据
        map.put("registerSuccess", String.valueOf(registerSuccess));
        list.add(map);
        return JSON.toJSONString(list);
    }
}
