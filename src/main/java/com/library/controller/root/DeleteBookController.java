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
@RequestMapping(value = "/root/api", produces = "text/html;charset=UTF-8;")
public class DeleteBookController {
    @Autowired
    RootService rootService;
    /**
     * @param id 书籍id
     * @return
     */
    @RequestMapping("/deleteBook")
    @ResponseBody
    public String deleteBook(@RequestParam(value = "id", defaultValue = "null") String id) {
        Object[] params = new Object[]{id};
        boolean deleteSuccess;
        Map<String,String> map = new HashMap<String, String>();
        try {
            deleteSuccess = rootService.deleteBook(params);
            map.put("deleteSuccess", String.valueOf(deleteSuccess));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return JSON.toJSONString(map);
    }
}
