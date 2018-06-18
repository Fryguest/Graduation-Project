package com.wlmiao.controller;

import com.wlmiao.constant.FrontConstant;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping({"/forbiddenFront"})
    public String forbidden() {
        return "forbidden";
    }

    @RequestMapping("/managerimportStudentFront")
    public String importStudentFront(Model model) {
        model.addAttribute("taskType", FrontConstant.IMPORT_STUDENT);
        return "import_student";
    }

    @RequestMapping("/manageruploadTrainPlanFront")
    public String manageruploadTrainPlanFront(Model model) {
        model.addAttribute("taskType", FrontConstant.UPLOAD_TRAIN_PLAN);
        return "upload_train_plan";
    }

    @RequestMapping("/manageruploadCourseInformationFront")
    public String manageruploadCourseInformationFront(Model model) {
        model.addAttribute("taskType", FrontConstant.UPLOAD_COURSE_INFORMATION);
        return "upload_course_information";
    }

    @RequestMapping("/managerdownloadStudentFront")
    public String managerdownloadStudentFront(Model model) {
        model.addAttribute("taskType", FrontConstant.DOWNLOAD_STUDENT_LIST);
        return "download_student";
    }

    @RequestMapping("/managerdownloadTeacherFront")
    public String managerdownloadTeacherFront(Model model) {
        model.addAttribute("taskType", FrontConstant.DOWNLOAD_TEACHER_LIST);
        return "download_teacher";
    }

    @RequestMapping("/managerdownloadClassFront")
    public String downloadClass(Model model) {
        model.addAttribute("taskType", FrontConstant.DOWNLOAD_CLASS_LIST);
        return "download_class";
    }

    @RequestMapping("/managerprofessionalDiversionFront")
    public String professionalDiversion(Model model) {
        model.addAttribute("taskType", FrontConstant.PROFESSIONAL_DIVERSION);
        return "professional_diversion";
    }

    @RequestMapping("/managerdistributionTeacherFront")
    public String distributionTeacherFront(Model model) {
        model.addAttribute("taskType", FrontConstant.DISTRIBUTION_TEACHER);
        return "distribution_teacher";
    }

    @RequestMapping("/managerdownloadTrainPlanFront")
    public String downloadTrainPlanFront(Model model) {
        model.addAttribute("taskType", FrontConstant.DOWNLOAD_TRAIN_PLAN);
        return "download_train_plan";
    }

    @RequestMapping("/managerimportTeacherFront")
    public String managerimportTeacherFront(Model model){
        model.addAttribute("taskType", FrontConstant.IMPORT_TEACHER);
        return "import_teacher";
    }

    @RequestMapping("/studentcourseChosenFront")
    public String courseChosenFront(Model model) {
        model.addAttribute("taskType", FrontConstant.COURSE_CHOSEN);
        return "course_chosen";
    }

    @RequestMapping("/studentcheckGPAFront")
    public String checkGPAFront(Model model) {
        model.addAttribute("taskType", FrontConstant.CHECK_GPA);
        return "check_GPA";
    }
    @RequestMapping("/studentdownloadCourseChosenTableFront")
    public String studentdownloadCourseChosenTableFront(Model model) {
        model.addAttribute("taskType", FrontConstant.DOWNLOAD_COURSE_CHOSEN_TABLE);
        return "download_course_chosen_table";
    }
    @RequestMapping("/studentdownloadStudentTimetableFront")
    public String downloadStudentTimetableFront(Model model) {
        model.addAttribute("taskType", FrontConstant.DOWNLOAD_STUDENT_TIMETABLE);
        return "download_student_timetable";
    }

    @RequestMapping("/teacherdownloadCourseStudentFront")
    public String downloadCourseStudentFront(Model model) {
        model.addAttribute("taskType", FrontConstant.DOWNLOAD_COURSE_STUDENT);
        return "download_course_student";
    }

    @RequestMapping("/teacheruploadCourseScoreFront")
    public String uploadCourseScoreFront(Model model) {
        model.addAttribute("taskType", FrontConstant.UPLOAD_COURSE_SCORE);
        return "upload_course_score";
    }

    @RequestMapping("/teacherdownloadTeacherTimetableFront")
    public String downloadTeacherTimetableFront(Model model) {
        model.addAttribute("taskType", FrontConstant.DOWNLOAD_TEACHER_TIMETABLE);
        return "download_teacher_timetable";
    }

    @RequestMapping("/studentExamRegistrationFront")
    public String studentExamRegistrationFront(Model model) {
        model.addAttribute("taskType", FrontConstant.EXAM_REGISTRATION);
        return "exam_registration";
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
