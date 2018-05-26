package com.wlmiao.bo;

import java.io.Serializable;
import java.util.Date;

public class CourseMain implements Serializable {
    private Long id;

    private String courseNo;

    private String courseName;

    private String teacherNo;

    private String instituteNo;

    private Integer credit;

    private Byte isExamation;

    private Date examationTime;

    private String examationPlace;

    private String examationInvigilator;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(String courseNo) {
        this.courseNo = courseNo == null ? null : courseNo.trim();
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName == null ? null : courseName.trim();
    }

    public String getTeacherNo() {
        return teacherNo;
    }

    public void setTeacherNo(String teacherNo) {
        this.teacherNo = teacherNo == null ? null : teacherNo.trim();
    }

    public String getInstituteNo() {
        return instituteNo;
    }

    public void setInstituteNo(String instituteNo) {
        this.instituteNo = instituteNo == null ? null : instituteNo.trim();
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public Byte getIsExamation() {
        return isExamation;
    }

    public void setIsExamation(Byte isExamation) {
        this.isExamation = isExamation;
    }

    public Date getExamationTime() {
        return examationTime;
    }

    public void setExamationTime(Date examationTime) {
        this.examationTime = examationTime;
    }

    public String getExamationPlace() {
        return examationPlace;
    }

    public void setExamationPlace(String examationPlace) {
        this.examationPlace = examationPlace == null ? null : examationPlace.trim();
    }

    public String getExamationInvigilator() {
        return examationInvigilator;
    }

    public void setExamationInvigilator(String examationInvigilator) {
        this.examationInvigilator = examationInvigilator == null ? null : examationInvigilator.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", courseNo=").append(courseNo);
        sb.append(", courseName=").append(courseName);
        sb.append(", teacherNo=").append(teacherNo);
        sb.append(", instituteNo=").append(instituteNo);
        sb.append(", credit=").append(credit);
        sb.append(", isExamation=").append(isExamation);
        sb.append(", examationTime=").append(examationTime);
        sb.append(", examationPlace=").append(examationPlace);
        sb.append(", examationInvigilator=").append(examationInvigilator);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}