package com.wlmiao.bo;

import java.io.Serializable;

public class ClassMain implements Serializable {
    private Long id;

    private String classNo;

    private String grade;

    private String className;

    private Integer studentCount;

    private String headTeacherNo;

    private String headTeacherName;

    private String majorNo;

    private String major;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClassNo() {
        return classNo;
    }

    public void setClassNo(String classNo) {
        this.classNo = classNo == null ? null : classNo.trim();
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade == null ? null : grade.trim();
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    public Integer getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(Integer studentCount) {
        this.studentCount = studentCount;
    }

    public String getHeadTeacherNo() {
        return headTeacherNo;
    }

    public void setHeadTeacherNo(String headTeacherNo) {
        this.headTeacherNo = headTeacherNo == null ? null : headTeacherNo.trim();
    }

    public String getHeadTeacherName() {
        return headTeacherName;
    }

    public void setHeadTeacherName(String headTeacherName) {
        this.headTeacherName = headTeacherName == null ? null : headTeacherName.trim();
    }

    public String getMajorNo() {
        return majorNo;
    }

    public void setMajorNo(String majorNo) {
        this.majorNo = majorNo == null ? null : majorNo.trim();
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", classNo=").append(classNo);
        sb.append(", grade=").append(grade);
        sb.append(", className=").append(className);
        sb.append(", studentCount=").append(studentCount);
        sb.append(", headTeacherNo=").append(headTeacherNo);
        sb.append(", headTeacherName=").append(headTeacherName);
        sb.append(", majorNo=").append(majorNo);
        sb.append(", major=").append(major);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}