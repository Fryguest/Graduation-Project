package com.wlmiao.service.impl;

import com.wlmiao.bo.CourseMain;
import com.wlmiao.bo.CourseMainExample;
import com.wlmiao.bo.CourseStudent;
import com.wlmiao.bo.CourseStudentExample;
import com.wlmiao.bo.StudentMain;
import com.wlmiao.bo.StudentMainExample;
import com.wlmiao.bo.TeacherMain;
import com.wlmiao.constant.ExceptionConstant;
import com.wlmiao.dao.CourseMainMapper;
import com.wlmiao.dao.CourseStudentMapper;
import com.wlmiao.dao.StudentMainMapper;
import com.wlmiao.exception.EduSysException;
import com.wlmiao.service.ITeacherService;
import com.wlmiao.util.XlsxUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements ITeacherService {

    @Autowired
    private CourseStudentMapper courseStudentMapper;
    @Autowired
    private StudentMainMapper studentMainMapper;
    @Autowired
    private CourseMainMapper courseMainMapper;

    @Override
    public void downloadCourseStudent(String courseNo, HttpServletResponse response) throws EduSysException {
        CourseStudentExample example = new CourseStudentExample();
        example.createCriteria().andCourseNoEqualTo(courseNo);
        List<CourseStudent> courseStudentList = courseStudentMapper.selectByExample(example);

        List<StudentMain> studentMainList = new ArrayList<>();
        for (CourseStudent courseStudent : courseStudentList) {
            StudentMainExample example1 = new StudentMainExample();
            example1.createCriteria().andStudentNoEqualTo(courseStudent.getStudentNo());
            List<StudentMain> list = studentMainMapper.selectByExample(example1);
            studentMainList.addAll(list);
        }

        List<String> titleList = Arrays
            .asList(new String[]{"id", "student_no", "student_name", "sex", "institute_no", "institute", "major_no",
                "major", "grade"});

        XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
        Sheet sheet = xssfWorkbook.createSheet("student_list");
        Row titleRow = sheet.createRow(0);
        for (Integer i = 0; i < titleList.size(); i++) {
            titleRow.createCell(i).setCellValue(titleList.get(i));
        }

        for (Integer rowNumber = 1; rowNumber <= studentMainList.size(); rowNumber++) {
            Row row = sheet.createRow(rowNumber);
            StudentMain student = studentMainList.get(rowNumber - 1);
            row.createCell(0).setCellValue(rowNumber);
            row.createCell(1).setCellValue(student.getStudentNo());
            row.createCell(2).setCellValue(student.getStudentName());
            row.createCell(3).setCellValue(student.getSex());
            row.createCell(4).setCellValue(student.getInstituteNo());
            row.createCell(5).setCellValue(student.getInstitute());
            row.createCell(6).setCellValue(student.getMajorNo());
            row.createCell(7).setCellValue(student.getMajor());
            row.createCell(8).setCellValue(student.getGrade());
        }

        try {
            response.setContentType("multipart/form-data");
            response.setHeader("Content-Disposition", "attachment;fileName=studentlist.xlsx");
            xssfWorkbook.write(response.getOutputStream());
        } catch (IOException e) {
            throw new EduSysException(ExceptionConstant.IO_EXCEPTION);
        }
    }

    @Override
    public void uploadStudentScore(String studentScore, String courseNo, HttpServletResponse response)
        throws EduSysException {
        List<HashMap<String, String>> inputList = XlsxUtil.readFromXls(studentScore);
        for (HashMap<String, String> map : inputList) {
            Integer score = Integer.valueOf(map.get("分数"));
            String studentNo = map.get("学号");

            CourseStudentExample example = new CourseStudentExample();
            example.createCriteria().andCourseNoEqualTo(courseNo).andStudentNoEqualTo(studentNo);
            CourseStudent courseStudent = new CourseStudent();
            courseStudent.setScore(score);
            courseStudentMapper.updateByExampleSelective(courseStudent, example);
        }
    }

    @Override
    public void downloadTeacherTimetable(TeacherMain teacherMain, HttpServletResponse response) throws EduSysException {

        String teacherNo = teacherMain.getTeacherNo();
        CourseMainExample example = new CourseMainExample();
        example.createCriteria().andTeacherNoEqualTo(teacherNo);
        List<CourseMain> courseMainList = courseMainMapper.selectByExample(example);

        List<String> titleList = Arrays.asList(new String[]{"时间", "周一", "周二", "周三", "周四", "周五", "周六", "周日"});

        XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
        Sheet sheet = xssfWorkbook.createSheet("课程表");
        Row titleRow = sheet.createRow(0);
        for (Integer i = 0; i < titleList.size(); i++) {
            titleRow.createCell(i).setCellValue(titleList.get(i));
        }

        sheet.createRow(1).createCell(0).setCellValue("第一节课/8:00 - 9:40");
        sheet.createRow(2).createCell(0).setCellValue("第二节课/9:55 - 11:35");
        sheet.createRow(3).createCell(0).setCellValue("第三节课/13:30 - 15:10");
        sheet.createRow(4).createCell(0).setCellValue("第四节课/15:25 - 17:05");
        sheet.createRow(5).createCell(0).setCellValue("第五节课/18:30 - 21:05");


        for (CourseMain courseMain : courseMainList) {
            String courseNo = courseMain.getCourseNo();
            String time = courseMain.getCourseTime();
            Integer weekday = Integer.valueOf(time.substring(0, time.indexOf("/")));
            Integer courseNumber = Integer.valueOf(time.substring(time.indexOf("/") + 1));
            Cell cell = sheet.getRow(weekday).createCell(courseNumber);
            cell.setCellValue(courseNo + "/" + courseMain.getTeacherName() + "/" + courseMain.getCredit());
        }

        try {
            response.setContentType("multipart/form-data");
            response.setHeader("Content-Disposition", "attachment;fileName=classlist.xlsx");
            xssfWorkbook.write(response.getOutputStream());
        } catch (IOException e) {
            throw new EduSysException(ExceptionConstant.IO_EXCEPTION);
        }
    }
}
