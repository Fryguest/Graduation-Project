package com.wlmiao.service.impl;

import static com.wlmiao.constant.RoleConstant.STUDENT;
import static com.wlmiao.constant.RoleConstant.TEACHER;
import static com.wlmiao.util.MD5Util.getMD5Str;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.util.StringUtil;
import com.wlmiao.bo.*;
import com.wlmiao.bo.StudentMainExample.Criteria;
import com.wlmiao.constant.ExceptionConstant;
import com.wlmiao.dao.ClassMainMapper;
import com.wlmiao.dao.CourseMainMapper;
import com.wlmiao.dao.InstituteMajorMapper;
import com.wlmiao.dao.StudentMainMapper;
import com.wlmiao.dao.TeacherMainMapper;
import com.wlmiao.dao.TrainingPlanMapper;
import com.wlmiao.dao.UserMapper;
import com.wlmiao.dao.UserRoleMapper;
import com.wlmiao.exception.EduSysException;
import com.wlmiao.model.User;
import com.wlmiao.model.UserRole;
import com.wlmiao.service.IManagerService;
import com.wlmiao.util.XlsxUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerServiceImpl implements IManagerService {

    @Autowired
    private StudentMainMapper studentMainMapper;
    @Autowired
    private TeacherMainMapper teacherMainMapper;
    @Autowired
    private ClassMainMapper classMainMapper;
    @Autowired
    private InstituteMajorMapper instituteMajorMapper;
    @Autowired
    private CourseMainMapper courseMainMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private TrainingPlanMapper trainingPlanMapper;

    @Override
    public void importStudentAndDivision(String studentListPath, Integer classStudentNumber, String grade,
        HttpServletResponse response)
        throws EduSysException {

        List<HashMap<String, String>> inputList = XlsxUtil.readFromXls(studentListPath);

        List<StudentMain> studentMainList = inputList.stream().map(map -> produceStudent(map, grade))
            .collect(Collectors.toList());
        Map<String, Map<String, List<StudentMain>>> majorMap = division(studentMainList, classStudentNumber, grade);
        List<ClassMain> classMainList = produceClass(majorMap, grade);
        studentMainList.forEach(s -> studentMainMapper.insert(s));
        classMainList.forEach(s -> classMainMapper.insert(s));
        studentMainList.forEach(s -> insertUser(s.getStudentNo(), s.getStudentName(), STUDENT));

    }

    @Override
    public void importTeacher(String teacherListPath, HttpServletResponse response)
        throws EduSysException {
        List<HashMap<String, String>> inputList = XlsxUtil.readFromXls(teacherListPath);
        List<TeacherMain> teacherMainList = inputList.stream().map(map -> produceTeacher(map))
            .collect(Collectors.toList());
        teacherMainList.forEach(s -> teacherMainMapper.insert(s));
        teacherMainList.forEach(s -> insertUser(s.getTeacherNo(), s.getTeacherName(), TEACHER));
    }

    @Override
    public void downloadStudent(String majorNo, String grade, HttpServletResponse response) throws EduSysException {
        StudentMainExample example = new StudentMainExample();
        Criteria criteria = example.createCriteria();
        if (StringUtil.isNotEmpty(grade)) {
            criteria.andGradeEqualTo(grade);
        }
        if (StringUtil.isNotEmpty(majorNo)) {
            criteria.andMajorEqualTo(majorNo);
        }
        List<StudentMain> studentMainList = studentMainMapper.selectByExample(example);

        List<String> titleList = Arrays
            .asList(new String[]{"id", "student_no", "student_name", "class_no", "sex", "institute_no",
                "institute", "major_no", "major", "grade", "native_place", "identity_number"});

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
            row.createCell(3).setCellValue(student.getClassNo());
            row.createCell(4).setCellValue(student.getSex());
            row.createCell(5).setCellValue(student.getInstituteNo());
            row.createCell(6).setCellValue(student.getInstitute());
            row.createCell(7).setCellValue(student.getMajorNo());
            row.createCell(8).setCellValue(student.getMajor());
            row.createCell(9).setCellValue(student.getGrade());
            row.createCell(10).setCellValue(student.getNativePlace());
            row.createCell(11).setCellValue(student.getIdentityNumber());
        }

        try {
            response.setContentType("multipart/form-data");
            response.setHeader("Content-Disposition", "attachment;fileName=student_list.xlsx");
            xssfWorkbook.write(response.getOutputStream());
        } catch (IOException e) {
            throw new EduSysException(ExceptionConstant.IO_EXCEPTION);
        }
    }


    @Override
    public void downloadTeacher(String instituteNo, HttpServletResponse response) throws EduSysException {

        TeacherMainExample example = new TeacherMainExample();
        TeacherMainExample.Criteria criteria = example.createCriteria();
        if (StringUtil.isNotEmpty(instituteNo)) {
            criteria.andInstituteNoEqualTo(instituteNo);
        }
        List<TeacherMain> teacherMainList = teacherMainMapper.selectByExample(example);

        List<String> titleList = Arrays
            .asList(new String[]{"id", "teacher_no", "teacher_name", "sex", "institute_no", "institute",
                "title", "native_place", "identity_number"});

        XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
        Sheet sheet = xssfWorkbook.createSheet("teacher_list");
        Row titleRow = sheet.createRow(0);
        for (Integer i = 0; i < titleList.size(); i++) {
            titleRow.createCell(i).setCellValue(titleList.get(i));
        }

        for (Integer rowNumber = 1; rowNumber <= teacherMainList.size(); rowNumber++) {
            Row row = sheet.createRow(rowNumber);
            TeacherMain teacher = teacherMainList.get(rowNumber - 1);
            row.createCell(0).setCellValue(rowNumber);
            row.createCell(1).setCellValue(teacher.getTeacherNo());
            row.createCell(2).setCellValue(teacher.getTeacherName());
            row.createCell(3).setCellValue(teacher.getSex());
            row.createCell(4).setCellValue(teacher.getInstituteNo());
            row.createCell(5).setCellValue(teacher.getInstitute());
            row.createCell(6).setCellValue(teacher.getTitle());
            row.createCell(7).setCellValue(teacher.getNativePlace());
            row.createCell(8).setCellValue(teacher.getIdentityNumber());
        }

        try {
            response.setContentType("multipart/form-data");
            response.setHeader("Content-Disposition", "attachment;fileName=teacher_list.xlsx");
            xssfWorkbook.write(response.getOutputStream());
        } catch (IOException e) {
            throw new EduSysException(ExceptionConstant.IO_EXCEPTION);
        }
    }


    @Override
    public void downloadClass(String majorNo, String grade, HttpServletResponse response) throws EduSysException {
        ClassMainExample example = new ClassMainExample();
        ClassMainExample.Criteria criteria = example.createCriteria();
        if (StringUtil.isNotEmpty(majorNo)) {
            criteria.andMajorNoEqualTo(majorNo);
        }
        if (StringUtil.isNotEmpty(grade)) {
            criteria.andGradeEqualTo(grade);
        }
        List<ClassMain> classMainList = classMainMapper.selectByExample(example);

        List<String> titleList = Arrays
            .asList(new String[]{"id", "班级编号", "年级", "学生人数", "班主任编号", "班主任姓名", "专业编号", "专业"});

        XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
        Sheet sheet = xssfWorkbook.createSheet("class_list");
        Row titleRow = sheet.createRow(0);
        for (Integer i = 0; i < titleList.size(); i++) {
            titleRow.createCell(i).setCellValue(titleList.get(i));
        }

        for (Integer rowNumber = 1; rowNumber <= classMainList.size(); rowNumber++) {
            Row row = sheet.createRow(rowNumber);
            ClassMain classMain = classMainList.get(rowNumber - 1);
            row.createCell(0).setCellValue(rowNumber);
            row.createCell(1).setCellValue(classMain.getClassNo());
            row.createCell(2).setCellValue(classMain.getGrade());
            row.createCell(3).setCellValue(classMain.getStudentCount());
            row.createCell(4).setCellValue(classMain.getHeadTeacherNo() == null ? "未分配" : classMain.getHeadTeacherNo());
            row.createCell(5).setCellValue(classMain.getHeadTeacherName() == null ? "未分配" : classMain.getHeadTeacherName());
            row.createCell(6).setCellValue(classMain.getMajorNo());
            row.createCell(7).setCellValue(classMain.getMajor());
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
    public void professionalDiversion(String professionalDiversionTable, Integer classStudentNumber, String grade,
        HttpServletResponse response) throws EduSysException {
        List<HashMap<String, String>> inputList = XlsxUtil.readFromXls(professionalDiversionTable);

        List<InstituteMajor> instituteMajorList = instituteMajorMapper.selectByExample(new InstituteMajorExample());
        HashMap<String, String> instituteMajorMap = new HashMap<>();
        for (InstituteMajor instituteMajor : instituteMajorList) {
            instituteMajorMap.put(instituteMajor.getMajorNo(), instituteMajor.getMajor());
        }

        List<StudentMain> studentMainList = new ArrayList<>();
        for (HashMap<String, String> map : inputList) {
            StudentMainExample example = new StudentMainExample();
            example.createCriteria().andStudentNoEqualTo(map.get("student_no"));

            List<StudentMain> selectList = studentMainMapper.selectByExample(example);
            if (CollectionUtils.isEmpty(selectList)) {
                continue;
            }

            StudentMain studentMain = selectList.get(0);
            studentMain.setMajorNo(map.get("major_no"));
            studentMain.setMajor(instituteMajorMap.get(map.get("major_no")));
            studentMainList.add(studentMain);
        }

        ClassMainExample example = new ClassMainExample();
        example.createCriteria().andGradeEqualTo(grade);
        classMainMapper.deleteByExample(example);

        Map<String, Map<String, List<StudentMain>>> majorMap = division(studentMainList, classStudentNumber, grade);
        List<ClassMain> classMainList = produceClass(majorMap, grade);

        studentMainList.forEach(s -> studentMainMapper.updateByPrimaryKeySelective(s));
        classMainList.forEach(s -> classMainMapper.insert(s));
    }

    /**
     * 分配教师
     */
    @Override
    public void distributionTeacher(String teacherList, String majorNo, String grade, Boolean random,
        HttpServletResponse response)
        throws EduSysException {

        List<HashMap<String, String>> inputList = XlsxUtil.readFromXls(teacherList);

        TeacherMainExample teacherMainExample = new TeacherMainExample();
        teacherMainExample.createCriteria();
        List<TeacherMain> teacherMainList = teacherMainMapper.selectByExample(teacherMainExample);
        HashMap<String,String> teacherMap = new HashMap<>();
        teacherMainList.forEach(s -> teacherMap.put(s.getTeacherNo(), s.getTeacherName()));

        ClassMainExample example = new ClassMainExample();
        example.createCriteria().andMajorNoEqualTo(majorNo).andGradeEqualTo(grade);
        List<ClassMain> classMainList = classMainMapper.selectByExample(example);

        if (random) {
            Collections.shuffle(classMainList);
            Collections.shuffle(inputList);
            for (Integer index = 0; index < classMainList.size(); index++) {
                ClassMain classMain = classMainList.get(index);
                HashMap<String, String> map = inputList.get(index % inputList.size());
                classMain.setHeadTeacherNo(map.get("教师编号"));
                classMain.setHeadTeacherName(teacherMap.get(map.get("教师编号")));
                classMainMapper.updateByPrimaryKeySelective(classMain);
            }
        } else {
            HashMap<String, String> classTeacherMap = new HashMap<>();
            for (HashMap<String, String> map : inputList) {
                classTeacherMap.put(map.get("班级编号"), map.get("教师编号"));
            }
            for (ClassMain classMain : classMainList) {
                classMain.setHeadTeacherNo(classTeacherMap.get(classMain.getClassNo()));
                classMain.setHeadTeacherName(teacherMap.get(classMain.getHeadTeacherNo()));
                classMainMapper.updateByPrimaryKeySelective(classMain);
            }
        }
    }

    /**
     * 上传培养计划
     */
    @Override
    public void uploadTrainPlan(String trainPlan, String majorNo, HttpServletResponse response) throws EduSysException {
        InstituteMajorExample example = new InstituteMajorExample();
        example.createCriteria().andMajorNoEqualTo(majorNo);
        List<InstituteMajor> instituteMajorList = instituteMajorMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(instituteMajorList)) {
            return;
        }

        List<HashMap<String, String>> inputList = XlsxUtil.readFromXls(trainPlan);
        JSONArray jsonArray = new JSONArray();

        for (HashMap<String, String> map : inputList) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("course_type_no", map.get("课程类型编号"));
            jsonObject.put("course_name", map.get("课程名"));
            jsonObject.put("credit", map.get("学分"));
            jsonObject.put("course_time", map.get("修读年") + "/" + map.get("学期"));
            jsonObject.put("examination_method", map.get("考查方式"));
            jsonArray.add(jsonObject);
        }

        TrainingPlanExample example1 = new TrainingPlanExample();
        example1.createCriteria().andMajorNoEqualTo(majorNo);
        List<TrainingPlan> trainingPlanList = trainingPlanMapper.selectByExampleWithBLOBs(example1);

        if (CollectionUtils.isEmpty(trainingPlanList)) {
            TrainingPlan trainingPlan = new TrainingPlan();
            trainingPlan.setContent(jsonArray.toString());
            trainingPlan.setMajorNo(majorNo);
            trainingPlan.setMajor(instituteMajorList.get(0).getMajor());
            trainingPlan.setInstituteNo(instituteMajorList.get(0).getInstituteNo());
            trainingPlan.setInstitute(instituteMajorList.get(0).getInstitute());
            trainingPlanMapper.insert(trainingPlan);
        } else {
            TrainingPlan trainingPlan = trainingPlanList.get(0);
            trainingPlan.setContent(jsonArray.toString());
            trainingPlan.setMajorNo(majorNo);
            trainingPlan.setMajor(instituteMajorList.get(0).getMajor());
            trainingPlan.setInstituteNo(instituteMajorList.get(0).getInstituteNo());
            trainingPlan.setInstitute(instituteMajorList.get(0).getInstitute());
            trainingPlanMapper.updateByExampleWithBLOBs(trainingPlan, example1);
        }
    }

    /**
     * 上传开课信息，并安排课程时间
     */
    @Override
    public void uploadCourseInformation(String courseInformationList, String grade, HttpServletResponse response)
        throws EduSysException {

        List<HashMap<String, String>> inputList = XlsxUtil.readFromXls(courseInformationList);

        List<CourseMain> courseMainList = inputList.stream().map(map -> produceCourse(map, grade))
            .collect(Collectors.toList());

        HashMap<String, List<CourseMain>> map = new HashMap<>();
        for (CourseMain courseMain : courseMainList) {
            if (map.containsKey(courseMain.getCourseType())) {
                map.get(courseMain.getCourseType()).add(courseMain);
            } else {
                List<CourseMain> list = new ArrayList<>();
                list.add(courseMain);
                map.put(courseMain.getCourseType(), list);
            }
        }

        for (List<CourseMain> list : map.values()) {
            for (Integer index = 0; index < list.size(); index++) {
                CourseMain courseMain = list.get(index);
                courseMain.setCourseNo(courseMain.getCourseType() + "2018" + String.format("%02d", index + 1));
            }
        }

        courseMainList.forEach(s -> courseMainMapper.insert(s));
    }

    /**
     * 生成课程
     */
    private CourseMain produceCourse(HashMap<String, String> map, String grade) {
        CourseMain courseMain = new CourseMain();

        courseMain.setCourseType(map.get("课程类型编号"));
        courseMain.setCourseName(map.get("课程名"));
        courseMain.setTeacherNo(map.get("教师编号"));
        courseMain.setTeacherName(map.get("教师姓名"));
        courseMain.setCredit(Integer.valueOf(map.get("学分")));
        courseMain.setCourseTime(map.get("上课时间"));
        courseMain.setGrade(grade);
        return courseMain;
    }

    /**
     * 生成班级
     */
    private List<ClassMain> produceClass(Map<String, Map<String, List<StudentMain>>> majorMap, String grade) {
        List<ClassMain> result = new ArrayList<>();

        List<InstituteMajor> instituteMajorList = instituteMajorMapper.selectByExample(new InstituteMajorExample());
        HashMap<String, String> instituteMajorMap = new HashMap<>();
        for (InstituteMajor instituteMajor : instituteMajorList) {
            instituteMajorMap.put(instituteMajor.getMajorNo(), instituteMajor.getMajor());
        }

        for (Map.Entry<String, Map<String, List<StudentMain>>> entry : majorMap.entrySet()) {
            String majorNo = entry.getKey();
            Map<String, List<StudentMain>> classMap = entry.getValue();
            for (Map.Entry<String, List<StudentMain>> map : classMap.entrySet()) {
                ClassMain classMain = new ClassMain();
                classMain.setGrade(grade);
                classMain.setClassNo(map.getKey());
                classMain.setMajorNo(majorNo);
                classMain.setMajor(instituteMajorMap.get(majorNo));
                classMain.setStudentCount(map.getValue().size());
                result.add(classMain);
                for (Integer index = 0; index < map.getValue().size(); index++) {
                    String studentNo = map.getKey() + String.format("%03d", index + 1);
                    map.getValue().get(index).setStudentNo(studentNo);
                }
            }
        }
        return result;
    }

    /**
     * 生成学生信息
     */
    private StudentMain produceStudent(HashMap<String, String> map, String grade) {
        StudentMain studentMain = new StudentMain();
        studentMain.setStudentName(map.get("student_name"));
        studentMain.setSex(map.get("sex"));
        studentMain.setInstituteNo(map.get("institute_no"));
        studentMain.setInstitute(map.get("institute"));
        studentMain.setMajorNo(map.get("major_no"));
        studentMain.setMajor(map.get("major"));
        studentMain.setGrade(grade);
        studentMain.setNativePlace(map.get("native_place"));
        studentMain.setIdentityNumber(map.get("identity_number"));
        studentMain.setGpa((float) 0);
        return studentMain;
    }

    /**
     * 生成教师信息
     */
    private TeacherMain produceTeacher(HashMap<String, String> map) {
        TeacherMain teacher = new TeacherMain();
        teacher.setIdentityNumber(map.get("identity_number"));
        teacher.setTeacherNo(map.get("teacher_no"));
        teacher.setTeacherName(map.get("teacher_name"));
        teacher.setSex(map.get("sex"));
        teacher.setInstituteNo(map.get("institute_no"));
        teacher.setInstitute(map.get("institute"));
        teacher.setNativePlace(map.get("native_place"));
        teacher.setIdentityNumber(map.get("identity_number"));
        teacher.setTitle(map.get("title"));
        return teacher;
    }

    /**
     * 分班
     */
    private Map<String, Map<String, List<StudentMain>>> division(List<StudentMain> studentList,
        Integer classStudentNumber, String grade) {
        Map<String, Map<String, List<StudentMain>>> studentMap = new HashMap<>();
        Map<String, List<StudentMain>> tempMap = new HashMap<>();
        for (StudentMain studentMain : studentList) {
            if (tempMap.containsKey(studentMain.getMajorNo())) {
                tempMap.get(studentMain.getMajorNo()).add(studentMain);
            } else {
                List<StudentMain> tempList = new ArrayList<>();
                tempList.add(studentMain);
                tempMap.put(studentMain.getMajorNo(), tempList);
            }
        }

        for (Map.Entry<String, List<StudentMain>> map : tempMap.entrySet()) {
            String majorNo = map.getKey();
            List<StudentMain> list = map.getValue();
            Collections.shuffle(list);

            Integer sum = list.size();
            Integer classNumber = (sum + classStudentNumber - 1) / classStudentNumber;

            Map<String, List<StudentMain>> classMap = new HashMap<>();
            for (Integer index = 0; index < classNumber; index++) {
                String s = String.format("%02d", index + 1);
                String classNo = grade + majorNo + s;
                classMap.put(classNo, new ArrayList<>());
            }

            Integer index = 0;
            for (StudentMain student : list) {
                String s = String.format("%02d", index + 1);
                String classNo = grade + majorNo + s;
                classMap.get(classNo).add(student);
                index = (index + 1) % classNumber;
                student.setClassNo(classNo);
            }

            studentMap.put(majorNo, classMap);
        }
        return studentMap;
    }


    public void insertUser(String userName, String nickName, Long type) {
        System.out.println(userName);
        User user = new User();
        user.setNickname(nickName);
        user.setEmail(userName);
        user.setPswd(getMD5Str(userName.substring(userName.length() - 6)));
        user.setCreateTime(new Date());
        user.setStatus(true);
        user.setModifyTime(new Date());

        userMapper.insert(user);

        UserRole userRole = new UserRole();
        userRole.setUserId(user.getId());
        userRole.setRoleId(type);
        userRoleMapper.insert(userRole);
    }
}
