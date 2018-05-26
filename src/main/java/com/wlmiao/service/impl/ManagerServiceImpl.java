package com.wlmiao.service.impl;

import com.wlmiao.bo.ClassMain;
import com.wlmiao.bo.StudentMain;
import com.wlmiao.dao.ClassMainMapper;
import com.wlmiao.dao.InstituteMajorMapper;
import com.wlmiao.dao.StudentMainMapper;
import com.wlmiao.exception.EduSysException;
import com.wlmiao.service.IManagerService;
import com.wlmiao.util.XlsxUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;
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
//                classMain.setClassName(clasName);
                classMain.setStudentCount(map.getValue().size());
                result.add(classMain);
                for (Integer index = 0;index < map.getValue().size();index++) {
                    String studentNo = grade + map.getKey() + String.format("%03d", index+1);
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
        //TODO 生成学号
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
                index = (index +1)% classNumber;
                student.setClassNo(classNo);
            }

            studentMap.put(majorNo, classMap);
        }
        return studentMap;
    }

}
