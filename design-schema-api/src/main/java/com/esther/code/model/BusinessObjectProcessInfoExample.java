package com.esther.code.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BusinessObjectProcessInfoExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BusinessObjectProcessInfoExample() {
        oredCriteria = new ArrayList<>();
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
        return new Criteria();
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * org.mybatis.generator.config.Context@3abfe836
     * 
     * @authpr gaowenlin
     * @version 1.0 2017-05-03
     */
    protected abstract static class GeneratedCriteria implements Serializable {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
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

        public Criteria andBusinessObjectIdIsNull() {
            addCriterion("business_object_id is null");
            return (Criteria) this;
        }

        public Criteria andBusinessObjectIdIsNotNull() {
            addCriterion("business_object_id is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessObjectIdEqualTo(Long value) {
            addCriterion("business_object_id =", value, "businessObjectId");
            return (Criteria) this;
        }

        public Criteria andBusinessObjectIdNotEqualTo(Long value) {
            addCriterion("business_object_id <>", value, "businessObjectId");
            return (Criteria) this;
        }

        public Criteria andBusinessObjectIdGreaterThan(Long value) {
            addCriterion("business_object_id >", value, "businessObjectId");
            return (Criteria) this;
        }

        public Criteria andBusinessObjectIdGreaterThanOrEqualTo(Long value) {
            addCriterion("business_object_id >=", value, "businessObjectId");
            return (Criteria) this;
        }

        public Criteria andBusinessObjectIdLessThan(Long value) {
            addCriterion("business_object_id <", value, "businessObjectId");
            return (Criteria) this;
        }

        public Criteria andBusinessObjectIdLessThanOrEqualTo(Long value) {
            addCriterion("business_object_id <=", value, "businessObjectId");
            return (Criteria) this;
        }

        public Criteria andBusinessObjectIdIn(List<Long> values) {
            addCriterion("business_object_id in", values, "businessObjectId");
            return (Criteria) this;
        }

        public Criteria andBusinessObjectIdNotIn(List<Long> values) {
            addCriterion("business_object_id not in", values, "businessObjectId");
            return (Criteria) this;
        }

        public Criteria andBusinessObjectIdBetween(Long value1, Long value2) {
            addCriterion("business_object_id between", value1, value2, "businessObjectId");
            return (Criteria) this;
        }

        public Criteria andBusinessObjectIdNotBetween(Long value1, Long value2) {
            addCriterion("business_object_id not between", value1, value2, "businessObjectId");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeIsNull() {
            addCriterion("business_type is null");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeIsNotNull() {
            addCriterion("business_type is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeEqualTo(String value) {
            addCriterion("business_type =", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNotEqualTo(String value) {
            addCriterion("business_type <>", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeGreaterThan(String value) {
            addCriterion("business_type >", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeGreaterThanOrEqualTo(String value) {
            addCriterion("business_type >=", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeLessThan(String value) {
            addCriterion("business_type <", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeLessThanOrEqualTo(String value) {
            addCriterion("business_type <=", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeLike(String value) {
            addCriterion("business_type like", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNotLike(String value) {
            addCriterion("business_type not like", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeIn(List<String> values) {
            addCriterion("business_type in", values, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNotIn(List<String> values) {
            addCriterion("business_type not in", values, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeBetween(String value1, String value2) {
            addCriterion("business_type between", value1, value2, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNotBetween(String value1, String value2) {
            addCriterion("business_type not between", value1, value2, "businessType");
            return (Criteria) this;
        }

        public Criteria andBorrowerIdIsNull() {
            addCriterion("borrower_id is null");
            return (Criteria) this;
        }

        public Criteria andBorrowerIdIsNotNull() {
            addCriterion("borrower_id is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowerIdEqualTo(Long value) {
            addCriterion("borrower_id =", value, "borrowerId");
            return (Criteria) this;
        }

        public Criteria andBorrowerIdNotEqualTo(Long value) {
            addCriterion("borrower_id <>", value, "borrowerId");
            return (Criteria) this;
        }

        public Criteria andBorrowerIdGreaterThan(Long value) {
            addCriterion("borrower_id >", value, "borrowerId");
            return (Criteria) this;
        }

        public Criteria andBorrowerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("borrower_id >=", value, "borrowerId");
            return (Criteria) this;
        }

        public Criteria andBorrowerIdLessThan(Long value) {
            addCriterion("borrower_id <", value, "borrowerId");
            return (Criteria) this;
        }

        public Criteria andBorrowerIdLessThanOrEqualTo(Long value) {
            addCriterion("borrower_id <=", value, "borrowerId");
            return (Criteria) this;
        }

        public Criteria andBorrowerIdIn(List<Long> values) {
            addCriterion("borrower_id in", values, "borrowerId");
            return (Criteria) this;
        }

        public Criteria andBorrowerIdNotIn(List<Long> values) {
            addCriterion("borrower_id not in", values, "borrowerId");
            return (Criteria) this;
        }

        public Criteria andBorrowerIdBetween(Long value1, Long value2) {
            addCriterion("borrower_id between", value1, value2, "borrowerId");
            return (Criteria) this;
        }

        public Criteria andBorrowerIdNotBetween(Long value1, Long value2) {
            addCriterion("borrower_id not between", value1, value2, "borrowerId");
            return (Criteria) this;
        }

        public Criteria andBorrowerNameIsNull() {
            addCriterion("borrower_name is null");
            return (Criteria) this;
        }

        public Criteria andBorrowerNameIsNotNull() {
            addCriterion("borrower_name is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowerNameEqualTo(String value) {
            addCriterion("borrower_name =", value, "borrowerName");
            return (Criteria) this;
        }

        public Criteria andBorrowerNameNotEqualTo(String value) {
            addCriterion("borrower_name <>", value, "borrowerName");
            return (Criteria) this;
        }

        public Criteria andBorrowerNameGreaterThan(String value) {
            addCriterion("borrower_name >", value, "borrowerName");
            return (Criteria) this;
        }

        public Criteria andBorrowerNameGreaterThanOrEqualTo(String value) {
            addCriterion("borrower_name >=", value, "borrowerName");
            return (Criteria) this;
        }

        public Criteria andBorrowerNameLessThan(String value) {
            addCriterion("borrower_name <", value, "borrowerName");
            return (Criteria) this;
        }

        public Criteria andBorrowerNameLessThanOrEqualTo(String value) {
            addCriterion("borrower_name <=", value, "borrowerName");
            return (Criteria) this;
        }

        public Criteria andBorrowerNameLike(String value) {
            addCriterion("borrower_name like", value, "borrowerName");
            return (Criteria) this;
        }

        public Criteria andBorrowerNameNotLike(String value) {
            addCriterion("borrower_name not like", value, "borrowerName");
            return (Criteria) this;
        }

        public Criteria andBorrowerNameIn(List<String> values) {
            addCriterion("borrower_name in", values, "borrowerName");
            return (Criteria) this;
        }

        public Criteria andBorrowerNameNotIn(List<String> values) {
            addCriterion("borrower_name not in", values, "borrowerName");
            return (Criteria) this;
        }

        public Criteria andBorrowerNameBetween(String value1, String value2) {
            addCriterion("borrower_name between", value1, value2, "borrowerName");
            return (Criteria) this;
        }

        public Criteria andBorrowerNameNotBetween(String value1, String value2) {
            addCriterion("borrower_name not between", value1, value2, "borrowerName");
            return (Criteria) this;
        }

        public Criteria andLaunchUserIdIsNull() {
            addCriterion("launch_user_id is null");
            return (Criteria) this;
        }

        public Criteria andLaunchUserIdIsNotNull() {
            addCriterion("launch_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andLaunchUserIdEqualTo(Long value) {
            addCriterion("launch_user_id =", value, "launchUserId");
            return (Criteria) this;
        }

        public Criteria andLaunchUserIdNotEqualTo(Long value) {
            addCriterion("launch_user_id <>", value, "launchUserId");
            return (Criteria) this;
        }

        public Criteria andLaunchUserIdGreaterThan(Long value) {
            addCriterion("launch_user_id >", value, "launchUserId");
            return (Criteria) this;
        }

        public Criteria andLaunchUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("launch_user_id >=", value, "launchUserId");
            return (Criteria) this;
        }

        public Criteria andLaunchUserIdLessThan(Long value) {
            addCriterion("launch_user_id <", value, "launchUserId");
            return (Criteria) this;
        }

        public Criteria andLaunchUserIdLessThanOrEqualTo(Long value) {
            addCriterion("launch_user_id <=", value, "launchUserId");
            return (Criteria) this;
        }

        public Criteria andLaunchUserIdIn(List<Long> values) {
            addCriterion("launch_user_id in", values, "launchUserId");
            return (Criteria) this;
        }

        public Criteria andLaunchUserIdNotIn(List<Long> values) {
            addCriterion("launch_user_id not in", values, "launchUserId");
            return (Criteria) this;
        }

        public Criteria andLaunchUserIdBetween(Long value1, Long value2) {
            addCriterion("launch_user_id between", value1, value2, "launchUserId");
            return (Criteria) this;
        }

        public Criteria andLaunchUserIdNotBetween(Long value1, Long value2) {
            addCriterion("launch_user_id not between", value1, value2, "launchUserId");
            return (Criteria) this;
        }

        public Criteria andLaunchUserNameIsNull() {
            addCriterion("launch_user_name is null");
            return (Criteria) this;
        }

        public Criteria andLaunchUserNameIsNotNull() {
            addCriterion("launch_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andLaunchUserNameEqualTo(String value) {
            addCriterion("launch_user_name =", value, "launchUserName");
            return (Criteria) this;
        }

        public Criteria andLaunchUserNameNotEqualTo(String value) {
            addCriterion("launch_user_name <>", value, "launchUserName");
            return (Criteria) this;
        }

        public Criteria andLaunchUserNameGreaterThan(String value) {
            addCriterion("launch_user_name >", value, "launchUserName");
            return (Criteria) this;
        }

        public Criteria andLaunchUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("launch_user_name >=", value, "launchUserName");
            return (Criteria) this;
        }

        public Criteria andLaunchUserNameLessThan(String value) {
            addCriterion("launch_user_name <", value, "launchUserName");
            return (Criteria) this;
        }

        public Criteria andLaunchUserNameLessThanOrEqualTo(String value) {
            addCriterion("launch_user_name <=", value, "launchUserName");
            return (Criteria) this;
        }

        public Criteria andLaunchUserNameLike(String value) {
            addCriterion("launch_user_name like", value, "launchUserName");
            return (Criteria) this;
        }

        public Criteria andLaunchUserNameNotLike(String value) {
            addCriterion("launch_user_name not like", value, "launchUserName");
            return (Criteria) this;
        }

        public Criteria andLaunchUserNameIn(List<String> values) {
            addCriterion("launch_user_name in", values, "launchUserName");
            return (Criteria) this;
        }

        public Criteria andLaunchUserNameNotIn(List<String> values) {
            addCriterion("launch_user_name not in", values, "launchUserName");
            return (Criteria) this;
        }

        public Criteria andLaunchUserNameBetween(String value1, String value2) {
            addCriterion("launch_user_name between", value1, value2, "launchUserName");
            return (Criteria) this;
        }

        public Criteria andLaunchUserNameNotBetween(String value1, String value2) {
            addCriterion("launch_user_name not between", value1, value2, "launchUserName");
            return (Criteria) this;
        }

        public Criteria andLaunchOrganizationIdIsNull() {
            addCriterion("launch_organization_id is null");
            return (Criteria) this;
        }

        public Criteria andLaunchOrganizationIdIsNotNull() {
            addCriterion("launch_organization_id is not null");
            return (Criteria) this;
        }

        public Criteria andLaunchOrganizationIdEqualTo(Long value) {
            addCriterion("launch_organization_id =", value, "launchOrganizationId");
            return (Criteria) this;
        }

        public Criteria andLaunchOrganizationIdNotEqualTo(Long value) {
            addCriterion("launch_organization_id <>", value, "launchOrganizationId");
            return (Criteria) this;
        }

        public Criteria andLaunchOrganizationIdGreaterThan(Long value) {
            addCriterion("launch_organization_id >", value, "launchOrganizationId");
            return (Criteria) this;
        }

        public Criteria andLaunchOrganizationIdGreaterThanOrEqualTo(Long value) {
            addCriterion("launch_organization_id >=", value, "launchOrganizationId");
            return (Criteria) this;
        }

        public Criteria andLaunchOrganizationIdLessThan(Long value) {
            addCriterion("launch_organization_id <", value, "launchOrganizationId");
            return (Criteria) this;
        }

        public Criteria andLaunchOrganizationIdLessThanOrEqualTo(Long value) {
            addCriterion("launch_organization_id <=", value, "launchOrganizationId");
            return (Criteria) this;
        }

        public Criteria andLaunchOrganizationIdIn(List<Long> values) {
            addCriterion("launch_organization_id in", values, "launchOrganizationId");
            return (Criteria) this;
        }

        public Criteria andLaunchOrganizationIdNotIn(List<Long> values) {
            addCriterion("launch_organization_id not in", values, "launchOrganizationId");
            return (Criteria) this;
        }

        public Criteria andLaunchOrganizationIdBetween(Long value1, Long value2) {
            addCriterion("launch_organization_id between", value1, value2, "launchOrganizationId");
            return (Criteria) this;
        }

        public Criteria andLaunchOrganizationIdNotBetween(Long value1, Long value2) {
            addCriterion("launch_organization_id not between", value1, value2, "launchOrganizationId");
            return (Criteria) this;
        }

        public Criteria andLaunchOrganizationNameIsNull() {
            addCriterion("launch_organization_name is null");
            return (Criteria) this;
        }

        public Criteria andLaunchOrganizationNameIsNotNull() {
            addCriterion("launch_organization_name is not null");
            return (Criteria) this;
        }

        public Criteria andLaunchOrganizationNameEqualTo(String value) {
            addCriterion("launch_organization_name =", value, "launchOrganizationName");
            return (Criteria) this;
        }

        public Criteria andLaunchOrganizationNameNotEqualTo(String value) {
            addCriterion("launch_organization_name <>", value, "launchOrganizationName");
            return (Criteria) this;
        }

        public Criteria andLaunchOrganizationNameGreaterThan(String value) {
            addCriterion("launch_organization_name >", value, "launchOrganizationName");
            return (Criteria) this;
        }

        public Criteria andLaunchOrganizationNameGreaterThanOrEqualTo(String value) {
            addCriterion("launch_organization_name >=", value, "launchOrganizationName");
            return (Criteria) this;
        }

        public Criteria andLaunchOrganizationNameLessThan(String value) {
            addCriterion("launch_organization_name <", value, "launchOrganizationName");
            return (Criteria) this;
        }

        public Criteria andLaunchOrganizationNameLessThanOrEqualTo(String value) {
            addCriterion("launch_organization_name <=", value, "launchOrganizationName");
            return (Criteria) this;
        }

        public Criteria andLaunchOrganizationNameLike(String value) {
            addCriterion("launch_organization_name like", value, "launchOrganizationName");
            return (Criteria) this;
        }

        public Criteria andLaunchOrganizationNameNotLike(String value) {
            addCriterion("launch_organization_name not like", value, "launchOrganizationName");
            return (Criteria) this;
        }

        public Criteria andLaunchOrganizationNameIn(List<String> values) {
            addCriterion("launch_organization_name in", values, "launchOrganizationName");
            return (Criteria) this;
        }

        public Criteria andLaunchOrganizationNameNotIn(List<String> values) {
            addCriterion("launch_organization_name not in", values, "launchOrganizationName");
            return (Criteria) this;
        }

        public Criteria andLaunchOrganizationNameBetween(String value1, String value2) {
            addCriterion("launch_organization_name between", value1, value2, "launchOrganizationName");
            return (Criteria) this;
        }

        public Criteria andLaunchOrganizationNameNotBetween(String value1, String value2) {
            addCriterion("launch_organization_name not between", value1, value2, "launchOrganizationName");
            return (Criteria) this;
        }

        public Criteria andBusinessGroupIdIsNull() {
            addCriterion("business_group_id is null");
            return (Criteria) this;
        }

        public Criteria andBusinessGroupIdIsNotNull() {
            addCriterion("business_group_id is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessGroupIdEqualTo(Long value) {
            addCriterion("business_group_id =", value, "businessGroupId");
            return (Criteria) this;
        }

        public Criteria andBusinessGroupIdNotEqualTo(Long value) {
            addCriterion("business_group_id <>", value, "businessGroupId");
            return (Criteria) this;
        }

        public Criteria andBusinessGroupIdGreaterThan(Long value) {
            addCriterion("business_group_id >", value, "businessGroupId");
            return (Criteria) this;
        }

        public Criteria andBusinessGroupIdGreaterThanOrEqualTo(Long value) {
            addCriterion("business_group_id >=", value, "businessGroupId");
            return (Criteria) this;
        }

        public Criteria andBusinessGroupIdLessThan(Long value) {
            addCriterion("business_group_id <", value, "businessGroupId");
            return (Criteria) this;
        }

        public Criteria andBusinessGroupIdLessThanOrEqualTo(Long value) {
            addCriterion("business_group_id <=", value, "businessGroupId");
            return (Criteria) this;
        }

        public Criteria andBusinessGroupIdIn(List<Long> values) {
            addCriterion("business_group_id in", values, "businessGroupId");
            return (Criteria) this;
        }

        public Criteria andBusinessGroupIdNotIn(List<Long> values) {
            addCriterion("business_group_id not in", values, "businessGroupId");
            return (Criteria) this;
        }

        public Criteria andBusinessGroupIdBetween(Long value1, Long value2) {
            addCriterion("business_group_id between", value1, value2, "businessGroupId");
            return (Criteria) this;
        }

        public Criteria andBusinessGroupIdNotBetween(Long value1, Long value2) {
            addCriterion("business_group_id not between", value1, value2, "businessGroupId");
            return (Criteria) this;
        }

        public Criteria andBusinessGroupNameIsNull() {
            addCriterion("business_group_name is null");
            return (Criteria) this;
        }

        public Criteria andBusinessGroupNameIsNotNull() {
            addCriterion("business_group_name is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessGroupNameEqualTo(String value) {
            addCriterion("business_group_name =", value, "businessGroupName");
            return (Criteria) this;
        }

        public Criteria andBusinessGroupNameNotEqualTo(String value) {
            addCriterion("business_group_name <>", value, "businessGroupName");
            return (Criteria) this;
        }

        public Criteria andBusinessGroupNameGreaterThan(String value) {
            addCriterion("business_group_name >", value, "businessGroupName");
            return (Criteria) this;
        }

        public Criteria andBusinessGroupNameGreaterThanOrEqualTo(String value) {
            addCriterion("business_group_name >=", value, "businessGroupName");
            return (Criteria) this;
        }

        public Criteria andBusinessGroupNameLessThan(String value) {
            addCriterion("business_group_name <", value, "businessGroupName");
            return (Criteria) this;
        }

        public Criteria andBusinessGroupNameLessThanOrEqualTo(String value) {
            addCriterion("business_group_name <=", value, "businessGroupName");
            return (Criteria) this;
        }

        public Criteria andBusinessGroupNameLike(String value) {
            addCriterion("business_group_name like", value, "businessGroupName");
            return (Criteria) this;
        }

        public Criteria andBusinessGroupNameNotLike(String value) {
            addCriterion("business_group_name not like", value, "businessGroupName");
            return (Criteria) this;
        }

        public Criteria andBusinessGroupNameIn(List<String> values) {
            addCriterion("business_group_name in", values, "businessGroupName");
            return (Criteria) this;
        }

        public Criteria andBusinessGroupNameNotIn(List<String> values) {
            addCriterion("business_group_name not in", values, "businessGroupName");
            return (Criteria) this;
        }

        public Criteria andBusinessGroupNameBetween(String value1, String value2) {
            addCriterion("business_group_name between", value1, value2, "businessGroupName");
            return (Criteria) this;
        }

        public Criteria andBusinessGroupNameNotBetween(String value1, String value2) {
            addCriterion("business_group_name not between", value1, value2, "businessGroupName");
            return (Criteria) this;
        }

        public Criteria andBusinessNumIsNull() {
            addCriterion("business_num is null");
            return (Criteria) this;
        }

        public Criteria andBusinessNumIsNotNull() {
            addCriterion("business_num is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessNumEqualTo(String value) {
            addCriterion("business_num =", value, "businessNum");
            return (Criteria) this;
        }

        public Criteria andBusinessNumNotEqualTo(String value) {
            addCriterion("business_num <>", value, "businessNum");
            return (Criteria) this;
        }

        public Criteria andBusinessNumGreaterThan(String value) {
            addCriterion("business_num >", value, "businessNum");
            return (Criteria) this;
        }

        public Criteria andBusinessNumGreaterThanOrEqualTo(String value) {
            addCriterion("business_num >=", value, "businessNum");
            return (Criteria) this;
        }

        public Criteria andBusinessNumLessThan(String value) {
            addCriterion("business_num <", value, "businessNum");
            return (Criteria) this;
        }

        public Criteria andBusinessNumLessThanOrEqualTo(String value) {
            addCriterion("business_num <=", value, "businessNum");
            return (Criteria) this;
        }

        public Criteria andBusinessNumLike(String value) {
            addCriterion("business_num like", value, "businessNum");
            return (Criteria) this;
        }

        public Criteria andBusinessNumNotLike(String value) {
            addCriterion("business_num not like", value, "businessNum");
            return (Criteria) this;
        }

        public Criteria andBusinessNumIn(List<String> values) {
            addCriterion("business_num in", values, "businessNum");
            return (Criteria) this;
        }

        public Criteria andBusinessNumNotIn(List<String> values) {
            addCriterion("business_num not in", values, "businessNum");
            return (Criteria) this;
        }

        public Criteria andBusinessNumBetween(String value1, String value2) {
            addCriterion("business_num between", value1, value2, "businessNum");
            return (Criteria) this;
        }

        public Criteria andBusinessNumNotBetween(String value1, String value2) {
            addCriterion("business_num not between", value1, value2, "businessNum");
            return (Criteria) this;
        }

        public Criteria andIsAdvanceIsNull() {
            addCriterion("is_advance is null");
            return (Criteria) this;
        }

        public Criteria andIsAdvanceIsNotNull() {
            addCriterion("is_advance is not null");
            return (Criteria) this;
        }

        public Criteria andIsAdvanceEqualTo(Boolean value) {
            addCriterion("is_advance =", value, "isAdvance");
            return (Criteria) this;
        }

        public Criteria andIsAdvanceNotEqualTo(Boolean value) {
            addCriterion("is_advance <>", value, "isAdvance");
            return (Criteria) this;
        }

        public Criteria andIsAdvanceGreaterThan(Boolean value) {
            addCriterion("is_advance >", value, "isAdvance");
            return (Criteria) this;
        }

        public Criteria andIsAdvanceGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_advance >=", value, "isAdvance");
            return (Criteria) this;
        }

        public Criteria andIsAdvanceLessThan(Boolean value) {
            addCriterion("is_advance <", value, "isAdvance");
            return (Criteria) this;
        }

        public Criteria andIsAdvanceLessThanOrEqualTo(Boolean value) {
            addCriterion("is_advance <=", value, "isAdvance");
            return (Criteria) this;
        }

        public Criteria andIsAdvanceIn(List<Boolean> values) {
            addCriterion("is_advance in", values, "isAdvance");
            return (Criteria) this;
        }

        public Criteria andIsAdvanceNotIn(List<Boolean> values) {
            addCriterion("is_advance not in", values, "isAdvance");
            return (Criteria) this;
        }

        public Criteria andIsAdvanceBetween(Boolean value1, Boolean value2) {
            addCriterion("is_advance between", value1, value2, "isAdvance");
            return (Criteria) this;
        }

        public Criteria andIsAdvanceNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_advance not between", value1, value2, "isAdvance");
            return (Criteria) this;
        }

        public Criteria andIsSecondHandCarIsNull() {
            addCriterion("is_second_hand_car is null");
            return (Criteria) this;
        }

        public Criteria andIsSecondHandCarIsNotNull() {
            addCriterion("is_second_hand_car is not null");
            return (Criteria) this;
        }

        public Criteria andIsSecondHandCarEqualTo(Boolean value) {
            addCriterion("is_second_hand_car =", value, "isSecondHandCar");
            return (Criteria) this;
        }

        public Criteria andIsSecondHandCarNotEqualTo(Boolean value) {
            addCriterion("is_second_hand_car <>", value, "isSecondHandCar");
            return (Criteria) this;
        }

        public Criteria andIsSecondHandCarGreaterThan(Boolean value) {
            addCriterion("is_second_hand_car >", value, "isSecondHandCar");
            return (Criteria) this;
        }

        public Criteria andIsSecondHandCarGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_second_hand_car >=", value, "isSecondHandCar");
            return (Criteria) this;
        }

        public Criteria andIsSecondHandCarLessThan(Boolean value) {
            addCriterion("is_second_hand_car <", value, "isSecondHandCar");
            return (Criteria) this;
        }

        public Criteria andIsSecondHandCarLessThanOrEqualTo(Boolean value) {
            addCriterion("is_second_hand_car <=", value, "isSecondHandCar");
            return (Criteria) this;
        }

        public Criteria andIsSecondHandCarIn(List<Boolean> values) {
            addCriterion("is_second_hand_car in", values, "isSecondHandCar");
            return (Criteria) this;
        }

        public Criteria andIsSecondHandCarNotIn(List<Boolean> values) {
            addCriterion("is_second_hand_car not in", values, "isSecondHandCar");
            return (Criteria) this;
        }

        public Criteria andIsSecondHandCarBetween(Boolean value1, Boolean value2) {
            addCriterion("is_second_hand_car between", value1, value2, "isSecondHandCar");
            return (Criteria) this;
        }

        public Criteria andIsSecondHandCarNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_second_hand_car not between", value1, value2, "isSecondHandCar");
            return (Criteria) this;
        }

        public Criteria andIsSubmittedIsNull() {
            addCriterion("is_submitted is null");
            return (Criteria) this;
        }

        public Criteria andIsSubmittedIsNotNull() {
            addCriterion("is_submitted is not null");
            return (Criteria) this;
        }

        public Criteria andIsSubmittedEqualTo(Boolean value) {
            addCriterion("is_submitted =", value, "isSubmitted");
            return (Criteria) this;
        }

        public Criteria andIsSubmittedNotEqualTo(Boolean value) {
            addCriterion("is_submitted <>", value, "isSubmitted");
            return (Criteria) this;
        }

        public Criteria andIsSubmittedGreaterThan(Boolean value) {
            addCriterion("is_submitted >", value, "isSubmitted");
            return (Criteria) this;
        }

        public Criteria andIsSubmittedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_submitted >=", value, "isSubmitted");
            return (Criteria) this;
        }

        public Criteria andIsSubmittedLessThan(Boolean value) {
            addCriterion("is_submitted <", value, "isSubmitted");
            return (Criteria) this;
        }

        public Criteria andIsSubmittedLessThanOrEqualTo(Boolean value) {
            addCriterion("is_submitted <=", value, "isSubmitted");
            return (Criteria) this;
        }

        public Criteria andIsSubmittedIn(List<Boolean> values) {
            addCriterion("is_submitted in", values, "isSubmitted");
            return (Criteria) this;
        }

        public Criteria andIsSubmittedNotIn(List<Boolean> values) {
            addCriterion("is_submitted not in", values, "isSubmitted");
            return (Criteria) this;
        }

        public Criteria andIsSubmittedBetween(Boolean value1, Boolean value2) {
            addCriterion("is_submitted between", value1, value2, "isSubmitted");
            return (Criteria) this;
        }

        public Criteria andIsSubmittedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_submitted not between", value1, value2, "isSubmitted");
            return (Criteria) this;
        }

        public Criteria andIsReadIsNull() {
            addCriterion("is_read is null");
            return (Criteria) this;
        }

        public Criteria andIsReadIsNotNull() {
            addCriterion("is_read is not null");
            return (Criteria) this;
        }

        public Criteria andIsReadEqualTo(Boolean value) {
            addCriterion("is_read =", value, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadNotEqualTo(Boolean value) {
            addCriterion("is_read <>", value, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadGreaterThan(Boolean value) {
            addCriterion("is_read >", value, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_read >=", value, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadLessThan(Boolean value) {
            addCriterion("is_read <", value, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadLessThanOrEqualTo(Boolean value) {
            addCriterion("is_read <=", value, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadIn(List<Boolean> values) {
            addCriterion("is_read in", values, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadNotIn(List<Boolean> values) {
            addCriterion("is_read not in", values, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadBetween(Boolean value1, Boolean value2) {
            addCriterion("is_read between", value1, value2, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_read not between", value1, value2, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsFinishedIsNull() {
            addCriterion("is_finished is null");
            return (Criteria) this;
        }

        public Criteria andIsFinishedIsNotNull() {
            addCriterion("is_finished is not null");
            return (Criteria) this;
        }

        public Criteria andIsFinishedEqualTo(Boolean value) {
            addCriterion("is_finished =", value, "isFinished");
            return (Criteria) this;
        }

        public Criteria andIsFinishedNotEqualTo(Boolean value) {
            addCriterion("is_finished <>", value, "isFinished");
            return (Criteria) this;
        }

        public Criteria andIsFinishedGreaterThan(Boolean value) {
            addCriterion("is_finished >", value, "isFinished");
            return (Criteria) this;
        }

        public Criteria andIsFinishedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_finished >=", value, "isFinished");
            return (Criteria) this;
        }

        public Criteria andIsFinishedLessThan(Boolean value) {
            addCriterion("is_finished <", value, "isFinished");
            return (Criteria) this;
        }

        public Criteria andIsFinishedLessThanOrEqualTo(Boolean value) {
            addCriterion("is_finished <=", value, "isFinished");
            return (Criteria) this;
        }

        public Criteria andIsFinishedIn(List<Boolean> values) {
            addCriterion("is_finished in", values, "isFinished");
            return (Criteria) this;
        }

        public Criteria andIsFinishedNotIn(List<Boolean> values) {
            addCriterion("is_finished not in", values, "isFinished");
            return (Criteria) this;
        }

        public Criteria andIsFinishedBetween(Boolean value1, Boolean value2) {
            addCriterion("is_finished between", value1, value2, "isFinished");
            return (Criteria) this;
        }

        public Criteria andIsFinishedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_finished not between", value1, value2, "isFinished");
            return (Criteria) this;
        }

        public Criteria andLastNodeKeyIsNull() {
            addCriterion("last_node_key is null");
            return (Criteria) this;
        }

        public Criteria andLastNodeKeyIsNotNull() {
            addCriterion("last_node_key is not null");
            return (Criteria) this;
        }

        public Criteria andLastNodeKeyEqualTo(String value) {
            addCriterion("last_node_key =", value, "lastNodeKey");
            return (Criteria) this;
        }

        public Criteria andLastNodeKeyNotEqualTo(String value) {
            addCriterion("last_node_key <>", value, "lastNodeKey");
            return (Criteria) this;
        }

        public Criteria andLastNodeKeyGreaterThan(String value) {
            addCriterion("last_node_key >", value, "lastNodeKey");
            return (Criteria) this;
        }

        public Criteria andLastNodeKeyGreaterThanOrEqualTo(String value) {
            addCriterion("last_node_key >=", value, "lastNodeKey");
            return (Criteria) this;
        }

        public Criteria andLastNodeKeyLessThan(String value) {
            addCriterion("last_node_key <", value, "lastNodeKey");
            return (Criteria) this;
        }

        public Criteria andLastNodeKeyLessThanOrEqualTo(String value) {
            addCriterion("last_node_key <=", value, "lastNodeKey");
            return (Criteria) this;
        }

        public Criteria andLastNodeKeyLike(String value) {
            addCriterion("last_node_key like", value, "lastNodeKey");
            return (Criteria) this;
        }

        public Criteria andLastNodeKeyNotLike(String value) {
            addCriterion("last_node_key not like", value, "lastNodeKey");
            return (Criteria) this;
        }

        public Criteria andLastNodeKeyIn(List<String> values) {
            addCriterion("last_node_key in", values, "lastNodeKey");
            return (Criteria) this;
        }

        public Criteria andLastNodeKeyNotIn(List<String> values) {
            addCriterion("last_node_key not in", values, "lastNodeKey");
            return (Criteria) this;
        }

        public Criteria andLastNodeKeyBetween(String value1, String value2) {
            addCriterion("last_node_key between", value1, value2, "lastNodeKey");
            return (Criteria) this;
        }

        public Criteria andLastNodeKeyNotBetween(String value1, String value2) {
            addCriterion("last_node_key not between", value1, value2, "lastNodeKey");
            return (Criteria) this;
        }

        public Criteria andLastNodeNameIsNull() {
            addCriterion("last_node_name is null");
            return (Criteria) this;
        }

        public Criteria andLastNodeNameIsNotNull() {
            addCriterion("last_node_name is not null");
            return (Criteria) this;
        }

        public Criteria andLastNodeNameEqualTo(String value) {
            addCriterion("last_node_name =", value, "lastNodeName");
            return (Criteria) this;
        }

        public Criteria andLastNodeNameNotEqualTo(String value) {
            addCriterion("last_node_name <>", value, "lastNodeName");
            return (Criteria) this;
        }

        public Criteria andLastNodeNameGreaterThan(String value) {
            addCriterion("last_node_name >", value, "lastNodeName");
            return (Criteria) this;
        }

        public Criteria andLastNodeNameGreaterThanOrEqualTo(String value) {
            addCriterion("last_node_name >=", value, "lastNodeName");
            return (Criteria) this;
        }

        public Criteria andLastNodeNameLessThan(String value) {
            addCriterion("last_node_name <", value, "lastNodeName");
            return (Criteria) this;
        }

        public Criteria andLastNodeNameLessThanOrEqualTo(String value) {
            addCriterion("last_node_name <=", value, "lastNodeName");
            return (Criteria) this;
        }

        public Criteria andLastNodeNameLike(String value) {
            addCriterion("last_node_name like", value, "lastNodeName");
            return (Criteria) this;
        }

        public Criteria andLastNodeNameNotLike(String value) {
            addCriterion("last_node_name not like", value, "lastNodeName");
            return (Criteria) this;
        }

        public Criteria andLastNodeNameIn(List<String> values) {
            addCriterion("last_node_name in", values, "lastNodeName");
            return (Criteria) this;
        }

        public Criteria andLastNodeNameNotIn(List<String> values) {
            addCriterion("last_node_name not in", values, "lastNodeName");
            return (Criteria) this;
        }

        public Criteria andLastNodeNameBetween(String value1, String value2) {
            addCriterion("last_node_name between", value1, value2, "lastNodeName");
            return (Criteria) this;
        }

        public Criteria andLastNodeNameNotBetween(String value1, String value2) {
            addCriterion("last_node_name not between", value1, value2, "lastNodeName");
            return (Criteria) this;
        }

        public Criteria andLastNodeIndexIsNull() {
            addCriterion("last_node_index is null");
            return (Criteria) this;
        }

        public Criteria andLastNodeIndexIsNotNull() {
            addCriterion("last_node_index is not null");
            return (Criteria) this;
        }

        public Criteria andLastNodeIndexEqualTo(Integer value) {
            addCriterion("last_node_index =", value, "lastNodeIndex");
            return (Criteria) this;
        }

        public Criteria andLastNodeIndexNotEqualTo(Integer value) {
            addCriterion("last_node_index <>", value, "lastNodeIndex");
            return (Criteria) this;
        }

        public Criteria andLastNodeIndexGreaterThan(Integer value) {
            addCriterion("last_node_index >", value, "lastNodeIndex");
            return (Criteria) this;
        }

        public Criteria andLastNodeIndexGreaterThanOrEqualTo(Integer value) {
            addCriterion("last_node_index >=", value, "lastNodeIndex");
            return (Criteria) this;
        }

        public Criteria andLastNodeIndexLessThan(Integer value) {
            addCriterion("last_node_index <", value, "lastNodeIndex");
            return (Criteria) this;
        }

        public Criteria andLastNodeIndexLessThanOrEqualTo(Integer value) {
            addCriterion("last_node_index <=", value, "lastNodeIndex");
            return (Criteria) this;
        }

        public Criteria andLastNodeIndexIn(List<Integer> values) {
            addCriterion("last_node_index in", values, "lastNodeIndex");
            return (Criteria) this;
        }

        public Criteria andLastNodeIndexNotIn(List<Integer> values) {
            addCriterion("last_node_index not in", values, "lastNodeIndex");
            return (Criteria) this;
        }

        public Criteria andLastNodeIndexBetween(Integer value1, Integer value2) {
            addCriterion("last_node_index between", value1, value2, "lastNodeIndex");
            return (Criteria) this;
        }

        public Criteria andLastNodeIndexNotBetween(Integer value1, Integer value2) {
            addCriterion("last_node_index not between", value1, value2, "lastNodeIndex");
            return (Criteria) this;
        }

        public Criteria andNodeKeyIsNull() {
            addCriterion("node_key is null");
            return (Criteria) this;
        }

        public Criteria andNodeKeyIsNotNull() {
            addCriterion("node_key is not null");
            return (Criteria) this;
        }

        public Criteria andNodeKeyEqualTo(String value) {
            addCriterion("node_key =", value, "nodeKey");
            return (Criteria) this;
        }

        public Criteria andNodeKeyNotEqualTo(String value) {
            addCriterion("node_key <>", value, "nodeKey");
            return (Criteria) this;
        }

        public Criteria andNodeKeyGreaterThan(String value) {
            addCriterion("node_key >", value, "nodeKey");
            return (Criteria) this;
        }

        public Criteria andNodeKeyGreaterThanOrEqualTo(String value) {
            addCriterion("node_key >=", value, "nodeKey");
            return (Criteria) this;
        }

        public Criteria andNodeKeyLessThan(String value) {
            addCriterion("node_key <", value, "nodeKey");
            return (Criteria) this;
        }

        public Criteria andNodeKeyLessThanOrEqualTo(String value) {
            addCriterion("node_key <=", value, "nodeKey");
            return (Criteria) this;
        }

        public Criteria andNodeKeyLike(String value) {
            addCriterion("node_key like", value, "nodeKey");
            return (Criteria) this;
        }

        public Criteria andNodeKeyNotLike(String value) {
            addCriterion("node_key not like", value, "nodeKey");
            return (Criteria) this;
        }

        public Criteria andNodeKeyIn(List<String> values) {
            addCriterion("node_key in", values, "nodeKey");
            return (Criteria) this;
        }

        public Criteria andNodeKeyNotIn(List<String> values) {
            addCriterion("node_key not in", values, "nodeKey");
            return (Criteria) this;
        }

        public Criteria andNodeKeyBetween(String value1, String value2) {
            addCriterion("node_key between", value1, value2, "nodeKey");
            return (Criteria) this;
        }

        public Criteria andNodeKeyNotBetween(String value1, String value2) {
            addCriterion("node_key not between", value1, value2, "nodeKey");
            return (Criteria) this;
        }

        public Criteria andNodeNameIsNull() {
            addCriterion("node_name is null");
            return (Criteria) this;
        }

        public Criteria andNodeNameIsNotNull() {
            addCriterion("node_name is not null");
            return (Criteria) this;
        }

        public Criteria andNodeNameEqualTo(String value) {
            addCriterion("node_name =", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameNotEqualTo(String value) {
            addCriterion("node_name <>", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameGreaterThan(String value) {
            addCriterion("node_name >", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameGreaterThanOrEqualTo(String value) {
            addCriterion("node_name >=", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameLessThan(String value) {
            addCriterion("node_name <", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameLessThanOrEqualTo(String value) {
            addCriterion("node_name <=", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameLike(String value) {
            addCriterion("node_name like", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameNotLike(String value) {
            addCriterion("node_name not like", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameIn(List<String> values) {
            addCriterion("node_name in", values, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameNotIn(List<String> values) {
            addCriterion("node_name not in", values, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameBetween(String value1, String value2) {
            addCriterion("node_name between", value1, value2, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameNotBetween(String value1, String value2) {
            addCriterion("node_name not between", value1, value2, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeIndexIsNull() {
            addCriterion("node_index is null");
            return (Criteria) this;
        }

        public Criteria andNodeIndexIsNotNull() {
            addCriterion("node_index is not null");
            return (Criteria) this;
        }

        public Criteria andNodeIndexEqualTo(Integer value) {
            addCriterion("node_index =", value, "nodeIndex");
            return (Criteria) this;
        }

        public Criteria andNodeIndexNotEqualTo(Integer value) {
            addCriterion("node_index <>", value, "nodeIndex");
            return (Criteria) this;
        }

        public Criteria andNodeIndexGreaterThan(Integer value) {
            addCriterion("node_index >", value, "nodeIndex");
            return (Criteria) this;
        }

        public Criteria andNodeIndexGreaterThanOrEqualTo(Integer value) {
            addCriterion("node_index >=", value, "nodeIndex");
            return (Criteria) this;
        }

        public Criteria andNodeIndexLessThan(Integer value) {
            addCriterion("node_index <", value, "nodeIndex");
            return (Criteria) this;
        }

        public Criteria andNodeIndexLessThanOrEqualTo(Integer value) {
            addCriterion("node_index <=", value, "nodeIndex");
            return (Criteria) this;
        }

        public Criteria andNodeIndexIn(List<Integer> values) {
            addCriterion("node_index in", values, "nodeIndex");
            return (Criteria) this;
        }

        public Criteria andNodeIndexNotIn(List<Integer> values) {
            addCriterion("node_index not in", values, "nodeIndex");
            return (Criteria) this;
        }

        public Criteria andNodeIndexBetween(Integer value1, Integer value2) {
            addCriterion("node_index between", value1, value2, "nodeIndex");
            return (Criteria) this;
        }

        public Criteria andNodeIndexNotBetween(Integer value1, Integer value2) {
            addCriterion("node_index not between", value1, value2, "nodeIndex");
            return (Criteria) this;
        }

        public Criteria andFlowIndexIsNull() {
            addCriterion("flow_index is null");
            return (Criteria) this;
        }

        public Criteria andFlowIndexIsNotNull() {
            addCriterion("flow_index is not null");
            return (Criteria) this;
        }

        public Criteria andFlowIndexEqualTo(Integer value) {
            addCriterion("flow_index =", value, "flowIndex");
            return (Criteria) this;
        }

        public Criteria andFlowIndexNotEqualTo(Integer value) {
            addCriterion("flow_index <>", value, "flowIndex");
            return (Criteria) this;
        }

        public Criteria andFlowIndexGreaterThan(Integer value) {
            addCriterion("flow_index >", value, "flowIndex");
            return (Criteria) this;
        }

        public Criteria andFlowIndexGreaterThanOrEqualTo(Integer value) {
            addCriterion("flow_index >=", value, "flowIndex");
            return (Criteria) this;
        }

        public Criteria andFlowIndexLessThan(Integer value) {
            addCriterion("flow_index <", value, "flowIndex");
            return (Criteria) this;
        }

        public Criteria andFlowIndexLessThanOrEqualTo(Integer value) {
            addCriterion("flow_index <=", value, "flowIndex");
            return (Criteria) this;
        }

        public Criteria andFlowIndexIn(List<Integer> values) {
            addCriterion("flow_index in", values, "flowIndex");
            return (Criteria) this;
        }

        public Criteria andFlowIndexNotIn(List<Integer> values) {
            addCriterion("flow_index not in", values, "flowIndex");
            return (Criteria) this;
        }

        public Criteria andFlowIndexBetween(Integer value1, Integer value2) {
            addCriterion("flow_index between", value1, value2, "flowIndex");
            return (Criteria) this;
        }

        public Criteria andFlowIndexNotBetween(Integer value1, Integer value2) {
            addCriterion("flow_index not between", value1, value2, "flowIndex");
            return (Criteria) this;
        }

        public Criteria andFlowVersionIsNull() {
            addCriterion("flow_version is null");
            return (Criteria) this;
        }

        public Criteria andFlowVersionIsNotNull() {
            addCriterion("flow_version is not null");
            return (Criteria) this;
        }

        public Criteria andFlowVersionEqualTo(String value) {
            addCriterion("flow_version =", value, "flowVersion");
            return (Criteria) this;
        }

        public Criteria andFlowVersionNotEqualTo(String value) {
            addCriterion("flow_version <>", value, "flowVersion");
            return (Criteria) this;
        }

        public Criteria andFlowVersionGreaterThan(String value) {
            addCriterion("flow_version >", value, "flowVersion");
            return (Criteria) this;
        }

        public Criteria andFlowVersionGreaterThanOrEqualTo(String value) {
            addCriterion("flow_version >=", value, "flowVersion");
            return (Criteria) this;
        }

        public Criteria andFlowVersionLessThan(String value) {
            addCriterion("flow_version <", value, "flowVersion");
            return (Criteria) this;
        }

        public Criteria andFlowVersionLessThanOrEqualTo(String value) {
            addCriterion("flow_version <=", value, "flowVersion");
            return (Criteria) this;
        }

        public Criteria andFlowVersionLike(String value) {
            addCriterion("flow_version like", value, "flowVersion");
            return (Criteria) this;
        }

        public Criteria andFlowVersionNotLike(String value) {
            addCriterion("flow_version not like", value, "flowVersion");
            return (Criteria) this;
        }

        public Criteria andFlowVersionIn(List<String> values) {
            addCriterion("flow_version in", values, "flowVersion");
            return (Criteria) this;
        }

        public Criteria andFlowVersionNotIn(List<String> values) {
            addCriterion("flow_version not in", values, "flowVersion");
            return (Criteria) this;
        }

        public Criteria andFlowVersionBetween(String value1, String value2) {
            addCriterion("flow_version between", value1, value2, "flowVersion");
            return (Criteria) this;
        }

        public Criteria andFlowVersionNotBetween(String value1, String value2) {
            addCriterion("flow_version not between", value1, value2, "flowVersion");
            return (Criteria) this;
        }

        public Criteria andFlowTypeIsNull() {
            addCriterion("flow_type is null");
            return (Criteria) this;
        }

        public Criteria andFlowTypeIsNotNull() {
            addCriterion("flow_type is not null");
            return (Criteria) this;
        }

        public Criteria andFlowTypeEqualTo(String value) {
            addCriterion("flow_type =", value, "flowType");
            return (Criteria) this;
        }

        public Criteria andFlowTypeNotEqualTo(String value) {
            addCriterion("flow_type <>", value, "flowType");
            return (Criteria) this;
        }

        public Criteria andFlowTypeGreaterThan(String value) {
            addCriterion("flow_type >", value, "flowType");
            return (Criteria) this;
        }

        public Criteria andFlowTypeGreaterThanOrEqualTo(String value) {
            addCriterion("flow_type >=", value, "flowType");
            return (Criteria) this;
        }

        public Criteria andFlowTypeLessThan(String value) {
            addCriterion("flow_type <", value, "flowType");
            return (Criteria) this;
        }

        public Criteria andFlowTypeLessThanOrEqualTo(String value) {
            addCriterion("flow_type <=", value, "flowType");
            return (Criteria) this;
        }

        public Criteria andFlowTypeLike(String value) {
            addCriterion("flow_type like", value, "flowType");
            return (Criteria) this;
        }

        public Criteria andFlowTypeNotLike(String value) {
            addCriterion("flow_type not like", value, "flowType");
            return (Criteria) this;
        }

        public Criteria andFlowTypeIn(List<String> values) {
            addCriterion("flow_type in", values, "flowType");
            return (Criteria) this;
        }

        public Criteria andFlowTypeNotIn(List<String> values) {
            addCriterion("flow_type not in", values, "flowType");
            return (Criteria) this;
        }

        public Criteria andFlowTypeBetween(String value1, String value2) {
            addCriterion("flow_type between", value1, value2, "flowType");
            return (Criteria) this;
        }

        public Criteria andFlowTypeNotBetween(String value1, String value2) {
            addCriterion("flow_type not between", value1, value2, "flowType");
            return (Criteria) this;
        }

        public Criteria andOperationRoleKeyIsNull() {
            addCriterion("operation_role_key is null");
            return (Criteria) this;
        }

        public Criteria andOperationRoleKeyIsNotNull() {
            addCriterion("operation_role_key is not null");
            return (Criteria) this;
        }

        public Criteria andOperationRoleKeyEqualTo(String value) {
            addCriterion("operation_role_key =", value, "operationRoleKey");
            return (Criteria) this;
        }

        public Criteria andOperationRoleKeyNotEqualTo(String value) {
            addCriterion("operation_role_key <>", value, "operationRoleKey");
            return (Criteria) this;
        }

        public Criteria andOperationRoleKeyGreaterThan(String value) {
            addCriterion("operation_role_key >", value, "operationRoleKey");
            return (Criteria) this;
        }

        public Criteria andOperationRoleKeyGreaterThanOrEqualTo(String value) {
            addCriterion("operation_role_key >=", value, "operationRoleKey");
            return (Criteria) this;
        }

        public Criteria andOperationRoleKeyLessThan(String value) {
            addCriterion("operation_role_key <", value, "operationRoleKey");
            return (Criteria) this;
        }

        public Criteria andOperationRoleKeyLessThanOrEqualTo(String value) {
            addCriterion("operation_role_key <=", value, "operationRoleKey");
            return (Criteria) this;
        }

        public Criteria andOperationRoleKeyLike(String value) {
            addCriterion("operation_role_key like", value, "operationRoleKey");
            return (Criteria) this;
        }

        public Criteria andOperationRoleKeyNotLike(String value) {
            addCriterion("operation_role_key not like", value, "operationRoleKey");
            return (Criteria) this;
        }

        public Criteria andOperationRoleKeyIn(List<String> values) {
            addCriterion("operation_role_key in", values, "operationRoleKey");
            return (Criteria) this;
        }

        public Criteria andOperationRoleKeyNotIn(List<String> values) {
            addCriterion("operation_role_key not in", values, "operationRoleKey");
            return (Criteria) this;
        }

        public Criteria andOperationRoleKeyBetween(String value1, String value2) {
            addCriterion("operation_role_key between", value1, value2, "operationRoleKey");
            return (Criteria) this;
        }

        public Criteria andOperationRoleKeyNotBetween(String value1, String value2) {
            addCriterion("operation_role_key not between", value1, value2, "operationRoleKey");
            return (Criteria) this;
        }

        public Criteria andOperationRoleNameIsNull() {
            addCriterion("operation_role_name is null");
            return (Criteria) this;
        }

        public Criteria andOperationRoleNameIsNotNull() {
            addCriterion("operation_role_name is not null");
            return (Criteria) this;
        }

        public Criteria andOperationRoleNameEqualTo(String value) {
            addCriterion("operation_role_name =", value, "operationRoleName");
            return (Criteria) this;
        }

        public Criteria andOperationRoleNameNotEqualTo(String value) {
            addCriterion("operation_role_name <>", value, "operationRoleName");
            return (Criteria) this;
        }

        public Criteria andOperationRoleNameGreaterThan(String value) {
            addCriterion("operation_role_name >", value, "operationRoleName");
            return (Criteria) this;
        }

        public Criteria andOperationRoleNameGreaterThanOrEqualTo(String value) {
            addCriterion("operation_role_name >=", value, "operationRoleName");
            return (Criteria) this;
        }

        public Criteria andOperationRoleNameLessThan(String value) {
            addCriterion("operation_role_name <", value, "operationRoleName");
            return (Criteria) this;
        }

        public Criteria andOperationRoleNameLessThanOrEqualTo(String value) {
            addCriterion("operation_role_name <=", value, "operationRoleName");
            return (Criteria) this;
        }

        public Criteria andOperationRoleNameLike(String value) {
            addCriterion("operation_role_name like", value, "operationRoleName");
            return (Criteria) this;
        }

        public Criteria andOperationRoleNameNotLike(String value) {
            addCriterion("operation_role_name not like", value, "operationRoleName");
            return (Criteria) this;
        }

        public Criteria andOperationRoleNameIn(List<String> values) {
            addCriterion("operation_role_name in", values, "operationRoleName");
            return (Criteria) this;
        }

        public Criteria andOperationRoleNameNotIn(List<String> values) {
            addCriterion("operation_role_name not in", values, "operationRoleName");
            return (Criteria) this;
        }

        public Criteria andOperationRoleNameBetween(String value1, String value2) {
            addCriterion("operation_role_name between", value1, value2, "operationRoleName");
            return (Criteria) this;
        }

        public Criteria andOperationRoleNameNotBetween(String value1, String value2) {
            addCriterion("operation_role_name not between", value1, value2, "operationRoleName");
            return (Criteria) this;
        }

        public Criteria andOperatorIdIsNull() {
            addCriterion("operator_id is null");
            return (Criteria) this;
        }

        public Criteria andOperatorIdIsNotNull() {
            addCriterion("operator_id is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorIdEqualTo(Long value) {
            addCriterion("operator_id =", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdNotEqualTo(Long value) {
            addCriterion("operator_id <>", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdGreaterThan(Long value) {
            addCriterion("operator_id >", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdGreaterThanOrEqualTo(Long value) {
            addCriterion("operator_id >=", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdLessThan(Long value) {
            addCriterion("operator_id <", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdLessThanOrEqualTo(Long value) {
            addCriterion("operator_id <=", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdIn(List<Long> values) {
            addCriterion("operator_id in", values, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdNotIn(List<Long> values) {
            addCriterion("operator_id not in", values, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdBetween(Long value1, Long value2) {
            addCriterion("operator_id between", value1, value2, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdNotBetween(Long value1, Long value2) {
            addCriterion("operator_id not between", value1, value2, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorNameIsNull() {
            addCriterion("operator_name is null");
            return (Criteria) this;
        }

        public Criteria andOperatorNameIsNotNull() {
            addCriterion("operator_name is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorNameEqualTo(String value) {
            addCriterion("operator_name =", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameNotEqualTo(String value) {
            addCriterion("operator_name <>", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameGreaterThan(String value) {
            addCriterion("operator_name >", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameGreaterThanOrEqualTo(String value) {
            addCriterion("operator_name >=", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameLessThan(String value) {
            addCriterion("operator_name <", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameLessThanOrEqualTo(String value) {
            addCriterion("operator_name <=", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameLike(String value) {
            addCriterion("operator_name like", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameNotLike(String value) {
            addCriterion("operator_name not like", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameIn(List<String> values) {
            addCriterion("operator_name in", values, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameNotIn(List<String> values) {
            addCriterion("operator_name not in", values, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameBetween(String value1, String value2) {
            addCriterion("operator_name between", value1, value2, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameNotBetween(String value1, String value2) {
            addCriterion("operator_name not between", value1, value2, "operatorName");
            return (Criteria) this;
        }

        public Criteria andApprovalResultIsNull() {
            addCriterion("approval_result is null");
            return (Criteria) this;
        }

        public Criteria andApprovalResultIsNotNull() {
            addCriterion("approval_result is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalResultEqualTo(Integer value) {
            addCriterion("approval_result =", value, "approvalResult");
            return (Criteria) this;
        }

        public Criteria andApprovalResultNotEqualTo(Integer value) {
            addCriterion("approval_result <>", value, "approvalResult");
            return (Criteria) this;
        }

        public Criteria andApprovalResultGreaterThan(Integer value) {
            addCriterion("approval_result >", value, "approvalResult");
            return (Criteria) this;
        }

        public Criteria andApprovalResultGreaterThanOrEqualTo(Integer value) {
            addCriterion("approval_result >=", value, "approvalResult");
            return (Criteria) this;
        }

        public Criteria andApprovalResultLessThan(Integer value) {
            addCriterion("approval_result <", value, "approvalResult");
            return (Criteria) this;
        }

        public Criteria andApprovalResultLessThanOrEqualTo(Integer value) {
            addCriterion("approval_result <=", value, "approvalResult");
            return (Criteria) this;
        }

        public Criteria andApprovalResultIn(List<Integer> values) {
            addCriterion("approval_result in", values, "approvalResult");
            return (Criteria) this;
        }

        public Criteria andApprovalResultNotIn(List<Integer> values) {
            addCriterion("approval_result not in", values, "approvalResult");
            return (Criteria) this;
        }

        public Criteria andApprovalResultBetween(Integer value1, Integer value2) {
            addCriterion("approval_result between", value1, value2, "approvalResult");
            return (Criteria) this;
        }

        public Criteria andApprovalResultNotBetween(Integer value1, Integer value2) {
            addCriterion("approval_result not between", value1, value2, "approvalResult");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeIsNull() {
            addCriterion("create_date_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeIsNotNull() {
            addCriterion("create_date_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeEqualTo(Date value) {
            addCriterion("create_date_time =", value, "createDateTime");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeNotEqualTo(Date value) {
            addCriterion("create_date_time <>", value, "createDateTime");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeGreaterThan(Date value) {
            addCriterion("create_date_time >", value, "createDateTime");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date_time >=", value, "createDateTime");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeLessThan(Date value) {
            addCriterion("create_date_time <", value, "createDateTime");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_date_time <=", value, "createDateTime");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeIn(List<Date> values) {
            addCriterion("create_date_time in", values, "createDateTime");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeNotIn(List<Date> values) {
            addCriterion("create_date_time not in", values, "createDateTime");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeBetween(Date value1, Date value2) {
            addCriterion("create_date_time between", value1, value2, "createDateTime");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_date_time not between", value1, value2, "createDateTime");
            return (Criteria) this;
        }

        public Criteria andApprovalDateTimeIsNull() {
            addCriterion("approval_date_time is null");
            return (Criteria) this;
        }

        public Criteria andApprovalDateTimeIsNotNull() {
            addCriterion("approval_date_time is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalDateTimeEqualTo(Date value) {
            addCriterion("approval_date_time =", value, "approvalDateTime");
            return (Criteria) this;
        }

        public Criteria andApprovalDateTimeNotEqualTo(Date value) {
            addCriterion("approval_date_time <>", value, "approvalDateTime");
            return (Criteria) this;
        }

        public Criteria andApprovalDateTimeGreaterThan(Date value) {
            addCriterion("approval_date_time >", value, "approvalDateTime");
            return (Criteria) this;
        }

        public Criteria andApprovalDateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("approval_date_time >=", value, "approvalDateTime");
            return (Criteria) this;
        }

        public Criteria andApprovalDateTimeLessThan(Date value) {
            addCriterion("approval_date_time <", value, "approvalDateTime");
            return (Criteria) this;
        }

        public Criteria andApprovalDateTimeLessThanOrEqualTo(Date value) {
            addCriterion("approval_date_time <=", value, "approvalDateTime");
            return (Criteria) this;
        }

        public Criteria andApprovalDateTimeIn(List<Date> values) {
            addCriterion("approval_date_time in", values, "approvalDateTime");
            return (Criteria) this;
        }

        public Criteria andApprovalDateTimeNotIn(List<Date> values) {
            addCriterion("approval_date_time not in", values, "approvalDateTime");
            return (Criteria) this;
        }

        public Criteria andApprovalDateTimeBetween(Date value1, Date value2) {
            addCriterion("approval_date_time between", value1, value2, "approvalDateTime");
            return (Criteria) this;
        }

        public Criteria andApprovalDateTimeNotBetween(Date value1, Date value2) {
            addCriterion("approval_date_time not between", value1, value2, "approvalDateTime");
            return (Criteria) this;
        }

        public Criteria andSubmittedDateTimeIsNull() {
            addCriterion("submitted_date_time is null");
            return (Criteria) this;
        }

        public Criteria andSubmittedDateTimeIsNotNull() {
            addCriterion("submitted_date_time is not null");
            return (Criteria) this;
        }

        public Criteria andSubmittedDateTimeEqualTo(Date value) {
            addCriterion("submitted_date_time =", value, "submittedDateTime");
            return (Criteria) this;
        }

        public Criteria andSubmittedDateTimeNotEqualTo(Date value) {
            addCriterion("submitted_date_time <>", value, "submittedDateTime");
            return (Criteria) this;
        }

        public Criteria andSubmittedDateTimeGreaterThan(Date value) {
            addCriterion("submitted_date_time >", value, "submittedDateTime");
            return (Criteria) this;
        }

        public Criteria andSubmittedDateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("submitted_date_time >=", value, "submittedDateTime");
            return (Criteria) this;
        }

        public Criteria andSubmittedDateTimeLessThan(Date value) {
            addCriterion("submitted_date_time <", value, "submittedDateTime");
            return (Criteria) this;
        }

        public Criteria andSubmittedDateTimeLessThanOrEqualTo(Date value) {
            addCriterion("submitted_date_time <=", value, "submittedDateTime");
            return (Criteria) this;
        }

        public Criteria andSubmittedDateTimeIn(List<Date> values) {
            addCriterion("submitted_date_time in", values, "submittedDateTime");
            return (Criteria) this;
        }

        public Criteria andSubmittedDateTimeNotIn(List<Date> values) {
            addCriterion("submitted_date_time not in", values, "submittedDateTime");
            return (Criteria) this;
        }

        public Criteria andSubmittedDateTimeBetween(Date value1, Date value2) {
            addCriterion("submitted_date_time between", value1, value2, "submittedDateTime");
            return (Criteria) this;
        }

        public Criteria andSubmittedDateTimeNotBetween(Date value1, Date value2) {
            addCriterion("submitted_date_time not between", value1, value2, "submittedDateTime");
            return (Criteria) this;
        }

        public Criteria andApprovalNoteIsNull() {
            addCriterion("approval_note is null");
            return (Criteria) this;
        }

        public Criteria andApprovalNoteIsNotNull() {
            addCriterion("approval_note is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalNoteEqualTo(String value) {
            addCriterion("approval_note =", value, "approvalNote");
            return (Criteria) this;
        }

        public Criteria andApprovalNoteNotEqualTo(String value) {
            addCriterion("approval_note <>", value, "approvalNote");
            return (Criteria) this;
        }

        public Criteria andApprovalNoteGreaterThan(String value) {
            addCriterion("approval_note >", value, "approvalNote");
            return (Criteria) this;
        }

        public Criteria andApprovalNoteGreaterThanOrEqualTo(String value) {
            addCriterion("approval_note >=", value, "approvalNote");
            return (Criteria) this;
        }

        public Criteria andApprovalNoteLessThan(String value) {
            addCriterion("approval_note <", value, "approvalNote");
            return (Criteria) this;
        }

        public Criteria andApprovalNoteLessThanOrEqualTo(String value) {
            addCriterion("approval_note <=", value, "approvalNote");
            return (Criteria) this;
        }

        public Criteria andApprovalNoteLike(String value) {
            addCriterion("approval_note like", value, "approvalNote");
            return (Criteria) this;
        }

        public Criteria andApprovalNoteNotLike(String value) {
            addCriterion("approval_note not like", value, "approvalNote");
            return (Criteria) this;
        }

        public Criteria andApprovalNoteIn(List<String> values) {
            addCriterion("approval_note in", values, "approvalNote");
            return (Criteria) this;
        }

        public Criteria andApprovalNoteNotIn(List<String> values) {
            addCriterion("approval_note not in", values, "approvalNote");
            return (Criteria) this;
        }

        public Criteria andApprovalNoteBetween(String value1, String value2) {
            addCriterion("approval_note between", value1, value2, "approvalNote");
            return (Criteria) this;
        }

        public Criteria andApprovalNoteNotBetween(String value1, String value2) {
            addCriterion("approval_note not between", value1, value2, "approvalNote");
            return (Criteria) this;
        }

        public Criteria andDeclineReasonKeyIsNull() {
            addCriterion("decline_reason_key is null");
            return (Criteria) this;
        }

        public Criteria andDeclineReasonKeyIsNotNull() {
            addCriterion("decline_reason_key is not null");
            return (Criteria) this;
        }

        public Criteria andDeclineReasonKeyEqualTo(String value) {
            addCriterion("decline_reason_key =", value, "declineReasonKey");
            return (Criteria) this;
        }

        public Criteria andDeclineReasonKeyNotEqualTo(String value) {
            addCriterion("decline_reason_key <>", value, "declineReasonKey");
            return (Criteria) this;
        }

        public Criteria andDeclineReasonKeyGreaterThan(String value) {
            addCriterion("decline_reason_key >", value, "declineReasonKey");
            return (Criteria) this;
        }

        public Criteria andDeclineReasonKeyGreaterThanOrEqualTo(String value) {
            addCriterion("decline_reason_key >=", value, "declineReasonKey");
            return (Criteria) this;
        }

        public Criteria andDeclineReasonKeyLessThan(String value) {
            addCriterion("decline_reason_key <", value, "declineReasonKey");
            return (Criteria) this;
        }

        public Criteria andDeclineReasonKeyLessThanOrEqualTo(String value) {
            addCriterion("decline_reason_key <=", value, "declineReasonKey");
            return (Criteria) this;
        }

        public Criteria andDeclineReasonKeyLike(String value) {
            addCriterion("decline_reason_key like", value, "declineReasonKey");
            return (Criteria) this;
        }

        public Criteria andDeclineReasonKeyNotLike(String value) {
            addCriterion("decline_reason_key not like", value, "declineReasonKey");
            return (Criteria) this;
        }

        public Criteria andDeclineReasonKeyIn(List<String> values) {
            addCriterion("decline_reason_key in", values, "declineReasonKey");
            return (Criteria) this;
        }

        public Criteria andDeclineReasonKeyNotIn(List<String> values) {
            addCriterion("decline_reason_key not in", values, "declineReasonKey");
            return (Criteria) this;
        }

        public Criteria andDeclineReasonKeyBetween(String value1, String value2) {
            addCriterion("decline_reason_key between", value1, value2, "declineReasonKey");
            return (Criteria) this;
        }

        public Criteria andDeclineReasonKeyNotBetween(String value1, String value2) {
            addCriterion("decline_reason_key not between", value1, value2, "declineReasonKey");
            return (Criteria) this;
        }

        public Criteria andRfeReasonKeyIsNull() {
            addCriterion("RFE_reason_key is null");
            return (Criteria) this;
        }

        public Criteria andRfeReasonKeyIsNotNull() {
            addCriterion("RFE_reason_key is not null");
            return (Criteria) this;
        }

        public Criteria andRfeReasonKeyEqualTo(String value) {
            addCriterion("RFE_reason_key =", value, "rfeReasonKey");
            return (Criteria) this;
        }

        public Criteria andRfeReasonKeyNotEqualTo(String value) {
            addCriterion("RFE_reason_key <>", value, "rfeReasonKey");
            return (Criteria) this;
        }

        public Criteria andRfeReasonKeyGreaterThan(String value) {
            addCriterion("RFE_reason_key >", value, "rfeReasonKey");
            return (Criteria) this;
        }

        public Criteria andRfeReasonKeyGreaterThanOrEqualTo(String value) {
            addCriterion("RFE_reason_key >=", value, "rfeReasonKey");
            return (Criteria) this;
        }

        public Criteria andRfeReasonKeyLessThan(String value) {
            addCriterion("RFE_reason_key <", value, "rfeReasonKey");
            return (Criteria) this;
        }

        public Criteria andRfeReasonKeyLessThanOrEqualTo(String value) {
            addCriterion("RFE_reason_key <=", value, "rfeReasonKey");
            return (Criteria) this;
        }

        public Criteria andRfeReasonKeyLike(String value) {
            addCriterion("RFE_reason_key like", value, "rfeReasonKey");
            return (Criteria) this;
        }

        public Criteria andRfeReasonKeyNotLike(String value) {
            addCriterion("RFE_reason_key not like", value, "rfeReasonKey");
            return (Criteria) this;
        }

        public Criteria andRfeReasonKeyIn(List<String> values) {
            addCriterion("RFE_reason_key in", values, "rfeReasonKey");
            return (Criteria) this;
        }

        public Criteria andRfeReasonKeyNotIn(List<String> values) {
            addCriterion("RFE_reason_key not in", values, "rfeReasonKey");
            return (Criteria) this;
        }

        public Criteria andRfeReasonKeyBetween(String value1, String value2) {
            addCriterion("RFE_reason_key between", value1, value2, "rfeReasonKey");
            return (Criteria) this;
        }

        public Criteria andRfeReasonKeyNotBetween(String value1, String value2) {
            addCriterion("RFE_reason_key not between", value1, value2, "rfeReasonKey");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNull() {
            addCriterion("modify_time is null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNotNull() {
            addCriterion("modify_time is not null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeEqualTo(Date value) {
            addCriterion("modify_time =", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotEqualTo(Date value) {
            addCriterion("modify_time <>", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThan(Date value) {
            addCriterion("modify_time >", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("modify_time >=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThan(Date value) {
            addCriterion("modify_time <", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("modify_time <=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIn(List<Date> values) {
            addCriterion("modify_time in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotIn(List<Date> values) {
            addCriterion("modify_time not in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeBetween(Date value1, Date value2) {
            addCriterion("modify_time between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("modify_time not between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andIsTwoCardIsNull() {
            addCriterion("is_two_card is null");
            return (Criteria) this;
        }

        public Criteria andIsTwoCardIsNotNull() {
            addCriterion("is_two_card is not null");
            return (Criteria) this;
        }

        public Criteria andIsTwoCardEqualTo(Integer value) {
            addCriterion("is_two_card =", value, "isTwoCard");
            return (Criteria) this;
        }

        public Criteria andIsTwoCardNotEqualTo(Integer value) {
            addCriterion("is_two_card <>", value, "isTwoCard");
            return (Criteria) this;
        }

        public Criteria andIsTwoCardGreaterThan(Integer value) {
            addCriterion("is_two_card >", value, "isTwoCard");
            return (Criteria) this;
        }

        public Criteria andIsTwoCardGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_two_card >=", value, "isTwoCard");
            return (Criteria) this;
        }

        public Criteria andIsTwoCardLessThan(Integer value) {
            addCriterion("is_two_card <", value, "isTwoCard");
            return (Criteria) this;
        }

        public Criteria andIsTwoCardLessThanOrEqualTo(Integer value) {
            addCriterion("is_two_card <=", value, "isTwoCard");
            return (Criteria) this;
        }

        public Criteria andIsTwoCardIn(List<Integer> values) {
            addCriterion("is_two_card in", values, "isTwoCard");
            return (Criteria) this;
        }

        public Criteria andIsTwoCardNotIn(List<Integer> values) {
            addCriterion("is_two_card not in", values, "isTwoCard");
            return (Criteria) this;
        }

        public Criteria andIsTwoCardBetween(Integer value1, Integer value2) {
            addCriterion("is_two_card between", value1, value2, "isTwoCard");
            return (Criteria) this;
        }

        public Criteria andIsTwoCardNotBetween(Integer value1, Integer value2) {
            addCriterion("is_two_card not between", value1, value2, "isTwoCard");
            return (Criteria) this;
        }
    }

    /**
     * org.mybatis.generator.config.Context@3abfe836
     * 
     * @authpr gaowenlin
     * @version 1.0 2017-05-03
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }

    /**
     * org.mybatis.generator.config.Context@3abfe836
     * 
     * @authpr gaowenlin
     * @version 1.0 2017-05-03
     */
    public static class Criterion implements Serializable {
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