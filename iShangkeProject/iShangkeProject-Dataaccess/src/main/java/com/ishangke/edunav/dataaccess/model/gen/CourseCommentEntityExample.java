package com.ishangke.edunav.dataaccess.model.gen;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CourseCommentEntityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CourseCommentEntityExample() {
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

        public Criteria andUserIdIsNull() {
            addCriterion("USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("USER_ID =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("USER_ID <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("USER_ID >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("USER_ID >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("USER_ID <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("USER_ID <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("USER_ID in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("USER_ID not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("USER_ID between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("USER_ID not between", value1, value2, "userId");
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

        public Criteria andTitleIsNull() {
            addCriterion("TITLE is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("TITLE is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("TITLE =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("TITLE <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("TITLE >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("TITLE >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("TITLE <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("TITLE <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("TITLE like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("TITLE not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("TITLE in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("TITLE not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("TITLE between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("TITLE not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("CONTENT is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("CONTENT is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("CONTENT =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("CONTENT <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("CONTENT >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("CONTENT >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("CONTENT <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("CONTENT <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("CONTENT like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("CONTENT not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("CONTENT in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("CONTENT not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("CONTENT between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("CONTENT not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andTotalRatingIsNull() {
            addCriterion("TOTAL_RATING is null");
            return (Criteria) this;
        }

        public Criteria andTotalRatingIsNotNull() {
            addCriterion("TOTAL_RATING is not null");
            return (Criteria) this;
        }

        public Criteria andTotalRatingEqualTo(Double value) {
            addCriterion("TOTAL_RATING =", value, "totalRating");
            return (Criteria) this;
        }

        public Criteria andTotalRatingNotEqualTo(Double value) {
            addCriterion("TOTAL_RATING <>", value, "totalRating");
            return (Criteria) this;
        }

        public Criteria andTotalRatingGreaterThan(Double value) {
            addCriterion("TOTAL_RATING >", value, "totalRating");
            return (Criteria) this;
        }

        public Criteria andTotalRatingGreaterThanOrEqualTo(Double value) {
            addCriterion("TOTAL_RATING >=", value, "totalRating");
            return (Criteria) this;
        }

        public Criteria andTotalRatingLessThan(Double value) {
            addCriterion("TOTAL_RATING <", value, "totalRating");
            return (Criteria) this;
        }

        public Criteria andTotalRatingLessThanOrEqualTo(Double value) {
            addCriterion("TOTAL_RATING <=", value, "totalRating");
            return (Criteria) this;
        }

        public Criteria andTotalRatingIn(List<Double> values) {
            addCriterion("TOTAL_RATING in", values, "totalRating");
            return (Criteria) this;
        }

        public Criteria andTotalRatingNotIn(List<Double> values) {
            addCriterion("TOTAL_RATING not in", values, "totalRating");
            return (Criteria) this;
        }

        public Criteria andTotalRatingBetween(Double value1, Double value2) {
            addCriterion("TOTAL_RATING between", value1, value2, "totalRating");
            return (Criteria) this;
        }

        public Criteria andTotalRatingNotBetween(Double value1, Double value2) {
            addCriterion("TOTAL_RATING not between", value1, value2, "totalRating");
            return (Criteria) this;
        }

        public Criteria andConditionRatingIsNull() {
            addCriterion("CONDITION_RATING is null");
            return (Criteria) this;
        }

        public Criteria andConditionRatingIsNotNull() {
            addCriterion("CONDITION_RATING is not null");
            return (Criteria) this;
        }

        public Criteria andConditionRatingEqualTo(Double value) {
            addCriterion("CONDITION_RATING =", value, "conditionRating");
            return (Criteria) this;
        }

        public Criteria andConditionRatingNotEqualTo(Double value) {
            addCriterion("CONDITION_RATING <>", value, "conditionRating");
            return (Criteria) this;
        }

        public Criteria andConditionRatingGreaterThan(Double value) {
            addCriterion("CONDITION_RATING >", value, "conditionRating");
            return (Criteria) this;
        }

        public Criteria andConditionRatingGreaterThanOrEqualTo(Double value) {
            addCriterion("CONDITION_RATING >=", value, "conditionRating");
            return (Criteria) this;
        }

        public Criteria andConditionRatingLessThan(Double value) {
            addCriterion("CONDITION_RATING <", value, "conditionRating");
            return (Criteria) this;
        }

        public Criteria andConditionRatingLessThanOrEqualTo(Double value) {
            addCriterion("CONDITION_RATING <=", value, "conditionRating");
            return (Criteria) this;
        }

        public Criteria andConditionRatingIn(List<Double> values) {
            addCriterion("CONDITION_RATING in", values, "conditionRating");
            return (Criteria) this;
        }

        public Criteria andConditionRatingNotIn(List<Double> values) {
            addCriterion("CONDITION_RATING not in", values, "conditionRating");
            return (Criteria) this;
        }

        public Criteria andConditionRatingBetween(Double value1, Double value2) {
            addCriterion("CONDITION_RATING between", value1, value2, "conditionRating");
            return (Criteria) this;
        }

        public Criteria andConditionRatingNotBetween(Double value1, Double value2) {
            addCriterion("CONDITION_RATING not between", value1, value2, "conditionRating");
            return (Criteria) this;
        }

        public Criteria andAttitudeRatingIsNull() {
            addCriterion("ATTITUDE_RATING is null");
            return (Criteria) this;
        }

        public Criteria andAttitudeRatingIsNotNull() {
            addCriterion("ATTITUDE_RATING is not null");
            return (Criteria) this;
        }

        public Criteria andAttitudeRatingEqualTo(Double value) {
            addCriterion("ATTITUDE_RATING =", value, "attitudeRating");
            return (Criteria) this;
        }

        public Criteria andAttitudeRatingNotEqualTo(Double value) {
            addCriterion("ATTITUDE_RATING <>", value, "attitudeRating");
            return (Criteria) this;
        }

        public Criteria andAttitudeRatingGreaterThan(Double value) {
            addCriterion("ATTITUDE_RATING >", value, "attitudeRating");
            return (Criteria) this;
        }

        public Criteria andAttitudeRatingGreaterThanOrEqualTo(Double value) {
            addCriterion("ATTITUDE_RATING >=", value, "attitudeRating");
            return (Criteria) this;
        }

        public Criteria andAttitudeRatingLessThan(Double value) {
            addCriterion("ATTITUDE_RATING <", value, "attitudeRating");
            return (Criteria) this;
        }

        public Criteria andAttitudeRatingLessThanOrEqualTo(Double value) {
            addCriterion("ATTITUDE_RATING <=", value, "attitudeRating");
            return (Criteria) this;
        }

        public Criteria andAttitudeRatingIn(List<Double> values) {
            addCriterion("ATTITUDE_RATING in", values, "attitudeRating");
            return (Criteria) this;
        }

        public Criteria andAttitudeRatingNotIn(List<Double> values) {
            addCriterion("ATTITUDE_RATING not in", values, "attitudeRating");
            return (Criteria) this;
        }

        public Criteria andAttitudeRatingBetween(Double value1, Double value2) {
            addCriterion("ATTITUDE_RATING between", value1, value2, "attitudeRating");
            return (Criteria) this;
        }

        public Criteria andAttitudeRatingNotBetween(Double value1, Double value2) {
            addCriterion("ATTITUDE_RATING not between", value1, value2, "attitudeRating");
            return (Criteria) this;
        }

        public Criteria andSatisfactionRatingIsNull() {
            addCriterion("SATISFACTION_RATING is null");
            return (Criteria) this;
        }

        public Criteria andSatisfactionRatingIsNotNull() {
            addCriterion("SATISFACTION_RATING is not null");
            return (Criteria) this;
        }

        public Criteria andSatisfactionRatingEqualTo(Double value) {
            addCriterion("SATISFACTION_RATING =", value, "satisfactionRating");
            return (Criteria) this;
        }

        public Criteria andSatisfactionRatingNotEqualTo(Double value) {
            addCriterion("SATISFACTION_RATING <>", value, "satisfactionRating");
            return (Criteria) this;
        }

        public Criteria andSatisfactionRatingGreaterThan(Double value) {
            addCriterion("SATISFACTION_RATING >", value, "satisfactionRating");
            return (Criteria) this;
        }

        public Criteria andSatisfactionRatingGreaterThanOrEqualTo(Double value) {
            addCriterion("SATISFACTION_RATING >=", value, "satisfactionRating");
            return (Criteria) this;
        }

        public Criteria andSatisfactionRatingLessThan(Double value) {
            addCriterion("SATISFACTION_RATING <", value, "satisfactionRating");
            return (Criteria) this;
        }

        public Criteria andSatisfactionRatingLessThanOrEqualTo(Double value) {
            addCriterion("SATISFACTION_RATING <=", value, "satisfactionRating");
            return (Criteria) this;
        }

        public Criteria andSatisfactionRatingIn(List<Double> values) {
            addCriterion("SATISFACTION_RATING in", values, "satisfactionRating");
            return (Criteria) this;
        }

        public Criteria andSatisfactionRatingNotIn(List<Double> values) {
            addCriterion("SATISFACTION_RATING not in", values, "satisfactionRating");
            return (Criteria) this;
        }

        public Criteria andSatisfactionRatingBetween(Double value1, Double value2) {
            addCriterion("SATISFACTION_RATING between", value1, value2, "satisfactionRating");
            return (Criteria) this;
        }

        public Criteria andSatisfactionRatingNotBetween(Double value1, Double value2) {
            addCriterion("SATISFACTION_RATING not between", value1, value2, "satisfactionRating");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeIsNull() {
            addCriterion("LAST_MODIFY_TIME is null");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeIsNotNull() {
            addCriterion("LAST_MODIFY_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeEqualTo(Calendar value) {
            addCriterion("LAST_MODIFY_TIME =", value, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeNotEqualTo(Calendar value) {
            addCriterion("LAST_MODIFY_TIME <>", value, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeGreaterThan(Calendar value) {
            addCriterion("LAST_MODIFY_TIME >", value, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeGreaterThanOrEqualTo(Calendar value) {
            addCriterion("LAST_MODIFY_TIME >=", value, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeLessThan(Calendar value) {
            addCriterion("LAST_MODIFY_TIME <", value, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeLessThanOrEqualTo(Calendar value) {
            addCriterion("LAST_MODIFY_TIME <=", value, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeIn(List<Calendar> values) {
            addCriterion("LAST_MODIFY_TIME in", values, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeNotIn(List<Calendar> values) {
            addCriterion("LAST_MODIFY_TIME not in", values, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeBetween(Calendar value1, Calendar value2) {
            addCriterion("LAST_MODIFY_TIME between", value1, value2, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeNotBetween(Calendar value1, Calendar value2) {
            addCriterion("LAST_MODIFY_TIME not between", value1, value2, "lastModifyTime");
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

        public Criteria andEnabledIsNull() {
            addCriterion("ENABLED is null");
            return (Criteria) this;
        }

        public Criteria andEnabledIsNotNull() {
            addCriterion("ENABLED is not null");
            return (Criteria) this;
        }

        public Criteria andEnabledEqualTo(Integer value) {
            addCriterion("ENABLED =", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledNotEqualTo(Integer value) {
            addCriterion("ENABLED <>", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledGreaterThan(Integer value) {
            addCriterion("ENABLED >", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledGreaterThanOrEqualTo(Integer value) {
            addCriterion("ENABLED >=", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledLessThan(Integer value) {
            addCriterion("ENABLED <", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledLessThanOrEqualTo(Integer value) {
            addCriterion("ENABLED <=", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledIn(List<Integer> values) {
            addCriterion("ENABLED in", values, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledNotIn(List<Integer> values) {
            addCriterion("ENABLED not in", values, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledBetween(Integer value1, Integer value2) {
            addCriterion("ENABLED between", value1, value2, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledNotBetween(Integer value1, Integer value2) {
            addCriterion("ENABLED not between", value1, value2, "enabled");
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