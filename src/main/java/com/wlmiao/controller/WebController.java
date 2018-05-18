package com.wlmiao.controller;

import static com.wlmiao.util.XlsxUtil.readFromXls;

import com.wlmiao.service.IManagerService;
import com.wlmiao.util.XlsxUtil;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebController {

    @Autowired
    private IManagerService managerService;


    @RequestMapping("/ping")
    @ResponseBody
    public String hello() {
        return "hello world";
    }

    /**
     * 导入新生
     */
    @RequestMapping("/importStudent")
    @ResponseBody
    public String importStudent(@RequestParam("student_list")String studentList, @RequestParam("class_number")Integer classNumber) throws Exception{
        System.out.println(studentList);
        List<HashMap<String ,String>> list = XlsxUtil.readFromXls(studentList);

        return "success";
    }
}
