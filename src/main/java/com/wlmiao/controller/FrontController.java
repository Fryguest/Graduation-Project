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

    @RequestMapping("/downloadClassFront")
    public String downloadClass(Model model) {
        model.addAttribute("taskType", FrontConstant.DOWNLOAD_CLASS_LIST);
        return "download_class";
    }

    @RequestMapping("/professionalDiversionFront")
    public String professionalDiversion(Model model) {
        model.addAttribute("taskType", FrontConstant.PROFESSIONAL_DIVERSION);
        return "professional_diversion";
    }

    @RequestMapping("/distributionTeacherFront")
    public String distributionTeacherFront(Model model) {
        model.addAttribute("taskType", FrontConstant.DISTRIBUTION_TEACHER);
        return "distribution_teacher";
    }

    @RequestMapping("/courseChosenFront")
    public String courseChosenFront(Model model) {
        model.addAttribute("taskType", FrontConstant.COURSE_CHOSEN);
        return "course_chosen";
    }

    @RequestMapping("/checkGPAFront")
    public String checkGPAFront(Model model) {
        model.addAttribute("taskType", FrontConstant.CHECK_GPA);
        return "check_GPA";
    }

    @RequestMapping("/downloadStudentTimetableFront")
    public String downloadStudentTimetableFront(Model model) {
        model.addAttribute("taskType", FrontConstant.DOWNLOAD_STUDENT_TIMETABLE);
        return "download_student_timetable";
    }

    @RequestMapping("/downloadCourseStudentFront")
    public String downloadCourseStudentFront(Model model) {
        model.addAttribute("taskType", FrontConstant.DOWNLOAD_COURSE_STUDENT);
        return "download_course_student";
    }

    @RequestMapping("/uploadCourseScoreFront")
    public String uploadCourseScoreFront(Model model) {
        model.addAttribute("taskType", FrontConstant.UPLOAD_COURSE_SCORE);
        return "upload_course_score";
    }

    @RequestMapping("/downloadTeacherTimetableFront")
    public String downloadTeacherTimetableFront(Model model) {
        model.addAttribute("taskType", FrontConstant.DOWNLOAD_TEACHER_TIMETABLE);
        return "download_teacher_timetable";
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
