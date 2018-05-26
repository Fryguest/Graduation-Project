package com.wlmiao.service;


import com.wlmiao.exception.EduSysException;
import javax.servlet.http.HttpServletResponse;

public interface IManagerService {

    void importStudentAndDivision(String studentList, Integer classNumber, String grade, HttpServletResponse response)
        throws EduSysException;
}
