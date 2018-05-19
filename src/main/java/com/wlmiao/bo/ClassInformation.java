package com.wlmiao.bo;

import java.io.Serializable;

public class ClassInformation implements Serializable {
    private Long id;

    private String classNo;

    private String grade;

    private String className;

    private String simplyName;

    private Integer studentCount;

    private String headTeacher;

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

    public String getSimplyName() {
        return simplyName;
    }

    public void setSimplyName(String simplyName) {
        this.simplyName = simplyName == null ? null : simplyName.trim();
    }

    public Integer getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(Integer studentCount) {
        this.studentCount = studentCount;
    }

    public String getHeadTeacher() {
        return headTeacher;
    }

    public void setHeadTeacher(String headTeacher) {
        this.headTeacher = headTeacher == null ? null : headTeacher.trim();
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
        sb.append(", simplyName=").append(simplyName);
        sb.append(", studentCount=").append(studentCount);
        sb.append(", headTeacher=").append(headTeacher);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}