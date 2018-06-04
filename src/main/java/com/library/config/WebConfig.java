package com.library.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * @Author: lixin
 * @Description:
 * @Date: Created in 2018/4/16 19:52
 * @Email: JustinDellAdam@live.com
 */

@Controller
public class WebConfig {
    /**配置登录页面*/
    @RequestMapping("/login")
    public String login(){
        return "/common/login";
    }

    /**测试数据对接*/
    @RequestMapping("/getJson")
    public String getJson(){
        return "/test/getJson";
    }

    /**配置首页为登录页面*/
    @RequestMapping("/")
    public String main(){
        return "/common/login";
    }

    /**管理员界面*/
    @RequestMapping("/root/manage")
    public String root(){
        return "/root/manage";
    }

    /**首页*/
    @RequestMapping("/book/index")
    public String book(){
        return "/book/main";
    }

    /**所有书籍*/
    @RequestMapping("/book/books")
    public String books(){
        return "/book/books";
    }

    /**最热书籍*/
    @RequestMapping("/book/hot")
    public String hot(){
        return "/book/hot";
    }

    /**书籍详情*/
    @RequestMapping("/book/details")
    public String details(){
        return "/book/details";
    }

    /**我的账号*/
    @RequestMapping("/book/account")
    public String account(){
        return "/book/myaccount";
    }

    /**我的书籍*/
    @RequestMapping("/book/borrow")
    public String myBorrow(){
        return "/book/my_borrow";
    }

    /**注册*/
    @RequestMapping("/register")
    public String register(){
        return "/book/register";
    }

    /**联系我们*/
    @RequestMapping("/book/contact")
    public String contact(){
        return "/book/contact";
    }

    /**配置权限错误403页面*/
    @RequestMapping("/forbidden")
    public String forbidden(){
        return "common/forbidden";
    }

    /**配置错误页面,注意：一定要放在最后*/
    @RequestMapping("/book/*")
    public String bookPageError(){
        return "common/page_error";
    }
    /**配置错误页面,注意：一定要放在最后*/
    @RequestMapping("/*")
    public String pageError(){
        return "common/page_error";
    }

}
