package com.xinfu.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * @Author: linxinfu
 * @Date: 2018/1/3 12:53
 * @Description:
 * @Email: linxinfu2018@qq.com
 */

@Controller
public class GetJsonTest {
    /**
     * @param id
     * @Description: 学生的id
     */
    @RequestMapping(value = "/getInfo",produces = "text/html;charset=UTF-8",method= RequestMethod.GET)
    @ResponseBody
    public String getJson(@RequestParam(value = "id",defaultValue="1") String id){
        return "{\"name\": \"李明\",\"id\": \"14121896\",\"role\": \"user\",\"term\": \"2017冬\",\"class\": [ {\"classId\": \"2345\",\"className\": \"数据结构\" }, {\"classId\": \"2344\",\"className\": \"离散数学\" }, {\"classId\": \"2233\",\"className\": \"操作系统\" }] }";
    }
}
