package com.wlmiao.bo;

import java.io.Serializable;

public class CourseStudent implements Serializable {
    private Long id;

    private String studentNo;

    private String courseNo;

    private Integer score;

    private Integer makeUp;

    private Byte isRework;

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

    public Integer getMakeUp() {
        return makeUp;
    }

    public void setMakeUp(Integer makeUp) {
        this.makeUp = makeUp;
    }

    public Byte getIsRework() {
        return isRework;
    }

    public void setIsRework(Byte isRework) {
        this.isRework = isRework;
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
        sb.append(", makeUp=").append(makeUp);
        sb.append(", isRework=").append(isRework);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}