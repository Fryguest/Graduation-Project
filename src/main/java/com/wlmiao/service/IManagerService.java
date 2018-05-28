package com.wlmiao.service;


import com.wlmiao.exception.EduSysException;
import javax.servlet.http.HttpServletResponse;

public interface IManagerService {

    void importStudentAndDivision(String studentList, Integer classNumber, String grade, HttpServletResponse response)
        throws EduSysException;

    void downloadStudent(String majorNo, String grade, HttpServletResponse response) throws EduSysException;

    void professionalDiversion(String professionalDiversionTable, HttpServletResponse response) throws EduSysException;
}
