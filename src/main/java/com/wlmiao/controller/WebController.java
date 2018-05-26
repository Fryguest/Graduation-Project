package com.wlmiao.controller;

import com.wlmiao.exception.EduSysException;
import com.wlmiao.service.IManagerService;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebController {

    private Logger logger = LoggerFactory.getLogger(getClass());

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
    public String importStudent(
        @RequestParam("student_list") String studentList,
        @RequestParam("class_student_number") Integer classStudentNumber,
        @RequestParam("grade") String grade,
        HttpServletResponse response) {
        logger.info("get request to importStudent, studentList = {}, class_student_number={}, grade = {}", studentList,
            classStudentNumber, grade);
        try {
            managerService.importStudentAndDivision(studentList, classStudentNumber, grade, response);
            return "success";
        } catch (EduSysException e) {
            return "fail";
        }
    }

}
