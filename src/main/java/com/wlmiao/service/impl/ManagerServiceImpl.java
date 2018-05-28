package com.wlmiao.service.impl;

import com.github.pagehelper.util.StringUtil;
import com.wlmiao.bo.ClassMain;
import com.wlmiao.bo.InstituteMajor;
import com.wlmiao.bo.InstituteMajorExample;
import com.wlmiao.bo.StudentMain;
import com.wlmiao.bo.StudentMainExample;
import com.wlmiao.bo.StudentMainExample.Criteria;
import com.wlmiao.constant.ExceptionConstant;
import com.wlmiao.dao.ClassMainMapper;
import com.wlmiao.dao.InstituteMajorMapper;
import com.wlmiao.dao.StudentMainMapper;
import com.wlmiao.exception.EduSysException;
import com.wlmiao.service.IManagerService;
import com.wlmiao.util.XlsxUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;
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
    private ClassMainMapper classMainMapper;
    @Autowired
    private InstituteMajorMapper instituteMajorMapper;

    @Override
    public void importStudentAndDivision(String studentListPath, Integer classStudentNumber, String grade,
        HttpServletResponse response)
        throws EduSysException {

        List<HashMap<String, String>> inputList = XlsxUtil.readFromXls(studentListPath);

        List<StudentMain> studentMainList = inputList.stream().map(map -> produceStudent(map, grade))
            .collect(Collectors.toList());
        Map<String, Map<String, List<StudentMain>>> majorMap = division(studentMainList, classStudentNumber);
        List<ClassMain> classMainList = produceClass(majorMap, grade);

        studentMainList.forEach(s -> studentMainMapper.insert(s));
        classMainList.forEach(s -> classMainMapper.insert(s));

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
            row.createCell(0).setCellValue(student.getId());
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
            response.setHeader("Content-Disposition", "attachment;fileName=studentlist.xlsx");
            xssfWorkbook.write(response.getOutputStream());
        } catch (IOException e) {
            throw new EduSysException(ExceptionConstant.IO_EXCEPTION);
        }

    }

    @Override
    public void professionalDiversion(String professionalDiversionTable, HttpServletResponse response)
        throws EduSysException {
        List<HashMap<String, String>> inputList = XlsxUtil.readFromXls(professionalDiversionTable);

        List<InstituteMajor> instituteMajorList = instituteMajorMapper.selectByExample(new InstituteMajorExample());
        HashMap<String, String> instituteMajorMap = new HashMap<>();
        for (InstituteMajor instituteMajor : instituteMajorList) {
            instituteMajorMap.put(instituteMajor.getMajorNo(), instituteMajor.getMajor());
        }

        for (HashMap<String, String> map : inputList) {
            StudentMainExample example = new StudentMainExample();
            example.createCriteria().andStudentNoEqualTo(map.get("student_no"));

            StudentMain studentMain = new StudentMain();
            studentMain.setMajorNo(map.get("major_no"));
            studentMain.setMajor(instituteMajorMap.get(map.get("major_no")));

            studentMainMapper.updateByExampleSelective(studentMain, example);
        }
    }

    /**
     * 生成班级
     */
    private List<ClassMain> produceClass(Map<String, Map<String, List<StudentMain>>> majorMap, String grade) {
        List<ClassMain> result = new ArrayList<>();

        for (Map.Entry<String, Map<String, List<StudentMain>>> entry : majorMap.entrySet()) {
            String majorNo = entry.getKey();
            Map<String, List<StudentMain>> classMap = entry.getValue();
            for (Map.Entry<String, List<StudentMain>> map : classMap.entrySet()) {
                ClassMain classMain = new ClassMain();
                classMain.setGrade(grade);
                classMain.setClassNo(map.getKey());
                //TODO 生成班级名
                classMain.setStudentCount(map.getValue().size());
                result.add(classMain);
                for (Integer index = 0; index < map.getValue().size(); index++) {
                    String studentNo = grade + map.getKey() + String.format("%03d", index + 1);
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
     * 分班
     */
    private Map<String, Map<String, List<StudentMain>>> division(List<StudentMain> studentList,
        Integer classStudentNumber) {
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
                String classNo = majorNo + s;
                classMap.put(classNo, new ArrayList<>());
            }

            Integer index = 0;
            for (StudentMain student : list) {
                String s = String.format("%02d", index + 1);
                String classNo = majorNo + s;
                classMap.get(classNo).add(student);
                index = (index + 1) % classNumber;
                student.setClassNo(classNo);
            }

            studentMap.put(majorNo, classMap);
        }
        return studentMap;
    }

}
