package com.xinfu.test;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/test", produces = "text/html;charset=UTF-8;")
public class TestController {
    @ResponseBody
    public String test(){
        String str = "[{\"all_num\": 12,\"author\": \"张爱玲\", \"classes\": \"科学\", \"id\": 9555, \"name\": \"中药资源教育\", \"pub\": \"中央编译出版社\", \"remain_num\": 0 }, { \"all_num\": 13, \"author\": \"郑艳\", \"classes\": \"文学\", \"id\": 9556, \"name\": \"少年维特之烦恼\", \"pub\": \"高等教育出版社\", \"remain_num\": 0 }, { \"all_num\": 18, \"author\": \"吴忠超\", \"classes\": \"科学\", \"id\": 9557, \"name\": \"时间简史\", \"pub\": \"牛津大学出版社\", \"remain_num\": 0 }]";
        return JSON.toJSONString(str);
    }
}
