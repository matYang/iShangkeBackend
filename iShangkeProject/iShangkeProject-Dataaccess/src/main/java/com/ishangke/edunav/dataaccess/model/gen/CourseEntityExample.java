package com.ishangke.edunav.dataaccess.model.gen;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CourseEntityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CourseEntityExample() {
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

        public Criteria andCourseNameIsNull() {
            addCriterion("COURSE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCourseNameIsNotNull() {
            addCriterion("COURSE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCourseNameEqualTo(String value) {
            addCriterion("COURSE_NAME =", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotEqualTo(String value) {
            addCriterion("COURSE_NAME <>", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameGreaterThan(String value) {
            addCriterion("COURSE_NAME >", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameGreaterThanOrEqualTo(String value) {
            addCriterion("COURSE_NAME >=", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameLessThan(String value) {
            addCriterion("COURSE_NAME <", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameLessThanOrEqualTo(String value) {
            addCriterion("COURSE_NAME <=", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameLike(String value) {
            addCriterion("COURSE_NAME like", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotLike(String value) {
            addCriterion("COURSE_NAME not like", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameIn(List<String> values) {
            addCriterion("COURSE_NAME in", values, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotIn(List<String> values) {
            addCriterion("COURSE_NAME not in", values, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameBetween(String value1, String value2) {
            addCriterion("COURSE_NAME between", value1, value2, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotBetween(String value1, String value2) {
            addCriterion("COURSE_NAME not between", value1, value2, "courseName");
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

        public Criteria andCategoryIdIsNull() {
            addCriterion("CATEGORY_ID is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNotNull() {
            addCriterion("CATEGORY_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdEqualTo(Integer value) {
            addCriterion("CATEGORY_ID =", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotEqualTo(Integer value) {
            addCriterion("CATEGORY_ID <>", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThan(Integer value) {
            addCriterion("CATEGORY_ID >", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("CATEGORY_ID >=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThan(Integer value) {
            addCriterion("CATEGORY_ID <", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThanOrEqualTo(Integer value) {
            addCriterion("CATEGORY_ID <=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIn(List<Integer> values) {
            addCriterion("CATEGORY_ID in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotIn(List<Integer> values) {
            addCriterion("CATEGORY_ID not in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdBetween(Integer value1, Integer value2) {
            addCriterion("CATEGORY_ID between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("CATEGORY_ID not between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andLocationIdIsNull() {
            addCriterion("LOCATION_ID is null");
            return (Criteria) this;
        }

        public Criteria andLocationIdIsNotNull() {
            addCriterion("LOCATION_ID is not null");
            return (Criteria) this;
        }

        public Criteria andLocationIdEqualTo(Integer value) {
            addCriterion("LOCATION_ID =", value, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationIdNotEqualTo(Integer value) {
            addCriterion("LOCATION_ID <>", value, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationIdGreaterThan(Integer value) {
            addCriterion("LOCATION_ID >", value, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("LOCATION_ID >=", value, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationIdLessThan(Integer value) {
            addCriterion("LOCATION_ID <", value, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationIdLessThanOrEqualTo(Integer value) {
            addCriterion("LOCATION_ID <=", value, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationIdIn(List<Integer> values) {
            addCriterion("LOCATION_ID in", values, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationIdNotIn(List<Integer> values) {
            addCriterion("LOCATION_ID not in", values, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationIdBetween(Integer value1, Integer value2) {
            addCriterion("LOCATION_ID between", value1, value2, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationIdNotBetween(Integer value1, Integer value2) {
            addCriterion("LOCATION_ID not between", value1, value2, "locationId");
            return (Criteria) this;
        }

        public Criteria andCircleIdIsNull() {
            addCriterion("CIRCLE_ID is null");
            return (Criteria) this;
        }

        public Criteria andCircleIdIsNotNull() {
            addCriterion("CIRCLE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCircleIdEqualTo(Integer value) {
            addCriterion("CIRCLE_ID =", value, "circleId");
            return (Criteria) this;
        }

        public Criteria andCircleIdNotEqualTo(Integer value) {
            addCriterion("CIRCLE_ID <>", value, "circleId");
            return (Criteria) this;
        }

        public Criteria andCircleIdGreaterThan(Integer value) {
            addCriterion("CIRCLE_ID >", value, "circleId");
            return (Criteria) this;
        }

        public Criteria andCircleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("CIRCLE_ID >=", value, "circleId");
            return (Criteria) this;
        }

        public Criteria andCircleIdLessThan(Integer value) {
            addCriterion("CIRCLE_ID <", value, "circleId");
            return (Criteria) this;
        }

        public Criteria andCircleIdLessThanOrEqualTo(Integer value) {
            addCriterion("CIRCLE_ID <=", value, "circleId");
            return (Criteria) this;
        }

        public Criteria andCircleIdIn(List<Integer> values) {
            addCriterion("CIRCLE_ID in", values, "circleId");
            return (Criteria) this;
        }

        public Criteria andCircleIdNotIn(List<Integer> values) {
            addCriterion("CIRCLE_ID not in", values, "circleId");
            return (Criteria) this;
        }

        public Criteria andCircleIdBetween(Integer value1, Integer value2) {
            addCriterion("CIRCLE_ID between", value1, value2, "circleId");
            return (Criteria) this;
        }

        public Criteria andCircleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("CIRCLE_ID not between", value1, value2, "circleId");
            return (Criteria) this;
        }

        public Criteria andPartnerIdIsNull() {
            addCriterion("PARTNER_ID is null");
            return (Criteria) this;
        }

        public Criteria andPartnerIdIsNotNull() {
            addCriterion("PARTNER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPartnerIdEqualTo(Integer value) {
            addCriterion("PARTNER_ID =", value, "partnerId");
            return (Criteria) this;
        }

        public Criteria andPartnerIdNotEqualTo(Integer value) {
            addCriterion("PARTNER_ID <>", value, "partnerId");
            return (Criteria) this;
        }

        public Criteria andPartnerIdGreaterThan(Integer value) {
            addCriterion("PARTNER_ID >", value, "partnerId");
            return (Criteria) this;
        }

        public Criteria andPartnerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("PARTNER_ID >=", value, "partnerId");
            return (Criteria) this;
        }

        public Criteria andPartnerIdLessThan(Integer value) {
            addCriterion("PARTNER_ID <", value, "partnerId");
            return (Criteria) this;
        }

        public Criteria andPartnerIdLessThanOrEqualTo(Integer value) {
            addCriterion("PARTNER_ID <=", value, "partnerId");
            return (Criteria) this;
        }

        public Criteria andPartnerIdIn(List<Integer> values) {
            addCriterion("PARTNER_ID in", values, "partnerId");
            return (Criteria) this;
        }

        public Criteria andPartnerIdNotIn(List<Integer> values) {
            addCriterion("PARTNER_ID not in", values, "partnerId");
            return (Criteria) this;
        }

        public Criteria andPartnerIdBetween(Integer value1, Integer value2) {
            addCriterion("PARTNER_ID between", value1, value2, "partnerId");
            return (Criteria) this;
        }

        public Criteria andPartnerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("PARTNER_ID not between", value1, value2, "partnerId");
            return (Criteria) this;
        }

        public Criteria andAddressIdIsNull() {
            addCriterion("ADDRESS_ID is null");
            return (Criteria) this;
        }

        public Criteria andAddressIdIsNotNull() {
            addCriterion("ADDRESS_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAddressIdEqualTo(Integer value) {
            addCriterion("ADDRESS_ID =", value, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdNotEqualTo(Integer value) {
            addCriterion("ADDRESS_ID <>", value, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdGreaterThan(Integer value) {
            addCriterion("ADDRESS_ID >", value, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ADDRESS_ID >=", value, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdLessThan(Integer value) {
            addCriterion("ADDRESS_ID <", value, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdLessThanOrEqualTo(Integer value) {
            addCriterion("ADDRESS_ID <=", value, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdIn(List<Integer> values) {
            addCriterion("ADDRESS_ID in", values, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdNotIn(List<Integer> values) {
            addCriterion("ADDRESS_ID not in", values, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdBetween(Integer value1, Integer value2) {
            addCriterion("ADDRESS_ID between", value1, value2, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ADDRESS_ID not between", value1, value2, "addressId");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("PRICE is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Double value) {
            addCriterion("PRICE =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Double value) {
            addCriterion("PRICE <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Double value) {
            addCriterion("PRICE >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("PRICE >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Double value) {
            addCriterion("PRICE <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Double value) {
            addCriterion("PRICE <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Double> values) {
            addCriterion("PRICE in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Double> values) {
            addCriterion("PRICE not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Double value1, Double value2) {
            addCriterion("PRICE between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Double value1, Double value2) {
            addCriterion("PRICE not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceIsNull() {
            addCriterion("ORIGINAL_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceIsNotNull() {
            addCriterion("ORIGINAL_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceEqualTo(Double value) {
            addCriterion("ORIGINAL_PRICE =", value, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceNotEqualTo(Double value) {
            addCriterion("ORIGINAL_PRICE <>", value, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceGreaterThan(Double value) {
            addCriterion("ORIGINAL_PRICE >", value, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("ORIGINAL_PRICE >=", value, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceLessThan(Double value) {
            addCriterion("ORIGINAL_PRICE <", value, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceLessThanOrEqualTo(Double value) {
            addCriterion("ORIGINAL_PRICE <=", value, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceIn(List<Double> values) {
            addCriterion("ORIGINAL_PRICE in", values, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceNotIn(List<Double> values) {
            addCriterion("ORIGINAL_PRICE not in", values, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceBetween(Double value1, Double value2) {
            addCriterion("ORIGINAL_PRICE between", value1, value2, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceNotBetween(Double value1, Double value2) {
            addCriterion("ORIGINAL_PRICE not between", value1, value2, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andCashbackIsNull() {
            addCriterion("CASHBACK is null");
            return (Criteria) this;
        }

        public Criteria andCashbackIsNotNull() {
            addCriterion("CASHBACK is not null");
            return (Criteria) this;
        }

        public Criteria andCashbackEqualTo(Double value) {
            addCriterion("CASHBACK =", value, "cashback");
            return (Criteria) this;
        }

        public Criteria andCashbackNotEqualTo(Double value) {
            addCriterion("CASHBACK <>", value, "cashback");
            return (Criteria) this;
        }

        public Criteria andCashbackGreaterThan(Double value) {
            addCriterion("CASHBACK >", value, "cashback");
            return (Criteria) this;
        }

        public Criteria andCashbackGreaterThanOrEqualTo(Double value) {
            addCriterion("CASHBACK >=", value, "cashback");
            return (Criteria) this;
        }

        public Criteria andCashbackLessThan(Double value) {
            addCriterion("CASHBACK <", value, "cashback");
            return (Criteria) this;
        }

        public Criteria andCashbackLessThanOrEqualTo(Double value) {
            addCriterion("CASHBACK <=", value, "cashback");
            return (Criteria) this;
        }

        public Criteria andCashbackIn(List<Double> values) {
            addCriterion("CASHBACK in", values, "cashback");
            return (Criteria) this;
        }

        public Criteria andCashbackNotIn(List<Double> values) {
            addCriterion("CASHBACK not in", values, "cashback");
            return (Criteria) this;
        }

        public Criteria andCashbackBetween(Double value1, Double value2) {
            addCriterion("CASHBACK between", value1, value2, "cashback");
            return (Criteria) this;
        }

        public Criteria andCashbackNotBetween(Double value1, Double value2) {
            addCriterion("CASHBACK not between", value1, value2, "cashback");
            return (Criteria) this;
        }

        public Criteria andCommissionIsNull() {
            addCriterion("COMMISSION is null");
            return (Criteria) this;
        }

        public Criteria andCommissionIsNotNull() {
            addCriterion("COMMISSION is not null");
            return (Criteria) this;
        }

        public Criteria andCommissionEqualTo(Double value) {
            addCriterion("COMMISSION =", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionNotEqualTo(Double value) {
            addCriterion("COMMISSION <>", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionGreaterThan(Double value) {
            addCriterion("COMMISSION >", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionGreaterThanOrEqualTo(Double value) {
            addCriterion("COMMISSION >=", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionLessThan(Double value) {
            addCriterion("COMMISSION <", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionLessThanOrEqualTo(Double value) {
            addCriterion("COMMISSION <=", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionIn(List<Double> values) {
            addCriterion("COMMISSION in", values, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionNotIn(List<Double> values) {
            addCriterion("COMMISSION not in", values, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionBetween(Double value1, Double value2) {
            addCriterion("COMMISSION between", value1, value2, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionNotBetween(Double value1, Double value2) {
            addCriterion("COMMISSION not between", value1, value2, "commission");
            return (Criteria) this;
        }

        public Criteria andServiceChargeIsNull() {
            addCriterion("SERVICE_CHARGE is null");
            return (Criteria) this;
        }

        public Criteria andServiceChargeIsNotNull() {
            addCriterion("SERVICE_CHARGE is not null");
            return (Criteria) this;
        }

        public Criteria andServiceChargeEqualTo(Double value) {
            addCriterion("SERVICE_CHARGE =", value, "serviceCharge");
            return (Criteria) this;
        }

        public Criteria andServiceChargeNotEqualTo(Double value) {
            addCriterion("SERVICE_CHARGE <>", value, "serviceCharge");
            return (Criteria) this;
        }

        public Criteria andServiceChargeGreaterThan(Double value) {
            addCriterion("SERVICE_CHARGE >", value, "serviceCharge");
            return (Criteria) this;
        }

        public Criteria andServiceChargeGreaterThanOrEqualTo(Double value) {
            addCriterion("SERVICE_CHARGE >=", value, "serviceCharge");
            return (Criteria) this;
        }

        public Criteria andServiceChargeLessThan(Double value) {
            addCriterion("SERVICE_CHARGE <", value, "serviceCharge");
            return (Criteria) this;
        }

        public Criteria andServiceChargeLessThanOrEqualTo(Double value) {
            addCriterion("SERVICE_CHARGE <=", value, "serviceCharge");
            return (Criteria) this;
        }

        public Criteria andServiceChargeIn(List<Double> values) {
            addCriterion("SERVICE_CHARGE in", values, "serviceCharge");
            return (Criteria) this;
        }

        public Criteria andServiceChargeNotIn(List<Double> values) {
            addCriterion("SERVICE_CHARGE not in", values, "serviceCharge");
            return (Criteria) this;
        }

        public Criteria andServiceChargeBetween(Double value1, Double value2) {
            addCriterion("SERVICE_CHARGE between", value1, value2, "serviceCharge");
            return (Criteria) this;
        }

        public Criteria andServiceChargeNotBetween(Double value1, Double value2) {
            addCriterion("SERVICE_CHARGE not between", value1, value2, "serviceCharge");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("STATUS not between", value1, value2, "status");
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

        public Criteria andLastModifyTimeEqualTo(Date value) {
            addCriterion("LAST_MODIFY_TIME =", value, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeNotEqualTo(Date value) {
            addCriterion("LAST_MODIFY_TIME <>", value, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeGreaterThan(Date value) {
            addCriterion("LAST_MODIFY_TIME >", value, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("LAST_MODIFY_TIME >=", value, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeLessThan(Date value) {
            addCriterion("LAST_MODIFY_TIME <", value, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("LAST_MODIFY_TIME <=", value, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeIn(List<Date> values) {
            addCriterion("LAST_MODIFY_TIME in", values, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeNotIn(List<Date> values) {
            addCriterion("LAST_MODIFY_TIME not in", values, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeBetween(Date value1, Date value2) {
            addCriterion("LAST_MODIFY_TIME between", value1, value2, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeNotBetween(Date value1, Date value2) {
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

        public Criteria andCourseHourLengthIsNull() {
            addCriterion("COURSE_HOUR_LENGTH is null");
            return (Criteria) this;
        }

        public Criteria andCourseHourLengthIsNotNull() {
            addCriterion("COURSE_HOUR_LENGTH is not null");
            return (Criteria) this;
        }

        public Criteria andCourseHourLengthEqualTo(Integer value) {
            addCriterion("COURSE_HOUR_LENGTH =", value, "courseHourLength");
            return (Criteria) this;
        }

        public Criteria andCourseHourLengthNotEqualTo(Integer value) {
            addCriterion("COURSE_HOUR_LENGTH <>", value, "courseHourLength");
            return (Criteria) this;
        }

        public Criteria andCourseHourLengthGreaterThan(Integer value) {
            addCriterion("COURSE_HOUR_LENGTH >", value, "courseHourLength");
            return (Criteria) this;
        }

        public Criteria andCourseHourLengthGreaterThanOrEqualTo(Integer value) {
            addCriterion("COURSE_HOUR_LENGTH >=", value, "courseHourLength");
            return (Criteria) this;
        }

        public Criteria andCourseHourLengthLessThan(Integer value) {
            addCriterion("COURSE_HOUR_LENGTH <", value, "courseHourLength");
            return (Criteria) this;
        }

        public Criteria andCourseHourLengthLessThanOrEqualTo(Integer value) {
            addCriterion("COURSE_HOUR_LENGTH <=", value, "courseHourLength");
            return (Criteria) this;
        }

        public Criteria andCourseHourLengthIn(List<Integer> values) {
            addCriterion("COURSE_HOUR_LENGTH in", values, "courseHourLength");
            return (Criteria) this;
        }

        public Criteria andCourseHourLengthNotIn(List<Integer> values) {
            addCriterion("COURSE_HOUR_LENGTH not in", values, "courseHourLength");
            return (Criteria) this;
        }

        public Criteria andCourseHourLengthBetween(Integer value1, Integer value2) {
            addCriterion("COURSE_HOUR_LENGTH between", value1, value2, "courseHourLength");
            return (Criteria) this;
        }

        public Criteria andCourseHourLengthNotBetween(Integer value1, Integer value2) {
            addCriterion("COURSE_HOUR_LENGTH not between", value1, value2, "courseHourLength");
            return (Criteria) this;
        }

        public Criteria andTeachingMethodIsNull() {
            addCriterion("TEACHING_METHOD is null");
            return (Criteria) this;
        }

        public Criteria andTeachingMethodIsNotNull() {
            addCriterion("TEACHING_METHOD is not null");
            return (Criteria) this;
        }

        public Criteria andTeachingMethodEqualTo(String value) {
            addCriterion("TEACHING_METHOD =", value, "teachingMethod");
            return (Criteria) this;
        }

        public Criteria andTeachingMethodNotEqualTo(String value) {
            addCriterion("TEACHING_METHOD <>", value, "teachingMethod");
            return (Criteria) this;
        }

        public Criteria andTeachingMethodGreaterThan(String value) {
            addCriterion("TEACHING_METHOD >", value, "teachingMethod");
            return (Criteria) this;
        }

        public Criteria andTeachingMethodGreaterThanOrEqualTo(String value) {
            addCriterion("TEACHING_METHOD >=", value, "teachingMethod");
            return (Criteria) this;
        }

        public Criteria andTeachingMethodLessThan(String value) {
            addCriterion("TEACHING_METHOD <", value, "teachingMethod");
            return (Criteria) this;
        }

        public Criteria andTeachingMethodLessThanOrEqualTo(String value) {
            addCriterion("TEACHING_METHOD <=", value, "teachingMethod");
            return (Criteria) this;
        }

        public Criteria andTeachingMethodLike(String value) {
            addCriterion("TEACHING_METHOD like", value, "teachingMethod");
            return (Criteria) this;
        }

        public Criteria andTeachingMethodNotLike(String value) {
            addCriterion("TEACHING_METHOD not like", value, "teachingMethod");
            return (Criteria) this;
        }

        public Criteria andTeachingMethodIn(List<String> values) {
            addCriterion("TEACHING_METHOD in", values, "teachingMethod");
            return (Criteria) this;
        }

        public Criteria andTeachingMethodNotIn(List<String> values) {
            addCriterion("TEACHING_METHOD not in", values, "teachingMethod");
            return (Criteria) this;
        }

        public Criteria andTeachingMethodBetween(String value1, String value2) {
            addCriterion("TEACHING_METHOD between", value1, value2, "teachingMethod");
            return (Criteria) this;
        }

        public Criteria andTeachingMethodNotBetween(String value1, String value2) {
            addCriterion("TEACHING_METHOD not between", value1, value2, "teachingMethod");
            return (Criteria) this;
        }

        public Criteria andTeachingMaterialFeeIsNull() {
            addCriterion("TEACHING_MATERIAL_FEE is null");
            return (Criteria) this;
        }

        public Criteria andTeachingMaterialFeeIsNotNull() {
            addCriterion("TEACHING_MATERIAL_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andTeachingMaterialFeeEqualTo(String value) {
            addCriterion("TEACHING_MATERIAL_FEE =", value, "teachingMaterialFee");
            return (Criteria) this;
        }

        public Criteria andTeachingMaterialFeeNotEqualTo(String value) {
            addCriterion("TEACHING_MATERIAL_FEE <>", value, "teachingMaterialFee");
            return (Criteria) this;
        }

        public Criteria andTeachingMaterialFeeGreaterThan(String value) {
            addCriterion("TEACHING_MATERIAL_FEE >", value, "teachingMaterialFee");
            return (Criteria) this;
        }

        public Criteria andTeachingMaterialFeeGreaterThanOrEqualTo(String value) {
            addCriterion("TEACHING_MATERIAL_FEE >=", value, "teachingMaterialFee");
            return (Criteria) this;
        }

        public Criteria andTeachingMaterialFeeLessThan(String value) {
            addCriterion("TEACHING_MATERIAL_FEE <", value, "teachingMaterialFee");
            return (Criteria) this;
        }

        public Criteria andTeachingMaterialFeeLessThanOrEqualTo(String value) {
            addCriterion("TEACHING_MATERIAL_FEE <=", value, "teachingMaterialFee");
            return (Criteria) this;
        }

        public Criteria andTeachingMaterialFeeLike(String value) {
            addCriterion("TEACHING_MATERIAL_FEE like", value, "teachingMaterialFee");
            return (Criteria) this;
        }

        public Criteria andTeachingMaterialFeeNotLike(String value) {
            addCriterion("TEACHING_MATERIAL_FEE not like", value, "teachingMaterialFee");
            return (Criteria) this;
        }

        public Criteria andTeachingMaterialFeeIn(List<String> values) {
            addCriterion("TEACHING_MATERIAL_FEE in", values, "teachingMaterialFee");
            return (Criteria) this;
        }

        public Criteria andTeachingMaterialFeeNotIn(List<String> values) {
            addCriterion("TEACHING_MATERIAL_FEE not in", values, "teachingMaterialFee");
            return (Criteria) this;
        }

        public Criteria andTeachingMaterialFeeBetween(String value1, String value2) {
            addCriterion("TEACHING_MATERIAL_FEE between", value1, value2, "teachingMaterialFee");
            return (Criteria) this;
        }

        public Criteria andTeachingMaterialFeeNotBetween(String value1, String value2) {
            addCriterion("TEACHING_MATERIAL_FEE not between", value1, value2, "teachingMaterialFee");
            return (Criteria) this;
        }

        public Criteria andDownloadMaterialsIsNull() {
            addCriterion("DOWNLOAD_MATERIALS is null");
            return (Criteria) this;
        }

        public Criteria andDownloadMaterialsIsNotNull() {
            addCriterion("DOWNLOAD_MATERIALS is not null");
            return (Criteria) this;
        }

        public Criteria andDownloadMaterialsEqualTo(String value) {
            addCriterion("DOWNLOAD_MATERIALS =", value, "downloadMaterials");
            return (Criteria) this;
        }

        public Criteria andDownloadMaterialsNotEqualTo(String value) {
            addCriterion("DOWNLOAD_MATERIALS <>", value, "downloadMaterials");
            return (Criteria) this;
        }

        public Criteria andDownloadMaterialsGreaterThan(String value) {
            addCriterion("DOWNLOAD_MATERIALS >", value, "downloadMaterials");
            return (Criteria) this;
        }

        public Criteria andDownloadMaterialsGreaterThanOrEqualTo(String value) {
            addCriterion("DOWNLOAD_MATERIALS >=", value, "downloadMaterials");
            return (Criteria) this;
        }

        public Criteria andDownloadMaterialsLessThan(String value) {
            addCriterion("DOWNLOAD_MATERIALS <", value, "downloadMaterials");
            return (Criteria) this;
        }

        public Criteria andDownloadMaterialsLessThanOrEqualTo(String value) {
            addCriterion("DOWNLOAD_MATERIALS <=", value, "downloadMaterials");
            return (Criteria) this;
        }

        public Criteria andDownloadMaterialsLike(String value) {
            addCriterion("DOWNLOAD_MATERIALS like", value, "downloadMaterials");
            return (Criteria) this;
        }

        public Criteria andDownloadMaterialsNotLike(String value) {
            addCriterion("DOWNLOAD_MATERIALS not like", value, "downloadMaterials");
            return (Criteria) this;
        }

        public Criteria andDownloadMaterialsIn(List<String> values) {
            addCriterion("DOWNLOAD_MATERIALS in", values, "downloadMaterials");
            return (Criteria) this;
        }

        public Criteria andDownloadMaterialsNotIn(List<String> values) {
            addCriterion("DOWNLOAD_MATERIALS not in", values, "downloadMaterials");
            return (Criteria) this;
        }

        public Criteria andDownloadMaterialsBetween(String value1, String value2) {
            addCriterion("DOWNLOAD_MATERIALS between", value1, value2, "downloadMaterials");
            return (Criteria) this;
        }

        public Criteria andDownloadMaterialsNotBetween(String value1, String value2) {
            addCriterion("DOWNLOAD_MATERIALS not between", value1, value2, "downloadMaterials");
            return (Criteria) this;
        }

        public Criteria andBonusServiceIsNull() {
            addCriterion("BONUS_SERVICE is null");
            return (Criteria) this;
        }

        public Criteria andBonusServiceIsNotNull() {
            addCriterion("BONUS_SERVICE is not null");
            return (Criteria) this;
        }

        public Criteria andBonusServiceEqualTo(String value) {
            addCriterion("BONUS_SERVICE =", value, "bonusService");
            return (Criteria) this;
        }

        public Criteria andBonusServiceNotEqualTo(String value) {
            addCriterion("BONUS_SERVICE <>", value, "bonusService");
            return (Criteria) this;
        }

        public Criteria andBonusServiceGreaterThan(String value) {
            addCriterion("BONUS_SERVICE >", value, "bonusService");
            return (Criteria) this;
        }

        public Criteria andBonusServiceGreaterThanOrEqualTo(String value) {
            addCriterion("BONUS_SERVICE >=", value, "bonusService");
            return (Criteria) this;
        }

        public Criteria andBonusServiceLessThan(String value) {
            addCriterion("BONUS_SERVICE <", value, "bonusService");
            return (Criteria) this;
        }

        public Criteria andBonusServiceLessThanOrEqualTo(String value) {
            addCriterion("BONUS_SERVICE <=", value, "bonusService");
            return (Criteria) this;
        }

        public Criteria andBonusServiceLike(String value) {
            addCriterion("BONUS_SERVICE like", value, "bonusService");
            return (Criteria) this;
        }

        public Criteria andBonusServiceNotLike(String value) {
            addCriterion("BONUS_SERVICE not like", value, "bonusService");
            return (Criteria) this;
        }

        public Criteria andBonusServiceIn(List<String> values) {
            addCriterion("BONUS_SERVICE in", values, "bonusService");
            return (Criteria) this;
        }

        public Criteria andBonusServiceNotIn(List<String> values) {
            addCriterion("BONUS_SERVICE not in", values, "bonusService");
            return (Criteria) this;
        }

        public Criteria andBonusServiceBetween(String value1, String value2) {
            addCriterion("BONUS_SERVICE between", value1, value2, "bonusService");
            return (Criteria) this;
        }

        public Criteria andBonusServiceNotBetween(String value1, String value2) {
            addCriterion("BONUS_SERVICE not between", value1, value2, "bonusService");
            return (Criteria) this;
        }

        public Criteria andMarkingIsNull() {
            addCriterion("MARKING is null");
            return (Criteria) this;
        }

        public Criteria andMarkingIsNotNull() {
            addCriterion("MARKING is not null");
            return (Criteria) this;
        }

        public Criteria andMarkingEqualTo(String value) {
            addCriterion("MARKING =", value, "marking");
            return (Criteria) this;
        }

        public Criteria andMarkingNotEqualTo(String value) {
            addCriterion("MARKING <>", value, "marking");
            return (Criteria) this;
        }

        public Criteria andMarkingGreaterThan(String value) {
            addCriterion("MARKING >", value, "marking");
            return (Criteria) this;
        }

        public Criteria andMarkingGreaterThanOrEqualTo(String value) {
            addCriterion("MARKING >=", value, "marking");
            return (Criteria) this;
        }

        public Criteria andMarkingLessThan(String value) {
            addCriterion("MARKING <", value, "marking");
            return (Criteria) this;
        }

        public Criteria andMarkingLessThanOrEqualTo(String value) {
            addCriterion("MARKING <=", value, "marking");
            return (Criteria) this;
        }

        public Criteria andMarkingLike(String value) {
            addCriterion("MARKING like", value, "marking");
            return (Criteria) this;
        }

        public Criteria andMarkingNotLike(String value) {
            addCriterion("MARKING not like", value, "marking");
            return (Criteria) this;
        }

        public Criteria andMarkingIn(List<String> values) {
            addCriterion("MARKING in", values, "marking");
            return (Criteria) this;
        }

        public Criteria andMarkingNotIn(List<String> values) {
            addCriterion("MARKING not in", values, "marking");
            return (Criteria) this;
        }

        public Criteria andMarkingBetween(String value1, String value2) {
            addCriterion("MARKING between", value1, value2, "marking");
            return (Criteria) this;
        }

        public Criteria andMarkingNotBetween(String value1, String value2) {
            addCriterion("MARKING not between", value1, value2, "marking");
            return (Criteria) this;
        }

        public Criteria andAssignmentsIsNull() {
            addCriterion("ASSIGNMENTS is null");
            return (Criteria) this;
        }

        public Criteria andAssignmentsIsNotNull() {
            addCriterion("ASSIGNMENTS is not null");
            return (Criteria) this;
        }

        public Criteria andAssignmentsEqualTo(String value) {
            addCriterion("ASSIGNMENTS =", value, "assignments");
            return (Criteria) this;
        }

        public Criteria andAssignmentsNotEqualTo(String value) {
            addCriterion("ASSIGNMENTS <>", value, "assignments");
            return (Criteria) this;
        }

        public Criteria andAssignmentsGreaterThan(String value) {
            addCriterion("ASSIGNMENTS >", value, "assignments");
            return (Criteria) this;
        }

        public Criteria andAssignmentsGreaterThanOrEqualTo(String value) {
            addCriterion("ASSIGNMENTS >=", value, "assignments");
            return (Criteria) this;
        }

        public Criteria andAssignmentsLessThan(String value) {
            addCriterion("ASSIGNMENTS <", value, "assignments");
            return (Criteria) this;
        }

        public Criteria andAssignmentsLessThanOrEqualTo(String value) {
            addCriterion("ASSIGNMENTS <=", value, "assignments");
            return (Criteria) this;
        }

        public Criteria andAssignmentsLike(String value) {
            addCriterion("ASSIGNMENTS like", value, "assignments");
            return (Criteria) this;
        }

        public Criteria andAssignmentsNotLike(String value) {
            addCriterion("ASSIGNMENTS not like", value, "assignments");
            return (Criteria) this;
        }

        public Criteria andAssignmentsIn(List<String> values) {
            addCriterion("ASSIGNMENTS in", values, "assignments");
            return (Criteria) this;
        }

        public Criteria andAssignmentsNotIn(List<String> values) {
            addCriterion("ASSIGNMENTS not in", values, "assignments");
            return (Criteria) this;
        }

        public Criteria andAssignmentsBetween(String value1, String value2) {
            addCriterion("ASSIGNMENTS between", value1, value2, "assignments");
            return (Criteria) this;
        }

        public Criteria andAssignmentsNotBetween(String value1, String value2) {
            addCriterion("ASSIGNMENTS not between", value1, value2, "assignments");
            return (Criteria) this;
        }

        public Criteria andTrailIsNull() {
            addCriterion("TRAIL is null");
            return (Criteria) this;
        }

        public Criteria andTrailIsNotNull() {
            addCriterion("TRAIL is not null");
            return (Criteria) this;
        }

        public Criteria andTrailEqualTo(String value) {
            addCriterion("TRAIL =", value, "trail");
            return (Criteria) this;
        }

        public Criteria andTrailNotEqualTo(String value) {
            addCriterion("TRAIL <>", value, "trail");
            return (Criteria) this;
        }

        public Criteria andTrailGreaterThan(String value) {
            addCriterion("TRAIL >", value, "trail");
            return (Criteria) this;
        }

        public Criteria andTrailGreaterThanOrEqualTo(String value) {
            addCriterion("TRAIL >=", value, "trail");
            return (Criteria) this;
        }

        public Criteria andTrailLessThan(String value) {
            addCriterion("TRAIL <", value, "trail");
            return (Criteria) this;
        }

        public Criteria andTrailLessThanOrEqualTo(String value) {
            addCriterion("TRAIL <=", value, "trail");
            return (Criteria) this;
        }

        public Criteria andTrailLike(String value) {
            addCriterion("TRAIL like", value, "trail");
            return (Criteria) this;
        }

        public Criteria andTrailNotLike(String value) {
            addCriterion("TRAIL not like", value, "trail");
            return (Criteria) this;
        }

        public Criteria andTrailIn(List<String> values) {
            addCriterion("TRAIL in", values, "trail");
            return (Criteria) this;
        }

        public Criteria andTrailNotIn(List<String> values) {
            addCriterion("TRAIL not in", values, "trail");
            return (Criteria) this;
        }

        public Criteria andTrailBetween(String value1, String value2) {
            addCriterion("TRAIL between", value1, value2, "trail");
            return (Criteria) this;
        }

        public Criteria andTrailNotBetween(String value1, String value2) {
            addCriterion("TRAIL not between", value1, value2, "trail");
            return (Criteria) this;
        }

        public Criteria andQuestionSessionIsNull() {
            addCriterion("QUESTION_SESSION is null");
            return (Criteria) this;
        }

        public Criteria andQuestionSessionIsNotNull() {
            addCriterion("QUESTION_SESSION is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionSessionEqualTo(String value) {
            addCriterion("QUESTION_SESSION =", value, "questionSession");
            return (Criteria) this;
        }

        public Criteria andQuestionSessionNotEqualTo(String value) {
            addCriterion("QUESTION_SESSION <>", value, "questionSession");
            return (Criteria) this;
        }

        public Criteria andQuestionSessionGreaterThan(String value) {
            addCriterion("QUESTION_SESSION >", value, "questionSession");
            return (Criteria) this;
        }

        public Criteria andQuestionSessionGreaterThanOrEqualTo(String value) {
            addCriterion("QUESTION_SESSION >=", value, "questionSession");
            return (Criteria) this;
        }

        public Criteria andQuestionSessionLessThan(String value) {
            addCriterion("QUESTION_SESSION <", value, "questionSession");
            return (Criteria) this;
        }

        public Criteria andQuestionSessionLessThanOrEqualTo(String value) {
            addCriterion("QUESTION_SESSION <=", value, "questionSession");
            return (Criteria) this;
        }

        public Criteria andQuestionSessionLike(String value) {
            addCriterion("QUESTION_SESSION like", value, "questionSession");
            return (Criteria) this;
        }

        public Criteria andQuestionSessionNotLike(String value) {
            addCriterion("QUESTION_SESSION not like", value, "questionSession");
            return (Criteria) this;
        }

        public Criteria andQuestionSessionIn(List<String> values) {
            addCriterion("QUESTION_SESSION in", values, "questionSession");
            return (Criteria) this;
        }

        public Criteria andQuestionSessionNotIn(List<String> values) {
            addCriterion("QUESTION_SESSION not in", values, "questionSession");
            return (Criteria) this;
        }

        public Criteria andQuestionSessionBetween(String value1, String value2) {
            addCriterion("QUESTION_SESSION between", value1, value2, "questionSession");
            return (Criteria) this;
        }

        public Criteria andQuestionSessionNotBetween(String value1, String value2) {
            addCriterion("QUESTION_SESSION not between", value1, value2, "questionSession");
            return (Criteria) this;
        }

        public Criteria andTeachingAndExerciseIsNull() {
            addCriterion("TEACHING_AND_EXERCISE is null");
            return (Criteria) this;
        }

        public Criteria andTeachingAndExerciseIsNotNull() {
            addCriterion("TEACHING_AND_EXERCISE is not null");
            return (Criteria) this;
        }

        public Criteria andTeachingAndExerciseEqualTo(String value) {
            addCriterion("TEACHING_AND_EXERCISE =", value, "teachingAndExercise");
            return (Criteria) this;
        }

        public Criteria andTeachingAndExerciseNotEqualTo(String value) {
            addCriterion("TEACHING_AND_EXERCISE <>", value, "teachingAndExercise");
            return (Criteria) this;
        }

        public Criteria andTeachingAndExerciseGreaterThan(String value) {
            addCriterion("TEACHING_AND_EXERCISE >", value, "teachingAndExercise");
            return (Criteria) this;
        }

        public Criteria andTeachingAndExerciseGreaterThanOrEqualTo(String value) {
            addCriterion("TEACHING_AND_EXERCISE >=", value, "teachingAndExercise");
            return (Criteria) this;
        }

        public Criteria andTeachingAndExerciseLessThan(String value) {
            addCriterion("TEACHING_AND_EXERCISE <", value, "teachingAndExercise");
            return (Criteria) this;
        }

        public Criteria andTeachingAndExerciseLessThanOrEqualTo(String value) {
            addCriterion("TEACHING_AND_EXERCISE <=", value, "teachingAndExercise");
            return (Criteria) this;
        }

        public Criteria andTeachingAndExerciseLike(String value) {
            addCriterion("TEACHING_AND_EXERCISE like", value, "teachingAndExercise");
            return (Criteria) this;
        }

        public Criteria andTeachingAndExerciseNotLike(String value) {
            addCriterion("TEACHING_AND_EXERCISE not like", value, "teachingAndExercise");
            return (Criteria) this;
        }

        public Criteria andTeachingAndExerciseIn(List<String> values) {
            addCriterion("TEACHING_AND_EXERCISE in", values, "teachingAndExercise");
            return (Criteria) this;
        }

        public Criteria andTeachingAndExerciseNotIn(List<String> values) {
            addCriterion("TEACHING_AND_EXERCISE not in", values, "teachingAndExercise");
            return (Criteria) this;
        }

        public Criteria andTeachingAndExerciseBetween(String value1, String value2) {
            addCriterion("TEACHING_AND_EXERCISE between", value1, value2, "teachingAndExercise");
            return (Criteria) this;
        }

        public Criteria andTeachingAndExerciseNotBetween(String value1, String value2) {
            addCriterion("TEACHING_AND_EXERCISE not between", value1, value2, "teachingAndExercise");
            return (Criteria) this;
        }

        public Criteria andClassTeacherIsNull() {
            addCriterion("CLASS_TEACHER is null");
            return (Criteria) this;
        }

        public Criteria andClassTeacherIsNotNull() {
            addCriterion("CLASS_TEACHER is not null");
            return (Criteria) this;
        }

        public Criteria andClassTeacherEqualTo(String value) {
            addCriterion("CLASS_TEACHER =", value, "classTeacher");
            return (Criteria) this;
        }

        public Criteria andClassTeacherNotEqualTo(String value) {
            addCriterion("CLASS_TEACHER <>", value, "classTeacher");
            return (Criteria) this;
        }

        public Criteria andClassTeacherGreaterThan(String value) {
            addCriterion("CLASS_TEACHER >", value, "classTeacher");
            return (Criteria) this;
        }

        public Criteria andClassTeacherGreaterThanOrEqualTo(String value) {
            addCriterion("CLASS_TEACHER >=", value, "classTeacher");
            return (Criteria) this;
        }

        public Criteria andClassTeacherLessThan(String value) {
            addCriterion("CLASS_TEACHER <", value, "classTeacher");
            return (Criteria) this;
        }

        public Criteria andClassTeacherLessThanOrEqualTo(String value) {
            addCriterion("CLASS_TEACHER <=", value, "classTeacher");
            return (Criteria) this;
        }

        public Criteria andClassTeacherLike(String value) {
            addCriterion("CLASS_TEACHER like", value, "classTeacher");
            return (Criteria) this;
        }

        public Criteria andClassTeacherNotLike(String value) {
            addCriterion("CLASS_TEACHER not like", value, "classTeacher");
            return (Criteria) this;
        }

        public Criteria andClassTeacherIn(List<String> values) {
            addCriterion("CLASS_TEACHER in", values, "classTeacher");
            return (Criteria) this;
        }

        public Criteria andClassTeacherNotIn(List<String> values) {
            addCriterion("CLASS_TEACHER not in", values, "classTeacher");
            return (Criteria) this;
        }

        public Criteria andClassTeacherBetween(String value1, String value2) {
            addCriterion("CLASS_TEACHER between", value1, value2, "classTeacher");
            return (Criteria) this;
        }

        public Criteria andClassTeacherNotBetween(String value1, String value2) {
            addCriterion("CLASS_TEACHER not between", value1, value2, "classTeacher");
            return (Criteria) this;
        }

        public Criteria andGoalIsNull() {
            addCriterion("GOAL is null");
            return (Criteria) this;
        }

        public Criteria andGoalIsNotNull() {
            addCriterion("GOAL is not null");
            return (Criteria) this;
        }

        public Criteria andGoalEqualTo(String value) {
            addCriterion("GOAL =", value, "goal");
            return (Criteria) this;
        }

        public Criteria andGoalNotEqualTo(String value) {
            addCriterion("GOAL <>", value, "goal");
            return (Criteria) this;
        }

        public Criteria andGoalGreaterThan(String value) {
            addCriterion("GOAL >", value, "goal");
            return (Criteria) this;
        }

        public Criteria andGoalGreaterThanOrEqualTo(String value) {
            addCriterion("GOAL >=", value, "goal");
            return (Criteria) this;
        }

        public Criteria andGoalLessThan(String value) {
            addCriterion("GOAL <", value, "goal");
            return (Criteria) this;
        }

        public Criteria andGoalLessThanOrEqualTo(String value) {
            addCriterion("GOAL <=", value, "goal");
            return (Criteria) this;
        }

        public Criteria andGoalLike(String value) {
            addCriterion("GOAL like", value, "goal");
            return (Criteria) this;
        }

        public Criteria andGoalNotLike(String value) {
            addCriterion("GOAL not like", value, "goal");
            return (Criteria) this;
        }

        public Criteria andGoalIn(List<String> values) {
            addCriterion("GOAL in", values, "goal");
            return (Criteria) this;
        }

        public Criteria andGoalNotIn(List<String> values) {
            addCriterion("GOAL not in", values, "goal");
            return (Criteria) this;
        }

        public Criteria andGoalBetween(String value1, String value2) {
            addCriterion("GOAL between", value1, value2, "goal");
            return (Criteria) this;
        }

        public Criteria andGoalNotBetween(String value1, String value2) {
            addCriterion("GOAL not between", value1, value2, "goal");
            return (Criteria) this;
        }

        public Criteria andOutlineIsNull() {
            addCriterion("OUTLINE is null");
            return (Criteria) this;
        }

        public Criteria andOutlineIsNotNull() {
            addCriterion("OUTLINE is not null");
            return (Criteria) this;
        }

        public Criteria andOutlineEqualTo(String value) {
            addCriterion("OUTLINE =", value, "outline");
            return (Criteria) this;
        }

        public Criteria andOutlineNotEqualTo(String value) {
            addCriterion("OUTLINE <>", value, "outline");
            return (Criteria) this;
        }

        public Criteria andOutlineGreaterThan(String value) {
            addCriterion("OUTLINE >", value, "outline");
            return (Criteria) this;
        }

        public Criteria andOutlineGreaterThanOrEqualTo(String value) {
            addCriterion("OUTLINE >=", value, "outline");
            return (Criteria) this;
        }

        public Criteria andOutlineLessThan(String value) {
            addCriterion("OUTLINE <", value, "outline");
            return (Criteria) this;
        }

        public Criteria andOutlineLessThanOrEqualTo(String value) {
            addCriterion("OUTLINE <=", value, "outline");
            return (Criteria) this;
        }

        public Criteria andOutlineLike(String value) {
            addCriterion("OUTLINE like", value, "outline");
            return (Criteria) this;
        }

        public Criteria andOutlineNotLike(String value) {
            addCriterion("OUTLINE not like", value, "outline");
            return (Criteria) this;
        }

        public Criteria andOutlineIn(List<String> values) {
            addCriterion("OUTLINE in", values, "outline");
            return (Criteria) this;
        }

        public Criteria andOutlineNotIn(List<String> values) {
            addCriterion("OUTLINE not in", values, "outline");
            return (Criteria) this;
        }

        public Criteria andOutlineBetween(String value1, String value2) {
            addCriterion("OUTLINE between", value1, value2, "outline");
            return (Criteria) this;
        }

        public Criteria andOutlineNotBetween(String value1, String value2) {
            addCriterion("OUTLINE not between", value1, value2, "outline");
            return (Criteria) this;
        }

        public Criteria andRegPhoneIsNull() {
            addCriterion("REG_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andRegPhoneIsNotNull() {
            addCriterion("REG_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andRegPhoneEqualTo(String value) {
            addCriterion("REG_PHONE =", value, "regPhone");
            return (Criteria) this;
        }

        public Criteria andRegPhoneNotEqualTo(String value) {
            addCriterion("REG_PHONE <>", value, "regPhone");
            return (Criteria) this;
        }

        public Criteria andRegPhoneGreaterThan(String value) {
            addCriterion("REG_PHONE >", value, "regPhone");
            return (Criteria) this;
        }

        public Criteria andRegPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("REG_PHONE >=", value, "regPhone");
            return (Criteria) this;
        }

        public Criteria andRegPhoneLessThan(String value) {
            addCriterion("REG_PHONE <", value, "regPhone");
            return (Criteria) this;
        }

        public Criteria andRegPhoneLessThanOrEqualTo(String value) {
            addCriterion("REG_PHONE <=", value, "regPhone");
            return (Criteria) this;
        }

        public Criteria andRegPhoneLike(String value) {
            addCriterion("REG_PHONE like", value, "regPhone");
            return (Criteria) this;
        }

        public Criteria andRegPhoneNotLike(String value) {
            addCriterion("REG_PHONE not like", value, "regPhone");
            return (Criteria) this;
        }

        public Criteria andRegPhoneIn(List<String> values) {
            addCriterion("REG_PHONE in", values, "regPhone");
            return (Criteria) this;
        }

        public Criteria andRegPhoneNotIn(List<String> values) {
            addCriterion("REG_PHONE not in", values, "regPhone");
            return (Criteria) this;
        }

        public Criteria andRegPhoneBetween(String value1, String value2) {
            addCriterion("REG_PHONE between", value1, value2, "regPhone");
            return (Criteria) this;
        }

        public Criteria andRegPhoneNotBetween(String value1, String value2) {
            addCriterion("REG_PHONE not between", value1, value2, "regPhone");
            return (Criteria) this;
        }

        public Criteria andContactIsNull() {
            addCriterion("CONTACT is null");
            return (Criteria) this;
        }

        public Criteria andContactIsNotNull() {
            addCriterion("CONTACT is not null");
            return (Criteria) this;
        }

        public Criteria andContactEqualTo(String value) {
            addCriterion("CONTACT =", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotEqualTo(String value) {
            addCriterion("CONTACT <>", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactGreaterThan(String value) {
            addCriterion("CONTACT >", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactGreaterThanOrEqualTo(String value) {
            addCriterion("CONTACT >=", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLessThan(String value) {
            addCriterion("CONTACT <", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLessThanOrEqualTo(String value) {
            addCriterion("CONTACT <=", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLike(String value) {
            addCriterion("CONTACT like", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotLike(String value) {
            addCriterion("CONTACT not like", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactIn(List<String> values) {
            addCriterion("CONTACT in", values, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotIn(List<String> values) {
            addCriterion("CONTACT not in", values, "contact");
            return (Criteria) this;
        }

        public Criteria andContactBetween(String value1, String value2) {
            addCriterion("CONTACT between", value1, value2, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotBetween(String value1, String value2) {
            addCriterion("CONTACT not between", value1, value2, "contact");
            return (Criteria) this;
        }

        public Criteria andExtracurricularIsNull() {
            addCriterion("EXTRACURRICULAR is null");
            return (Criteria) this;
        }

        public Criteria andExtracurricularIsNotNull() {
            addCriterion("EXTRACURRICULAR is not null");
            return (Criteria) this;
        }

        public Criteria andExtracurricularEqualTo(String value) {
            addCriterion("EXTRACURRICULAR =", value, "extracurricular");
            return (Criteria) this;
        }

        public Criteria andExtracurricularNotEqualTo(String value) {
            addCriterion("EXTRACURRICULAR <>", value, "extracurricular");
            return (Criteria) this;
        }

        public Criteria andExtracurricularGreaterThan(String value) {
            addCriterion("EXTRACURRICULAR >", value, "extracurricular");
            return (Criteria) this;
        }

        public Criteria andExtracurricularGreaterThanOrEqualTo(String value) {
            addCriterion("EXTRACURRICULAR >=", value, "extracurricular");
            return (Criteria) this;
        }

        public Criteria andExtracurricularLessThan(String value) {
            addCriterion("EXTRACURRICULAR <", value, "extracurricular");
            return (Criteria) this;
        }

        public Criteria andExtracurricularLessThanOrEqualTo(String value) {
            addCriterion("EXTRACURRICULAR <=", value, "extracurricular");
            return (Criteria) this;
        }

        public Criteria andExtracurricularLike(String value) {
            addCriterion("EXTRACURRICULAR like", value, "extracurricular");
            return (Criteria) this;
        }

        public Criteria andExtracurricularNotLike(String value) {
            addCriterion("EXTRACURRICULAR not like", value, "extracurricular");
            return (Criteria) this;
        }

        public Criteria andExtracurricularIn(List<String> values) {
            addCriterion("EXTRACURRICULAR in", values, "extracurricular");
            return (Criteria) this;
        }

        public Criteria andExtracurricularNotIn(List<String> values) {
            addCriterion("EXTRACURRICULAR not in", values, "extracurricular");
            return (Criteria) this;
        }

        public Criteria andExtracurricularBetween(String value1, String value2) {
            addCriterion("EXTRACURRICULAR between", value1, value2, "extracurricular");
            return (Criteria) this;
        }

        public Criteria andExtracurricularNotBetween(String value1, String value2) {
            addCriterion("EXTRACURRICULAR not between", value1, value2, "extracurricular");
            return (Criteria) this;
        }

        public Criteria andPassAgreementIsNull() {
            addCriterion("PASS_AGREEMENT is null");
            return (Criteria) this;
        }

        public Criteria andPassAgreementIsNotNull() {
            addCriterion("PASS_AGREEMENT is not null");
            return (Criteria) this;
        }

        public Criteria andPassAgreementEqualTo(String value) {
            addCriterion("PASS_AGREEMENT =", value, "passAgreement");
            return (Criteria) this;
        }

        public Criteria andPassAgreementNotEqualTo(String value) {
            addCriterion("PASS_AGREEMENT <>", value, "passAgreement");
            return (Criteria) this;
        }

        public Criteria andPassAgreementGreaterThan(String value) {
            addCriterion("PASS_AGREEMENT >", value, "passAgreement");
            return (Criteria) this;
        }

        public Criteria andPassAgreementGreaterThanOrEqualTo(String value) {
            addCriterion("PASS_AGREEMENT >=", value, "passAgreement");
            return (Criteria) this;
        }

        public Criteria andPassAgreementLessThan(String value) {
            addCriterion("PASS_AGREEMENT <", value, "passAgreement");
            return (Criteria) this;
        }

        public Criteria andPassAgreementLessThanOrEqualTo(String value) {
            addCriterion("PASS_AGREEMENT <=", value, "passAgreement");
            return (Criteria) this;
        }

        public Criteria andPassAgreementLike(String value) {
            addCriterion("PASS_AGREEMENT like", value, "passAgreement");
            return (Criteria) this;
        }

        public Criteria andPassAgreementNotLike(String value) {
            addCriterion("PASS_AGREEMENT not like", value, "passAgreement");
            return (Criteria) this;
        }

        public Criteria andPassAgreementIn(List<String> values) {
            addCriterion("PASS_AGREEMENT in", values, "passAgreement");
            return (Criteria) this;
        }

        public Criteria andPassAgreementNotIn(List<String> values) {
            addCriterion("PASS_AGREEMENT not in", values, "passAgreement");
            return (Criteria) this;
        }

        public Criteria andPassAgreementBetween(String value1, String value2) {
            addCriterion("PASS_AGREEMENT between", value1, value2, "passAgreement");
            return (Criteria) this;
        }

        public Criteria andPassAgreementNotBetween(String value1, String value2) {
            addCriterion("PASS_AGREEMENT not between", value1, value2, "passAgreement");
            return (Criteria) this;
        }

        public Criteria andQualityAssuranceIsNull() {
            addCriterion("QUALITY_ASSURANCE is null");
            return (Criteria) this;
        }

        public Criteria andQualityAssuranceIsNotNull() {
            addCriterion("QUALITY_ASSURANCE is not null");
            return (Criteria) this;
        }

        public Criteria andQualityAssuranceEqualTo(String value) {
            addCriterion("QUALITY_ASSURANCE =", value, "qualityAssurance");
            return (Criteria) this;
        }

        public Criteria andQualityAssuranceNotEqualTo(String value) {
            addCriterion("QUALITY_ASSURANCE <>", value, "qualityAssurance");
            return (Criteria) this;
        }

        public Criteria andQualityAssuranceGreaterThan(String value) {
            addCriterion("QUALITY_ASSURANCE >", value, "qualityAssurance");
            return (Criteria) this;
        }

        public Criteria andQualityAssuranceGreaterThanOrEqualTo(String value) {
            addCriterion("QUALITY_ASSURANCE >=", value, "qualityAssurance");
            return (Criteria) this;
        }

        public Criteria andQualityAssuranceLessThan(String value) {
            addCriterion("QUALITY_ASSURANCE <", value, "qualityAssurance");
            return (Criteria) this;
        }

        public Criteria andQualityAssuranceLessThanOrEqualTo(String value) {
            addCriterion("QUALITY_ASSURANCE <=", value, "qualityAssurance");
            return (Criteria) this;
        }

        public Criteria andQualityAssuranceLike(String value) {
            addCriterion("QUALITY_ASSURANCE like", value, "qualityAssurance");
            return (Criteria) this;
        }

        public Criteria andQualityAssuranceNotLike(String value) {
            addCriterion("QUALITY_ASSURANCE not like", value, "qualityAssurance");
            return (Criteria) this;
        }

        public Criteria andQualityAssuranceIn(List<String> values) {
            addCriterion("QUALITY_ASSURANCE in", values, "qualityAssurance");
            return (Criteria) this;
        }

        public Criteria andQualityAssuranceNotIn(List<String> values) {
            addCriterion("QUALITY_ASSURANCE not in", values, "qualityAssurance");
            return (Criteria) this;
        }

        public Criteria andQualityAssuranceBetween(String value1, String value2) {
            addCriterion("QUALITY_ASSURANCE between", value1, value2, "qualityAssurance");
            return (Criteria) this;
        }

        public Criteria andQualityAssuranceNotBetween(String value1, String value2) {
            addCriterion("QUALITY_ASSURANCE not between", value1, value2, "qualityAssurance");
            return (Criteria) this;
        }

        public Criteria andQuestionBankIsNull() {
            addCriterion("QUESTION_BANK is null");
            return (Criteria) this;
        }

        public Criteria andQuestionBankIsNotNull() {
            addCriterion("QUESTION_BANK is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionBankEqualTo(String value) {
            addCriterion("QUESTION_BANK =", value, "questionBank");
            return (Criteria) this;
        }

        public Criteria andQuestionBankNotEqualTo(String value) {
            addCriterion("QUESTION_BANK <>", value, "questionBank");
            return (Criteria) this;
        }

        public Criteria andQuestionBankGreaterThan(String value) {
            addCriterion("QUESTION_BANK >", value, "questionBank");
            return (Criteria) this;
        }

        public Criteria andQuestionBankGreaterThanOrEqualTo(String value) {
            addCriterion("QUESTION_BANK >=", value, "questionBank");
            return (Criteria) this;
        }

        public Criteria andQuestionBankLessThan(String value) {
            addCriterion("QUESTION_BANK <", value, "questionBank");
            return (Criteria) this;
        }

        public Criteria andQuestionBankLessThanOrEqualTo(String value) {
            addCriterion("QUESTION_BANK <=", value, "questionBank");
            return (Criteria) this;
        }

        public Criteria andQuestionBankLike(String value) {
            addCriterion("QUESTION_BANK like", value, "questionBank");
            return (Criteria) this;
        }

        public Criteria andQuestionBankNotLike(String value) {
            addCriterion("QUESTION_BANK not like", value, "questionBank");
            return (Criteria) this;
        }

        public Criteria andQuestionBankIn(List<String> values) {
            addCriterion("QUESTION_BANK in", values, "questionBank");
            return (Criteria) this;
        }

        public Criteria andQuestionBankNotIn(List<String> values) {
            addCriterion("QUESTION_BANK not in", values, "questionBank");
            return (Criteria) this;
        }

        public Criteria andQuestionBankBetween(String value1, String value2) {
            addCriterion("QUESTION_BANK between", value1, value2, "questionBank");
            return (Criteria) this;
        }

        public Criteria andQuestionBankNotBetween(String value1, String value2) {
            addCriterion("QUESTION_BANK not between", value1, value2, "questionBank");
            return (Criteria) this;
        }

        public Criteria andTeachingMaterialIntroIsNull() {
            addCriterion("TEACHING_MATERIAL_INTRO is null");
            return (Criteria) this;
        }

        public Criteria andTeachingMaterialIntroIsNotNull() {
            addCriterion("TEACHING_MATERIAL_INTRO is not null");
            return (Criteria) this;
        }

        public Criteria andTeachingMaterialIntroEqualTo(String value) {
            addCriterion("TEACHING_MATERIAL_INTRO =", value, "teachingMaterialIntro");
            return (Criteria) this;
        }

        public Criteria andTeachingMaterialIntroNotEqualTo(String value) {
            addCriterion("TEACHING_MATERIAL_INTRO <>", value, "teachingMaterialIntro");
            return (Criteria) this;
        }

        public Criteria andTeachingMaterialIntroGreaterThan(String value) {
            addCriterion("TEACHING_MATERIAL_INTRO >", value, "teachingMaterialIntro");
            return (Criteria) this;
        }

        public Criteria andTeachingMaterialIntroGreaterThanOrEqualTo(String value) {
            addCriterion("TEACHING_MATERIAL_INTRO >=", value, "teachingMaterialIntro");
            return (Criteria) this;
        }

        public Criteria andTeachingMaterialIntroLessThan(String value) {
            addCriterion("TEACHING_MATERIAL_INTRO <", value, "teachingMaterialIntro");
            return (Criteria) this;
        }

        public Criteria andTeachingMaterialIntroLessThanOrEqualTo(String value) {
            addCriterion("TEACHING_MATERIAL_INTRO <=", value, "teachingMaterialIntro");
            return (Criteria) this;
        }

        public Criteria andTeachingMaterialIntroLike(String value) {
            addCriterion("TEACHING_MATERIAL_INTRO like", value, "teachingMaterialIntro");
            return (Criteria) this;
        }

        public Criteria andTeachingMaterialIntroNotLike(String value) {
            addCriterion("TEACHING_MATERIAL_INTRO not like", value, "teachingMaterialIntro");
            return (Criteria) this;
        }

        public Criteria andTeachingMaterialIntroIn(List<String> values) {
            addCriterion("TEACHING_MATERIAL_INTRO in", values, "teachingMaterialIntro");
            return (Criteria) this;
        }

        public Criteria andTeachingMaterialIntroNotIn(List<String> values) {
            addCriterion("TEACHING_MATERIAL_INTRO not in", values, "teachingMaterialIntro");
            return (Criteria) this;
        }

        public Criteria andTeachingMaterialIntroBetween(String value1, String value2) {
            addCriterion("TEACHING_MATERIAL_INTRO between", value1, value2, "teachingMaterialIntro");
            return (Criteria) this;
        }

        public Criteria andTeachingMaterialIntroNotBetween(String value1, String value2) {
            addCriterion("TEACHING_MATERIAL_INTRO not between", value1, value2, "teachingMaterialIntro");
            return (Criteria) this;
        }

        public Criteria andStudyDayNoteIsNull() {
            addCriterion("STUDY_DAY_NOTE is null");
            return (Criteria) this;
        }

        public Criteria andStudyDayNoteIsNotNull() {
            addCriterion("STUDY_DAY_NOTE is not null");
            return (Criteria) this;
        }

        public Criteria andStudyDayNoteEqualTo(String value) {
            addCriterion("STUDY_DAY_NOTE =", value, "studyDayNote");
            return (Criteria) this;
        }

        public Criteria andStudyDayNoteNotEqualTo(String value) {
            addCriterion("STUDY_DAY_NOTE <>", value, "studyDayNote");
            return (Criteria) this;
        }

        public Criteria andStudyDayNoteGreaterThan(String value) {
            addCriterion("STUDY_DAY_NOTE >", value, "studyDayNote");
            return (Criteria) this;
        }

        public Criteria andStudyDayNoteGreaterThanOrEqualTo(String value) {
            addCriterion("STUDY_DAY_NOTE >=", value, "studyDayNote");
            return (Criteria) this;
        }

        public Criteria andStudyDayNoteLessThan(String value) {
            addCriterion("STUDY_DAY_NOTE <", value, "studyDayNote");
            return (Criteria) this;
        }

        public Criteria andStudyDayNoteLessThanOrEqualTo(String value) {
            addCriterion("STUDY_DAY_NOTE <=", value, "studyDayNote");
            return (Criteria) this;
        }

        public Criteria andStudyDayNoteLike(String value) {
            addCriterion("STUDY_DAY_NOTE like", value, "studyDayNote");
            return (Criteria) this;
        }

        public Criteria andStudyDayNoteNotLike(String value) {
            addCriterion("STUDY_DAY_NOTE not like", value, "studyDayNote");
            return (Criteria) this;
        }

        public Criteria andStudyDayNoteIn(List<String> values) {
            addCriterion("STUDY_DAY_NOTE in", values, "studyDayNote");
            return (Criteria) this;
        }

        public Criteria andStudyDayNoteNotIn(List<String> values) {
            addCriterion("STUDY_DAY_NOTE not in", values, "studyDayNote");
            return (Criteria) this;
        }

        public Criteria andStudyDayNoteBetween(String value1, String value2) {
            addCriterion("STUDY_DAY_NOTE between", value1, value2, "studyDayNote");
            return (Criteria) this;
        }

        public Criteria andStudyDayNoteNotBetween(String value1, String value2) {
            addCriterion("STUDY_DAY_NOTE not between", value1, value2, "studyDayNote");
            return (Criteria) this;
        }

        public Criteria andHighScoreRewardIsNull() {
            addCriterion("HIGH_SCORE_REWARD is null");
            return (Criteria) this;
        }

        public Criteria andHighScoreRewardIsNotNull() {
            addCriterion("HIGH_SCORE_REWARD is not null");
            return (Criteria) this;
        }

        public Criteria andHighScoreRewardEqualTo(String value) {
            addCriterion("HIGH_SCORE_REWARD =", value, "highScoreReward");
            return (Criteria) this;
        }

        public Criteria andHighScoreRewardNotEqualTo(String value) {
            addCriterion("HIGH_SCORE_REWARD <>", value, "highScoreReward");
            return (Criteria) this;
        }

        public Criteria andHighScoreRewardGreaterThan(String value) {
            addCriterion("HIGH_SCORE_REWARD >", value, "highScoreReward");
            return (Criteria) this;
        }

        public Criteria andHighScoreRewardGreaterThanOrEqualTo(String value) {
            addCriterion("HIGH_SCORE_REWARD >=", value, "highScoreReward");
            return (Criteria) this;
        }

        public Criteria andHighScoreRewardLessThan(String value) {
            addCriterion("HIGH_SCORE_REWARD <", value, "highScoreReward");
            return (Criteria) this;
        }

        public Criteria andHighScoreRewardLessThanOrEqualTo(String value) {
            addCriterion("HIGH_SCORE_REWARD <=", value, "highScoreReward");
            return (Criteria) this;
        }

        public Criteria andHighScoreRewardLike(String value) {
            addCriterion("HIGH_SCORE_REWARD like", value, "highScoreReward");
            return (Criteria) this;
        }

        public Criteria andHighScoreRewardNotLike(String value) {
            addCriterion("HIGH_SCORE_REWARD not like", value, "highScoreReward");
            return (Criteria) this;
        }

        public Criteria andHighScoreRewardIn(List<String> values) {
            addCriterion("HIGH_SCORE_REWARD in", values, "highScoreReward");
            return (Criteria) this;
        }

        public Criteria andHighScoreRewardNotIn(List<String> values) {
            addCriterion("HIGH_SCORE_REWARD not in", values, "highScoreReward");
            return (Criteria) this;
        }

        public Criteria andHighScoreRewardBetween(String value1, String value2) {
            addCriterion("HIGH_SCORE_REWARD between", value1, value2, "highScoreReward");
            return (Criteria) this;
        }

        public Criteria andHighScoreRewardNotBetween(String value1, String value2) {
            addCriterion("HIGH_SCORE_REWARD not between", value1, value2, "highScoreReward");
            return (Criteria) this;
        }

        public Criteria andPrerequestIsNull() {
            addCriterion("PREREQUEST is null");
            return (Criteria) this;
        }

        public Criteria andPrerequestIsNotNull() {
            addCriterion("PREREQUEST is not null");
            return (Criteria) this;
        }

        public Criteria andPrerequestEqualTo(String value) {
            addCriterion("PREREQUEST =", value, "prerequest");
            return (Criteria) this;
        }

        public Criteria andPrerequestNotEqualTo(String value) {
            addCriterion("PREREQUEST <>", value, "prerequest");
            return (Criteria) this;
        }

        public Criteria andPrerequestGreaterThan(String value) {
            addCriterion("PREREQUEST >", value, "prerequest");
            return (Criteria) this;
        }

        public Criteria andPrerequestGreaterThanOrEqualTo(String value) {
            addCriterion("PREREQUEST >=", value, "prerequest");
            return (Criteria) this;
        }

        public Criteria andPrerequestLessThan(String value) {
            addCriterion("PREREQUEST <", value, "prerequest");
            return (Criteria) this;
        }

        public Criteria andPrerequestLessThanOrEqualTo(String value) {
            addCriterion("PREREQUEST <=", value, "prerequest");
            return (Criteria) this;
        }

        public Criteria andPrerequestLike(String value) {
            addCriterion("PREREQUEST like", value, "prerequest");
            return (Criteria) this;
        }

        public Criteria andPrerequestNotLike(String value) {
            addCriterion("PREREQUEST not like", value, "prerequest");
            return (Criteria) this;
        }

        public Criteria andPrerequestIn(List<String> values) {
            addCriterion("PREREQUEST in", values, "prerequest");
            return (Criteria) this;
        }

        public Criteria andPrerequestNotIn(List<String> values) {
            addCriterion("PREREQUEST not in", values, "prerequest");
            return (Criteria) this;
        }

        public Criteria andPrerequestBetween(String value1, String value2) {
            addCriterion("PREREQUEST between", value1, value2, "prerequest");
            return (Criteria) this;
        }

        public Criteria andPrerequestNotBetween(String value1, String value2) {
            addCriterion("PREREQUEST not between", value1, value2, "prerequest");
            return (Criteria) this;
        }

        public Criteria andSuitableStudentIsNull() {
            addCriterion("SUITABLE_STUDENT is null");
            return (Criteria) this;
        }

        public Criteria andSuitableStudentIsNotNull() {
            addCriterion("SUITABLE_STUDENT is not null");
            return (Criteria) this;
        }

        public Criteria andSuitableStudentEqualTo(String value) {
            addCriterion("SUITABLE_STUDENT =", value, "suitableStudent");
            return (Criteria) this;
        }

        public Criteria andSuitableStudentNotEqualTo(String value) {
            addCriterion("SUITABLE_STUDENT <>", value, "suitableStudent");
            return (Criteria) this;
        }

        public Criteria andSuitableStudentGreaterThan(String value) {
            addCriterion("SUITABLE_STUDENT >", value, "suitableStudent");
            return (Criteria) this;
        }

        public Criteria andSuitableStudentGreaterThanOrEqualTo(String value) {
            addCriterion("SUITABLE_STUDENT >=", value, "suitableStudent");
            return (Criteria) this;
        }

        public Criteria andSuitableStudentLessThan(String value) {
            addCriterion("SUITABLE_STUDENT <", value, "suitableStudent");
            return (Criteria) this;
        }

        public Criteria andSuitableStudentLessThanOrEqualTo(String value) {
            addCriterion("SUITABLE_STUDENT <=", value, "suitableStudent");
            return (Criteria) this;
        }

        public Criteria andSuitableStudentLike(String value) {
            addCriterion("SUITABLE_STUDENT like", value, "suitableStudent");
            return (Criteria) this;
        }

        public Criteria andSuitableStudentNotLike(String value) {
            addCriterion("SUITABLE_STUDENT not like", value, "suitableStudent");
            return (Criteria) this;
        }

        public Criteria andSuitableStudentIn(List<String> values) {
            addCriterion("SUITABLE_STUDENT in", values, "suitableStudent");
            return (Criteria) this;
        }

        public Criteria andSuitableStudentNotIn(List<String> values) {
            addCriterion("SUITABLE_STUDENT not in", values, "suitableStudent");
            return (Criteria) this;
        }

        public Criteria andSuitableStudentBetween(String value1, String value2) {
            addCriterion("SUITABLE_STUDENT between", value1, value2, "suitableStudent");
            return (Criteria) this;
        }

        public Criteria andSuitableStudentNotBetween(String value1, String value2) {
            addCriterion("SUITABLE_STUDENT not between", value1, value2, "suitableStudent");
            return (Criteria) this;
        }

        public Criteria andOpenCourseRequirementIsNull() {
            addCriterion("OPEN_COURSE_REQUIREMENT is null");
            return (Criteria) this;
        }

        public Criteria andOpenCourseRequirementIsNotNull() {
            addCriterion("OPEN_COURSE_REQUIREMENT is not null");
            return (Criteria) this;
        }

        public Criteria andOpenCourseRequirementEqualTo(String value) {
            addCriterion("OPEN_COURSE_REQUIREMENT =", value, "openCourseRequirement");
            return (Criteria) this;
        }

        public Criteria andOpenCourseRequirementNotEqualTo(String value) {
            addCriterion("OPEN_COURSE_REQUIREMENT <>", value, "openCourseRequirement");
            return (Criteria) this;
        }

        public Criteria andOpenCourseRequirementGreaterThan(String value) {
            addCriterion("OPEN_COURSE_REQUIREMENT >", value, "openCourseRequirement");
            return (Criteria) this;
        }

        public Criteria andOpenCourseRequirementGreaterThanOrEqualTo(String value) {
            addCriterion("OPEN_COURSE_REQUIREMENT >=", value, "openCourseRequirement");
            return (Criteria) this;
        }

        public Criteria andOpenCourseRequirementLessThan(String value) {
            addCriterion("OPEN_COURSE_REQUIREMENT <", value, "openCourseRequirement");
            return (Criteria) this;
        }

        public Criteria andOpenCourseRequirementLessThanOrEqualTo(String value) {
            addCriterion("OPEN_COURSE_REQUIREMENT <=", value, "openCourseRequirement");
            return (Criteria) this;
        }

        public Criteria andOpenCourseRequirementLike(String value) {
            addCriterion("OPEN_COURSE_REQUIREMENT like", value, "openCourseRequirement");
            return (Criteria) this;
        }

        public Criteria andOpenCourseRequirementNotLike(String value) {
            addCriterion("OPEN_COURSE_REQUIREMENT not like", value, "openCourseRequirement");
            return (Criteria) this;
        }

        public Criteria andOpenCourseRequirementIn(List<String> values) {
            addCriterion("OPEN_COURSE_REQUIREMENT in", values, "openCourseRequirement");
            return (Criteria) this;
        }

        public Criteria andOpenCourseRequirementNotIn(List<String> values) {
            addCriterion("OPEN_COURSE_REQUIREMENT not in", values, "openCourseRequirement");
            return (Criteria) this;
        }

        public Criteria andOpenCourseRequirementBetween(String value1, String value2) {
            addCriterion("OPEN_COURSE_REQUIREMENT between", value1, value2, "openCourseRequirement");
            return (Criteria) this;
        }

        public Criteria andOpenCourseRequirementNotBetween(String value1, String value2) {
            addCriterion("OPEN_COURSE_REQUIREMENT not between", value1, value2, "openCourseRequirement");
            return (Criteria) this;
        }

        public Criteria andCertificationIsNull() {
            addCriterion("CERTIFICATION is null");
            return (Criteria) this;
        }

        public Criteria andCertificationIsNotNull() {
            addCriterion("CERTIFICATION is not null");
            return (Criteria) this;
        }

        public Criteria andCertificationEqualTo(String value) {
            addCriterion("CERTIFICATION =", value, "certification");
            return (Criteria) this;
        }

        public Criteria andCertificationNotEqualTo(String value) {
            addCriterion("CERTIFICATION <>", value, "certification");
            return (Criteria) this;
        }

        public Criteria andCertificationGreaterThan(String value) {
            addCriterion("CERTIFICATION >", value, "certification");
            return (Criteria) this;
        }

        public Criteria andCertificationGreaterThanOrEqualTo(String value) {
            addCriterion("CERTIFICATION >=", value, "certification");
            return (Criteria) this;
        }

        public Criteria andCertificationLessThan(String value) {
            addCriterion("CERTIFICATION <", value, "certification");
            return (Criteria) this;
        }

        public Criteria andCertificationLessThanOrEqualTo(String value) {
            addCriterion("CERTIFICATION <=", value, "certification");
            return (Criteria) this;
        }

        public Criteria andCertificationLike(String value) {
            addCriterion("CERTIFICATION like", value, "certification");
            return (Criteria) this;
        }

        public Criteria andCertificationNotLike(String value) {
            addCriterion("CERTIFICATION not like", value, "certification");
            return (Criteria) this;
        }

        public Criteria andCertificationIn(List<String> values) {
            addCriterion("CERTIFICATION in", values, "certification");
            return (Criteria) this;
        }

        public Criteria andCertificationNotIn(List<String> values) {
            addCriterion("CERTIFICATION not in", values, "certification");
            return (Criteria) this;
        }

        public Criteria andCertificationBetween(String value1, String value2) {
            addCriterion("CERTIFICATION between", value1, value2, "certification");
            return (Criteria) this;
        }

        public Criteria andCertificationNotBetween(String value1, String value2) {
            addCriterion("CERTIFICATION not between", value1, value2, "certification");
            return (Criteria) this;
        }

        public Criteria andQuizIsNull() {
            addCriterion("QUIZ is null");
            return (Criteria) this;
        }

        public Criteria andQuizIsNotNull() {
            addCriterion("QUIZ is not null");
            return (Criteria) this;
        }

        public Criteria andQuizEqualTo(String value) {
            addCriterion("QUIZ =", value, "quiz");
            return (Criteria) this;
        }

        public Criteria andQuizNotEqualTo(String value) {
            addCriterion("QUIZ <>", value, "quiz");
            return (Criteria) this;
        }

        public Criteria andQuizGreaterThan(String value) {
            addCriterion("QUIZ >", value, "quiz");
            return (Criteria) this;
        }

        public Criteria andQuizGreaterThanOrEqualTo(String value) {
            addCriterion("QUIZ >=", value, "quiz");
            return (Criteria) this;
        }

        public Criteria andQuizLessThan(String value) {
            addCriterion("QUIZ <", value, "quiz");
            return (Criteria) this;
        }

        public Criteria andQuizLessThanOrEqualTo(String value) {
            addCriterion("QUIZ <=", value, "quiz");
            return (Criteria) this;
        }

        public Criteria andQuizLike(String value) {
            addCriterion("QUIZ like", value, "quiz");
            return (Criteria) this;
        }

        public Criteria andQuizNotLike(String value) {
            addCriterion("QUIZ not like", value, "quiz");
            return (Criteria) this;
        }

        public Criteria andQuizIn(List<String> values) {
            addCriterion("QUIZ in", values, "quiz");
            return (Criteria) this;
        }

        public Criteria andQuizNotIn(List<String> values) {
            addCriterion("QUIZ not in", values, "quiz");
            return (Criteria) this;
        }

        public Criteria andQuizBetween(String value1, String value2) {
            addCriterion("QUIZ between", value1, value2, "quiz");
            return (Criteria) this;
        }

        public Criteria andQuizNotBetween(String value1, String value2) {
            addCriterion("QUIZ not between", value1, value2, "quiz");
            return (Criteria) this;
        }

        public Criteria andCourseIntroIsNull() {
            addCriterion("COURSE_INTRO is null");
            return (Criteria) this;
        }

        public Criteria andCourseIntroIsNotNull() {
            addCriterion("COURSE_INTRO is not null");
            return (Criteria) this;
        }

        public Criteria andCourseIntroEqualTo(String value) {
            addCriterion("COURSE_INTRO =", value, "courseIntro");
            return (Criteria) this;
        }

        public Criteria andCourseIntroNotEqualTo(String value) {
            addCriterion("COURSE_INTRO <>", value, "courseIntro");
            return (Criteria) this;
        }

        public Criteria andCourseIntroGreaterThan(String value) {
            addCriterion("COURSE_INTRO >", value, "courseIntro");
            return (Criteria) this;
        }

        public Criteria andCourseIntroGreaterThanOrEqualTo(String value) {
            addCriterion("COURSE_INTRO >=", value, "courseIntro");
            return (Criteria) this;
        }

        public Criteria andCourseIntroLessThan(String value) {
            addCriterion("COURSE_INTRO <", value, "courseIntro");
            return (Criteria) this;
        }

        public Criteria andCourseIntroLessThanOrEqualTo(String value) {
            addCriterion("COURSE_INTRO <=", value, "courseIntro");
            return (Criteria) this;
        }

        public Criteria andCourseIntroLike(String value) {
            addCriterion("COURSE_INTRO like", value, "courseIntro");
            return (Criteria) this;
        }

        public Criteria andCourseIntroNotLike(String value) {
            addCriterion("COURSE_INTRO not like", value, "courseIntro");
            return (Criteria) this;
        }

        public Criteria andCourseIntroIn(List<String> values) {
            addCriterion("COURSE_INTRO in", values, "courseIntro");
            return (Criteria) this;
        }

        public Criteria andCourseIntroNotIn(List<String> values) {
            addCriterion("COURSE_INTRO not in", values, "courseIntro");
            return (Criteria) this;
        }

        public Criteria andCourseIntroBetween(String value1, String value2) {
            addCriterion("COURSE_INTRO between", value1, value2, "courseIntro");
            return (Criteria) this;
        }

        public Criteria andCourseIntroNotBetween(String value1, String value2) {
            addCriterion("COURSE_INTRO not between", value1, value2, "courseIntro");
            return (Criteria) this;
        }

        public Criteria andReferenceIsNull() {
            addCriterion("REFERENCE is null");
            return (Criteria) this;
        }

        public Criteria andReferenceIsNotNull() {
            addCriterion("REFERENCE is not null");
            return (Criteria) this;
        }

        public Criteria andReferenceEqualTo(String value) {
            addCriterion("REFERENCE =", value, "reference");
            return (Criteria) this;
        }

        public Criteria andReferenceNotEqualTo(String value) {
            addCriterion("REFERENCE <>", value, "reference");
            return (Criteria) this;
        }

        public Criteria andReferenceGreaterThan(String value) {
            addCriterion("REFERENCE >", value, "reference");
            return (Criteria) this;
        }

        public Criteria andReferenceGreaterThanOrEqualTo(String value) {
            addCriterion("REFERENCE >=", value, "reference");
            return (Criteria) this;
        }

        public Criteria andReferenceLessThan(String value) {
            addCriterion("REFERENCE <", value, "reference");
            return (Criteria) this;
        }

        public Criteria andReferenceLessThanOrEqualTo(String value) {
            addCriterion("REFERENCE <=", value, "reference");
            return (Criteria) this;
        }

        public Criteria andReferenceLike(String value) {
            addCriterion("REFERENCE like", value, "reference");
            return (Criteria) this;
        }

        public Criteria andReferenceNotLike(String value) {
            addCriterion("REFERENCE not like", value, "reference");
            return (Criteria) this;
        }

        public Criteria andReferenceIn(List<String> values) {
            addCriterion("REFERENCE in", values, "reference");
            return (Criteria) this;
        }

        public Criteria andReferenceNotIn(List<String> values) {
            addCriterion("REFERENCE not in", values, "reference");
            return (Criteria) this;
        }

        public Criteria andReferenceBetween(String value1, String value2) {
            addCriterion("REFERENCE between", value1, value2, "reference");
            return (Criteria) this;
        }

        public Criteria andReferenceNotBetween(String value1, String value2) {
            addCriterion("REFERENCE not between", value1, value2, "reference");
            return (Criteria) this;
        }

        public Criteria andRegLocationIsNull() {
            addCriterion("REG_LOCATION is null");
            return (Criteria) this;
        }

        public Criteria andRegLocationIsNotNull() {
            addCriterion("REG_LOCATION is not null");
            return (Criteria) this;
        }

        public Criteria andRegLocationEqualTo(String value) {
            addCriterion("REG_LOCATION =", value, "regLocation");
            return (Criteria) this;
        }

        public Criteria andRegLocationNotEqualTo(String value) {
            addCriterion("REG_LOCATION <>", value, "regLocation");
            return (Criteria) this;
        }

        public Criteria andRegLocationGreaterThan(String value) {
            addCriterion("REG_LOCATION >", value, "regLocation");
            return (Criteria) this;
        }

        public Criteria andRegLocationGreaterThanOrEqualTo(String value) {
            addCriterion("REG_LOCATION >=", value, "regLocation");
            return (Criteria) this;
        }

        public Criteria andRegLocationLessThan(String value) {
            addCriterion("REG_LOCATION <", value, "regLocation");
            return (Criteria) this;
        }

        public Criteria andRegLocationLessThanOrEqualTo(String value) {
            addCriterion("REG_LOCATION <=", value, "regLocation");
            return (Criteria) this;
        }

        public Criteria andRegLocationLike(String value) {
            addCriterion("REG_LOCATION like", value, "regLocation");
            return (Criteria) this;
        }

        public Criteria andRegLocationNotLike(String value) {
            addCriterion("REG_LOCATION not like", value, "regLocation");
            return (Criteria) this;
        }

        public Criteria andRegLocationIn(List<String> values) {
            addCriterion("REG_LOCATION in", values, "regLocation");
            return (Criteria) this;
        }

        public Criteria andRegLocationNotIn(List<String> values) {
            addCriterion("REG_LOCATION not in", values, "regLocation");
            return (Criteria) this;
        }

        public Criteria andRegLocationBetween(String value1, String value2) {
            addCriterion("REG_LOCATION between", value1, value2, "regLocation");
            return (Criteria) this;
        }

        public Criteria andRegLocationNotBetween(String value1, String value2) {
            addCriterion("REG_LOCATION not between", value1, value2, "regLocation");
            return (Criteria) this;
        }

        public Criteria andFinishTime2IsNull() {
            addCriterion("FINISH_TIME2 is null");
            return (Criteria) this;
        }

        public Criteria andFinishTime2IsNotNull() {
            addCriterion("FINISH_TIME2 is not null");
            return (Criteria) this;
        }

        public Criteria andFinishTime2EqualTo(Integer value) {
            addCriterion("FINISH_TIME2 =", value, "finishTime2");
            return (Criteria) this;
        }

        public Criteria andFinishTime2NotEqualTo(Integer value) {
            addCriterion("FINISH_TIME2 <>", value, "finishTime2");
            return (Criteria) this;
        }

        public Criteria andFinishTime2GreaterThan(Integer value) {
            addCriterion("FINISH_TIME2 >", value, "finishTime2");
            return (Criteria) this;
        }

        public Criteria andFinishTime2GreaterThanOrEqualTo(Integer value) {
            addCriterion("FINISH_TIME2 >=", value, "finishTime2");
            return (Criteria) this;
        }

        public Criteria andFinishTime2LessThan(Integer value) {
            addCriterion("FINISH_TIME2 <", value, "finishTime2");
            return (Criteria) this;
        }

        public Criteria andFinishTime2LessThanOrEqualTo(Integer value) {
            addCriterion("FINISH_TIME2 <=", value, "finishTime2");
            return (Criteria) this;
        }

        public Criteria andFinishTime2In(List<Integer> values) {
            addCriterion("FINISH_TIME2 in", values, "finishTime2");
            return (Criteria) this;
        }

        public Criteria andFinishTime2NotIn(List<Integer> values) {
            addCriterion("FINISH_TIME2 not in", values, "finishTime2");
            return (Criteria) this;
        }

        public Criteria andFinishTime2Between(Integer value1, Integer value2) {
            addCriterion("FINISH_TIME2 between", value1, value2, "finishTime2");
            return (Criteria) this;
        }

        public Criteria andFinishTime2NotBetween(Integer value1, Integer value2) {
            addCriterion("FINISH_TIME2 not between", value1, value2, "finishTime2");
            return (Criteria) this;
        }

        public Criteria andStartTime2IsNull() {
            addCriterion("START_TIME2 is null");
            return (Criteria) this;
        }

        public Criteria andStartTime2IsNotNull() {
            addCriterion("START_TIME2 is not null");
            return (Criteria) this;
        }

        public Criteria andStartTime2EqualTo(Integer value) {
            addCriterion("START_TIME2 =", value, "startTime2");
            return (Criteria) this;
        }

        public Criteria andStartTime2NotEqualTo(Integer value) {
            addCriterion("START_TIME2 <>", value, "startTime2");
            return (Criteria) this;
        }

        public Criteria andStartTime2GreaterThan(Integer value) {
            addCriterion("START_TIME2 >", value, "startTime2");
            return (Criteria) this;
        }

        public Criteria andStartTime2GreaterThanOrEqualTo(Integer value) {
            addCriterion("START_TIME2 >=", value, "startTime2");
            return (Criteria) this;
        }

        public Criteria andStartTime2LessThan(Integer value) {
            addCriterion("START_TIME2 <", value, "startTime2");
            return (Criteria) this;
        }

        public Criteria andStartTime2LessThanOrEqualTo(Integer value) {
            addCriterion("START_TIME2 <=", value, "startTime2");
            return (Criteria) this;
        }

        public Criteria andStartTime2In(List<Integer> values) {
            addCriterion("START_TIME2 in", values, "startTime2");
            return (Criteria) this;
        }

        public Criteria andStartTime2NotIn(List<Integer> values) {
            addCriterion("START_TIME2 not in", values, "startTime2");
            return (Criteria) this;
        }

        public Criteria andStartTime2Between(Integer value1, Integer value2) {
            addCriterion("START_TIME2 between", value1, value2, "startTime2");
            return (Criteria) this;
        }

        public Criteria andStartTime2NotBetween(Integer value1, Integer value2) {
            addCriterion("START_TIME2 not between", value1, value2, "startTime2");
            return (Criteria) this;
        }

        public Criteria andFinishTime1IsNull() {
            addCriterion("FINISH_TIME1 is null");
            return (Criteria) this;
        }

        public Criteria andFinishTime1IsNotNull() {
            addCriterion("FINISH_TIME1 is not null");
            return (Criteria) this;
        }

        public Criteria andFinishTime1EqualTo(Integer value) {
            addCriterion("FINISH_TIME1 =", value, "finishTime1");
            return (Criteria) this;
        }

        public Criteria andFinishTime1NotEqualTo(Integer value) {
            addCriterion("FINISH_TIME1 <>", value, "finishTime1");
            return (Criteria) this;
        }

        public Criteria andFinishTime1GreaterThan(Integer value) {
            addCriterion("FINISH_TIME1 >", value, "finishTime1");
            return (Criteria) this;
        }

        public Criteria andFinishTime1GreaterThanOrEqualTo(Integer value) {
            addCriterion("FINISH_TIME1 >=", value, "finishTime1");
            return (Criteria) this;
        }

        public Criteria andFinishTime1LessThan(Integer value) {
            addCriterion("FINISH_TIME1 <", value, "finishTime1");
            return (Criteria) this;
        }

        public Criteria andFinishTime1LessThanOrEqualTo(Integer value) {
            addCriterion("FINISH_TIME1 <=", value, "finishTime1");
            return (Criteria) this;
        }

        public Criteria andFinishTime1In(List<Integer> values) {
            addCriterion("FINISH_TIME1 in", values, "finishTime1");
            return (Criteria) this;
        }

        public Criteria andFinishTime1NotIn(List<Integer> values) {
            addCriterion("FINISH_TIME1 not in", values, "finishTime1");
            return (Criteria) this;
        }

        public Criteria andFinishTime1Between(Integer value1, Integer value2) {
            addCriterion("FINISH_TIME1 between", value1, value2, "finishTime1");
            return (Criteria) this;
        }

        public Criteria andFinishTime1NotBetween(Integer value1, Integer value2) {
            addCriterion("FINISH_TIME1 not between", value1, value2, "finishTime1");
            return (Criteria) this;
        }

        public Criteria andStartTime1IsNull() {
            addCriterion("START_TIME1 is null");
            return (Criteria) this;
        }

        public Criteria andStartTime1IsNotNull() {
            addCriterion("START_TIME1 is not null");
            return (Criteria) this;
        }

        public Criteria andStartTime1EqualTo(Integer value) {
            addCriterion("START_TIME1 =", value, "startTime1");
            return (Criteria) this;
        }

        public Criteria andStartTime1NotEqualTo(Integer value) {
            addCriterion("START_TIME1 <>", value, "startTime1");
            return (Criteria) this;
        }

        public Criteria andStartTime1GreaterThan(Integer value) {
            addCriterion("START_TIME1 >", value, "startTime1");
            return (Criteria) this;
        }

        public Criteria andStartTime1GreaterThanOrEqualTo(Integer value) {
            addCriterion("START_TIME1 >=", value, "startTime1");
            return (Criteria) this;
        }

        public Criteria andStartTime1LessThan(Integer value) {
            addCriterion("START_TIME1 <", value, "startTime1");
            return (Criteria) this;
        }

        public Criteria andStartTime1LessThanOrEqualTo(Integer value) {
            addCriterion("START_TIME1 <=", value, "startTime1");
            return (Criteria) this;
        }

        public Criteria andStartTime1In(List<Integer> values) {
            addCriterion("START_TIME1 in", values, "startTime1");
            return (Criteria) this;
        }

        public Criteria andStartTime1NotIn(List<Integer> values) {
            addCriterion("START_TIME1 not in", values, "startTime1");
            return (Criteria) this;
        }

        public Criteria andStartTime1Between(Integer value1, Integer value2) {
            addCriterion("START_TIME1 between", value1, value2, "startTime1");
            return (Criteria) this;
        }

        public Criteria andStartTime1NotBetween(Integer value1, Integer value2) {
            addCriterion("START_TIME1 not between", value1, value2, "startTime1");
            return (Criteria) this;
        }

        public Criteria andStartUponArrivalIsNull() {
            addCriterion("START_UPON_ARRIVAL is null");
            return (Criteria) this;
        }

        public Criteria andStartUponArrivalIsNotNull() {
            addCriterion("START_UPON_ARRIVAL is not null");
            return (Criteria) this;
        }

        public Criteria andStartUponArrivalEqualTo(Integer value) {
            addCriterion("START_UPON_ARRIVAL =", value, "startUponArrival");
            return (Criteria) this;
        }

        public Criteria andStartUponArrivalNotEqualTo(Integer value) {
            addCriterion("START_UPON_ARRIVAL <>", value, "startUponArrival");
            return (Criteria) this;
        }

        public Criteria andStartUponArrivalGreaterThan(Integer value) {
            addCriterion("START_UPON_ARRIVAL >", value, "startUponArrival");
            return (Criteria) this;
        }

        public Criteria andStartUponArrivalGreaterThanOrEqualTo(Integer value) {
            addCriterion("START_UPON_ARRIVAL >=", value, "startUponArrival");
            return (Criteria) this;
        }

        public Criteria andStartUponArrivalLessThan(Integer value) {
            addCriterion("START_UPON_ARRIVAL <", value, "startUponArrival");
            return (Criteria) this;
        }

        public Criteria andStartUponArrivalLessThanOrEqualTo(Integer value) {
            addCriterion("START_UPON_ARRIVAL <=", value, "startUponArrival");
            return (Criteria) this;
        }

        public Criteria andStartUponArrivalIn(List<Integer> values) {
            addCriterion("START_UPON_ARRIVAL in", values, "startUponArrival");
            return (Criteria) this;
        }

        public Criteria andStartUponArrivalNotIn(List<Integer> values) {
            addCriterion("START_UPON_ARRIVAL not in", values, "startUponArrival");
            return (Criteria) this;
        }

        public Criteria andStartUponArrivalBetween(Integer value1, Integer value2) {
            addCriterion("START_UPON_ARRIVAL between", value1, value2, "startUponArrival");
            return (Criteria) this;
        }

        public Criteria andStartUponArrivalNotBetween(Integer value1, Integer value2) {
            addCriterion("START_UPON_ARRIVAL not between", value1, value2, "startUponArrival");
            return (Criteria) this;
        }

        public Criteria andBookingTypeIsNull() {
            addCriterion("BOOKING_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andBookingTypeIsNotNull() {
            addCriterion("BOOKING_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andBookingTypeEqualTo(Integer value) {
            addCriterion("BOOKING_TYPE =", value, "bookingType");
            return (Criteria) this;
        }

        public Criteria andBookingTypeNotEqualTo(Integer value) {
            addCriterion("BOOKING_TYPE <>", value, "bookingType");
            return (Criteria) this;
        }

        public Criteria andBookingTypeGreaterThan(Integer value) {
            addCriterion("BOOKING_TYPE >", value, "bookingType");
            return (Criteria) this;
        }

        public Criteria andBookingTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("BOOKING_TYPE >=", value, "bookingType");
            return (Criteria) this;
        }

        public Criteria andBookingTypeLessThan(Integer value) {
            addCriterion("BOOKING_TYPE <", value, "bookingType");
            return (Criteria) this;
        }

        public Criteria andBookingTypeLessThanOrEqualTo(Integer value) {
            addCriterion("BOOKING_TYPE <=", value, "bookingType");
            return (Criteria) this;
        }

        public Criteria andBookingTypeIn(List<Integer> values) {
            addCriterion("BOOKING_TYPE in", values, "bookingType");
            return (Criteria) this;
        }

        public Criteria andBookingTypeNotIn(List<Integer> values) {
            addCriterion("BOOKING_TYPE not in", values, "bookingType");
            return (Criteria) this;
        }

        public Criteria andBookingTypeBetween(Integer value1, Integer value2) {
            addCriterion("BOOKING_TYPE between", value1, value2, "bookingType");
            return (Criteria) this;
        }

        public Criteria andBookingTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("BOOKING_TYPE not between", value1, value2, "bookingType");
            return (Criteria) this;
        }

        public Criteria andCashbackDateIsNull() {
            addCriterion("CASHBACK_DATE is null");
            return (Criteria) this;
        }

        public Criteria andCashbackDateIsNotNull() {
            addCriterion("CASHBACK_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andCashbackDateEqualTo(Date value) {
            addCriterion("CASHBACK_DATE =", value, "cashbackDate");
            return (Criteria) this;
        }

        public Criteria andCashbackDateNotEqualTo(Date value) {
            addCriterion("CASHBACK_DATE <>", value, "cashbackDate");
            return (Criteria) this;
        }

        public Criteria andCashbackDateGreaterThan(Date value) {
            addCriterion("CASHBACK_DATE >", value, "cashbackDate");
            return (Criteria) this;
        }

        public Criteria andCashbackDateGreaterThanOrEqualTo(Date value) {
            addCriterion("CASHBACK_DATE >=", value, "cashbackDate");
            return (Criteria) this;
        }

        public Criteria andCashbackDateLessThan(Date value) {
            addCriterion("CASHBACK_DATE <", value, "cashbackDate");
            return (Criteria) this;
        }

        public Criteria andCashbackDateLessThanOrEqualTo(Date value) {
            addCriterion("CASHBACK_DATE <=", value, "cashbackDate");
            return (Criteria) this;
        }

        public Criteria andCashbackDateIn(List<Date> values) {
            addCriterion("CASHBACK_DATE in", values, "cashbackDate");
            return (Criteria) this;
        }

        public Criteria andCashbackDateNotIn(List<Date> values) {
            addCriterion("CASHBACK_DATE not in", values, "cashbackDate");
            return (Criteria) this;
        }

        public Criteria andCashbackDateBetween(Date value1, Date value2) {
            addCriterion("CASHBACK_DATE between", value1, value2, "cashbackDate");
            return (Criteria) this;
        }

        public Criteria andCashbackDateNotBetween(Date value1, Date value2) {
            addCriterion("CASHBACK_DATE not between", value1, value2, "cashbackDate");
            return (Criteria) this;
        }

        public Criteria andNoRefundDateIsNull() {
            addCriterion("NO_REFUND_DATE is null");
            return (Criteria) this;
        }

        public Criteria andNoRefundDateIsNotNull() {
            addCriterion("NO_REFUND_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andNoRefundDateEqualTo(Date value) {
            addCriterion("NO_REFUND_DATE =", value, "noRefundDate");
            return (Criteria) this;
        }

        public Criteria andNoRefundDateNotEqualTo(Date value) {
            addCriterion("NO_REFUND_DATE <>", value, "noRefundDate");
            return (Criteria) this;
        }

        public Criteria andNoRefundDateGreaterThan(Date value) {
            addCriterion("NO_REFUND_DATE >", value, "noRefundDate");
            return (Criteria) this;
        }

        public Criteria andNoRefundDateGreaterThanOrEqualTo(Date value) {
            addCriterion("NO_REFUND_DATE >=", value, "noRefundDate");
            return (Criteria) this;
        }

        public Criteria andNoRefundDateLessThan(Date value) {
            addCriterion("NO_REFUND_DATE <", value, "noRefundDate");
            return (Criteria) this;
        }

        public Criteria andNoRefundDateLessThanOrEqualTo(Date value) {
            addCriterion("NO_REFUND_DATE <=", value, "noRefundDate");
            return (Criteria) this;
        }

        public Criteria andNoRefundDateIn(List<Date> values) {
            addCriterion("NO_REFUND_DATE in", values, "noRefundDate");
            return (Criteria) this;
        }

        public Criteria andNoRefundDateNotIn(List<Date> values) {
            addCriterion("NO_REFUND_DATE not in", values, "noRefundDate");
            return (Criteria) this;
        }

        public Criteria andNoRefundDateBetween(Date value1, Date value2) {
            addCriterion("NO_REFUND_DATE between", value1, value2, "noRefundDate");
            return (Criteria) this;
        }

        public Criteria andNoRefundDateNotBetween(Date value1, Date value2) {
            addCriterion("NO_REFUND_DATE not between", value1, value2, "noRefundDate");
            return (Criteria) this;
        }

        public Criteria andCutoffDateIsNull() {
            addCriterion("CUTOFF_DATE is null");
            return (Criteria) this;
        }

        public Criteria andCutoffDateIsNotNull() {
            addCriterion("CUTOFF_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andCutoffDateEqualTo(Date value) {
            addCriterion("CUTOFF_DATE =", value, "cutoffDate");
            return (Criteria) this;
        }

        public Criteria andCutoffDateNotEqualTo(Date value) {
            addCriterion("CUTOFF_DATE <>", value, "cutoffDate");
            return (Criteria) this;
        }

        public Criteria andCutoffDateGreaterThan(Date value) {
            addCriterion("CUTOFF_DATE >", value, "cutoffDate");
            return (Criteria) this;
        }

        public Criteria andCutoffDateGreaterThanOrEqualTo(Date value) {
            addCriterion("CUTOFF_DATE >=", value, "cutoffDate");
            return (Criteria) this;
        }

        public Criteria andCutoffDateLessThan(Date value) {
            addCriterion("CUTOFF_DATE <", value, "cutoffDate");
            return (Criteria) this;
        }

        public Criteria andCutoffDateLessThanOrEqualTo(Date value) {
            addCriterion("CUTOFF_DATE <=", value, "cutoffDate");
            return (Criteria) this;
        }

        public Criteria andCutoffDateIn(List<Date> values) {
            addCriterion("CUTOFF_DATE in", values, "cutoffDate");
            return (Criteria) this;
        }

        public Criteria andCutoffDateNotIn(List<Date> values) {
            addCriterion("CUTOFF_DATE not in", values, "cutoffDate");
            return (Criteria) this;
        }

        public Criteria andCutoffDateBetween(Date value1, Date value2) {
            addCriterion("CUTOFF_DATE between", value1, value2, "cutoffDate");
            return (Criteria) this;
        }

        public Criteria andCutoffDateNotBetween(Date value1, Date value2) {
            addCriterion("CUTOFF_DATE not between", value1, value2, "cutoffDate");
            return (Criteria) this;
        }

        public Criteria andFinishDateIsNull() {
            addCriterion("FINISH_DATE is null");
            return (Criteria) this;
        }

        public Criteria andFinishDateIsNotNull() {
            addCriterion("FINISH_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andFinishDateEqualTo(Date value) {
            addCriterion("FINISH_DATE =", value, "finishDate");
            return (Criteria) this;
        }

        public Criteria andFinishDateNotEqualTo(Date value) {
            addCriterion("FINISH_DATE <>", value, "finishDate");
            return (Criteria) this;
        }

        public Criteria andFinishDateGreaterThan(Date value) {
            addCriterion("FINISH_DATE >", value, "finishDate");
            return (Criteria) this;
        }

        public Criteria andFinishDateGreaterThanOrEqualTo(Date value) {
            addCriterion("FINISH_DATE >=", value, "finishDate");
            return (Criteria) this;
        }

        public Criteria andFinishDateLessThan(Date value) {
            addCriterion("FINISH_DATE <", value, "finishDate");
            return (Criteria) this;
        }

        public Criteria andFinishDateLessThanOrEqualTo(Date value) {
            addCriterion("FINISH_DATE <=", value, "finishDate");
            return (Criteria) this;
        }

        public Criteria andFinishDateIn(List<Date> values) {
            addCriterion("FINISH_DATE in", values, "finishDate");
            return (Criteria) this;
        }

        public Criteria andFinishDateNotIn(List<Date> values) {
            addCriterion("FINISH_DATE not in", values, "finishDate");
            return (Criteria) this;
        }

        public Criteria andFinishDateBetween(Date value1, Date value2) {
            addCriterion("FINISH_DATE between", value1, value2, "finishDate");
            return (Criteria) this;
        }

        public Criteria andFinishDateNotBetween(Date value1, Date value2) {
            addCriterion("FINISH_DATE not between", value1, value2, "finishDate");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNull() {
            addCriterion("START_DATE is null");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNotNull() {
            addCriterion("START_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andStartDateEqualTo(Date value) {
            addCriterion("START_DATE =", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotEqualTo(Date value) {
            addCriterion("START_DATE <>", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThan(Date value) {
            addCriterion("START_DATE >", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThanOrEqualTo(Date value) {
            addCriterion("START_DATE >=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThan(Date value) {
            addCriterion("START_DATE <", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThanOrEqualTo(Date value) {
            addCriterion("START_DATE <=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateIn(List<Date> values) {
            addCriterion("START_DATE in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotIn(List<Date> values) {
            addCriterion("START_DATE not in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateBetween(Date value1, Date value2) {
            addCriterion("START_DATE between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotBetween(Date value1, Date value2) {
            addCriterion("START_DATE not between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andPopularityIsNull() {
            addCriterion("POPULARITY is null");
            return (Criteria) this;
        }

        public Criteria andPopularityIsNotNull() {
            addCriterion("POPULARITY is not null");
            return (Criteria) this;
        }

        public Criteria andPopularityEqualTo(Integer value) {
            addCriterion("POPULARITY =", value, "popularity");
            return (Criteria) this;
        }

        public Criteria andPopularityNotEqualTo(Integer value) {
            addCriterion("POPULARITY <>", value, "popularity");
            return (Criteria) this;
        }

        public Criteria andPopularityGreaterThan(Integer value) {
            addCriterion("POPULARITY >", value, "popularity");
            return (Criteria) this;
        }

        public Criteria andPopularityGreaterThanOrEqualTo(Integer value) {
            addCriterion("POPULARITY >=", value, "popularity");
            return (Criteria) this;
        }

        public Criteria andPopularityLessThan(Integer value) {
            addCriterion("POPULARITY <", value, "popularity");
            return (Criteria) this;
        }

        public Criteria andPopularityLessThanOrEqualTo(Integer value) {
            addCriterion("POPULARITY <=", value, "popularity");
            return (Criteria) this;
        }

        public Criteria andPopularityIn(List<Integer> values) {
            addCriterion("POPULARITY in", values, "popularity");
            return (Criteria) this;
        }

        public Criteria andPopularityNotIn(List<Integer> values) {
            addCriterion("POPULARITY not in", values, "popularity");
            return (Criteria) this;
        }

        public Criteria andPopularityBetween(Integer value1, Integer value2) {
            addCriterion("POPULARITY between", value1, value2, "popularity");
            return (Criteria) this;
        }

        public Criteria andPopularityNotBetween(Integer value1, Integer value2) {
            addCriterion("POPULARITY not between", value1, value2, "popularity");
            return (Criteria) this;
        }

        public Criteria andClassSizeIsNull() {
            addCriterion("CLASS_SIZE is null");
            return (Criteria) this;
        }

        public Criteria andClassSizeIsNotNull() {
            addCriterion("CLASS_SIZE is not null");
            return (Criteria) this;
        }

        public Criteria andClassSizeEqualTo(Integer value) {
            addCriterion("CLASS_SIZE =", value, "classSize");
            return (Criteria) this;
        }

        public Criteria andClassSizeNotEqualTo(Integer value) {
            addCriterion("CLASS_SIZE <>", value, "classSize");
            return (Criteria) this;
        }

        public Criteria andClassSizeGreaterThan(Integer value) {
            addCriterion("CLASS_SIZE >", value, "classSize");
            return (Criteria) this;
        }

        public Criteria andClassSizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("CLASS_SIZE >=", value, "classSize");
            return (Criteria) this;
        }

        public Criteria andClassSizeLessThan(Integer value) {
            addCriterion("CLASS_SIZE <", value, "classSize");
            return (Criteria) this;
        }

        public Criteria andClassSizeLessThanOrEqualTo(Integer value) {
            addCriterion("CLASS_SIZE <=", value, "classSize");
            return (Criteria) this;
        }

        public Criteria andClassSizeIn(List<Integer> values) {
            addCriterion("CLASS_SIZE in", values, "classSize");
            return (Criteria) this;
        }

        public Criteria andClassSizeNotIn(List<Integer> values) {
            addCriterion("CLASS_SIZE not in", values, "classSize");
            return (Criteria) this;
        }

        public Criteria andClassSizeBetween(Integer value1, Integer value2) {
            addCriterion("CLASS_SIZE between", value1, value2, "classSize");
            return (Criteria) this;
        }

        public Criteria andClassSizeNotBetween(Integer value1, Integer value2) {
            addCriterion("CLASS_SIZE not between", value1, value2, "classSize");
            return (Criteria) this;
        }

        public Criteria andCourseHourNumIsNull() {
            addCriterion("COURSE_HOUR_NUM is null");
            return (Criteria) this;
        }

        public Criteria andCourseHourNumIsNotNull() {
            addCriterion("COURSE_HOUR_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andCourseHourNumEqualTo(Integer value) {
            addCriterion("COURSE_HOUR_NUM =", value, "courseHourNum");
            return (Criteria) this;
        }

        public Criteria andCourseHourNumNotEqualTo(Integer value) {
            addCriterion("COURSE_HOUR_NUM <>", value, "courseHourNum");
            return (Criteria) this;
        }

        public Criteria andCourseHourNumGreaterThan(Integer value) {
            addCriterion("COURSE_HOUR_NUM >", value, "courseHourNum");
            return (Criteria) this;
        }

        public Criteria andCourseHourNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("COURSE_HOUR_NUM >=", value, "courseHourNum");
            return (Criteria) this;
        }

        public Criteria andCourseHourNumLessThan(Integer value) {
            addCriterion("COURSE_HOUR_NUM <", value, "courseHourNum");
            return (Criteria) this;
        }

        public Criteria andCourseHourNumLessThanOrEqualTo(Integer value) {
            addCriterion("COURSE_HOUR_NUM <=", value, "courseHourNum");
            return (Criteria) this;
        }

        public Criteria andCourseHourNumIn(List<Integer> values) {
            addCriterion("COURSE_HOUR_NUM in", values, "courseHourNum");
            return (Criteria) this;
        }

        public Criteria andCourseHourNumNotIn(List<Integer> values) {
            addCriterion("COURSE_HOUR_NUM not in", values, "courseHourNum");
            return (Criteria) this;
        }

        public Criteria andCourseHourNumBetween(Integer value1, Integer value2) {
            addCriterion("COURSE_HOUR_NUM between", value1, value2, "courseHourNum");
            return (Criteria) this;
        }

        public Criteria andCourseHourNumNotBetween(Integer value1, Integer value2) {
            addCriterion("COURSE_HOUR_NUM not between", value1, value2, "courseHourNum");
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