package com.wlmiao.bo;

import java.util.ArrayList;
import java.util.List;

public class ClassMainExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ClassMainExample() {
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

        public Criteria andClassNoIsNull() {
            addCriterion("class_no is null");
            return (Criteria) this;
        }

        public Criteria andClassNoIsNotNull() {
            addCriterion("class_no is not null");
            return (Criteria) this;
        }

        public Criteria andClassNoEqualTo(String value) {
            addCriterion("class_no =", value, "classNo");
            return (Criteria) this;
        }

        public Criteria andClassNoNotEqualTo(String value) {
            addCriterion("class_no <>", value, "classNo");
            return (Criteria) this;
        }

        public Criteria andClassNoGreaterThan(String value) {
            addCriterion("class_no >", value, "classNo");
            return (Criteria) this;
        }

        public Criteria andClassNoGreaterThanOrEqualTo(String value) {
            addCriterion("class_no >=", value, "classNo");
            return (Criteria) this;
        }

        public Criteria andClassNoLessThan(String value) {
            addCriterion("class_no <", value, "classNo");
            return (Criteria) this;
        }

        public Criteria andClassNoLessThanOrEqualTo(String value) {
            addCriterion("class_no <=", value, "classNo");
            return (Criteria) this;
        }

        public Criteria andClassNoLike(String value) {
            addCriterion("class_no like", value, "classNo");
            return (Criteria) this;
        }

        public Criteria andClassNoNotLike(String value) {
            addCriterion("class_no not like", value, "classNo");
            return (Criteria) this;
        }

        public Criteria andClassNoIn(List<String> values) {
            addCriterion("class_no in", values, "classNo");
            return (Criteria) this;
        }

        public Criteria andClassNoNotIn(List<String> values) {
            addCriterion("class_no not in", values, "classNo");
            return (Criteria) this;
        }

        public Criteria andClassNoBetween(String value1, String value2) {
            addCriterion("class_no between", value1, value2, "classNo");
            return (Criteria) this;
        }

        public Criteria andClassNoNotBetween(String value1, String value2) {
            addCriterion("class_no not between", value1, value2, "classNo");
            return (Criteria) this;
        }

        public Criteria andGradeIsNull() {
            addCriterion("grade is null");
            return (Criteria) this;
        }

        public Criteria andGradeIsNotNull() {
            addCriterion("grade is not null");
            return (Criteria) this;
        }

