package com.wlmiao.controller;

import com.wlmiao.constant.FrontConstant;
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

    @RequestMapping("/courseChosenFront")
    public String courseChosen(Model model){
        model.addAttribute("taskType", FrontConstant.COURSE_CHOSEN);
        return "course_chosen";
    }

    @RequestMapping("/importStudentFront")
    public String importStudentFront(Model model) {
        model.addAttribute("taskType", FrontConstant.IMPORT_STUDENT);
        return "import_student";
    }
}
