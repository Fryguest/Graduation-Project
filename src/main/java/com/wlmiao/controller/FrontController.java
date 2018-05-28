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

    @RequestMapping("/uploadTrainPlanFront")
    public String uploadTrainPlan(Model model) {
        model.addAttribute("taskType", FrontConstant.UPLOAD_TRAIN_PLAN);
        return "upload_train_plan";
    }

    @RequestMapping("/downloadStudentFront")
    public String downloadStudent(Model model) {
        model.addAttribute("taskType", FrontConstant.DOWNLOAD_STUDENT_LIST);
        return "download_student";
    }

    @RequestMapping("/professionalDiversionFront")
    public String professionalDiversion(Model model) {
        model.addAttribute("taskType", FrontConstant.PROFESSIONAL_DIVERSION);
        return "professional_diversion";
    }

    @RequestMapping("/success")
    public String success(Model model) {
        return "success";
    }

    @RequestMapping("/fail")
    public String fail(Model model) {
        return "fail";
    }
}
