package com.library.controller.common;

import com.alibaba.fastjson.JSON;
import com.library.service.common.LoginService;
import com.library.utils.MyMD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author lixin
 */
@Controller
public class LoginController {
    @Autowired
    LoginService loginService;

    /**
     * 验证登录
     *
     * @param username 用户名
     * @param password 密码
     * @return 是否登录成功、个人信息、编码
     */
    @RequestMapping("/api/login")
    @ResponseBody
    public String login(@RequestParam(value = "username", defaultValue = "") String username,
                        @RequestParam(value = "password", defaultValue = "") String password) {
        //加密后的密码
        String md5Password = MyMD5.md5(password);
        Object[] params = new Object[]{username, md5Password};
        List result = null;
        //获取当前时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formatTime = sdf.format(new Date());
        try {
            result = loginService.login(params);
            // 修改上次登录时间
            if (result != null) {
                Object[] changeTimeParams = new Object[]{formatTime, username};
                loginService.changeLastLoginTime(changeTimeParams);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return JSON.toJSONString(result);
    }
}
