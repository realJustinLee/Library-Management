package com.library.controller.root;

import com.alibaba.fastjson.JSON;
import com.library.service.root.RootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lixin
 * @Description: 增加书籍
 */
@Controller
public class AddBookController {
    @Autowired
    RootService rootService;

    @RequestMapping(value = "/root/api/addBook",method = RequestMethod.POST)
    @ResponseBody
    public String addBook(HttpServletRequest request,
                          HttpServletResponse response,
                          @RequestParam("classes") String classes,
                          @RequestParam("bookname") String bookName,
                          @RequestParam("author") String author,
                          @RequestParam("publicationInfo") String publicationInfo,
                          @RequestParam("bookNum") String bookNum,
                          @RequestParam("description") String description,
                          @RequestParam("file") MultipartFile file) throws IOException, SQLException {
        String imgPath = "/statics/images/upload/";
        boolean addSuccess = false;
        //如果文件不为空，写入上传路径
        if(!file.isEmpty()) {
            //上传文件路径
            String path = "/Users/lixin/Downloads/upload";
            //上传文件名
            String filename = file.getOriginalFilename();
            imgPath += filename;
            File filepath = new File(path,filename);
            //判断路径是否存在，如果不存在就创建一个
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }
            //将上传文件保存到一个目标文件当中
            file.transferTo(new File(path + File.separator + filename));
            Object[] params = new Object[]{bookName,author,publicationInfo,classes,bookNum,bookNum,description,imgPath,0};
            addSuccess = rootService.addBookInformation(params);
            response.sendRedirect("/root/manage");
            return "success";
        } else {
            addSuccess = false;
        }
        Map<String,String> map = new HashMap<String, String>();
        map.put("addSuccess", String.valueOf(addSuccess));
        response.sendRedirect("/root/manage");
        return JSON.toJSONString(map);
    }
}
