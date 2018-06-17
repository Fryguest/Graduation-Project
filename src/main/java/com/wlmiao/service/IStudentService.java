package com.wlmiao.service;

import com.wlmiao.bo.StudentMain;
import com.wlmiao.exception.EduSysException;
import javax.servlet.http.HttpServletResponse;

public interface IStudentService {

    void checkGPA(StudentMain studentMain, HttpServletResponse response) throws EduSysException;

    void courseChosen(StudentMain studentMain, String courseChosen, HttpServletResponse response)
        throws EduSysException;

    void downloadCourseChosenTable(StudentMain studentMain, HttpServletResponse response) throws EduSysException;


    void downloadStudentTimetable(StudentMain studentMain, HttpServletResponse response) throws EduSysException;
}
