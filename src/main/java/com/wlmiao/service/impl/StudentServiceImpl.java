package com.wlmiao.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wlmiao.bo.CourseMain;
import com.wlmiao.bo.CourseMainExample;
import com.wlmiao.bo.CourseStudent;
import com.wlmiao.bo.CourseStudentExample;
import com.wlmiao.bo.StudentMain;
import com.wlmiao.bo.TrainingPlan;
import com.wlmiao.bo.TrainingPlanExample;
import com.wlmiao.constant.ExceptionConstant;
import com.wlmiao.dao.CourseMainMapper;
import com.wlmiao.dao.CourseStudentMapper;
import com.wlmiao.dao.TrainingPlanMapper;
import com.wlmiao.exception.EduSysException;
import com.wlmiao.service.IStudentService;
import com.wlmiao.util.XlsxUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private TrainingPlanMapper trainingPlanMapper;
    @Autowired
    private CourseMainMapper courseMainMapper;
    @Autowired
    private CourseStudentMapper courseStudentMapper;

    @Override
    public void checkGPA(StudentMain student, HttpServletResponse response) throws EduSysException {
        String majorNo = student.getMajorNo();
        String studentNo = student.getStudentNo();

        TrainingPlanExample example = new TrainingPlanExample();
        example.createCriteria().andMajorNoEqualTo(majorNo);
        List<TrainingPlan> trainingPlanList = trainingPlanMapper.selectByExampleWithBLOBs(example);
        if (CollectionUtils.isEmpty(trainingPlanList)) {
            throw new EduSysException(ExceptionConstant.UNEXCEPT_ERROR);
        }

        TrainingPlan trainingPlan = trainingPlanList.get(0);
        JSONArray content = JSON.parseArray(trainingPlan.getContent());

        CourseStudentExample example1 = new CourseStudentExample();
        example1.createCriteria().andStudentNoEqualTo(studentNo);
        List<CourseStudent> courseStudentList = courseStudentMapper.selectByExample(example1);

        HashMap<String, Integer> courseScoreMap = new HashMap<>();
        for (CourseStudent courseStudent : courseStudentList) {
            String courseNo = courseStudent.getCourseNo();
            CourseMainExample courseMainExample = new CourseMainExample();
            courseMainExample.createCriteria().andCourseNoEqualTo(courseNo);
            CourseMain courseMain = courseMainMapper.selectByExample(courseMainExample).get(0);
            courseScoreMap.put(courseMain.getCourseType(), courseStudent.getScore());
        }

        Double totalCredit = (double) 0;
        Double totalGP = (double) 0;
        for (Object o : content) {
            JSONObject jsonObject = (JSONObject) o;
            String courseType = jsonObject.getString("course_type_no");
            if (courseScoreMap.get(courseType) != null) {
                Integer score = courseScoreMap.get(courseType);
                if (score >= 60) {
                    totalGP += (double) (courseScoreMap.get(courseType) - 50) / 10 * jsonObject.getInteger("credit");
                } else {
                    totalGP += 1 * jsonObject.getInteger("credit");
                }

                totalCredit += jsonObject.getInteger("credit");

                jsonObject.put("score", score);
            }
        }
        Double GPA = totalGP / totalCredit;

        XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
        Sheet sheet = xssfWorkbook.createSheet("student_list");

        Row tempRow = sheet.createRow(0);
        tempRow.createCell(0).setCellValue("姓名: ");
        tempRow.createCell(1).setCellValue(student.getStudentName());
        tempRow.createCell(2).setCellValue("学号: ");
        tempRow.createCell(3).setCellValue(studentNo);
        tempRow.createCell(4).setCellValue("专业: ");
        tempRow.createCell(5).setCellValue(student.getMajor());

        tempRow = sheet.createRow(1);
        tempRow.createCell(0).setCellValue("当前绩点: " + GPA + ", 毕业绩点低于1.5将");

        List<String> titleList = Arrays.asList(new String[]{"课程编号", "课程名", "修读年", "学分", "成绩", "单科绩点"});

        Row titleRow = sheet.createRow(2);
        for (Integer i = 0; i < titleList.size(); i++) {
            titleRow.createCell(i).setCellValue(titleList.get(i));
        }

        for (Integer rowNumber = 0; rowNumber < content.size(); rowNumber++) {
            Row row = sheet.createRow(rowNumber + 3);
            JSONObject jsonObject = content.getJSONObject(rowNumber);
            row.createCell(0).setCellValue(jsonObject.getString("course_type_no"));
            row.createCell(1).setCellValue(jsonObject.getString("course_name"));
            row.createCell(2).setCellValue(jsonObject.getString("course_time"));
            row.createCell(3).setCellValue(jsonObject.getString("credit"));
            Integer score = jsonObject.getInteger("score");
            row.createCell(4).setCellValue(score);

                if (score >= 60) {
                    row.createCell(5).setCellValue((double)(score - 50) / 10);
                } else {
                    row.createCell(5).setCellValue(1);
                }
            row.createCell(5).setCellValue((jsonObject.getDouble("score") - 60) / 10 + 1);
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
    public void downloadCourseChosenTable(StudentMain student, HttpServletResponse response)
        throws EduSysException {

        String majorNo = student.getMajorNo();
        String grade = student.getGrade();

        TrainingPlanExample example = new TrainingPlanExample();
        example.createCriteria().andMajorNoEqualTo(majorNo);
        List<TrainingPlan> trainingPlanList = trainingPlanMapper.selectByExampleWithBLOBs(example);
        if (CollectionUtils.isEmpty(trainingPlanList)) {
            throw new EduSysException(ExceptionConstant.UNEXCEPT_ERROR);
        }

        TrainingPlan trainingPlan = trainingPlanList.get(0);
        JSONArray content = JSON.parseArray(trainingPlan.getContent());

        List<CourseMain> courseMainList = new ArrayList<>();
        for (Object o : content) {
            JSONObject jsonObject = (JSONObject) o;
            String courseTypeNo = jsonObject.getString("course_type_no");
            CourseMainExample example1 = new CourseMainExample();
            example1.createCriteria().andCourseTypeEqualTo(courseTypeNo).andGradeEqualTo(grade);
            List<CourseMain> courseMains = courseMainMapper.selectByExample(example1);
            courseMainList.addAll(courseMains);
        }

        List<String> titleList = Arrays
            .asList(new String[]{"id", "课程类型编号", "课程名", "教师编号", "教师姓名", "学分", "上课时间"});

        XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
        Sheet sheet = xssfWorkbook.createSheet("选课列表");
        Row titleRow = sheet.createRow(0);
        for (Integer i = 0; i < titleList.size(); i++) {
            titleRow.createCell(i).setCellValue(titleList.get(i));
        }

        for (Integer rowNumber = 1; rowNumber <= courseMainList.size(); rowNumber++) {
            Row row = sheet.createRow(rowNumber);
            CourseMain courseMain = courseMainList.get(rowNumber - 1);
            row.createCell(0).setCellValue(rowNumber);
            row.createCell(1).setCellValue(courseMain.getCourseType());
            row.createCell(2).setCellValue(courseMain.getCourseName());
            row.createCell(3).setCellValue(courseMain.getTeacherNo());
            row.createCell(4).setCellValue(courseMain.getTeacherName());
            row.createCell(5).setCellValue(courseMain.getCredit());
            row.createCell(6).setCellValue(courseMain.getCourseTime());
        }

        try {
            response.setContentType("multipart/form-data");
            response.setHeader("Content-Disposition", "attachment;fileName=classlist.xlsx");
            xssfWorkbook.write(response.getOutputStream());
        } catch (IOException e) {
            throw new EduSysException(ExceptionConstant.IO_EXCEPTION);
        }
    }


    @Override
    public void courseChosen(StudentMain student, String courseChosenPath, HttpServletResponse response)
        throws EduSysException {
        String grade = student.getGrade();
        List<HashMap<String, String>> inputList = XlsxUtil.readFromXls(courseChosenPath);
        List<CourseMain> courseMainList = new ArrayList<>();
        for (HashMap<String, String> map : inputList) {
            CourseMainExample example = new CourseMainExample();
            example.createCriteria().andCourseTypeEqualTo(map.get("课程类型编号")).andTeacherNoEqualTo(map.get("教师编号"))
                .andGradeEqualTo(grade);
            courseMainList.addAll(courseMainMapper.selectByExample(example));
        }

        //TODO 异常处理

        for (CourseMain courseMain : courseMainList) {
            CourseStudent courseStudent = new CourseStudent();
            courseStudent.setStudentNo(student.getStudentNo());
            courseStudent.setCourseNo(courseMain.getCourseNo());
            courseStudent.setIsRework((byte) 0);
            courseStudentMapper.insert(courseStudent);
        }
    }


    @Override
    public void downloadStudentTimetable(StudentMain student, HttpServletResponse response) throws EduSysException {
        String studentNo = student.getStudentNo();
        CourseStudentExample example = new CourseStudentExample();
        example.createCriteria().andStudentNoEqualTo(studentNo);
        List<CourseStudent> courseStudentList = courseStudentMapper.selectByExample(example);

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

        for (CourseStudent courseStudent : courseStudentList) {
            String courseNo = courseStudent.getCourseNo();
            CourseMainExample example1 = new CourseMainExample();
            example1.createCriteria().andCourseNoEqualTo(courseNo);

            CourseMain courseMain = courseMainMapper.selectByExample(example1).get(0);

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
