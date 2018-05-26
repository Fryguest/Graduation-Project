package com.wlmiao.bo;

import java.io.Serializable;

public class TeacherMain implements Serializable {
    private Long id;

    private String teacherNo;

    private String teacherName;

    private String sex;

    private String instituteNo;

    private String institute;

    private String title;

    private String nativePlace;

    private String identityNumber;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeacherNo() {
        return teacherNo;
    }

    public void setTeacherNo(String teacherNo) {
        this.teacherNo = teacherNo == null ? null : teacherNo.trim();
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName == null ? null : teacherName.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getInstituteNo() {
        return instituteNo;
    }

    public void setInstituteNo(String instituteNo) {
        this.instituteNo = instituteNo == null ? null : instituteNo.trim();
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute == null ? null : institute.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace == null ? null : nativePlace.trim();
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber == null ? null : identityNumber.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", teacherNo=").append(teacherNo);
        sb.append(", teacherName=").append(teacherName);
        sb.append(", sex=").append(sex);
        sb.append(", instituteNo=").append(instituteNo);
        sb.append(", institute=").append(institute);
        sb.append(", title=").append(title);
        sb.append(", nativePlace=").append(nativePlace);
        sb.append(", identityNumber=").append(identityNumber);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}