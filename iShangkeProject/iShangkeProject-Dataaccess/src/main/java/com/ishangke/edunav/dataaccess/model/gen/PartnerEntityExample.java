package com.ishangke.edunav.dataaccess.model.gen;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PartnerEntityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PartnerEntityExample() {
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

        public Criteria andInstNameIsNull() {
            addCriterion("INST_NAME is null");
            return (Criteria) this;
        }

        public Criteria andInstNameIsNotNull() {
            addCriterion("INST_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andInstNameEqualTo(String value) {
            addCriterion("INST_NAME =", value, "instName");
            return (Criteria) this;
        }

        public Criteria andInstNameNotEqualTo(String value) {
            addCriterion("INST_NAME <>", value, "instName");
            return (Criteria) this;
        }

        public Criteria andInstNameGreaterThan(String value) {
            addCriterion("INST_NAME >", value, "instName");
            return (Criteria) this;
        }

        public Criteria andInstNameGreaterThanOrEqualTo(String value) {
            addCriterion("INST_NAME >=", value, "instName");
            return (Criteria) this;
        }

        public Criteria andInstNameLessThan(String value) {
            addCriterion("INST_NAME <", value, "instName");
            return (Criteria) this;
        }

        public Criteria andInstNameLessThanOrEqualTo(String value) {
            addCriterion("INST_NAME <=", value, "instName");
            return (Criteria) this;
        }

        public Criteria andInstNameLike(String value) {
            addCriterion("INST_NAME like", value, "instName");
            return (Criteria) this;
        }

        public Criteria andInstNameNotLike(String value) {
            addCriterion("INST_NAME not like", value, "instName");
            return (Criteria) this;
        }

        public Criteria andInstNameIn(List<String> values) {
            addCriterion("INST_NAME in", values, "instName");
            return (Criteria) this;
        }

        public Criteria andInstNameNotIn(List<String> values) {
            addCriterion("INST_NAME not in", values, "instName");
            return (Criteria) this;
        }

        public Criteria andInstNameBetween(String value1, String value2) {
            addCriterion("INST_NAME between", value1, value2, "instName");
            return (Criteria) this;
        }

        public Criteria andInstNameNotBetween(String value1, String value2) {
            addCriterion("INST_NAME not between", value1, value2, "instName");
            return (Criteria) this;
        }

        public Criteria andLogoUrlIsNull() {
            addCriterion("LOGO_URL is null");
            return (Criteria) this;
        }

        public Criteria andLogoUrlIsNotNull() {
            addCriterion("LOGO_URL is not null");
            return (Criteria) this;
        }

        public Criteria andLogoUrlEqualTo(String value) {
            addCriterion("LOGO_URL =", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlNotEqualTo(String value) {
            addCriterion("LOGO_URL <>", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlGreaterThan(String value) {
            addCriterion("LOGO_URL >", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlGreaterThanOrEqualTo(String value) {
            addCriterion("LOGO_URL >=", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlLessThan(String value) {
            addCriterion("LOGO_URL <", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlLessThanOrEqualTo(String value) {
            addCriterion("LOGO_URL <=", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlLike(String value) {
            addCriterion("LOGO_URL like", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlNotLike(String value) {
            addCriterion("LOGO_URL not like", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlIn(List<String> values) {
            addCriterion("LOGO_URL in", values, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlNotIn(List<String> values) {
            addCriterion("LOGO_URL not in", values, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlBetween(String value1, String value2) {
            addCriterion("LOGO_URL between", value1, value2, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlNotBetween(String value1, String value2) {
            addCriterion("LOGO_URL not between", value1, value2, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andContractIsNull() {
            addCriterion("CONTRACT is null");
            return (Criteria) this;
        }

        public Criteria andContractIsNotNull() {
            addCriterion("CONTRACT is not null");
            return (Criteria) this;
        }

        public Criteria andContractEqualTo(String value) {
            addCriterion("CONTRACT =", value, "contract");
            return (Criteria) this;
        }

        public Criteria andContractNotEqualTo(String value) {
            addCriterion("CONTRACT <>", value, "contract");
            return (Criteria) this;
        }

        public Criteria andContractGreaterThan(String value) {
            addCriterion("CONTRACT >", value, "contract");
            return (Criteria) this;
        }

        public Criteria andContractGreaterThanOrEqualTo(String value) {
            addCriterion("CONTRACT >=", value, "contract");
            return (Criteria) this;
        }

        public Criteria andContractLessThan(String value) {
            addCriterion("CONTRACT <", value, "contract");
            return (Criteria) this;
        }

        public Criteria andContractLessThanOrEqualTo(String value) {
            addCriterion("CONTRACT <=", value, "contract");
            return (Criteria) this;
        }

        public Criteria andContractLike(String value) {
            addCriterion("CONTRACT like", value, "contract");
            return (Criteria) this;
        }

        public Criteria andContractNotLike(String value) {
            addCriterion("CONTRACT not like", value, "contract");
            return (Criteria) this;
        }

        public Criteria andContractIn(List<String> values) {
            addCriterion("CONTRACT in", values, "contract");
            return (Criteria) this;
        }

        public Criteria andContractNotIn(List<String> values) {
            addCriterion("CONTRACT not in", values, "contract");
            return (Criteria) this;
        }

        public Criteria andContractBetween(String value1, String value2) {
            addCriterion("CONTRACT between", value1, value2, "contract");
            return (Criteria) this;
        }

        public Criteria andContractNotBetween(String value1, String value2) {
            addCriterion("CONTRACT not between", value1, value2, "contract");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeIsNull() {
            addCriterion("LAST_LOGIN_TIME is null");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeIsNotNull() {
            addCriterion("LAST_LOGIN_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeEqualTo(Date value) {
            addCriterion("LAST_LOGIN_TIME =", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeNotEqualTo(Date value) {
            addCriterion("LAST_LOGIN_TIME <>", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeGreaterThan(Date value) {
            addCriterion("LAST_LOGIN_TIME >", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("LAST_LOGIN_TIME >=", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeLessThan(Date value) {
            addCriterion("LAST_LOGIN_TIME <", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeLessThanOrEqualTo(Date value) {
            addCriterion("LAST_LOGIN_TIME <=", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeIn(List<Date> values) {
            addCriterion("LAST_LOGIN_TIME in", values, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeNotIn(List<Date> values) {
            addCriterion("LAST_LOGIN_TIME not in", values, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeBetween(Date value1, Date value2) {
            addCriterion("LAST_LOGIN_TIME between", value1, value2, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeNotBetween(Date value1, Date value2) {
            addCriterion("LAST_LOGIN_TIME not between", value1, value2, "lastLoginTime");
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

        public Criteria andWholeNameIsNull() {
            addCriterion("WHOLE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andWholeNameIsNotNull() {
            addCriterion("WHOLE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andWholeNameEqualTo(String value) {
            addCriterion("WHOLE_NAME =", value, "wholeName");
            return (Criteria) this;
        }

        public Criteria andWholeNameNotEqualTo(String value) {
            addCriterion("WHOLE_NAME <>", value, "wholeName");
            return (Criteria) this;
        }

        public Criteria andWholeNameGreaterThan(String value) {
            addCriterion("WHOLE_NAME >", value, "wholeName");
            return (Criteria) this;
        }

        public Criteria andWholeNameGreaterThanOrEqualTo(String value) {
            addCriterion("WHOLE_NAME >=", value, "wholeName");
            return (Criteria) this;
        }

        public Criteria andWholeNameLessThan(String value) {
            addCriterion("WHOLE_NAME <", value, "wholeName");
            return (Criteria) this;
        }

        public Criteria andWholeNameLessThanOrEqualTo(String value) {
            addCriterion("WHOLE_NAME <=", value, "wholeName");
            return (Criteria) this;
        }

        public Criteria andWholeNameLike(String value) {
            addCriterion("WHOLE_NAME like", value, "wholeName");
            return (Criteria) this;
        }

        public Criteria andWholeNameNotLike(String value) {
            addCriterion("WHOLE_NAME not like", value, "wholeName");
            return (Criteria) this;
        }

        public Criteria andWholeNameIn(List<String> values) {
            addCriterion("WHOLE_NAME in", values, "wholeName");
            return (Criteria) this;
        }

        public Criteria andWholeNameNotIn(List<String> values) {
            addCriterion("WHOLE_NAME not in", values, "wholeName");
            return (Criteria) this;
        }

        public Criteria andWholeNameBetween(String value1, String value2) {
            addCriterion("WHOLE_NAME between", value1, value2, "wholeName");
            return (Criteria) this;
        }

        public Criteria andWholeNameNotBetween(String value1, String value2) {
            addCriterion("WHOLE_NAME not between", value1, value2, "wholeName");
            return (Criteria) this;
        }

        public Criteria andLicenceIsNull() {
            addCriterion("LICENCE is null");
            return (Criteria) this;
        }

        public Criteria andLicenceIsNotNull() {
            addCriterion("LICENCE is not null");
            return (Criteria) this;
        }

        public Criteria andLicenceEqualTo(String value) {
            addCriterion("LICENCE =", value, "licence");
            return (Criteria) this;
        }

        public Criteria andLicenceNotEqualTo(String value) {
            addCriterion("LICENCE <>", value, "licence");
            return (Criteria) this;
        }

        public Criteria andLicenceGreaterThan(String value) {
            addCriterion("LICENCE >", value, "licence");
            return (Criteria) this;
        }

        public Criteria andLicenceGreaterThanOrEqualTo(String value) {
            addCriterion("LICENCE >=", value, "licence");
            return (Criteria) this;
        }

        public Criteria andLicenceLessThan(String value) {
            addCriterion("LICENCE <", value, "licence");
            return (Criteria) this;
        }

        public Criteria andLicenceLessThanOrEqualTo(String value) {
            addCriterion("LICENCE <=", value, "licence");
            return (Criteria) this;
        }

        public Criteria andLicenceLike(String value) {
            addCriterion("LICENCE like", value, "licence");
            return (Criteria) this;
        }

        public Criteria andLicenceNotLike(String value) {
            addCriterion("LICENCE not like", value, "licence");
            return (Criteria) this;
        }

        public Criteria andLicenceIn(List<String> values) {
            addCriterion("LICENCE in", values, "licence");
            return (Criteria) this;
        }

        public Criteria andLicenceNotIn(List<String> values) {
            addCriterion("LICENCE not in", values, "licence");
            return (Criteria) this;
        }

        public Criteria andLicenceBetween(String value1, String value2) {
            addCriterion("LICENCE between", value1, value2, "licence");
            return (Criteria) this;
        }

        public Criteria andLicenceNotBetween(String value1, String value2) {
            addCriterion("LICENCE not between", value1, value2, "licence");
            return (Criteria) this;
        }

        public Criteria andOrganizationNumIsNull() {
            addCriterion("ORGANIZATION_NUM is null");
            return (Criteria) this;
        }

        public Criteria andOrganizationNumIsNotNull() {
            addCriterion("ORGANIZATION_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andOrganizationNumEqualTo(String value) {
            addCriterion("ORGANIZATION_NUM =", value, "organizationNum");
            return (Criteria) this;
        }

        public Criteria andOrganizationNumNotEqualTo(String value) {
            addCriterion("ORGANIZATION_NUM <>", value, "organizationNum");
            return (Criteria) this;
        }

        public Criteria andOrganizationNumGreaterThan(String value) {
            addCriterion("ORGANIZATION_NUM >", value, "organizationNum");
            return (Criteria) this;
        }

        public Criteria andOrganizationNumGreaterThanOrEqualTo(String value) {
            addCriterion("ORGANIZATION_NUM >=", value, "organizationNum");
            return (Criteria) this;
        }

        public Criteria andOrganizationNumLessThan(String value) {
            addCriterion("ORGANIZATION_NUM <", value, "organizationNum");
            return (Criteria) this;
        }

        public Criteria andOrganizationNumLessThanOrEqualTo(String value) {
            addCriterion("ORGANIZATION_NUM <=", value, "organizationNum");
            return (Criteria) this;
        }

        public Criteria andOrganizationNumLike(String value) {
            addCriterion("ORGANIZATION_NUM like", value, "organizationNum");
            return (Criteria) this;
        }

        public Criteria andOrganizationNumNotLike(String value) {
            addCriterion("ORGANIZATION_NUM not like", value, "organizationNum");
            return (Criteria) this;
        }

        public Criteria andOrganizationNumIn(List<String> values) {
            addCriterion("ORGANIZATION_NUM in", values, "organizationNum");
            return (Criteria) this;
        }

        public Criteria andOrganizationNumNotIn(List<String> values) {
            addCriterion("ORGANIZATION_NUM not in", values, "organizationNum");
            return (Criteria) this;
        }

        public Criteria andOrganizationNumBetween(String value1, String value2) {
            addCriterion("ORGANIZATION_NUM between", value1, value2, "organizationNum");
            return (Criteria) this;
        }

        public Criteria andOrganizationNumNotBetween(String value1, String value2) {
            addCriterion("ORGANIZATION_NUM not between", value1, value2, "organizationNum");
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

        public Criteria andPasswordIsNull() {
            addCriterion("PASSWORD is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("PASSWORD is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("PASSWORD =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("PASSWORD <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("PASSWORD >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("PASSWORD >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("PASSWORD <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("PASSWORD <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("PASSWORD like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("PASSWORD not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("PASSWORD in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("PASSWORD not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("PASSWORD between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("PASSWORD not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPartnerIntroIsNull() {
            addCriterion("PARTNER_INTRO is null");
            return (Criteria) this;
        }

        public Criteria andPartnerIntroIsNotNull() {
            addCriterion("PARTNER_INTRO is not null");
            return (Criteria) this;
        }

        public Criteria andPartnerIntroEqualTo(String value) {
            addCriterion("PARTNER_INTRO =", value, "partnerIntro");
            return (Criteria) this;
        }

        public Criteria andPartnerIntroNotEqualTo(String value) {
            addCriterion("PARTNER_INTRO <>", value, "partnerIntro");
            return (Criteria) this;
        }

        public Criteria andPartnerIntroGreaterThan(String value) {
            addCriterion("PARTNER_INTRO >", value, "partnerIntro");
            return (Criteria) this;
        }

        public Criteria andPartnerIntroGreaterThanOrEqualTo(String value) {
            addCriterion("PARTNER_INTRO >=", value, "partnerIntro");
            return (Criteria) this;
        }

        public Criteria andPartnerIntroLessThan(String value) {
            addCriterion("PARTNER_INTRO <", value, "partnerIntro");
            return (Criteria) this;
        }

        public Criteria andPartnerIntroLessThanOrEqualTo(String value) {
            addCriterion("PARTNER_INTRO <=", value, "partnerIntro");
            return (Criteria) this;
        }

        public Criteria andPartnerIntroLike(String value) {
            addCriterion("PARTNER_INTRO like", value, "partnerIntro");
            return (Criteria) this;
        }

        public Criteria andPartnerIntroNotLike(String value) {
            addCriterion("PARTNER_INTRO not like", value, "partnerIntro");
            return (Criteria) this;
        }

        public Criteria andPartnerIntroIn(List<String> values) {
            addCriterion("PARTNER_INTRO in", values, "partnerIntro");
            return (Criteria) this;
        }

        public Criteria andPartnerIntroNotIn(List<String> values) {
            addCriterion("PARTNER_INTRO not in", values, "partnerIntro");
            return (Criteria) this;
        }

        public Criteria andPartnerIntroBetween(String value1, String value2) {
            addCriterion("PARTNER_INTRO between", value1, value2, "partnerIntro");
            return (Criteria) this;
        }

        public Criteria andPartnerIntroNotBetween(String value1, String value2) {
            addCriterion("PARTNER_INTRO not between", value1, value2, "partnerIntro");
            return (Criteria) this;
        }

        public Criteria andPartnerDistinctionIsNull() {
            addCriterion("PARTNER_DISTINCTION is null");
            return (Criteria) this;
        }

        public Criteria andPartnerDistinctionIsNotNull() {
            addCriterion("PARTNER_DISTINCTION is not null");
            return (Criteria) this;
        }

        public Criteria andPartnerDistinctionEqualTo(String value) {
            addCriterion("PARTNER_DISTINCTION =", value, "partnerDistinction");
            return (Criteria) this;
        }

        public Criteria andPartnerDistinctionNotEqualTo(String value) {
            addCriterion("PARTNER_DISTINCTION <>", value, "partnerDistinction");
            return (Criteria) this;
        }

        public Criteria andPartnerDistinctionGreaterThan(String value) {
            addCriterion("PARTNER_DISTINCTION >", value, "partnerDistinction");
            return (Criteria) this;
        }

        public Criteria andPartnerDistinctionGreaterThanOrEqualTo(String value) {
            addCriterion("PARTNER_DISTINCTION >=", value, "partnerDistinction");
            return (Criteria) this;
        }

        public Criteria andPartnerDistinctionLessThan(String value) {
            addCriterion("PARTNER_DISTINCTION <", value, "partnerDistinction");
            return (Criteria) this;
        }

        public Criteria andPartnerDistinctionLessThanOrEqualTo(String value) {
            addCriterion("PARTNER_DISTINCTION <=", value, "partnerDistinction");
            return (Criteria) this;
        }

        public Criteria andPartnerDistinctionLike(String value) {
            addCriterion("PARTNER_DISTINCTION like", value, "partnerDistinction");
            return (Criteria) this;
        }

        public Criteria andPartnerDistinctionNotLike(String value) {
            addCriterion("PARTNER_DISTINCTION not like", value, "partnerDistinction");
            return (Criteria) this;
        }

        public Criteria andPartnerDistinctionIn(List<String> values) {
            addCriterion("PARTNER_DISTINCTION in", values, "partnerDistinction");
            return (Criteria) this;
        }

        public Criteria andPartnerDistinctionNotIn(List<String> values) {
            addCriterion("PARTNER_DISTINCTION not in", values, "partnerDistinction");
            return (Criteria) this;
        }

        public Criteria andPartnerDistinctionBetween(String value1, String value2) {
            addCriterion("PARTNER_DISTINCTION between", value1, value2, "partnerDistinction");
            return (Criteria) this;
        }

        public Criteria andPartnerDistinctionNotBetween(String value1, String value2) {
            addCriterion("PARTNER_DISTINCTION not between", value1, value2, "partnerDistinction");
            return (Criteria) this;
        }

        public Criteria andLicenceImgUrlIsNull() {
            addCriterion("LICENCE_IMG_URL is null");
            return (Criteria) this;
        }

        public Criteria andLicenceImgUrlIsNotNull() {
            addCriterion("LICENCE_IMG_URL is not null");
            return (Criteria) this;
        }

        public Criteria andLicenceImgUrlEqualTo(String value) {
            addCriterion("LICENCE_IMG_URL =", value, "licenceImgUrl");
            return (Criteria) this;
        }

        public Criteria andLicenceImgUrlNotEqualTo(String value) {
            addCriterion("LICENCE_IMG_URL <>", value, "licenceImgUrl");
            return (Criteria) this;
        }

        public Criteria andLicenceImgUrlGreaterThan(String value) {
            addCriterion("LICENCE_IMG_URL >", value, "licenceImgUrl");
            return (Criteria) this;
        }

        public Criteria andLicenceImgUrlGreaterThanOrEqualTo(String value) {
            addCriterion("LICENCE_IMG_URL >=", value, "licenceImgUrl");
            return (Criteria) this;
        }

        public Criteria andLicenceImgUrlLessThan(String value) {
            addCriterion("LICENCE_IMG_URL <", value, "licenceImgUrl");
            return (Criteria) this;
        }

        public Criteria andLicenceImgUrlLessThanOrEqualTo(String value) {
            addCriterion("LICENCE_IMG_URL <=", value, "licenceImgUrl");
            return (Criteria) this;
        }

        public Criteria andLicenceImgUrlLike(String value) {
            addCriterion("LICENCE_IMG_URL like", value, "licenceImgUrl");
            return (Criteria) this;
        }

        public Criteria andLicenceImgUrlNotLike(String value) {
            addCriterion("LICENCE_IMG_URL not like", value, "licenceImgUrl");
            return (Criteria) this;
        }

        public Criteria andLicenceImgUrlIn(List<String> values) {
            addCriterion("LICENCE_IMG_URL in", values, "licenceImgUrl");
            return (Criteria) this;
        }

        public Criteria andLicenceImgUrlNotIn(List<String> values) {
            addCriterion("LICENCE_IMG_URL not in", values, "licenceImgUrl");
            return (Criteria) this;
        }

        public Criteria andLicenceImgUrlBetween(String value1, String value2) {
            addCriterion("LICENCE_IMG_URL between", value1, value2, "licenceImgUrl");
            return (Criteria) this;
        }

        public Criteria andLicenceImgUrlNotBetween(String value1, String value2) {
            addCriterion("LICENCE_IMG_URL not between", value1, value2, "licenceImgUrl");
            return (Criteria) this;
        }

        public Criteria andTaxRegImgUrlIsNull() {
            addCriterion("TAX_REG_IMG_URL is null");
            return (Criteria) this;
        }

        public Criteria andTaxRegImgUrlIsNotNull() {
            addCriterion("TAX_REG_IMG_URL is not null");
            return (Criteria) this;
        }

        public Criteria andTaxRegImgUrlEqualTo(String value) {
            addCriterion("TAX_REG_IMG_URL =", value, "taxRegImgUrl");
            return (Criteria) this;
        }

        public Criteria andTaxRegImgUrlNotEqualTo(String value) {
            addCriterion("TAX_REG_IMG_URL <>", value, "taxRegImgUrl");
            return (Criteria) this;
        }

        public Criteria andTaxRegImgUrlGreaterThan(String value) {
            addCriterion("TAX_REG_IMG_URL >", value, "taxRegImgUrl");
            return (Criteria) this;
        }

        public Criteria andTaxRegImgUrlGreaterThanOrEqualTo(String value) {
            addCriterion("TAX_REG_IMG_URL >=", value, "taxRegImgUrl");
            return (Criteria) this;
        }

        public Criteria andTaxRegImgUrlLessThan(String value) {
            addCriterion("TAX_REG_IMG_URL <", value, "taxRegImgUrl");
            return (Criteria) this;
        }

        public Criteria andTaxRegImgUrlLessThanOrEqualTo(String value) {
            addCriterion("TAX_REG_IMG_URL <=", value, "taxRegImgUrl");
            return (Criteria) this;
        }

        public Criteria andTaxRegImgUrlLike(String value) {
            addCriterion("TAX_REG_IMG_URL like", value, "taxRegImgUrl");
            return (Criteria) this;
        }

        public Criteria andTaxRegImgUrlNotLike(String value) {
            addCriterion("TAX_REG_IMG_URL not like", value, "taxRegImgUrl");
            return (Criteria) this;
        }

        public Criteria andTaxRegImgUrlIn(List<String> values) {
            addCriterion("TAX_REG_IMG_URL in", values, "taxRegImgUrl");
            return (Criteria) this;
        }

        public Criteria andTaxRegImgUrlNotIn(List<String> values) {
            addCriterion("TAX_REG_IMG_URL not in", values, "taxRegImgUrl");
            return (Criteria) this;
        }

        public Criteria andTaxRegImgUrlBetween(String value1, String value2) {
            addCriterion("TAX_REG_IMG_URL between", value1, value2, "taxRegImgUrl");
            return (Criteria) this;
        }

        public Criteria andTaxRegImgUrlNotBetween(String value1, String value2) {
            addCriterion("TAX_REG_IMG_URL not between", value1, value2, "taxRegImgUrl");
            return (Criteria) this;
        }

        public Criteria andEduQualificationImgUrlIsNull() {
            addCriterion("EDU_QUALIFICATION_IMG_URL is null");
            return (Criteria) this;
        }

        public Criteria andEduQualificationImgUrlIsNotNull() {
            addCriterion("EDU_QUALIFICATION_IMG_URL is not null");
            return (Criteria) this;
        }

        public Criteria andEduQualificationImgUrlEqualTo(String value) {
            addCriterion("EDU_QUALIFICATION_IMG_URL =", value, "eduQualificationImgUrl");
            return (Criteria) this;
        }

        public Criteria andEduQualificationImgUrlNotEqualTo(String value) {
            addCriterion("EDU_QUALIFICATION_IMG_URL <>", value, "eduQualificationImgUrl");
            return (Criteria) this;
        }

        public Criteria andEduQualificationImgUrlGreaterThan(String value) {
            addCriterion("EDU_QUALIFICATION_IMG_URL >", value, "eduQualificationImgUrl");
            return (Criteria) this;
        }

        public Criteria andEduQualificationImgUrlGreaterThanOrEqualTo(String value) {
            addCriterion("EDU_QUALIFICATION_IMG_URL >=", value, "eduQualificationImgUrl");
            return (Criteria) this;
        }

        public Criteria andEduQualificationImgUrlLessThan(String value) {
            addCriterion("EDU_QUALIFICATION_IMG_URL <", value, "eduQualificationImgUrl");
            return (Criteria) this;
        }

        public Criteria andEduQualificationImgUrlLessThanOrEqualTo(String value) {
            addCriterion("EDU_QUALIFICATION_IMG_URL <=", value, "eduQualificationImgUrl");
            return (Criteria) this;
        }

        public Criteria andEduQualificationImgUrlLike(String value) {
            addCriterion("EDU_QUALIFICATION_IMG_URL like", value, "eduQualificationImgUrl");
            return (Criteria) this;
        }

        public Criteria andEduQualificationImgUrlNotLike(String value) {
            addCriterion("EDU_QUALIFICATION_IMG_URL not like", value, "eduQualificationImgUrl");
            return (Criteria) this;
        }

        public Criteria andEduQualificationImgUrlIn(List<String> values) {
            addCriterion("EDU_QUALIFICATION_IMG_URL in", values, "eduQualificationImgUrl");
            return (Criteria) this;
        }

        public Criteria andEduQualificationImgUrlNotIn(List<String> values) {
            addCriterion("EDU_QUALIFICATION_IMG_URL not in", values, "eduQualificationImgUrl");
            return (Criteria) this;
        }

        public Criteria andEduQualificationImgUrlBetween(String value1, String value2) {
            addCriterion("EDU_QUALIFICATION_IMG_URL between", value1, value2, "eduQualificationImgUrl");
            return (Criteria) this;
        }

        public Criteria andEduQualificationImgUrlNotBetween(String value1, String value2) {
            addCriterion("EDU_QUALIFICATION_IMG_URL not between", value1, value2, "eduQualificationImgUrl");
            return (Criteria) this;
        }

        public Criteria andHqLocationIsNull() {
            addCriterion("HQ_LOCATION is null");
            return (Criteria) this;
        }

        public Criteria andHqLocationIsNotNull() {
            addCriterion("HQ_LOCATION is not null");
            return (Criteria) this;
        }

        public Criteria andHqLocationEqualTo(String value) {
            addCriterion("HQ_LOCATION =", value, "hqLocation");
            return (Criteria) this;
        }

        public Criteria andHqLocationNotEqualTo(String value) {
            addCriterion("HQ_LOCATION <>", value, "hqLocation");
            return (Criteria) this;
        }

        public Criteria andHqLocationGreaterThan(String value) {
            addCriterion("HQ_LOCATION >", value, "hqLocation");
            return (Criteria) this;
        }

        public Criteria andHqLocationGreaterThanOrEqualTo(String value) {
            addCriterion("HQ_LOCATION >=", value, "hqLocation");
            return (Criteria) this;
        }

        public Criteria andHqLocationLessThan(String value) {
            addCriterion("HQ_LOCATION <", value, "hqLocation");
            return (Criteria) this;
        }

        public Criteria andHqLocationLessThanOrEqualTo(String value) {
            addCriterion("HQ_LOCATION <=", value, "hqLocation");
            return (Criteria) this;
        }

        public Criteria andHqLocationLike(String value) {
            addCriterion("HQ_LOCATION like", value, "hqLocation");
            return (Criteria) this;
        }

        public Criteria andHqLocationNotLike(String value) {
            addCriterion("HQ_LOCATION not like", value, "hqLocation");
            return (Criteria) this;
        }

        public Criteria andHqLocationIn(List<String> values) {
            addCriterion("HQ_LOCATION in", values, "hqLocation");
            return (Criteria) this;
        }

        public Criteria andHqLocationNotIn(List<String> values) {
            addCriterion("HQ_LOCATION not in", values, "hqLocation");
            return (Criteria) this;
        }

        public Criteria andHqLocationBetween(String value1, String value2) {
            addCriterion("HQ_LOCATION between", value1, value2, "hqLocation");
            return (Criteria) this;
        }

        public Criteria andHqLocationNotBetween(String value1, String value2) {
            addCriterion("HQ_LOCATION not between", value1, value2, "hqLocation");
            return (Criteria) this;
        }

        public Criteria andUniRegLocationIsNull() {
            addCriterion("UNI_REG_LOCATION is null");
            return (Criteria) this;
        }

        public Criteria andUniRegLocationIsNotNull() {
            addCriterion("UNI_REG_LOCATION is not null");
            return (Criteria) this;
        }

        public Criteria andUniRegLocationEqualTo(Integer value) {
            addCriterion("UNI_REG_LOCATION =", value, "uniRegLocation");
            return (Criteria) this;
        }

        public Criteria andUniRegLocationNotEqualTo(Integer value) {
            addCriterion("UNI_REG_LOCATION <>", value, "uniRegLocation");
            return (Criteria) this;
        }

        public Criteria andUniRegLocationGreaterThan(Integer value) {
            addCriterion("UNI_REG_LOCATION >", value, "uniRegLocation");
            return (Criteria) this;
        }

        public Criteria andUniRegLocationGreaterThanOrEqualTo(Integer value) {
            addCriterion("UNI_REG_LOCATION >=", value, "uniRegLocation");
            return (Criteria) this;
        }

        public Criteria andUniRegLocationLessThan(Integer value) {
            addCriterion("UNI_REG_LOCATION <", value, "uniRegLocation");
            return (Criteria) this;
        }

        public Criteria andUniRegLocationLessThanOrEqualTo(Integer value) {
            addCriterion("UNI_REG_LOCATION <=", value, "uniRegLocation");
            return (Criteria) this;
        }

        public Criteria andUniRegLocationIn(List<Integer> values) {
            addCriterion("UNI_REG_LOCATION in", values, "uniRegLocation");
            return (Criteria) this;
        }

        public Criteria andUniRegLocationNotIn(List<Integer> values) {
            addCriterion("UNI_REG_LOCATION not in", values, "uniRegLocation");
            return (Criteria) this;
        }

        public Criteria andUniRegLocationBetween(Integer value1, Integer value2) {
            addCriterion("UNI_REG_LOCATION between", value1, value2, "uniRegLocation");
            return (Criteria) this;
        }

        public Criteria andUniRegLocationNotBetween(Integer value1, Integer value2) {
            addCriterion("UNI_REG_LOCATION not between", value1, value2, "uniRegLocation");
            return (Criteria) this;
        }

        public Criteria andHqContactIsNull() {
            addCriterion("HQ_CONTACT is null");
            return (Criteria) this;
        }

        public Criteria andHqContactIsNotNull() {
            addCriterion("HQ_CONTACT is not null");
            return (Criteria) this;
        }

        public Criteria andHqContactEqualTo(String value) {
            addCriterion("HQ_CONTACT =", value, "hqContact");
            return (Criteria) this;
        }

        public Criteria andHqContactNotEqualTo(String value) {
            addCriterion("HQ_CONTACT <>", value, "hqContact");
            return (Criteria) this;
        }

        public Criteria andHqContactGreaterThan(String value) {
            addCriterion("HQ_CONTACT >", value, "hqContact");
            return (Criteria) this;
        }

        public Criteria andHqContactGreaterThanOrEqualTo(String value) {
            addCriterion("HQ_CONTACT >=", value, "hqContact");
            return (Criteria) this;
        }

        public Criteria andHqContactLessThan(String value) {
            addCriterion("HQ_CONTACT <", value, "hqContact");
            return (Criteria) this;
        }

        public Criteria andHqContactLessThanOrEqualTo(String value) {
            addCriterion("HQ_CONTACT <=", value, "hqContact");
            return (Criteria) this;
        }

        public Criteria andHqContactLike(String value) {
            addCriterion("HQ_CONTACT like", value, "hqContact");
            return (Criteria) this;
        }

        public Criteria andHqContactNotLike(String value) {
            addCriterion("HQ_CONTACT not like", value, "hqContact");
            return (Criteria) this;
        }

        public Criteria andHqContactIn(List<String> values) {
            addCriterion("HQ_CONTACT in", values, "hqContact");
            return (Criteria) this;
        }

        public Criteria andHqContactNotIn(List<String> values) {
            addCriterion("HQ_CONTACT not in", values, "hqContact");
            return (Criteria) this;
        }

        public Criteria andHqContactBetween(String value1, String value2) {
            addCriterion("HQ_CONTACT between", value1, value2, "hqContact");
            return (Criteria) this;
        }

        public Criteria andHqContactNotBetween(String value1, String value2) {
            addCriterion("HQ_CONTACT not between", value1, value2, "hqContact");
            return (Criteria) this;
        }

        public Criteria andHqContactPhoneIsNull() {
            addCriterion("HQ_CONTACT_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andHqContactPhoneIsNotNull() {
            addCriterion("HQ_CONTACT_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andHqContactPhoneEqualTo(String value) {
            addCriterion("HQ_CONTACT_PHONE =", value, "hqContactPhone");
            return (Criteria) this;
        }

        public Criteria andHqContactPhoneNotEqualTo(String value) {
            addCriterion("HQ_CONTACT_PHONE <>", value, "hqContactPhone");
            return (Criteria) this;
        }

        public Criteria andHqContactPhoneGreaterThan(String value) {
            addCriterion("HQ_CONTACT_PHONE >", value, "hqContactPhone");
            return (Criteria) this;
        }

        public Criteria andHqContactPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("HQ_CONTACT_PHONE >=", value, "hqContactPhone");
            return (Criteria) this;
        }

        public Criteria andHqContactPhoneLessThan(String value) {
            addCriterion("HQ_CONTACT_PHONE <", value, "hqContactPhone");
            return (Criteria) this;
        }

        public Criteria andHqContactPhoneLessThanOrEqualTo(String value) {
            addCriterion("HQ_CONTACT_PHONE <=", value, "hqContactPhone");
            return (Criteria) this;
        }

        public Criteria andHqContactPhoneLike(String value) {
            addCriterion("HQ_CONTACT_PHONE like", value, "hqContactPhone");
            return (Criteria) this;
        }

        public Criteria andHqContactPhoneNotLike(String value) {
            addCriterion("HQ_CONTACT_PHONE not like", value, "hqContactPhone");
            return (Criteria) this;
        }

        public Criteria andHqContactPhoneIn(List<String> values) {
            addCriterion("HQ_CONTACT_PHONE in", values, "hqContactPhone");
            return (Criteria) this;
        }

        public Criteria andHqContactPhoneNotIn(List<String> values) {
            addCriterion("HQ_CONTACT_PHONE not in", values, "hqContactPhone");
            return (Criteria) this;
        }

        public Criteria andHqContactPhoneBetween(String value1, String value2) {
            addCriterion("HQ_CONTACT_PHONE between", value1, value2, "hqContactPhone");
            return (Criteria) this;
        }

        public Criteria andHqContactPhoneNotBetween(String value1, String value2) {
            addCriterion("HQ_CONTACT_PHONE not between", value1, value2, "hqContactPhone");
            return (Criteria) this;
        }

        public Criteria andHqContactSecoptIsNull() {
            addCriterion("HQ_CONTACT_SECOPT is null");
            return (Criteria) this;
        }

        public Criteria andHqContactSecoptIsNotNull() {
            addCriterion("HQ_CONTACT_SECOPT is not null");
            return (Criteria) this;
        }

        public Criteria andHqContactSecoptEqualTo(String value) {
            addCriterion("HQ_CONTACT_SECOPT =", value, "hqContactSecopt");
            return (Criteria) this;
        }

        public Criteria andHqContactSecoptNotEqualTo(String value) {
            addCriterion("HQ_CONTACT_SECOPT <>", value, "hqContactSecopt");
            return (Criteria) this;
        }

        public Criteria andHqContactSecoptGreaterThan(String value) {
            addCriterion("HQ_CONTACT_SECOPT >", value, "hqContactSecopt");
            return (Criteria) this;
        }

        public Criteria andHqContactSecoptGreaterThanOrEqualTo(String value) {
            addCriterion("HQ_CONTACT_SECOPT >=", value, "hqContactSecopt");
            return (Criteria) this;
        }

        public Criteria andHqContactSecoptLessThan(String value) {
            addCriterion("HQ_CONTACT_SECOPT <", value, "hqContactSecopt");
            return (Criteria) this;
        }

        public Criteria andHqContactSecoptLessThanOrEqualTo(String value) {
            addCriterion("HQ_CONTACT_SECOPT <=", value, "hqContactSecopt");
            return (Criteria) this;
        }

        public Criteria andHqContactSecoptLike(String value) {
            addCriterion("HQ_CONTACT_SECOPT like", value, "hqContactSecopt");
            return (Criteria) this;
        }

        public Criteria andHqContactSecoptNotLike(String value) {
            addCriterion("HQ_CONTACT_SECOPT not like", value, "hqContactSecopt");
            return (Criteria) this;
        }

        public Criteria andHqContactSecoptIn(List<String> values) {
            addCriterion("HQ_CONTACT_SECOPT in", values, "hqContactSecopt");
            return (Criteria) this;
        }

        public Criteria andHqContactSecoptNotIn(List<String> values) {
            addCriterion("HQ_CONTACT_SECOPT not in", values, "hqContactSecopt");
            return (Criteria) this;
        }

        public Criteria andHqContactSecoptBetween(String value1, String value2) {
            addCriterion("HQ_CONTACT_SECOPT between", value1, value2, "hqContactSecopt");
            return (Criteria) this;
        }

        public Criteria andHqContactSecoptNotBetween(String value1, String value2) {
            addCriterion("HQ_CONTACT_SECOPT not between", value1, value2, "hqContactSecopt");
            return (Criteria) this;
        }

        public Criteria andCourseContactIsNull() {
            addCriterion("COURSE_CONTACT is null");
            return (Criteria) this;
        }

        public Criteria andCourseContactIsNotNull() {
            addCriterion("COURSE_CONTACT is not null");
            return (Criteria) this;
        }

        public Criteria andCourseContactEqualTo(String value) {
            addCriterion("COURSE_CONTACT =", value, "courseContact");
            return (Criteria) this;
        }

        public Criteria andCourseContactNotEqualTo(String value) {
            addCriterion("COURSE_CONTACT <>", value, "courseContact");
            return (Criteria) this;
        }

        public Criteria andCourseContactGreaterThan(String value) {
            addCriterion("COURSE_CONTACT >", value, "courseContact");
            return (Criteria) this;
        }

        public Criteria andCourseContactGreaterThanOrEqualTo(String value) {
            addCriterion("COURSE_CONTACT >=", value, "courseContact");
            return (Criteria) this;
        }

        public Criteria andCourseContactLessThan(String value) {
            addCriterion("COURSE_CONTACT <", value, "courseContact");
            return (Criteria) this;
        }

        public Criteria andCourseContactLessThanOrEqualTo(String value) {
            addCriterion("COURSE_CONTACT <=", value, "courseContact");
            return (Criteria) this;
        }

        public Criteria andCourseContactLike(String value) {
            addCriterion("COURSE_CONTACT like", value, "courseContact");
            return (Criteria) this;
        }

        public Criteria andCourseContactNotLike(String value) {
            addCriterion("COURSE_CONTACT not like", value, "courseContact");
            return (Criteria) this;
        }

        public Criteria andCourseContactIn(List<String> values) {
            addCriterion("COURSE_CONTACT in", values, "courseContact");
            return (Criteria) this;
        }

        public Criteria andCourseContactNotIn(List<String> values) {
            addCriterion("COURSE_CONTACT not in", values, "courseContact");
            return (Criteria) this;
        }

        public Criteria andCourseContactBetween(String value1, String value2) {
            addCriterion("COURSE_CONTACT between", value1, value2, "courseContact");
            return (Criteria) this;
        }

        public Criteria andCourseContactNotBetween(String value1, String value2) {
            addCriterion("COURSE_CONTACT not between", value1, value2, "courseContact");
            return (Criteria) this;
        }

        public Criteria andCourseContactPhoneIsNull() {
            addCriterion("COURSE_CONTACT_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andCourseContactPhoneIsNotNull() {
            addCriterion("COURSE_CONTACT_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andCourseContactPhoneEqualTo(String value) {
            addCriterion("COURSE_CONTACT_PHONE =", value, "courseContactPhone");
            return (Criteria) this;
        }

        public Criteria andCourseContactPhoneNotEqualTo(String value) {
            addCriterion("COURSE_CONTACT_PHONE <>", value, "courseContactPhone");
            return (Criteria) this;
        }

        public Criteria andCourseContactPhoneGreaterThan(String value) {
            addCriterion("COURSE_CONTACT_PHONE >", value, "courseContactPhone");
            return (Criteria) this;
        }

        public Criteria andCourseContactPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("COURSE_CONTACT_PHONE >=", value, "courseContactPhone");
            return (Criteria) this;
        }

        public Criteria andCourseContactPhoneLessThan(String value) {
            addCriterion("COURSE_CONTACT_PHONE <", value, "courseContactPhone");
            return (Criteria) this;
        }

        public Criteria andCourseContactPhoneLessThanOrEqualTo(String value) {
            addCriterion("COURSE_CONTACT_PHONE <=", value, "courseContactPhone");
            return (Criteria) this;
        }

        public Criteria andCourseContactPhoneLike(String value) {
            addCriterion("COURSE_CONTACT_PHONE like", value, "courseContactPhone");
            return (Criteria) this;
        }

        public Criteria andCourseContactPhoneNotLike(String value) {
            addCriterion("COURSE_CONTACT_PHONE not like", value, "courseContactPhone");
            return (Criteria) this;
        }

        public Criteria andCourseContactPhoneIn(List<String> values) {
            addCriterion("COURSE_CONTACT_PHONE in", values, "courseContactPhone");
            return (Criteria) this;
        }

        public Criteria andCourseContactPhoneNotIn(List<String> values) {
            addCriterion("COURSE_CONTACT_PHONE not in", values, "courseContactPhone");
            return (Criteria) this;
        }

        public Criteria andCourseContactPhoneBetween(String value1, String value2) {
            addCriterion("COURSE_CONTACT_PHONE between", value1, value2, "courseContactPhone");
            return (Criteria) this;
        }

        public Criteria andCourseContactPhoneNotBetween(String value1, String value2) {
            addCriterion("COURSE_CONTACT_PHONE not between", value1, value2, "courseContactPhone");
            return (Criteria) this;
        }

        public Criteria andStudentInqueryPhoneIsNull() {
            addCriterion("STUDENT_INQUERY_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andStudentInqueryPhoneIsNotNull() {
            addCriterion("STUDENT_INQUERY_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andStudentInqueryPhoneEqualTo(String value) {
            addCriterion("STUDENT_INQUERY_PHONE =", value, "studentInqueryPhone");
            return (Criteria) this;
        }

        public Criteria andStudentInqueryPhoneNotEqualTo(String value) {
            addCriterion("STUDENT_INQUERY_PHONE <>", value, "studentInqueryPhone");
            return (Criteria) this;
        }

        public Criteria andStudentInqueryPhoneGreaterThan(String value) {
            addCriterion("STUDENT_INQUERY_PHONE >", value, "studentInqueryPhone");
            return (Criteria) this;
        }

        public Criteria andStudentInqueryPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("STUDENT_INQUERY_PHONE >=", value, "studentInqueryPhone");
            return (Criteria) this;
        }

        public Criteria andStudentInqueryPhoneLessThan(String value) {
            addCriterion("STUDENT_INQUERY_PHONE <", value, "studentInqueryPhone");
            return (Criteria) this;
        }

        public Criteria andStudentInqueryPhoneLessThanOrEqualTo(String value) {
            addCriterion("STUDENT_INQUERY_PHONE <=", value, "studentInqueryPhone");
            return (Criteria) this;
        }

        public Criteria andStudentInqueryPhoneLike(String value) {
            addCriterion("STUDENT_INQUERY_PHONE like", value, "studentInqueryPhone");
            return (Criteria) this;
        }

        public Criteria andStudentInqueryPhoneNotLike(String value) {
            addCriterion("STUDENT_INQUERY_PHONE not like", value, "studentInqueryPhone");
            return (Criteria) this;
        }

        public Criteria andStudentInqueryPhoneIn(List<String> values) {
            addCriterion("STUDENT_INQUERY_PHONE in", values, "studentInqueryPhone");
            return (Criteria) this;
        }

        public Criteria andStudentInqueryPhoneNotIn(List<String> values) {
            addCriterion("STUDENT_INQUERY_PHONE not in", values, "studentInqueryPhone");
            return (Criteria) this;
        }

        public Criteria andStudentInqueryPhoneBetween(String value1, String value2) {
            addCriterion("STUDENT_INQUERY_PHONE between", value1, value2, "studentInqueryPhone");
            return (Criteria) this;
        }

        public Criteria andStudentInqueryPhoneNotBetween(String value1, String value2) {
            addCriterion("STUDENT_INQUERY_PHONE not between", value1, value2, "studentInqueryPhone");
            return (Criteria) this;
        }

        public Criteria andRegContactIsNull() {
            addCriterion("REG_CONTACT is null");
            return (Criteria) this;
        }

        public Criteria andRegContactIsNotNull() {
            addCriterion("REG_CONTACT is not null");
            return (Criteria) this;
        }

        public Criteria andRegContactEqualTo(String value) {
            addCriterion("REG_CONTACT =", value, "regContact");
            return (Criteria) this;
        }

        public Criteria andRegContactNotEqualTo(String value) {
            addCriterion("REG_CONTACT <>", value, "regContact");
            return (Criteria) this;
        }

        public Criteria andRegContactGreaterThan(String value) {
            addCriterion("REG_CONTACT >", value, "regContact");
            return (Criteria) this;
        }

        public Criteria andRegContactGreaterThanOrEqualTo(String value) {
            addCriterion("REG_CONTACT >=", value, "regContact");
            return (Criteria) this;
        }

        public Criteria andRegContactLessThan(String value) {
            addCriterion("REG_CONTACT <", value, "regContact");
            return (Criteria) this;
        }

        public Criteria andRegContactLessThanOrEqualTo(String value) {
            addCriterion("REG_CONTACT <=", value, "regContact");
            return (Criteria) this;
        }

        public Criteria andRegContactLike(String value) {
            addCriterion("REG_CONTACT like", value, "regContact");
            return (Criteria) this;
        }

        public Criteria andRegContactNotLike(String value) {
            addCriterion("REG_CONTACT not like", value, "regContact");
            return (Criteria) this;
        }

        public Criteria andRegContactIn(List<String> values) {
            addCriterion("REG_CONTACT in", values, "regContact");
            return (Criteria) this;
        }

        public Criteria andRegContactNotIn(List<String> values) {
            addCriterion("REG_CONTACT not in", values, "regContact");
            return (Criteria) this;
        }

        public Criteria andRegContactBetween(String value1, String value2) {
            addCriterion("REG_CONTACT between", value1, value2, "regContact");
            return (Criteria) this;
        }

        public Criteria andRegContactNotBetween(String value1, String value2) {
            addCriterion("REG_CONTACT not between", value1, value2, "regContact");
            return (Criteria) this;
        }

        public Criteria andRegContactPhoneIsNull() {
            addCriterion("REG_CONTACT_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andRegContactPhoneIsNotNull() {
            addCriterion("REG_CONTACT_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andRegContactPhoneEqualTo(String value) {
            addCriterion("REG_CONTACT_PHONE =", value, "regContactPhone");
            return (Criteria) this;
        }

        public Criteria andRegContactPhoneNotEqualTo(String value) {
            addCriterion("REG_CONTACT_PHONE <>", value, "regContactPhone");
            return (Criteria) this;
        }

        public Criteria andRegContactPhoneGreaterThan(String value) {
            addCriterion("REG_CONTACT_PHONE >", value, "regContactPhone");
            return (Criteria) this;
        }

        public Criteria andRegContactPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("REG_CONTACT_PHONE >=", value, "regContactPhone");
            return (Criteria) this;
        }

        public Criteria andRegContactPhoneLessThan(String value) {
            addCriterion("REG_CONTACT_PHONE <", value, "regContactPhone");
            return (Criteria) this;
        }

        public Criteria andRegContactPhoneLessThanOrEqualTo(String value) {
            addCriterion("REG_CONTACT_PHONE <=", value, "regContactPhone");
            return (Criteria) this;
        }

        public Criteria andRegContactPhoneLike(String value) {
            addCriterion("REG_CONTACT_PHONE like", value, "regContactPhone");
            return (Criteria) this;
        }

        public Criteria andRegContactPhoneNotLike(String value) {
            addCriterion("REG_CONTACT_PHONE not like", value, "regContactPhone");
            return (Criteria) this;
        }

        public Criteria andRegContactPhoneIn(List<String> values) {
            addCriterion("REG_CONTACT_PHONE in", values, "regContactPhone");
            return (Criteria) this;
        }

        public Criteria andRegContactPhoneNotIn(List<String> values) {
            addCriterion("REG_CONTACT_PHONE not in", values, "regContactPhone");
            return (Criteria) this;
        }

        public Criteria andRegContactPhoneBetween(String value1, String value2) {
            addCriterion("REG_CONTACT_PHONE between", value1, value2, "regContactPhone");
            return (Criteria) this;
        }

        public Criteria andRegContactPhoneNotBetween(String value1, String value2) {
            addCriterion("REG_CONTACT_PHONE not between", value1, value2, "regContactPhone");
            return (Criteria) this;
        }

        public Criteria andRegContactFaxIsNull() {
            addCriterion("REG_CONTACT_FAX is null");
            return (Criteria) this;
        }

        public Criteria andRegContactFaxIsNotNull() {
            addCriterion("REG_CONTACT_FAX is not null");
            return (Criteria) this;
        }

        public Criteria andRegContactFaxEqualTo(String value) {
            addCriterion("REG_CONTACT_FAX =", value, "regContactFax");
            return (Criteria) this;
        }

        public Criteria andRegContactFaxNotEqualTo(String value) {
            addCriterion("REG_CONTACT_FAX <>", value, "regContactFax");
            return (Criteria) this;
        }

        public Criteria andRegContactFaxGreaterThan(String value) {
            addCriterion("REG_CONTACT_FAX >", value, "regContactFax");
            return (Criteria) this;
        }

        public Criteria andRegContactFaxGreaterThanOrEqualTo(String value) {
            addCriterion("REG_CONTACT_FAX >=", value, "regContactFax");
            return (Criteria) this;
        }

        public Criteria andRegContactFaxLessThan(String value) {
            addCriterion("REG_CONTACT_FAX <", value, "regContactFax");
            return (Criteria) this;
        }

        public Criteria andRegContactFaxLessThanOrEqualTo(String value) {
            addCriterion("REG_CONTACT_FAX <=", value, "regContactFax");
            return (Criteria) this;
        }

        public Criteria andRegContactFaxLike(String value) {
            addCriterion("REG_CONTACT_FAX like", value, "regContactFax");
            return (Criteria) this;
        }

        public Criteria andRegContactFaxNotLike(String value) {
            addCriterion("REG_CONTACT_FAX not like", value, "regContactFax");
            return (Criteria) this;
        }

        public Criteria andRegContactFaxIn(List<String> values) {
            addCriterion("REG_CONTACT_FAX in", values, "regContactFax");
            return (Criteria) this;
        }

        public Criteria andRegContactFaxNotIn(List<String> values) {
            addCriterion("REG_CONTACT_FAX not in", values, "regContactFax");
            return (Criteria) this;
        }

        public Criteria andRegContactFaxBetween(String value1, String value2) {
            addCriterion("REG_CONTACT_FAX between", value1, value2, "regContactFax");
            return (Criteria) this;
        }

        public Criteria andRegContactFaxNotBetween(String value1, String value2) {
            addCriterion("REG_CONTACT_FAX not between", value1, value2, "regContactFax");
            return (Criteria) this;
        }

        public Criteria andCutoffDayIsNull() {
            addCriterion("CUTOFF_DAY is null");
            return (Criteria) this;
        }

        public Criteria andCutoffDayIsNotNull() {
            addCriterion("CUTOFF_DAY is not null");
            return (Criteria) this;
        }

        public Criteria andCutoffDayEqualTo(Integer value) {
            addCriterion("CUTOFF_DAY =", value, "cutoffDay");
            return (Criteria) this;
        }

        public Criteria andCutoffDayNotEqualTo(Integer value) {
            addCriterion("CUTOFF_DAY <>", value, "cutoffDay");
            return (Criteria) this;
        }

        public Criteria andCutoffDayGreaterThan(Integer value) {
            addCriterion("CUTOFF_DAY >", value, "cutoffDay");
            return (Criteria) this;
        }

        public Criteria andCutoffDayGreaterThanOrEqualTo(Integer value) {
            addCriterion("CUTOFF_DAY >=", value, "cutoffDay");
            return (Criteria) this;
        }

        public Criteria andCutoffDayLessThan(Integer value) {
            addCriterion("CUTOFF_DAY <", value, "cutoffDay");
            return (Criteria) this;
        }

        public Criteria andCutoffDayLessThanOrEqualTo(Integer value) {
            addCriterion("CUTOFF_DAY <=", value, "cutoffDay");
            return (Criteria) this;
        }

        public Criteria andCutoffDayIn(List<Integer> values) {
            addCriterion("CUTOFF_DAY in", values, "cutoffDay");
            return (Criteria) this;
        }

        public Criteria andCutoffDayNotIn(List<Integer> values) {
            addCriterion("CUTOFF_DAY not in", values, "cutoffDay");
            return (Criteria) this;
        }

        public Criteria andCutoffDayBetween(Integer value1, Integer value2) {
            addCriterion("CUTOFF_DAY between", value1, value2, "cutoffDay");
            return (Criteria) this;
        }

        public Criteria andCutoffDayNotBetween(Integer value1, Integer value2) {
            addCriterion("CUTOFF_DAY not between", value1, value2, "cutoffDay");
            return (Criteria) this;
        }

        public Criteria andCutoffTimeIsNull() {
            addCriterion("CUTOFF_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCutoffTimeIsNotNull() {
            addCriterion("CUTOFF_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCutoffTimeEqualTo(Integer value) {
            addCriterion("CUTOFF_TIME =", value, "cutoffTime");
            return (Criteria) this;
        }

        public Criteria andCutoffTimeNotEqualTo(Integer value) {
            addCriterion("CUTOFF_TIME <>", value, "cutoffTime");
            return (Criteria) this;
        }

        public Criteria andCutoffTimeGreaterThan(Integer value) {
            addCriterion("CUTOFF_TIME >", value, "cutoffTime");
            return (Criteria) this;
        }

        public Criteria andCutoffTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("CUTOFF_TIME >=", value, "cutoffTime");
            return (Criteria) this;
        }

        public Criteria andCutoffTimeLessThan(Integer value) {
            addCriterion("CUTOFF_TIME <", value, "cutoffTime");
            return (Criteria) this;
        }

        public Criteria andCutoffTimeLessThanOrEqualTo(Integer value) {
            addCriterion("CUTOFF_TIME <=", value, "cutoffTime");
            return (Criteria) this;
        }

        public Criteria andCutoffTimeIn(List<Integer> values) {
            addCriterion("CUTOFF_TIME in", values, "cutoffTime");
            return (Criteria) this;
        }

        public Criteria andCutoffTimeNotIn(List<Integer> values) {
            addCriterion("CUTOFF_TIME not in", values, "cutoffTime");
            return (Criteria) this;
        }

        public Criteria andCutoffTimeBetween(Integer value1, Integer value2) {
            addCriterion("CUTOFF_TIME between", value1, value2, "cutoffTime");
            return (Criteria) this;
        }

        public Criteria andCutoffTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("CUTOFF_TIME not between", value1, value2, "cutoffTime");
            return (Criteria) this;
        }

        public Criteria andPartnerQualificationIsNull() {
            addCriterion("PARTNER_QUALIFICATION is null");
            return (Criteria) this;
        }

        public Criteria andPartnerQualificationIsNotNull() {
            addCriterion("PARTNER_QUALIFICATION is not null");
            return (Criteria) this;
        }

        public Criteria andPartnerQualificationEqualTo(Integer value) {
            addCriterion("PARTNER_QUALIFICATION =", value, "partnerQualification");
            return (Criteria) this;
        }

        public Criteria andPartnerQualificationNotEqualTo(Integer value) {
            addCriterion("PARTNER_QUALIFICATION <>", value, "partnerQualification");
            return (Criteria) this;
        }

        public Criteria andPartnerQualificationGreaterThan(Integer value) {
            addCriterion("PARTNER_QUALIFICATION >", value, "partnerQualification");
            return (Criteria) this;
        }

        public Criteria andPartnerQualificationGreaterThanOrEqualTo(Integer value) {
            addCriterion("PARTNER_QUALIFICATION >=", value, "partnerQualification");
            return (Criteria) this;
        }

        public Criteria andPartnerQualificationLessThan(Integer value) {
            addCriterion("PARTNER_QUALIFICATION <", value, "partnerQualification");
            return (Criteria) this;
        }

        public Criteria andPartnerQualificationLessThanOrEqualTo(Integer value) {
            addCriterion("PARTNER_QUALIFICATION <=", value, "partnerQualification");
            return (Criteria) this;
        }

        public Criteria andPartnerQualificationIn(List<Integer> values) {
            addCriterion("PARTNER_QUALIFICATION in", values, "partnerQualification");
            return (Criteria) this;
        }

        public Criteria andPartnerQualificationNotIn(List<Integer> values) {
            addCriterion("PARTNER_QUALIFICATION not in", values, "partnerQualification");
            return (Criteria) this;
        }

        public Criteria andPartnerQualificationBetween(Integer value1, Integer value2) {
            addCriterion("PARTNER_QUALIFICATION between", value1, value2, "partnerQualification");
            return (Criteria) this;
        }

        public Criteria andPartnerQualificationNotBetween(Integer value1, Integer value2) {
            addCriterion("PARTNER_QUALIFICATION not between", value1, value2, "partnerQualification");
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