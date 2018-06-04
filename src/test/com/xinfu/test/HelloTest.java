package com.xinfu.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: xinfu
 * @Description:
 * @Date: Created in 2017/12/14
 * @Email: linxinfu2018@qq.com
 */

@Controller
public class HelloTest {
    /**测试用例*/
    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello(){
        return "Welcome to Libarary!";
    }

    @RequestMapping("/helloUser")
    @ResponseBody
    public String user(){
        return "Welcome User!";
    }

    @RequestMapping("/helloAdmin")
    @ResponseBody
    public String admin(){
        return "Welcome Admin!";
    }
}
