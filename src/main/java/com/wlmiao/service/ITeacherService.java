package com.wlmiao.service;

import com.wlmiao.bo.TeacherMain;
import com.wlmiao.exception.EduSysException;
import javax.servlet.http.HttpServletResponse;

public interface ITeacherService {

    void downloadCourseStudent(String courseNo, HttpServletResponse response) throws EduSysException;

    void uploadStudentScore(String studentScore, String courseNo, HttpServletResponse response) throws EduSysException;

    void downloadTeacherTimetable(TeacherMain teacherMain, HttpServletResponse response)throws EduSysException;
}
