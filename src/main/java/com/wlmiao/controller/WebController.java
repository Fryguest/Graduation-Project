package com.wlmiao.controller;

import com.wlmiao.exception.EduSysException;
import com.wlmiao.service.IManagerService;
import java.io.IOException;
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
    public String importStudent(@RequestParam("student_list") String studentList,
        @RequestParam("class_student_number") Integer classStudentNumber, @RequestParam("grade") String grade,
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

    /**
     * 下载学生名单
     */
    @RequestMapping("/downloadStudent")
    public void downloadStudent(@RequestParam("grade") String grade, @RequestParam("major_no") String majorNo,
        HttpServletResponse response) throws IOException {
        try {
            managerService.downloadStudent(majorNo, grade, response);
        } catch (EduSysException e) {
            e.returnException(response);
        }
    }

    /**
     * 上传培养计划
     */
    @RequestMapping("/uploadTrainPlan")
    public String uploadTrainPlan(@RequestParam("train_plan") String trainPlan,
        @RequestParam("major") String major, @RequestParam("grade") String grade,
        HttpServletResponse response) {
        //TODO 设计培养计划样例
        try {
            return "success";
        } catch (Exception e) {
            return "fail";
        }
    }

    /**
     * 专业分流
     */
    @RequestMapping("/professionalDiversion")
    public String professionalDiversion(@RequestParam("professional_diversion") String professionalDiversionTable,
        HttpServletResponse response) throws IOException {
        try {
            managerService.professionalDiversion(professionalDiversionTable, response);
            return "success";
        } catch (EduSysException e) {
            return "fail";
        }
    }
}
