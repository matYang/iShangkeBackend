package com.ishangke.edunav.dataaccess.model.gen;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CourseTemplateClassPhotoEntityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CourseTemplateClassPhotoEntityExample() {
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
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCourseTemplateIdIsNull() {
            addCriterion("COURSE_TEMPLATE_ID is null");
            return (Criteria) this;
        }

        public Criteria andCourseTemplateIdIsNotNull() {
            addCriterion("COURSE_TEMPLATE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCourseTemplateIdEqualTo(Integer value) {
            addCriterion("COURSE_TEMPLATE_ID =", value, "courseTemplateId");
            return (Criteria) this;
        }

        public Criteria andCourseTemplateIdNotEqualTo(Integer value) {
            addCriterion("COURSE_TEMPLATE_ID <>", value, "courseTemplateId");
            return (Criteria) this;
        }

        public Criteria andCourseTemplateIdGreaterThan(Integer value) {
            addCriterion("COURSE_TEMPLATE_ID >", value, "courseTemplateId");
            return (Criteria) this;
        }

        public Criteria andCourseTemplateIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("COURSE_TEMPLATE_ID >=", value, "courseTemplateId");
            return (Criteria) this;
        }

        public Criteria andCourseTemplateIdLessThan(Integer value) {
            addCriterion("COURSE_TEMPLATE_ID <", value, "courseTemplateId");
            return (Criteria) this;
        }

        public Criteria andCourseTemplateIdLessThanOrEqualTo(Integer value) {
            addCriterion("COURSE_TEMPLATE_ID <=", value, "courseTemplateId");
            return (Criteria) this;
        }

        public Criteria andCourseTemplateIdIn(List<Integer> values) {
            addCriterion("COURSE_TEMPLATE_ID in", values, "courseTemplateId");
            return (Criteria) this;
        }

        public Criteria andCourseTemplateIdNotIn(List<Integer> values) {
            addCriterion("COURSE_TEMPLATE_ID not in", values, "courseTemplateId");
            return (Criteria) this;
        }

        public Criteria andCourseTemplateIdBetween(Integer value1, Integer value2) {
            addCriterion("COURSE_TEMPLATE_ID between", value1, value2, "courseTemplateId");
            return (Criteria) this;
        }

        public Criteria andCourseTemplateIdNotBetween(Integer value1, Integer value2) {
            addCriterion("COURSE_TEMPLATE_ID not between", value1, value2, "courseTemplateId");
            return (Criteria) this;
        }

        public Criteria andClassPhotoIdIsNull() {
            addCriterion("CLASS_PHOTO_ID is null");
            return (Criteria) this;
        }

        public Criteria andClassPhotoIdIsNotNull() {
            addCriterion("CLASS_PHOTO_ID is not null");
            return (Criteria) this;
        }

        public Criteria andClassPhotoIdEqualTo(Integer value) {
            addCriterion("CLASS_PHOTO_ID =", value, "classPhotoId");
            return (Criteria) this;
        }

        public Criteria andClassPhotoIdNotEqualTo(Integer value) {
            addCriterion("CLASS_PHOTO_ID <>", value, "classPhotoId");
            return (Criteria) this;
        }

        public Criteria andClassPhotoIdGreaterThan(Integer value) {
            addCriterion("CLASS_PHOTO_ID >", value, "classPhotoId");
            return (Criteria) this;
        }

        public Criteria andClassPhotoIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("CLASS_PHOTO_ID >=", value, "classPhotoId");
            return (Criteria) this;
        }

        public Criteria andClassPhotoIdLessThan(Integer value) {
            addCriterion("CLASS_PHOTO_ID <", value, "classPhotoId");
            return (Criteria) this;
        }

        public Criteria andClassPhotoIdLessThanOrEqualTo(Integer value) {
            addCriterion("CLASS_PHOTO_ID <=", value, "classPhotoId");
            return (Criteria) this;
        }

        public Criteria andClassPhotoIdIn(List<Integer> values) {
            addCriterion("CLASS_PHOTO_ID in", values, "classPhotoId");
            return (Criteria) this;
        }

        public Criteria andClassPhotoIdNotIn(List<Integer> values) {
            addCriterion("CLASS_PHOTO_ID not in", values, "classPhotoId");
            return (Criteria) this;
        }

        public Criteria andClassPhotoIdBetween(Integer value1, Integer value2) {
            addCriterion("CLASS_PHOTO_ID between", value1, value2, "classPhotoId");
            return (Criteria) this;
        }

        public Criteria andClassPhotoIdNotBetween(Integer value1, Integer value2) {
            addCriterion("CLASS_PHOTO_ID not between", value1, value2, "classPhotoId");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Calendar value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Calendar value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Calendar value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Calendar value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Calendar value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Calendar value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Calendar> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Calendar> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Calendar value1, Calendar value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Calendar value1, Calendar value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNull() {
            addCriterion("DELETED is null");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNotNull() {
            addCriterion("DELETED is not null");
            return (Criteria) this;
        }

        public Criteria andDeletedEqualTo(Integer value) {
            addCriterion("DELETED =", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotEqualTo(Integer value) {
            addCriterion("DELETED <>", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThan(Integer value) {
            addCriterion("DELETED >", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThanOrEqualTo(Integer value) {
            addCriterion("DELETED >=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThan(Integer value) {
            addCriterion("DELETED <", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThanOrEqualTo(Integer value) {
            addCriterion("DELETED <=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedIn(List<Integer> values) {
            addCriterion("DELETED in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotIn(List<Integer> values) {
            addCriterion("DELETED not in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedBetween(Integer value1, Integer value2) {
            addCriterion("DELETED between", value1, value2, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotBetween(Integer value1, Integer value2) {
            addCriterion("DELETED not between", value1, value2, "deleted");
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