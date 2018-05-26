package com.wlmiao.bo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CourseMainExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CourseMainExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCourseNoIsNull() {
            addCriterion("course_no is null");
            return (Criteria) this;
        }

        public Criteria andCourseNoIsNotNull() {
            addCriterion("course_no is not null");
            return (Criteria) this;
        }

        public Criteria andCourseNoEqualTo(String value) {
            addCriterion("course_no =", value, "courseNo");
            return (Criteria) this;
        }

        public Criteria andCourseNoNotEqualTo(String value) {
            addCriterion("course_no <>", value, "courseNo");
            return (Criteria) this;
        }

        public Criteria andCourseNoGreaterThan(String value) {
            addCriterion("course_no >", value, "courseNo");
            return (Criteria) this;
        }

        public Criteria andCourseNoGreaterThanOrEqualTo(String value) {
            addCriterion("course_no >=", value, "courseNo");
            return (Criteria) this;
        }

        public Criteria andCourseNoLessThan(String value) {
            addCriterion("course_no <", value, "courseNo");
            return (Criteria) this;
        }

        public Criteria andCourseNoLessThanOrEqualTo(String value) {
            addCriterion("course_no <=", value, "courseNo");
            return (Criteria) this;
        }

        public Criteria andCourseNoLike(String value) {
            addCriterion("course_no like", value, "courseNo");
            return (Criteria) this;
        }

        public Criteria andCourseNoNotLike(String value) {
            addCriterion("course_no not like", value, "courseNo");
            return (Criteria) this;
        }

        public Criteria andCourseNoIn(List<String> values) {
            addCriterion("course_no in", values, "courseNo");
            return (Criteria) this;
        }

        public Criteria andCourseNoNotIn(List<String> values) {
            addCriterion("course_no not in", values, "courseNo");
            return (Criteria) this;
        }

        public Criteria andCourseNoBetween(String value1, String value2) {
            addCriterion("course_no between", value1, value2, "courseNo");
            return (Criteria) this;
        }

        public Criteria andCourseNoNotBetween(String value1, String value2) {
            addCriterion("course_no not between", value1, value2, "courseNo");
            return (Criteria) this;
        }

        public Criteria andCourseNameIsNull() {
            addCriterion("course_name is null");
            return (Criteria) this;
        }

        public Criteria andCourseNameIsNotNull() {
            addCriterion("course_name is not null");
            return (Criteria) this;
        }

        public Criteria andCourseNameEqualTo(String value) {
            addCriterion("course_name =", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotEqualTo(String value) {
            addCriterion("course_name <>", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameGreaterThan(String value) {
            addCriterion("course_name >", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameGreaterThanOrEqualTo(String value) {
            addCriterion("course_name >=", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameLessThan(String value) {
            addCriterion("course_name <", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameLessThanOrEqualTo(String value) {
            addCriterion("course_name <=", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameLike(String value) {
            addCriterion("course_name like", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotLike(String value) {
            addCriterion("course_name not like", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameIn(List<String> values) {
            addCriterion("course_name in", values, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotIn(List<String> values) {
            addCriterion("course_name not in", values, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameBetween(String value1, String value2) {
            addCriterion("course_name between", value1, value2, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotBetween(String value1, String value2) {
            addCriterion("course_name not between", value1, value2, "courseName");
            return (Criteria) this;
        }

        public Criteria andTeacherNoIsNull() {
            addCriterion("teacher_no is null");
            return (Criteria) this;
        }

        public Criteria andTeacherNoIsNotNull() {
            addCriterion("teacher_no is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherNoEqualTo(String value) {
            addCriterion("teacher_no =", value, "teacherNo");
            return (Criteria) this;
        }

        public Criteria andTeacherNoNotEqualTo(String value) {
            addCriterion("teacher_no <>", value, "teacherNo");
            return (Criteria) this;
        }

        public Criteria andTeacherNoGreaterThan(String value) {
            addCriterion("teacher_no >", value, "teacherNo");
            return (Criteria) this;
        }

        public Criteria andTeacherNoGreaterThanOrEqualTo(String value) {
            addCriterion("teacher_no >=", value, "teacherNo");
            return (Criteria) this;
        }

        public Criteria andTeacherNoLessThan(String value) {
            addCriterion("teacher_no <", value, "teacherNo");
            return (Criteria) this;
        }

        public Criteria andTeacherNoLessThanOrEqualTo(String value) {
            addCriterion("teacher_no <=", value, "teacherNo");
            return (Criteria) this;
        }

        public Criteria andTeacherNoLike(String value) {
            addCriterion("teacher_no like", value, "teacherNo");
            return (Criteria) this;
        }

        public Criteria andTeacherNoNotLike(String value) {
            addCriterion("teacher_no not like", value, "teacherNo");
            return (Criteria) this;
        }

        public Criteria andTeacherNoIn(List<String> values) {
            addCriterion("teacher_no in", values, "teacherNo");
            return (Criteria) this;
        }

        public Criteria andTeacherNoNotIn(List<String> values) {
            addCriterion("teacher_no not in", values, "teacherNo");
            return (Criteria) this;
        }

        public Criteria andTeacherNoBetween(String value1, String value2) {
            addCriterion("teacher_no between", value1, value2, "teacherNo");
            return (Criteria) this;
        }

        public Criteria andTeacherNoNotBetween(String value1, String value2) {
            addCriterion("teacher_no not between", value1, value2, "teacherNo");
            return (Criteria) this;
        }

        public Criteria andInstituteNoIsNull() {
            addCriterion("institute_no is null");
            return (Criteria) this;
        }

        public Criteria andInstituteNoIsNotNull() {
            addCriterion("institute_no is not null");
            return (Criteria) this;
        }

        public Criteria andInstituteNoEqualTo(String value) {
            addCriterion("institute_no =", value, "instituteNo");
            return (Criteria) this;
        }

        public Criteria andInstituteNoNotEqualTo(String value) {
            addCriterion("institute_no <>", value, "instituteNo");
            return (Criteria) this;
        }

        public Criteria andInstituteNoGreaterThan(String value) {
            addCriterion("institute_no >", value, "instituteNo");
            return (Criteria) this;
        }

        public Criteria andInstituteNoGreaterThanOrEqualTo(String value) {
            addCriterion("institute_no >=", value, "instituteNo");
            return (Criteria) this;
        }

        public Criteria andInstituteNoLessThan(String value) {
            addCriterion("institute_no <", value, "instituteNo");
            return (Criteria) this;
        }

        public Criteria andInstituteNoLessThanOrEqualTo(String value) {
            addCriterion("institute_no <=", value, "instituteNo");
            return (Criteria) this;
        }

        public Criteria andInstituteNoLike(String value) {
            addCriterion("institute_no like", value, "instituteNo");
            return (Criteria) this;
        }

        public Criteria andInstituteNoNotLike(String value) {
            addCriterion("institute_no not like", value, "instituteNo");
            return (Criteria) this;
        }

        public Criteria andInstituteNoIn(List<String> values) {
            addCriterion("institute_no in", values, "instituteNo");
            return (Criteria) this;
        }

        public Criteria andInstituteNoNotIn(List<String> values) {
            addCriterion("institute_no not in", values, "instituteNo");
            return (Criteria) this;
        }

        public Criteria andInstituteNoBetween(String value1, String value2) {
            addCriterion("institute_no between", value1, value2, "instituteNo");
            return (Criteria) this;
        }

        public Criteria andInstituteNoNotBetween(String value1, String value2) {
            addCriterion("institute_no not between", value1, value2, "instituteNo");
            return (Criteria) this;
        }

        public Criteria andCreditIsNull() {
            addCriterion("credit is null");
            return (Criteria) this;
        }

        public Criteria andCreditIsNotNull() {
            addCriterion("credit is not null");
            return (Criteria) this;
        }

        public Criteria andCreditEqualTo(Integer value) {
            addCriterion("credit =", value, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditNotEqualTo(Integer value) {
            addCriterion("credit <>", value, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditGreaterThan(Integer value) {
            addCriterion("credit >", value, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditGreaterThanOrEqualTo(Integer value) {
            addCriterion("credit >=", value, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditLessThan(Integer value) {
            addCriterion("credit <", value, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditLessThanOrEqualTo(Integer value) {
            addCriterion("credit <=", value, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditIn(List<Integer> values) {
            addCriterion("credit in", values, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditNotIn(List<Integer> values) {
            addCriterion("credit not in", values, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditBetween(Integer value1, Integer value2) {
            addCriterion("credit between", value1, value2, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditNotBetween(Integer value1, Integer value2) {
            addCriterion("credit not between", value1, value2, "credit");
            return (Criteria) this;
        }

        public Criteria andIsExamationIsNull() {
            addCriterion("is_examation is null");
            return (Criteria) this;
        }

        public Criteria andIsExamationIsNotNull() {
            addCriterion("is_examation is not null");
            return (Criteria) this;
        }

        public Criteria andIsExamationEqualTo(Byte value) {
            addCriterion("is_examation =", value, "isExamation");
            return (Criteria) this;
        }

        public Criteria andIsExamationNotEqualTo(Byte value) {
            addCriterion("is_examation <>", value, "isExamation");
            return (Criteria) this;
        }

        public Criteria andIsExamationGreaterThan(Byte value) {
            addCriterion("is_examation >", value, "isExamation");
            return (Criteria) this;
        }

        public Criteria andIsExamationGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_examation >=", value, "isExamation");
            return (Criteria) this;
        }

        public Criteria andIsExamationLessThan(Byte value) {
            addCriterion("is_examation <", value, "isExamation");
            return (Criteria) this;
        }

        public Criteria andIsExamationLessThanOrEqualTo(Byte value) {
            addCriterion("is_examation <=", value, "isExamation");
            return (Criteria) this;
        }

        public Criteria andIsExamationIn(List<Byte> values) {
            addCriterion("is_examation in", values, "isExamation");
            return (Criteria) this;
        }

        public Criteria andIsExamationNotIn(List<Byte> values) {
            addCriterion("is_examation not in", values, "isExamation");
            return (Criteria) this;
        }

        public Criteria andIsExamationBetween(Byte value1, Byte value2) {
            addCriterion("is_examation between", value1, value2, "isExamation");
            return (Criteria) this;
        }

        public Criteria andIsExamationNotBetween(Byte value1, Byte value2) {
            addCriterion("is_examation not between", value1, value2, "isExamation");
            return (Criteria) this;
        }

        public Criteria andExamationTimeIsNull() {
            addCriterion("examation_time is null");
            return (Criteria) this;
        }

        public Criteria andExamationTimeIsNotNull() {
            addCriterion("examation_time is not null");
            return (Criteria) this;
        }

        public Criteria andExamationTimeEqualTo(Date value) {
            addCriterion("examation_time =", value, "examationTime");
            return (Criteria) this;
        }

        public Criteria andExamationTimeNotEqualTo(Date value) {
            addCriterion("examation_time <>", value, "examationTime");
            return (Criteria) this;
        }

        public Criteria andExamationTimeGreaterThan(Date value) {
            addCriterion("examation_time >", value, "examationTime");
            return (Criteria) this;
        }

        public Criteria andExamationTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("examation_time >=", value, "examationTime");
            return (Criteria) this;
        }

        public Criteria andExamationTimeLessThan(Date value) {
            addCriterion("examation_time <", value, "examationTime");
            return (Criteria) this;
        }

        public Criteria andExamationTimeLessThanOrEqualTo(Date value) {
            addCriterion("examation_time <=", value, "examationTime");
            return (Criteria) this;
        }

        public Criteria andExamationTimeIn(List<Date> values) {
            addCriterion("examation_time in", values, "examationTime");
            return (Criteria) this;
        }

        public Criteria andExamationTimeNotIn(List<Date> values) {
            addCriterion("examation_time not in", values, "examationTime");
            return (Criteria) this;
        }

        public Criteria andExamationTimeBetween(Date value1, Date value2) {
            addCriterion("examation_time between", value1, value2, "examationTime");
            return (Criteria) this;
        }

        public Criteria andExamationTimeNotBetween(Date value1, Date value2) {
            addCriterion("examation_time not between", value1, value2, "examationTime");
            return (Criteria) this;
        }

        public Criteria andExamationPlaceIsNull() {
            addCriterion("examation_place is null");
            return (Criteria) this;
        }

        public Criteria andExamationPlaceIsNotNull() {
            addCriterion("examation_place is not null");
            return (Criteria) this;
        }

        public Criteria andExamationPlaceEqualTo(String value) {
            addCriterion("examation_place =", value, "examationPlace");
            return (Criteria) this;
        }

        public Criteria andExamationPlaceNotEqualTo(String value) {
            addCriterion("examation_place <>", value, "examationPlace");
            return (Criteria) this;
        }

        public Criteria andExamationPlaceGreaterThan(String value) {
            addCriterion("examation_place >", value, "examationPlace");
            return (Criteria) this;
        }

        public Criteria andExamationPlaceGreaterThanOrEqualTo(String value) {
            addCriterion("examation_place >=", value, "examationPlace");
            return (Criteria) this;
        }

        public Criteria andExamationPlaceLessThan(String value) {
            addCriterion("examation_place <", value, "examationPlace");
            return (Criteria) this;
        }

        public Criteria andExamationPlaceLessThanOrEqualTo(String value) {
            addCriterion("examation_place <=", value, "examationPlace");
            return (Criteria) this;
        }

        public Criteria andExamationPlaceLike(String value) {
            addCriterion("examation_place like", value, "examationPlace");
            return (Criteria) this;
        }

        public Criteria andExamationPlaceNotLike(String value) {
            addCriterion("examation_place not like", value, "examationPlace");
            return (Criteria) this;
        }

        public Criteria andExamationPlaceIn(List<String> values) {
            addCriterion("examation_place in", values, "examationPlace");
            return (Criteria) this;
        }

        public Criteria andExamationPlaceNotIn(List<String> values) {
            addCriterion("examation_place not in", values, "examationPlace");
            return (Criteria) this;
        }

        public Criteria andExamationPlaceBetween(String value1, String value2) {
            addCriterion("examation_place between", value1, value2, "examationPlace");
            return (Criteria) this;
        }

        public Criteria andExamationPlaceNotBetween(String value1, String value2) {
            addCriterion("examation_place not between", value1, value2, "examationPlace");
            return (Criteria) this;
        }

        public Criteria andExamationInvigilatorIsNull() {
            addCriterion("examation_invigilator is null");
            return (Criteria) this;
        }

        public Criteria andExamationInvigilatorIsNotNull() {
            addCriterion("examation_invigilator is not null");
            return (Criteria) this;
        }

        public Criteria andExamationInvigilatorEqualTo(String value) {
            addCriterion("examation_invigilator =", value, "examationInvigilator");
            return (Criteria) this;
        }

        public Criteria andExamationInvigilatorNotEqualTo(String value) {
            addCriterion("examation_invigilator <>", value, "examationInvigilator");
            return (Criteria) this;
        }

        public Criteria andExamationInvigilatorGreaterThan(String value) {
            addCriterion("examation_invigilator >", value, "examationInvigilator");
            return (Criteria) this;
        }

        public Criteria andExamationInvigilatorGreaterThanOrEqualTo(String value) {
            addCriterion("examation_invigilator >=", value, "examationInvigilator");
            return (Criteria) this;
        }

        public Criteria andExamationInvigilatorLessThan(String value) {
            addCriterion("examation_invigilator <", value, "examationInvigilator");
            return (Criteria) this;
        }

        public Criteria andExamationInvigilatorLessThanOrEqualTo(String value) {
            addCriterion("examation_invigilator <=", value, "examationInvigilator");
            return (Criteria) this;
        }

        public Criteria andExamationInvigilatorLike(String value) {
            addCriterion("examation_invigilator like", value, "examationInvigilator");
            return (Criteria) this;
        }

        public Criteria andExamationInvigilatorNotLike(String value) {
            addCriterion("examation_invigilator not like", value, "examationInvigilator");
            return (Criteria) this;
        }

        public Criteria andExamationInvigilatorIn(List<String> values) {
            addCriterion("examation_invigilator in", values, "examationInvigilator");
            return (Criteria) this;
        }

        public Criteria andExamationInvigilatorNotIn(List<String> values) {
            addCriterion("examation_invigilator not in", values, "examationInvigilator");
            return (Criteria) this;
        }

        public Criteria andExamationInvigilatorBetween(String value1, String value2) {
            addCriterion("examation_invigilator between", value1, value2, "examationInvigilator");
            return (Criteria) this;
        }

        public Criteria andExamationInvigilatorNotBetween(String value1, String value2) {
            addCriterion("examation_invigilator not between", value1, value2, "examationInvigilator");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}