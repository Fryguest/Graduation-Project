package com.wlmiao.bo;

import java.io.Serializable;

public class StudentScore implements Serializable {
    private Long id;

    private String studentNo;

    private String courseNo;

    private Integer score;

    private String rework;

    private String supplementaryExamination;

    private String confirm;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo == null ? null : studentNo.trim();
    }

    public String getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(String courseNo) {
        this.courseNo = courseNo == null ? null : courseNo.trim();
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getRework() {
        return rework;
    }

    public void setRework(String rework) {
        this.rework = rework == null ? null : rework.trim();
    }

    public String getSupplementaryExamination() {
        return supplementaryExamination;
    }

    public void setSupplementaryExamination(String supplementaryExamination) {
        this.supplementaryExamination = supplementaryExamination == null ? null : supplementaryExamination.trim();
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm == null ? null : confirm.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", studentNo=").append(studentNo);
        sb.append(", courseNo=").append(courseNo);
        sb.append(", score=").append(score);
        sb.append(", rework=").append(rework);
        sb.append(", supplementaryExamination=").append(supplementaryExamination);
        sb.append(", confirm=").append(confirm);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}