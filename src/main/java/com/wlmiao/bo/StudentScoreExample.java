package com.wlmiao.bo;

import java.util.ArrayList;
import java.util.List;

public class StudentScoreExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StudentScoreExample() {
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

        public Criteria andStudentNoIsNull() {
            addCriterion("student_no is null");
            return (Criteria) this;
        }

        public Criteria andStudentNoIsNotNull() {
            addCriterion("student_no is not null");
            return (Criteria) this;
        }

        public Criteria andStudentNoEqualTo(String value) {
            addCriterion("student_no =", value, "studentNo");
            return (Criteria) this;
        }

        public Criteria andStudentNoNotEqualTo(String value) {
            addCriterion("student_no <>", value, "studentNo");
            return (Criteria) this;
        }

        public Criteria andStudentNoGreaterThan(String value) {
            addCriterion("student_no >", value, "studentNo");
            return (Criteria) this;
        }

        public Criteria andStudentNoGreaterThanOrEqualTo(String value) {
            addCriterion("student_no >=", value, "studentNo");
            return (Criteria) this;
        }

        public Criteria andStudentNoLessThan(String value) {
            addCriterion("student_no <", value, "studentNo");
            return (Criteria) this;
        }

        public Criteria andStudentNoLessThanOrEqualTo(String value) {
            addCriterion("student_no <=", value, "studentNo");
            return (Criteria) this;
        }

        public Criteria andStudentNoLike(String value) {
            addCriterion("student_no like", value, "studentNo");
            return (Criteria) this;
        }

        public Criteria andStudentNoNotLike(String value) {
            addCriterion("student_no not like", value, "studentNo");
            return (Criteria) this;
        }

        public Criteria andStudentNoIn(List<String> values) {
            addCriterion("student_no in", values, "studentNo");
            return (Criteria) this;
        }

        public Criteria andStudentNoNotIn(List<String> values) {
            addCriterion("student_no not in", values, "studentNo");
            return (Criteria) this;
        }

        public Criteria andStudentNoBetween(String value1, String value2) {
            addCriterion("student_no between", value1, value2, "studentNo");
            return (Criteria) this;
        }

