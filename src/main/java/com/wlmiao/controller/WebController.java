package com.wlmiao.controller;

import com.wlmiao.bo.StudentMain;
import com.wlmiao.bo.StudentMainExample;
import com.wlmiao.bo.TeacherMain;
import com.wlmiao.bo.TeacherMainExample;
import com.wlmiao.dao.StudentMainMapper;
import com.wlmiao.dao.TeacherMainMapper;
import com.wlmiao.exception.EduSysException;
import com.wlmiao.realm.DemoAuthorizingRealm;
import com.wlmiao.service.IManagerService;
import com.wlmiao.service.IStudentService;
import com.wlmiao.service.ITeacherService;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.CollectionUtils;
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
    @Autowired
    private ITeacherService teacherService;
    @Autowired
    private IStudentService studentService;

    @Autowired
    private TeacherMainMapper teacherMainMapper;
    @Autowired
    private StudentMainMapper studentMainMapper;

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
     * 导入教师
     */
    @RequestMapping("/importTeacher")
    public String importTeacher(@RequestParam("teacher_list") String teacherList,
        HttpServletResponse response) {
        logger.info("get request to importTeacher, teacherList = {}", teacherList);
        try {
            managerService.importTeacher(teacherList, response);
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
        logger.info("get request to downloadTeacher, grade = {}, majorNo = {}", grade, majorNo);
        try {
            managerService.downloadStudent(majorNo, grade, response);
        } catch (EduSysException e) {
            e.returnException(response);
        }
    }

    /**
     * 下载教师名单
     */
    @RequestMapping("/downloadTeacher")
    public void downloadTeacher(@RequestParam("institute_no") String instituteNo, HttpServletResponse response)
        throws IOException {
        logger.info("get request to downloadTeacher, instituteNo = {}", instituteNo);
        try {
            managerService.downloadTeacher(instituteNo, response);
        } catch (EduSysException e) {
            e.returnException(response);
        }
    }

    /**
     * 上传培养计划
     */
    @RequestMapping("/uploadTrainPlan")
    public String uploadTrainPlan(@RequestParam("train_plan") String trainPlan,
        @RequestParam("major") String major, HttpServletResponse response) {
        logger.info("get request to uploadTrainPlan, trainPlan = {}", trainPlan);
        try {
            managerService.uploadTrainPlan(trainPlan, major, response);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    /**
     * 教师开课
     */
    @RequestMapping("/uploadCourseInformation")
    public String uploadCourseInformation(@RequestParam("course_information") String courseInformation,
        @RequestParam("grade") String grade, HttpServletResponse response) {
        logger.info("get request to uploadCourseInformation, courseInformation = {}", courseInformation);
        try {
            managerService.uploadCourseInformation(courseInformation, grade, response);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    /**
     * 下载班级列表
     */
    @RequestMapping("/downloadClass")
    public void downloadClass(@RequestParam("grade") String grade, @RequestParam("major_no") String majorNo,
        HttpServletResponse response) throws IOException {
        logger.info("get request to downloadClass, grade = {}, majorNo = {}", grade, majorNo);
        try {
            managerService.downloadClass(majorNo, grade, response);
        } catch (EduSysException e) {
            e.returnException(response);
        }
    }

    /**
     * 专业分流
     */
    @RequestMapping("/professionalDiversion")
    public String professionalDiversion(@RequestParam("professional_diversion") String professionalDiversionTable,
        @RequestParam("class_student_number") Integer classStudentNumber, @RequestParam("grade") String grade,
        HttpServletResponse response) throws IOException {
        logger.info("get request to professionalDiversion, professionalDiversionTable = {}, class_student_number = {}, grade = {}", professionalDiversionTable, classStudentNumber, grade);
        try {
            managerService.professionalDiversion(professionalDiversionTable, classStudentNumber, grade, response);
            return "success";
        } catch (EduSysException e) {
            return "fail";
        }
    }

    /**
     * 教师分配
     */
    @RequestMapping("/distributionTeacher")
    public String distributionTeacher(@RequestParam("teacher_list") String teacherList,
        @RequestParam("grade") String grade, @RequestParam("major_no") String majorNo,
        @RequestParam("random") Boolean random, HttpServletResponse response) throws IOException {
        logger.info("get request to distributionTeacher, grade = {}, majorNo = {}, random = {}", grade, majorNo, random);
        try {
            managerService.distributionTeacher(teacherList, majorNo, grade, random, response);
            return "success";
        } catch (EduSysException e) {
            return "fail";
        }
    }

    /**
     * 绩点查询
     */
    @RequestMapping("/checkGPA")
    public String checkGPA(HttpServletResponse response) throws IOException {
        logger.info("get request to checkGPA");
        try {
            StudentMain studentMain = getCurrentStudent();
            studentService.checkGPA(studentMain, response);
            return "success";
        } catch (EduSysException e) {
            return "fail";
        }
    }

    /**
     * 下载选课表
     */
    @RequestMapping("/downloadCourseChosenTable")
    public void downloadCourseChosenTable(HttpServletResponse response) throws IOException {
        logger.info("get request to downloadCourseChosenTable");
        try {
            StudentMain studentMain = getCurrentStudent();
            studentService.downloadCourseChosenTable(studentMain, response);
        } catch (EduSysException e) {
            e.returnException(response);
        }
    }

    /**
     * 选课
     */
    @RequestMapping("/courseChosen")
    public String courseChosen(@RequestParam("course_chosen") String courseChosen, HttpServletResponse response) {
        logger.info("get request to courseChosen, courseChosen = {}", courseChosen);
        try {
            StudentMain studentMain = getCurrentStudent();
            studentService.courseChosen(studentMain, courseChosen, response);
            return "success";
        } catch (EduSysException e) {
            return "fail";
        }
    }

    /**
     * 下载课表(学生)
     */
    @RequestMapping("/downloadStudentTimetable")
    public void downloadStudentTimetable(HttpServletResponse response) throws IOException {
        logger.info("get request to downloadStudentTimetable");
        try {
            StudentMain studentMain = getCurrentStudent();
            studentService.downloadStudentTimetable(studentMain, response);
        } catch (EduSysException e) {
            e.returnException(response);
        }
    }

    /**
     * 下载课程学生名单
     */
    @RequestMapping("/downloadCourseStudent")
    public void downloadCourseStudent(@RequestParam("course_no") String courseNo, HttpServletResponse response)
        throws IOException {
        logger.info("get request to downloadCourseStudent, courseNo = {}", courseNo);
        try {
            TeacherMain teacherMain = getCurrentTeacher();
            teacherService.downloadCourseStudent(teacherMain, courseNo, response);
        } catch (EduSysException e) {
            e.returnException(response);
        }
    }

    /**
     * 上传学生成绩
     */
    @RequestMapping("/uploadCourseScore")
    public void uploadCourseScore(@RequestParam("course_score") String courseScore,
        @RequestParam("course_no") String courseNo, HttpServletResponse response) throws IOException {
        logger.info("get request to uploadCourseScore, courseScore = {}, courseNo = {}", courseScore, courseNo);
        try {
            TeacherMain teacherMain = getCurrentTeacher();
            teacherService.uploadStudentScore(teacherMain, courseScore, courseNo, response);
        } catch (EduSysException e) {
            e.returnException(response);
        }
    }

    /**
     * 下载课表(教师)
     */
    @RequestMapping("/downloadTeacherTimetable")
    public void downloadTeacherTimetable(HttpServletResponse response) throws IOException {
        logger.info("get request to downloadTeacherTimetable");
        try {
            TeacherMain teacherMain = getCurrentTeacher();
            teacherService.downloadTeacherTimetable(teacherMain, response);
        } catch (EduSysException e) {
            e.returnException(response);
        }
    }


    private TeacherMain getCurrentTeacher() {
        String userName = getUserName();
        TeacherMainExample example = new TeacherMainExample();
        example.createCriteria().andTeacherNoEqualTo(userName);
        List<TeacherMain> teacherMainList = teacherMainMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(teacherMainList)) {
            return null;
        }
        return teacherMainList.get(0);
    }

    private StudentMain getCurrentStudent() {
        String userName = getUserName();
        StudentMainExample example = new StudentMainExample();
        example.createCriteria().andStudentNoEqualTo(userName);
        List<StudentMain> studentMainList = studentMainMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(studentMainList)) {
            return null;
        }
        return studentMainList.get(0);
    }

    private String getUserName() {
        Subject currentUser = org.apache.shiro.SecurityUtils.getSubject();
        if (currentUser == null || currentUser.getPrincipal() == null) {
            return "";
        }
        DemoAuthorizingRealm.ShiroUser shiroUser = (DemoAuthorizingRealm.ShiroUser) currentUser.getPrincipal();
        return shiroUser.getUsername().toString();
    }


}
