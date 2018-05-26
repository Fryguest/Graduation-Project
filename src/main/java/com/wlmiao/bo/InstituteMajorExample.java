package com.wlmiao.bo;

import java.util.ArrayList;
import java.util.List;

public class InstituteMajorExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InstituteMajorExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
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

        public Criteria andInstituteIsNull() {
            addCriterion("institute is null");
            return (Criteria) this;
        }

        public Criteria andInstituteIsNotNull() {
            addCriterion("institute is not null");
            return (Criteria) this;
        }

        public Criteria andInstituteEqualTo(String value) {
            addCriterion("institute =", value, "institute");
            return (Criteria) this;
        }

        public Criteria andInstituteNotEqualTo(String value) {
            addCriterion("institute <>", value, "institute");
            return (Criteria) this;
        }

        public Criteria andInstituteGreaterThan(String value) {
            addCriterion("institute >", value, "institute");
            return (Criteria) this;
        }

        public Criteria andInstituteGreaterThanOrEqualTo(String value) {
            addCriterion("institute >=", value, "institute");
            return (Criteria) this;
        }

        public Criteria andInstituteLessThan(String value) {
            addCriterion("institute <", value, "institute");
            return (Criteria) this;
        }

        public Criteria andInstituteLessThanOrEqualTo(String value) {
            addCriterion("institute <=", value, "institute");
            return (Criteria) this;
        }

        public Criteria andInstituteLike(String value) {
            addCriterion("institute like", value, "institute");
            return (Criteria) this;
        }

        public Criteria andInstituteNotLike(String value) {
            addCriterion("institute not like", value, "institute");
            return (Criteria) this;
        }

        public Criteria andInstituteIn(List<String> values) {
            addCriterion("institute in", values, "institute");
            return (Criteria) this;
        }

        public Criteria andInstituteNotIn(List<String> values) {
            addCriterion("institute not in", values, "institute");
            return (Criteria) this;
        }

        public Criteria andInstituteBetween(String value1, String value2) {
            addCriterion("institute between", value1, value2, "institute");
            return (Criteria) this;
        }

        public Criteria andInstituteNotBetween(String value1, String value2) {
            addCriterion("institute not between", value1, value2, "institute");
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