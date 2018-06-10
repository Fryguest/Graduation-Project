package com.wlmiao.service;


import com.wlmiao.exception.EduSysException;

import javax.servlet.http.HttpServletResponse;

public interface IManagerService {

    void importStudentAndDivision(String studentList, Integer classNumber, String grade, HttpServletResponse response)
            throws EduSysException;

    void downloadStudent(String majorNo, String grade, HttpServletResponse response) throws EduSysException;

    void downloadClass(String majorNo, String grade, HttpServletResponse response) throws EduSysException;

    void professionalDiversion(String professionalDiversionTable, Integer classStudentNumber, String grade,
                               HttpServletResponse response) throws EduSysException;

    void distributionTeacher(String teacherList, String majorNo, String grade, Boolean random, HttpServletResponse response)
            throws EduSysException;

    void uploadTrainPlan(String trainPlan, String major, HttpServletResponse response) throws EduSysException;
}
