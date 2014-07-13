package com.ishangke.edunav.dataaccess.model.gen;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MessageEntityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MessageEntityExample() {
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

        public Criteria andMessageTextIsNull() {
            addCriterion("MESSAGE_TEXT is null");
            return (Criteria) this;
        }

        public Criteria andMessageTextIsNotNull() {
            addCriterion("MESSAGE_TEXT is not null");
            return (Criteria) this;
        }

        public Criteria andMessageTextEqualTo(String value) {
            addCriterion("MESSAGE_TEXT =", value, "messageText");
            return (Criteria) this;
        }

        public Criteria andMessageTextNotEqualTo(String value) {
            addCriterion("MESSAGE_TEXT <>", value, "messageText");
            return (Criteria) this;
        }

        public Criteria andMessageTextGreaterThan(String value) {
            addCriterion("MESSAGE_TEXT >", value, "messageText");
            return (Criteria) this;
        }

        public Criteria andMessageTextGreaterThanOrEqualTo(String value) {
            addCriterion("MESSAGE_TEXT >=", value, "messageText");
            return (Criteria) this;
        }

        public Criteria andMessageTextLessThan(String value) {
            addCriterion("MESSAGE_TEXT <", value, "messageText");
            return (Criteria) this;
        }

        public Criteria andMessageTextLessThanOrEqualTo(String value) {
            addCriterion("MESSAGE_TEXT <=", value, "messageText");
            return (Criteria) this;
        }

        public Criteria andMessageTextLike(String value) {
            addCriterion("MESSAGE_TEXT like", value, "messageText");
            return (Criteria) this;
        }

        public Criteria andMessageTextNotLike(String value) {
            addCriterion("MESSAGE_TEXT not like", value, "messageText");
            return (Criteria) this;
        }

        public Criteria andMessageTextIn(List<String> values) {
            addCriterion("MESSAGE_TEXT in", values, "messageText");
            return (Criteria) this;
        }

        public Criteria andMessageTextNotIn(List<String> values) {
            addCriterion("MESSAGE_TEXT not in", values, "messageText");
            return (Criteria) this;
        }

        public Criteria andMessageTextBetween(String value1, String value2) {
            addCriterion("MESSAGE_TEXT between", value1, value2, "messageText");
            return (Criteria) this;
        }

        public Criteria andMessageTextNotBetween(String value1, String value2) {
            addCriterion("MESSAGE_TEXT not between", value1, value2, "messageText");
            return (Criteria) this;
        }

        public Criteria andUserFromIdIsNull() {
            addCriterion("USER_FROM_ID is null");
            return (Criteria) this;
        }

        public Criteria andUserFromIdIsNotNull() {
            addCriterion("USER_FROM_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUserFromIdEqualTo(Integer value) {
            addCriterion("USER_FROM_ID =", value, "userFromId");
            return (Criteria) this;
        }

        public Criteria andUserFromIdNotEqualTo(Integer value) {
            addCriterion("USER_FROM_ID <>", value, "userFromId");
            return (Criteria) this;
        }

        public Criteria andUserFromIdGreaterThan(Integer value) {
            addCriterion("USER_FROM_ID >", value, "userFromId");
            return (Criteria) this;
        }

        public Criteria andUserFromIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("USER_FROM_ID >=", value, "userFromId");
            return (Criteria) this;
        }

        public Criteria andUserFromIdLessThan(Integer value) {
            addCriterion("USER_FROM_ID <", value, "userFromId");
            return (Criteria) this;
        }

        public Criteria andUserFromIdLessThanOrEqualTo(Integer value) {
            addCriterion("USER_FROM_ID <=", value, "userFromId");
            return (Criteria) this;
        }

        public Criteria andUserFromIdIn(List<Integer> values) {
            addCriterion("USER_FROM_ID in", values, "userFromId");
            return (Criteria) this;
        }

        public Criteria andUserFromIdNotIn(List<Integer> values) {
            addCriterion("USER_FROM_ID not in", values, "userFromId");
            return (Criteria) this;
        }

        public Criteria andUserFromIdBetween(Integer value1, Integer value2) {
            addCriterion("USER_FROM_ID between", value1, value2, "userFromId");
            return (Criteria) this;
        }

        public Criteria andUserFromIdNotBetween(Integer value1, Integer value2) {
            addCriterion("USER_FROM_ID not between", value1, value2, "userFromId");
            return (Criteria) this;
        }

        public Criteria andUserToIdIsNull() {
            addCriterion("USER_TO_ID is null");
            return (Criteria) this;
        }

        public Criteria andUserToIdIsNotNull() {
            addCriterion("USER_TO_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUserToIdEqualTo(Integer value) {
            addCriterion("USER_TO_ID =", value, "userToId");
            return (Criteria) this;
        }

        public Criteria andUserToIdNotEqualTo(Integer value) {
            addCriterion("USER_TO_ID <>", value, "userToId");
            return (Criteria) this;
        }

        public Criteria andUserToIdGreaterThan(Integer value) {
            addCriterion("USER_TO_ID >", value, "userToId");
            return (Criteria) this;
        }

        public Criteria andUserToIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("USER_TO_ID >=", value, "userToId");
            return (Criteria) this;
        }

        public Criteria andUserToIdLessThan(Integer value) {
            addCriterion("USER_TO_ID <", value, "userToId");
            return (Criteria) this;
        }

        public Criteria andUserToIdLessThanOrEqualTo(Integer value) {
            addCriterion("USER_TO_ID <=", value, "userToId");
            return (Criteria) this;
        }

        public Criteria andUserToIdIn(List<Integer> values) {
            addCriterion("USER_TO_ID in", values, "userToId");
            return (Criteria) this;
        }

        public Criteria andUserToIdNotIn(List<Integer> values) {
            addCriterion("USER_TO_ID not in", values, "userToId");
            return (Criteria) this;
        }

        public Criteria andUserToIdBetween(Integer value1, Integer value2) {
            addCriterion("USER_TO_ID between", value1, value2, "userToId");
            return (Criteria) this;
        }

        public Criteria andUserToIdNotBetween(Integer value1, Integer value2) {
            addCriterion("USER_TO_ID not between", value1, value2, "userToId");
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