        public Criteria andStudentNoNotBetween(String value1, String value2) {
            addCriterion("student_no not between", value1, value2, "studentNo");
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

        public Criteria andScoreIsNull() {
            addCriterion("score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(Integer value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(Integer value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(Integer value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(Integer value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(Integer value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<Integer> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<Integer> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(Integer value1, Integer value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("score not between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andReworkIsNull() {
            addCriterion("rework is null");
            return (Criteria) this;
        }

        public Criteria andReworkIsNotNull() {
            addCriterion("rework is not null");
            return (Criteria) this;
        }

        public Criteria andReworkEqualTo(String value) {
            addCriterion("rework =", value, "rework");
            return (Criteria) this;
        }

        public Criteria andReworkNotEqualTo(String value) {
            addCriterion("rework <>", value, "rework");
            return (Criteria) this;
        }

        public Criteria andReworkGreaterThan(String value) {
            addCriterion("rework >", value, "rework");
            return (Criteria) this;
        }

        public Criteria andReworkGreaterThanOrEqualTo(String value) {
            addCriterion("rework >=", value, "rework");
            return (Criteria) this;
        }

        public Criteria andReworkLessThan(String value) {
            addCriterion("rework <", value, "rework");
            return (Criteria) this;
        }

        public Criteria andReworkLessThanOrEqualTo(String value) {
            addCriterion("rework <=", value, "rework");
            return (Criteria) this;
        }

        public Criteria andReworkLike(String value) {
            addCriterion("rework like", value, "rework");
            return (Criteria) this;
        }

        public Criteria andReworkNotLike(String value) {
            addCriterion("rework not like", value, "rework");
            return (Criteria) this;
        }

        public Criteria andReworkIn(List<String> values) {
            addCriterion("rework in", values, "rework");
            return (Criteria) this;
        }

        public Criteria andReworkNotIn(List<String> values) {
            addCriterion("rework not in", values, "rework");
            return (Criteria) this;
        }

        public Criteria andReworkBetween(String value1, String value2) {
            addCriterion("rework between", value1, value2, "rework");
            return (Criteria) this;
        }

        public Criteria andReworkNotBetween(String value1, String value2) {
            addCriterion("rework not between", value1, value2, "rework");
            return (Criteria) this;
        }

        public Criteria andSupplementaryExaminationIsNull() {
            addCriterion("supplementary_examination is null");
            return (Criteria) this;
        }

        public Criteria andSupplementaryExaminationIsNotNull() {
            addCriterion("supplementary_examination is not null");
            return (Criteria) this;
        }

        public Criteria andSupplementaryExaminationEqualTo(String value) {
            addCriterion("supplementary_examination =", value, "supplementaryExamination");
            return (Criteria) this;
        }

        public Criteria andSupplementaryExaminationNotEqualTo(String value) {
            addCriterion("supplementary_examination <>", value, "supplementaryExamination");
            return (Criteria) this;
        }

        public Criteria andSupplementaryExaminationGreaterThan(String value) {
            addCriterion("supplementary_examination >", value, "supplementaryExamination");
            return (Criteria) this;
        }

        public Criteria andSupplementaryExaminationGreaterThanOrEqualTo(String value) {
            addCriterion("supplementary_examination >=", value, "supplementaryExamination");
            return (Criteria) this;
        }

        public Criteria andSupplementaryExaminationLessThan(String value) {
            addCriterion("supplementary_examination <", value, "supplementaryExamination");
            return (Criteria) this;
        }

        public Criteria andSupplementaryExaminationLessThanOrEqualTo(String value) {
            addCriterion("supplementary_examination <=", value, "supplementaryExamination");
            return (Criteria) this;
        }

        public Criteria andSupplementaryExaminationLike(String value) {
            addCriterion("supplementary_examination like", value, "supplementaryExamination");
            return (Criteria) this;
        }

        public Criteria andSupplementaryExaminationNotLike(String value) {
            addCriterion("supplementary_examination not like", value, "supplementaryExamination");
            return (Criteria) this;
        }

        public Criteria andSupplementaryExaminationIn(List<String> values) {
            addCriterion("supplementary_examination in", values, "supplementaryExamination");
            return (Criteria) this;
        }

        public Criteria andSupplementaryExaminationNotIn(List<String> values) {
            addCriterion("supplementary_examination not in", values, "supplementaryExamination");
            return (Criteria) this;
        }

        public Criteria andSupplementaryExaminationBetween(String value1, String value2) {
            addCriterion("supplementary_examination between", value1, value2, "supplementaryExamination");
            return (Criteria) this;
        }

        public Criteria andSupplementaryExaminationNotBetween(String value1, String value2) {
            addCriterion("supplementary_examination not between", value1, value2, "supplementaryExamination");
            return (Criteria) this;
        }

        public Criteria andConfirmIsNull() {
            addCriterion("confirm is null");
            return (Criteria) this;
        }

        public Criteria andConfirmIsNotNull() {
            addCriterion("confirm is not null");
            return (Criteria) this;
        }

        public Criteria andConfirmEqualTo(String value) {
            addCriterion("confirm =", value, "confirm");
            return (Criteria) this;
        }

        public Criteria andConfirmNotEqualTo(String value) {
            addCriterion("confirm <>", value, "confirm");
            return (Criteria) this;
        }

        public Criteria andConfirmGreaterThan(String value) {
            addCriterion("confirm >", value, "confirm");
            return (Criteria) this;
        }

        public Criteria andConfirmGreaterThanOrEqualTo(String value) {
            addCriterion("confirm >=", value, "confirm");
            return (Criteria) this;
        }

        public Criteria andConfirmLessThan(String value) {
            addCriterion("confirm <", value, "confirm");
            return (Criteria) this;
        }

        public Criteria andConfirmLessThanOrEqualTo(String value) {
            addCriterion("confirm <=", value, "confirm");
            return (Criteria) this;
        }

        public Criteria andConfirmLike(String value) {
            addCriterion("confirm like", value, "confirm");
            return (Criteria) this;
        }

        public Criteria andConfirmNotLike(String value) {
            addCriterion("confirm not like", value, "confirm");
            return (Criteria) this;
        }

        public Criteria andConfirmIn(List<String> values) {
            addCriterion("confirm in", values, "confirm");
            return (Criteria) this;
        }

        public Criteria andConfirmNotIn(List<String> values) {
            addCriterion("confirm not in", values, "confirm");
            return (Criteria) this;
        }

        public Criteria andConfirmBetween(String value1, String value2) {
            addCriterion("confirm between", value1, value2, "confirm");
            return (Criteria) this;
        }

        public Criteria andConfirmNotBetween(String value1, String value2) {
            addCriterion("confirm not between", value1, value2, "confirm");
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