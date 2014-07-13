package com.ishangke.edunav.dataaccess.model.gen;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ApproveHistoryEntityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ApproveHistoryEntityExample() {
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

        public Criteria andTypeIsNull() {
            addCriterion("TYPE is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("TYPE =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("TYPE <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("TYPE >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("TYPE >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("TYPE <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("TYPE <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("TYPE in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("TYPE not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("TYPE between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("TYPE not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andAttachedIdIsNull() {
            addCriterion("ATTACHED_ID is null");
            return (Criteria) this;
        }

        public Criteria andAttachedIdIsNotNull() {
            addCriterion("ATTACHED_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAttachedIdEqualTo(Integer value) {
            addCriterion("ATTACHED_ID =", value, "attachedId");
            return (Criteria) this;
        }

        public Criteria andAttachedIdNotEqualTo(Integer value) {
            addCriterion("ATTACHED_ID <>", value, "attachedId");
            return (Criteria) this;
        }

        public Criteria andAttachedIdGreaterThan(Integer value) {
            addCriterion("ATTACHED_ID >", value, "attachedId");
            return (Criteria) this;
        }

        public Criteria andAttachedIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ATTACHED_ID >=", value, "attachedId");
            return (Criteria) this;
        }

        public Criteria andAttachedIdLessThan(Integer value) {
            addCriterion("ATTACHED_ID <", value, "attachedId");
            return (Criteria) this;
        }

        public Criteria andAttachedIdLessThanOrEqualTo(Integer value) {
            addCriterion("ATTACHED_ID <=", value, "attachedId");
            return (Criteria) this;
        }

        public Criteria andAttachedIdIn(List<Integer> values) {
            addCriterion("ATTACHED_ID in", values, "attachedId");
            return (Criteria) this;
        }

        public Criteria andAttachedIdNotIn(List<Integer> values) {
            addCriterion("ATTACHED_ID not in", values, "attachedId");
            return (Criteria) this;
        }

        public Criteria andAttachedIdBetween(Integer value1, Integer value2) {
            addCriterion("ATTACHED_ID between", value1, value2, "attachedId");
            return (Criteria) this;
        }

        public Criteria andAttachedIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ATTACHED_ID not between", value1, value2, "attachedId");
            return (Criteria) this;
        }

        public Criteria andSubmitUserIdIsNull() {
            addCriterion("SUBMIT_USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andSubmitUserIdIsNotNull() {
            addCriterion("SUBMIT_USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSubmitUserIdEqualTo(Integer value) {
            addCriterion("SUBMIT_USER_ID =", value, "submitUserId");
            return (Criteria) this;
        }

        public Criteria andSubmitUserIdNotEqualTo(Integer value) {
            addCriterion("SUBMIT_USER_ID <>", value, "submitUserId");
            return (Criteria) this;
        }

        public Criteria andSubmitUserIdGreaterThan(Integer value) {
            addCriterion("SUBMIT_USER_ID >", value, "submitUserId");
            return (Criteria) this;
        }

        public Criteria andSubmitUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("SUBMIT_USER_ID >=", value, "submitUserId");
            return (Criteria) this;
        }

        public Criteria andSubmitUserIdLessThan(Integer value) {
            addCriterion("SUBMIT_USER_ID <", value, "submitUserId");
            return (Criteria) this;
        }

        public Criteria andSubmitUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("SUBMIT_USER_ID <=", value, "submitUserId");
            return (Criteria) this;
        }

        public Criteria andSubmitUserIdIn(List<Integer> values) {
            addCriterion("SUBMIT_USER_ID in", values, "submitUserId");
            return (Criteria) this;
        }

        public Criteria andSubmitUserIdNotIn(List<Integer> values) {
            addCriterion("SUBMIT_USER_ID not in", values, "submitUserId");
            return (Criteria) this;
        }

        public Criteria andSubmitUserIdBetween(Integer value1, Integer value2) {
            addCriterion("SUBMIT_USER_ID between", value1, value2, "submitUserId");
            return (Criteria) this;
        }

        public Criteria andSubmitUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("SUBMIT_USER_ID not between", value1, value2, "submitUserId");
            return (Criteria) this;
        }

        public Criteria andApproveUserIdIsNull() {
            addCriterion("APPROVE_USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andApproveUserIdIsNotNull() {
            addCriterion("APPROVE_USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andApproveUserIdEqualTo(Integer value) {
            addCriterion("APPROVE_USER_ID =", value, "approveUserId");
            return (Criteria) this;
        }

        public Criteria andApproveUserIdNotEqualTo(Integer value) {
            addCriterion("APPROVE_USER_ID <>", value, "approveUserId");
            return (Criteria) this;
        }

        public Criteria andApproveUserIdGreaterThan(Integer value) {
            addCriterion("APPROVE_USER_ID >", value, "approveUserId");
            return (Criteria) this;
        }

        public Criteria andApproveUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("APPROVE_USER_ID >=", value, "approveUserId");
            return (Criteria) this;
        }

        public Criteria andApproveUserIdLessThan(Integer value) {
            addCriterion("APPROVE_USER_ID <", value, "approveUserId");
            return (Criteria) this;
        }

        public Criteria andApproveUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("APPROVE_USER_ID <=", value, "approveUserId");
            return (Criteria) this;
        }

        public Criteria andApproveUserIdIn(List<Integer> values) {
            addCriterion("APPROVE_USER_ID in", values, "approveUserId");
            return (Criteria) this;
        }

        public Criteria andApproveUserIdNotIn(List<Integer> values) {
            addCriterion("APPROVE_USER_ID not in", values, "approveUserId");
            return (Criteria) this;
        }

        public Criteria andApproveUserIdBetween(Integer value1, Integer value2) {
            addCriterion("APPROVE_USER_ID between", value1, value2, "approveUserId");
            return (Criteria) this;
        }

        public Criteria andApproveUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("APPROVE_USER_ID not between", value1, value2, "approveUserId");
            return (Criteria) this;
        }

        public Criteria andPreStatusIsNull() {
            addCriterion("PRE_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andPreStatusIsNotNull() {
            addCriterion("PRE_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andPreStatusEqualTo(Integer value) {
            addCriterion("PRE_STATUS =", value, "preStatus");
            return (Criteria) this;
        }

        public Criteria andPreStatusNotEqualTo(Integer value) {
            addCriterion("PRE_STATUS <>", value, "preStatus");
            return (Criteria) this;
        }

        public Criteria andPreStatusGreaterThan(Integer value) {
            addCriterion("PRE_STATUS >", value, "preStatus");
            return (Criteria) this;
        }

        public Criteria andPreStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("PRE_STATUS >=", value, "preStatus");
            return (Criteria) this;
        }

        public Criteria andPreStatusLessThan(Integer value) {
            addCriterion("PRE_STATUS <", value, "preStatus");
            return (Criteria) this;
        }

        public Criteria andPreStatusLessThanOrEqualTo(Integer value) {
            addCriterion("PRE_STATUS <=", value, "preStatus");
            return (Criteria) this;
        }

        public Criteria andPreStatusIn(List<Integer> values) {
            addCriterion("PRE_STATUS in", values, "preStatus");
            return (Criteria) this;
        }

        public Criteria andPreStatusNotIn(List<Integer> values) {
            addCriterion("PRE_STATUS not in", values, "preStatus");
            return (Criteria) this;
        }

        public Criteria andPreStatusBetween(Integer value1, Integer value2) {
            addCriterion("PRE_STATUS between", value1, value2, "preStatus");
            return (Criteria) this;
        }

        public Criteria andPreStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("PRE_STATUS not between", value1, value2, "preStatus");
            return (Criteria) this;
        }

        public Criteria andPostStatusIsNull() {
            addCriterion("POST_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andPostStatusIsNotNull() {
            addCriterion("POST_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andPostStatusEqualTo(Integer value) {
            addCriterion("POST_STATUS =", value, "postStatus");
            return (Criteria) this;
        }

        public Criteria andPostStatusNotEqualTo(Integer value) {
            addCriterion("POST_STATUS <>", value, "postStatus");
            return (Criteria) this;
        }

        public Criteria andPostStatusGreaterThan(Integer value) {
            addCriterion("POST_STATUS >", value, "postStatus");
            return (Criteria) this;
        }

        public Criteria andPostStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("POST_STATUS >=", value, "postStatus");
            return (Criteria) this;
        }

        public Criteria andPostStatusLessThan(Integer value) {
            addCriterion("POST_STATUS <", value, "postStatus");
            return (Criteria) this;
        }

        public Criteria andPostStatusLessThanOrEqualTo(Integer value) {
            addCriterion("POST_STATUS <=", value, "postStatus");
            return (Criteria) this;
        }

        public Criteria andPostStatusIn(List<Integer> values) {
            addCriterion("POST_STATUS in", values, "postStatus");
            return (Criteria) this;
        }

        public Criteria andPostStatusNotIn(List<Integer> values) {
            addCriterion("POST_STATUS not in", values, "postStatus");
            return (Criteria) this;
        }

        public Criteria andPostStatusBetween(Integer value1, Integer value2) {
            addCriterion("POST_STATUS between", value1, value2, "postStatus");
            return (Criteria) this;
        }

        public Criteria andPostStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("POST_STATUS not between", value1, value2, "postStatus");
            return (Criteria) this;
        }

        public Criteria andCommentIsNull() {
            addCriterion("COMMENT is null");
            return (Criteria) this;
        }

        public Criteria andCommentIsNotNull() {
            addCriterion("COMMENT is not null");
            return (Criteria) this;
        }

        public Criteria andCommentEqualTo(String value) {
            addCriterion("COMMENT =", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotEqualTo(String value) {
            addCriterion("COMMENT <>", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThan(String value) {
            addCriterion("COMMENT >", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThanOrEqualTo(String value) {
            addCriterion("COMMENT >=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThan(String value) {
            addCriterion("COMMENT <", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThanOrEqualTo(String value) {
            addCriterion("COMMENT <=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLike(String value) {
            addCriterion("COMMENT like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotLike(String value) {
            addCriterion("COMMENT not like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentIn(List<String> values) {
            addCriterion("COMMENT in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotIn(List<String> values) {
            addCriterion("COMMENT not in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentBetween(String value1, String value2) {
            addCriterion("COMMENT between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotBetween(String value1, String value2) {
            addCriterion("COMMENT not between", value1, value2, "comment");
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

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
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