        public Criteria andGradeEqualTo(String value) {
            addCriterion("grade =", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotEqualTo(String value) {
            addCriterion("grade <>", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThan(String value) {
            addCriterion("grade >", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThanOrEqualTo(String value) {
            addCriterion("grade >=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThan(String value) {
            addCriterion("grade <", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThanOrEqualTo(String value) {
            addCriterion("grade <=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLike(String value) {
            addCriterion("grade like", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotLike(String value) {
            addCriterion("grade not like", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeIn(List<String> values) {
            addCriterion("grade in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotIn(List<String> values) {
            addCriterion("grade not in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeBetween(String value1, String value2) {
            addCriterion("grade between", value1, value2, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotBetween(String value1, String value2) {
            addCriterion("grade not between", value1, value2, "grade");
            return (Criteria) this;
        }

        public Criteria andClassNameIsNull() {
            addCriterion("class_name is null");
            return (Criteria) this;
        }

        public Criteria andClassNameIsNotNull() {
            addCriterion("class_name is not null");
            return (Criteria) this;
        }

        public Criteria andClassNameEqualTo(String value) {
            addCriterion("class_name =", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotEqualTo(String value) {
            addCriterion("class_name <>", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameGreaterThan(String value) {
            addCriterion("class_name >", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameGreaterThanOrEqualTo(String value) {
            addCriterion("class_name >=", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameLessThan(String value) {
            addCriterion("class_name <", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameLessThanOrEqualTo(String value) {
            addCriterion("class_name <=", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameLike(String value) {
            addCriterion("class_name like", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotLike(String value) {
            addCriterion("class_name not like", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameIn(List<String> values) {
            addCriterion("class_name in", values, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotIn(List<String> values) {
            addCriterion("class_name not in", values, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameBetween(String value1, String value2) {
            addCriterion("class_name between", value1, value2, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotBetween(String value1, String value2) {
            addCriterion("class_name not between", value1, value2, "className");
            return (Criteria) this;
        }

        public Criteria andStudentCountIsNull() {
            addCriterion("student_count is null");
            return (Criteria) this;
        }

        public Criteria andStudentCountIsNotNull() {
            addCriterion("student_count is not null");
            return (Criteria) this;
        }

        public Criteria andStudentCountEqualTo(Integer value) {
            addCriterion("student_count =", value, "studentCount");
            return (Criteria) this;
        }

        public Criteria andStudentCountNotEqualTo(Integer value) {
            addCriterion("student_count <>", value, "studentCount");
            return (Criteria) this;
        }

        public Criteria andStudentCountGreaterThan(Integer value) {
            addCriterion("student_count >", value, "studentCount");
            return (Criteria) this;
        }

        public Criteria andStudentCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("student_count >=", value, "studentCount");
            return (Criteria) this;
        }

        public Criteria andStudentCountLessThan(Integer value) {
            addCriterion("student_count <", value, "studentCount");
            return (Criteria) this;
        }

        public Criteria andStudentCountLessThanOrEqualTo(Integer value) {
            addCriterion("student_count <=", value, "studentCount");
            return (Criteria) this;
        }

        public Criteria andStudentCountIn(List<Integer> values) {
            addCriterion("student_count in", values, "studentCount");
            return (Criteria) this;
        }

        public Criteria andStudentCountNotIn(List<Integer> values) {
            addCriterion("student_count not in", values, "studentCount");
            return (Criteria) this;
        }

        public Criteria andStudentCountBetween(Integer value1, Integer value2) {
            addCriterion("student_count between", value1, value2, "studentCount");
            return (Criteria) this;
        }

        public Criteria andStudentCountNotBetween(Integer value1, Integer value2) {
            addCriterion("student_count not between", value1, value2, "studentCount");
            return (Criteria) this;
        }

        public Criteria andHeadTeacherNoIsNull() {
            addCriterion("head_teacher_no is null");
            return (Criteria) this;
        }

        public Criteria andHeadTeacherNoIsNotNull() {
            addCriterion("head_teacher_no is not null");
            return (Criteria) this;
        }

        public Criteria andHeadTeacherNoEqualTo(String value) {
            addCriterion("head_teacher_no =", value, "headTeacherNo");
            return (Criteria) this;
        }

        public Criteria andHeadTeacherNoNotEqualTo(String value) {
            addCriterion("head_teacher_no <>", value, "headTeacherNo");
            return (Criteria) this;
        }

        public Criteria andHeadTeacherNoGreaterThan(String value) {
            addCriterion("head_teacher_no >", value, "headTeacherNo");
            return (Criteria) this;
        }

        public Criteria andHeadTeacherNoGreaterThanOrEqualTo(String value) {
            addCriterion("head_teacher_no >=", value, "headTeacherNo");
            return (Criteria) this;
        }

        public Criteria andHeadTeacherNoLessThan(String value) {
            addCriterion("head_teacher_no <", value, "headTeacherNo");
            return (Criteria) this;
        }

        public Criteria andHeadTeacherNoLessThanOrEqualTo(String value) {
            addCriterion("head_teacher_no <=", value, "headTeacherNo");
            return (Criteria) this;
        }

        public Criteria andHeadTeacherNoLike(String value) {
            addCriterion("head_teacher_no like", value, "headTeacherNo");
            return (Criteria) this;
        }

        public Criteria andHeadTeacherNoNotLike(String value) {
            addCriterion("head_teacher_no not like", value, "headTeacherNo");
            return (Criteria) this;
        }

        public Criteria andHeadTeacherNoIn(List<String> values) {
            addCriterion("head_teacher_no in", values, "headTeacherNo");
            return (Criteria) this;
        }

        public Criteria andHeadTeacherNoNotIn(List<String> values) {
            addCriterion("head_teacher_no not in", values, "headTeacherNo");
            return (Criteria) this;
        }

        public Criteria andHeadTeacherNoBetween(String value1, String value2) {
            addCriterion("head_teacher_no between", value1, value2, "headTeacherNo");
            return (Criteria) this;
        }

        public Criteria andHeadTeacherNoNotBetween(String value1, String value2) {
            addCriterion("head_teacher_no not between", value1, value2, "headTeacherNo");
            return (Criteria) this;
        }

        public Criteria andHeadTeacherNameIsNull() {
            addCriterion("head_teacher_name is null");
            return (Criteria) this;
        }

        public Criteria andHeadTeacherNameIsNotNull() {
            addCriterion("head_teacher_name is not null");
            return (Criteria) this;
        }

        public Criteria andHeadTeacherNameEqualTo(String value) {
            addCriterion("head_teacher_name =", value, "headTeacherName");
            return (Criteria) this;
        }

        public Criteria andHeadTeacherNameNotEqualTo(String value) {
            addCriterion("head_teacher_name <>", value, "headTeacherName");
            return (Criteria) this;
        }

        public Criteria andHeadTeacherNameGreaterThan(String value) {
            addCriterion("head_teacher_name >", value, "headTeacherName");
            return (Criteria) this;
        }

        public Criteria andHeadTeacherNameGreaterThanOrEqualTo(String value) {
            addCriterion("head_teacher_name >=", value, "headTeacherName");
            return (Criteria) this;
        }

        public Criteria andHeadTeacherNameLessThan(String value) {
            addCriterion("head_teacher_name <", value, "headTeacherName");
            return (Criteria) this;
        }

        public Criteria andHeadTeacherNameLessThanOrEqualTo(String value) {
            addCriterion("head_teacher_name <=", value, "headTeacherName");
            return (Criteria) this;
        }

        public Criteria andHeadTeacherNameLike(String value) {
            addCriterion("head_teacher_name like", value, "headTeacherName");
            return (Criteria) this;
        }

        public Criteria andHeadTeacherNameNotLike(String value) {
            addCriterion("head_teacher_name not like", value, "headTeacherName");
            return (Criteria) this;
        }

        public Criteria andHeadTeacherNameIn(List<String> values) {
            addCriterion("head_teacher_name in", values, "headTeacherName");
            return (Criteria) this;
        }

        public Criteria andHeadTeacherNameNotIn(List<String> values) {
            addCriterion("head_teacher_name not in", values, "headTeacherName");
            return (Criteria) this;
        }

        public Criteria andHeadTeacherNameBetween(String value1, String value2) {
            addCriterion("head_teacher_name between", value1, value2, "headTeacherName");
            return (Criteria) this;
        }

        public Criteria andHeadTeacherNameNotBetween(String value1, String value2) {
            addCriterion("head_teacher_name not between", value1, value2, "headTeacherName");
            return (Criteria) this;
        }

        public Criteria andMajorNoIsNull() {
            addCriterion("major_no is null");
            return (Criteria) this;
        }

        public Criteria andMajorNoIsNotNull() {
            addCriterion("major_no is not null");
            return (Criteria) this;
        }

        public Criteria andMajorNoEqualTo(String value) {
            addCriterion("major_no =", value, "majorNo");
            return (Criteria) this;
        }

        public Criteria andMajorNoNotEqualTo(String value) {
            addCriterion("major_no <>", value, "majorNo");
            return (Criteria) this;
        }

        public Criteria andMajorNoGreaterThan(String value) {
            addCriterion("major_no >", value, "majorNo");
            return (Criteria) this;
        }

        public Criteria andMajorNoGreaterThanOrEqualTo(String value) {
            addCriterion("major_no >=", value, "majorNo");
            return (Criteria) this;
        }

        public Criteria andMajorNoLessThan(String value) {
            addCriterion("major_no <", value, "majorNo");
            return (Criteria) this;
        }

        public Criteria andMajorNoLessThanOrEqualTo(String value) {
            addCriterion("major_no <=", value, "majorNo");
            return (Criteria) this;
        }

        public Criteria andMajorNoLike(String value) {
            addCriterion("major_no like", value, "majorNo");
            return (Criteria) this;
        }

        public Criteria andMajorNoNotLike(String value) {
            addCriterion("major_no not like", value, "majorNo");
            return (Criteria) this;
        }

        public Criteria andMajorNoIn(List<String> values) {
            addCriterion("major_no in", values, "majorNo");
            return (Criteria) this;
        }

        public Criteria andMajorNoNotIn(List<String> values) {
            addCriterion("major_no not in", values, "majorNo");
            return (Criteria) this;
        }

        public Criteria andMajorNoBetween(String value1, String value2) {
            addCriterion("major_no between", value1, value2, "majorNo");
            return (Criteria) this;
        }

        public Criteria andMajorNoNotBetween(String value1, String value2) {
            addCriterion("major_no not between", value1, value2, "majorNo");
            return (Criteria) this;
        }

        public Criteria andMajorIsNull() {
            addCriterion("major is null");
            return (Criteria) this;
        }

        public Criteria andMajorIsNotNull() {
            addCriterion("major is not null");
            return (Criteria) this;
        }

        public Criteria andMajorEqualTo(String value) {
            addCriterion("major =", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorNotEqualTo(String value) {
            addCriterion("major <>", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorGreaterThan(String value) {
            addCriterion("major >", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorGreaterThanOrEqualTo(String value) {
            addCriterion("major >=", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorLessThan(String value) {
            addCriterion("major <", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorLessThanOrEqualTo(String value) {
            addCriterion("major <=", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorLike(String value) {
            addCriterion("major like", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorNotLike(String value) {
            addCriterion("major not like", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorIn(List<String> values) {
            addCriterion("major in", values, "major");
            return (Criteria) this;
        }

        public Criteria andMajorNotIn(List<String> values) {
            addCriterion("major not in", values, "major");
            return (Criteria) this;
        }

        public Criteria andMajorBetween(String value1, String value2) {
            addCriterion("major between", value1, value2, "major");
            return (Criteria) this;
        }

        public Criteria andMajorNotBetween(String value1, String value2) {
            addCriterion("major not between", value1, value2, "major");
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