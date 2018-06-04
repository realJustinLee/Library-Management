package com.library.controller.root;

import com.alibaba.fastjson.JSON;
import com.library.service.root.RootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lixin
 * @Description:
 */
@Controller
public class UpdateBookController {

    @Autowired
    RootService rootService;

    @RequestMapping(value = "/root/api/updateBook")
    @ResponseBody
    public String addBook(@RequestParam("classes") String classes,
                          @RequestParam("id") String id,
                          @RequestParam("name") String name,
                          @RequestParam("author") String author,
                          @RequestParam("all_num") String bookNum){
        Object[] params = new Object[]{classes,name,author,bookNum,id};
        Map<String,String> map = new HashMap<String, String>();
        boolean updateSuccess = false;
        try {
          updateSuccess =  rootService.updateBookInfo(params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        map.put("updateSuccess", String.valueOf(updateSuccess));
        return JSON.toJSONString(map);
    }
}
