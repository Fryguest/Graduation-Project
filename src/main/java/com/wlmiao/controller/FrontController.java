package com.wlmiao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by xinxin.chen on 2018.1.6.
 */
@Controller
public class FrontController {

    @RequestMapping({"/", "/index"})
    public String index() {
        return "index";
    }

    @RequestMapping("/teacherEndPoint")
    public String teacherEndPoint(Model model){
        return "teacher_end_point";
    }

    @RequestMapping("/studentEndPoint")
    public String studentEndPoint(Model model){
        model.addAttribute("taskType", 10000);
        return "student_end_point";
    }
    @RequestMapping("/courseChosen")
    public String courseChosen(Model model){
        model.addAttribute("taskType", 10000);
        return "course_chosen";
    }
}
