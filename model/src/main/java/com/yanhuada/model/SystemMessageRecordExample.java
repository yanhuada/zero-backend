package com.yanhuada.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SystemMessageRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SystemMessageRecordExample() {
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andSystemMessageIdIsNull() {
            addCriterion("system_message_id is null");
            return (Criteria) this;
        }

        public Criteria andSystemMessageIdIsNotNull() {
            addCriterion("system_message_id is not null");
            return (Criteria) this;
        }

        public Criteria andSystemMessageIdEqualTo(Long value) {
            addCriterion("system_message_id =", value, "systemMessageId");
            return (Criteria) this;
        }

        public Criteria andSystemMessageIdNotEqualTo(Long value) {
            addCriterion("system_message_id <>", value, "systemMessageId");
            return (Criteria) this;
        }

        public Criteria andSystemMessageIdGreaterThan(Long value) {
            addCriterion("system_message_id >", value, "systemMessageId");
            return (Criteria) this;
        }

        public Criteria andSystemMessageIdGreaterThanOrEqualTo(Long value) {
            addCriterion("system_message_id >=", value, "systemMessageId");
            return (Criteria) this;
        }

        public Criteria andSystemMessageIdLessThan(Long value) {
            addCriterion("system_message_id <", value, "systemMessageId");
            return (Criteria) this;
        }

        public Criteria andSystemMessageIdLessThanOrEqualTo(Long value) {
            addCriterion("system_message_id <=", value, "systemMessageId");
            return (Criteria) this;
        }

        public Criteria andSystemMessageIdIn(List<Long> values) {
            addCriterion("system_message_id in", values, "systemMessageId");
            return (Criteria) this;
        }

        public Criteria andSystemMessageIdNotIn(List<Long> values) {
            addCriterion("system_message_id not in", values, "systemMessageId");
            return (Criteria) this;
        }

        public Criteria andSystemMessageIdBetween(Long value1, Long value2) {
            addCriterion("system_message_id between", value1, value2, "systemMessageId");
            return (Criteria) this;
        }

        public Criteria andSystemMessageIdNotBetween(Long value1, Long value2) {
            addCriterion("system_message_id not between", value1, value2, "systemMessageId");
            return (Criteria) this;
        }

        public Criteria andSystemMessageTitleIsNull() {
            addCriterion("system_message_title is null");
            return (Criteria) this;
        }

        public Criteria andSystemMessageTitleIsNotNull() {
            addCriterion("system_message_title is not null");
            return (Criteria) this;
        }

        public Criteria andSystemMessageTitleEqualTo(String value) {
            addCriterion("system_message_title =", value, "systemMessageTitle");
            return (Criteria) this;
        }

        public Criteria andSystemMessageTitleNotEqualTo(String value) {
            addCriterion("system_message_title <>", value, "systemMessageTitle");
            return (Criteria) this;
        }

        public Criteria andSystemMessageTitleGreaterThan(String value) {
            addCriterion("system_message_title >", value, "systemMessageTitle");
            return (Criteria) this;
        }

        public Criteria andSystemMessageTitleGreaterThanOrEqualTo(String value) {
            addCriterion("system_message_title >=", value, "systemMessageTitle");
            return (Criteria) this;
        }

        public Criteria andSystemMessageTitleLessThan(String value) {
            addCriterion("system_message_title <", value, "systemMessageTitle");
            return (Criteria) this;
        }

        public Criteria andSystemMessageTitleLessThanOrEqualTo(String value) {
            addCriterion("system_message_title <=", value, "systemMessageTitle");
            return (Criteria) this;
        }

        public Criteria andSystemMessageTitleLike(String value) {
            addCriterion("system_message_title like", value, "systemMessageTitle");
            return (Criteria) this;
        }

        public Criteria andSystemMessageTitleNotLike(String value) {
            addCriterion("system_message_title not like", value, "systemMessageTitle");
            return (Criteria) this;
        }

        public Criteria andSystemMessageTitleIn(List<String> values) {
            addCriterion("system_message_title in", values, "systemMessageTitle");
            return (Criteria) this;
        }

        public Criteria andSystemMessageTitleNotIn(List<String> values) {
            addCriterion("system_message_title not in", values, "systemMessageTitle");
            return (Criteria) this;
        }

        public Criteria andSystemMessageTitleBetween(String value1, String value2) {
            addCriterion("system_message_title between", value1, value2, "systemMessageTitle");
            return (Criteria) this;
        }

        public Criteria andSystemMessageTitleNotBetween(String value1, String value2) {
            addCriterion("system_message_title not between", value1, value2, "systemMessageTitle");
            return (Criteria) this;
        }

        public Criteria andSystemMessageContentIsNull() {
            addCriterion("system_message_content is null");
            return (Criteria) this;
        }

        public Criteria andSystemMessageContentIsNotNull() {
            addCriterion("system_message_content is not null");
            return (Criteria) this;
        }

        public Criteria andSystemMessageContentEqualTo(String value) {
            addCriterion("system_message_content =", value, "systemMessageContent");
            return (Criteria) this;
        }

        public Criteria andSystemMessageContentNotEqualTo(String value) {
            addCriterion("system_message_content <>", value, "systemMessageContent");
            return (Criteria) this;
        }

        public Criteria andSystemMessageContentGreaterThan(String value) {
            addCriterion("system_message_content >", value, "systemMessageContent");
            return (Criteria) this;
        }

        public Criteria andSystemMessageContentGreaterThanOrEqualTo(String value) {
            addCriterion("system_message_content >=", value, "systemMessageContent");
            return (Criteria) this;
        }

        public Criteria andSystemMessageContentLessThan(String value) {
            addCriterion("system_message_content <", value, "systemMessageContent");
            return (Criteria) this;
        }

        public Criteria andSystemMessageContentLessThanOrEqualTo(String value) {
            addCriterion("system_message_content <=", value, "systemMessageContent");
            return (Criteria) this;
        }

        public Criteria andSystemMessageContentLike(String value) {
            addCriterion("system_message_content like", value, "systemMessageContent");
            return (Criteria) this;
        }

        public Criteria andSystemMessageContentNotLike(String value) {
            addCriterion("system_message_content not like", value, "systemMessageContent");
            return (Criteria) this;
        }

        public Criteria andSystemMessageContentIn(List<String> values) {
            addCriterion("system_message_content in", values, "systemMessageContent");
            return (Criteria) this;
        }

        public Criteria andSystemMessageContentNotIn(List<String> values) {
            addCriterion("system_message_content not in", values, "systemMessageContent");
            return (Criteria) this;
        }

        public Criteria andSystemMessageContentBetween(String value1, String value2) {
            addCriterion("system_message_content between", value1, value2, "systemMessageContent");
            return (Criteria) this;
        }

        public Criteria andSystemMessageContentNotBetween(String value1, String value2) {
            addCriterion("system_message_content not between", value1, value2, "systemMessageContent");
            return (Criteria) this;
        }

        public Criteria andSystemMessageUrlIsNull() {
            addCriterion("system_message_url is null");
            return (Criteria) this;
        }

        public Criteria andSystemMessageUrlIsNotNull() {
            addCriterion("system_message_url is not null");
            return (Criteria) this;
        }

        public Criteria andSystemMessageUrlEqualTo(String value) {
            addCriterion("system_message_url =", value, "systemMessageUrl");
            return (Criteria) this;
        }

        public Criteria andSystemMessageUrlNotEqualTo(String value) {
            addCriterion("system_message_url <>", value, "systemMessageUrl");
            return (Criteria) this;
        }

        public Criteria andSystemMessageUrlGreaterThan(String value) {
            addCriterion("system_message_url >", value, "systemMessageUrl");
            return (Criteria) this;
        }

        public Criteria andSystemMessageUrlGreaterThanOrEqualTo(String value) {
            addCriterion("system_message_url >=", value, "systemMessageUrl");
            return (Criteria) this;
        }

        public Criteria andSystemMessageUrlLessThan(String value) {
            addCriterion("system_message_url <", value, "systemMessageUrl");
            return (Criteria) this;
        }

        public Criteria andSystemMessageUrlLessThanOrEqualTo(String value) {
            addCriterion("system_message_url <=", value, "systemMessageUrl");
            return (Criteria) this;
        }

        public Criteria andSystemMessageUrlLike(String value) {
            addCriterion("system_message_url like", value, "systemMessageUrl");
            return (Criteria) this;
        }

        public Criteria andSystemMessageUrlNotLike(String value) {
            addCriterion("system_message_url not like", value, "systemMessageUrl");
            return (Criteria) this;
        }

        public Criteria andSystemMessageUrlIn(List<String> values) {
            addCriterion("system_message_url in", values, "systemMessageUrl");
            return (Criteria) this;
        }

        public Criteria andSystemMessageUrlNotIn(List<String> values) {
            addCriterion("system_message_url not in", values, "systemMessageUrl");
            return (Criteria) this;
        }

        public Criteria andSystemMessageUrlBetween(String value1, String value2) {
            addCriterion("system_message_url between", value1, value2, "systemMessageUrl");
            return (Criteria) this;
        }

        public Criteria andSystemMessageUrlNotBetween(String value1, String value2) {
            addCriterion("system_message_url not between", value1, value2, "systemMessageUrl");
            return (Criteria) this;
        }

        public Criteria andSystemMessageUrlTextIsNull() {
            addCriterion("system_message_url_text is null");
            return (Criteria) this;
        }

        public Criteria andSystemMessageUrlTextIsNotNull() {
            addCriterion("system_message_url_text is not null");
            return (Criteria) this;
        }

        public Criteria andSystemMessageUrlTextEqualTo(String value) {
            addCriterion("system_message_url_text =", value, "systemMessageUrlText");
            return (Criteria) this;
        }

        public Criteria andSystemMessageUrlTextNotEqualTo(String value) {
            addCriterion("system_message_url_text <>", value, "systemMessageUrlText");
            return (Criteria) this;
        }

        public Criteria andSystemMessageUrlTextGreaterThan(String value) {
            addCriterion("system_message_url_text >", value, "systemMessageUrlText");
            return (Criteria) this;
        }

        public Criteria andSystemMessageUrlTextGreaterThanOrEqualTo(String value) {
            addCriterion("system_message_url_text >=", value, "systemMessageUrlText");
            return (Criteria) this;
        }

        public Criteria andSystemMessageUrlTextLessThan(String value) {
            addCriterion("system_message_url_text <", value, "systemMessageUrlText");
            return (Criteria) this;
        }

        public Criteria andSystemMessageUrlTextLessThanOrEqualTo(String value) {
            addCriterion("system_message_url_text <=", value, "systemMessageUrlText");
            return (Criteria) this;
        }

        public Criteria andSystemMessageUrlTextLike(String value) {
            addCriterion("system_message_url_text like", value, "systemMessageUrlText");
            return (Criteria) this;
        }

        public Criteria andSystemMessageUrlTextNotLike(String value) {
            addCriterion("system_message_url_text not like", value, "systemMessageUrlText");
            return (Criteria) this;
        }

        public Criteria andSystemMessageUrlTextIn(List<String> values) {
            addCriterion("system_message_url_text in", values, "systemMessageUrlText");
            return (Criteria) this;
        }

        public Criteria andSystemMessageUrlTextNotIn(List<String> values) {
            addCriterion("system_message_url_text not in", values, "systemMessageUrlText");
            return (Criteria) this;
        }

        public Criteria andSystemMessageUrlTextBetween(String value1, String value2) {
            addCriterion("system_message_url_text between", value1, value2, "systemMessageUrlText");
            return (Criteria) this;
        }

        public Criteria andSystemMessageUrlTextNotBetween(String value1, String value2) {
            addCriterion("system_message_url_text not between", value1, value2, "systemMessageUrlText");
            return (Criteria) this;
        }

        public Criteria andIfReadIsNull() {
            addCriterion("if_read is null");
            return (Criteria) this;
        }

        public Criteria andIfReadIsNotNull() {
            addCriterion("if_read is not null");
            return (Criteria) this;
        }

        public Criteria andIfReadEqualTo(Boolean value) {
            addCriterion("if_read =", value, "ifRead");
            return (Criteria) this;
        }

        public Criteria andIfReadNotEqualTo(Boolean value) {
            addCriterion("if_read <>", value, "ifRead");
            return (Criteria) this;
        }

        public Criteria andIfReadGreaterThan(Boolean value) {
            addCriterion("if_read >", value, "ifRead");
            return (Criteria) this;
        }

        public Criteria andIfReadGreaterThanOrEqualTo(Boolean value) {
            addCriterion("if_read >=", value, "ifRead");
            return (Criteria) this;
        }

        public Criteria andIfReadLessThan(Boolean value) {
            addCriterion("if_read <", value, "ifRead");
            return (Criteria) this;
        }

        public Criteria andIfReadLessThanOrEqualTo(Boolean value) {
            addCriterion("if_read <=", value, "ifRead");
            return (Criteria) this;
        }

        public Criteria andIfReadIn(List<Boolean> values) {
            addCriterion("if_read in", values, "ifRead");
            return (Criteria) this;
        }

        public Criteria andIfReadNotIn(List<Boolean> values) {
            addCriterion("if_read not in", values, "ifRead");
            return (Criteria) this;
        }

        public Criteria andIfReadBetween(Boolean value1, Boolean value2) {
            addCriterion("if_read between", value1, value2, "ifRead");
            return (Criteria) this;
        }

        public Criteria andIfReadNotBetween(Boolean value1, Boolean value2) {
            addCriterion("if_read not between", value1, value2, "ifRead");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIsNull() {
            addCriterion("created_at is null");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIsNotNull() {
            addCriterion("created_at is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedAtEqualTo(LocalDateTime value) {
            addCriterion("created_at =", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotEqualTo(LocalDateTime value) {
            addCriterion("created_at <>", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtGreaterThan(LocalDateTime value) {
            addCriterion("created_at >", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtGreaterThanOrEqualTo(LocalDateTime value) {
            addCriterion("created_at >=", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtLessThan(LocalDateTime value) {
            addCriterion("created_at <", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtLessThanOrEqualTo(LocalDateTime value) {
            addCriterion("created_at <=", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIn(List<LocalDateTime> values) {
            addCriterion("created_at in", values, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotIn(List<LocalDateTime> values) {
            addCriterion("created_at not in", values, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("created_at between", value1, value2, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("created_at not between", value1, value2, "createdAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIsNull() {
            addCriterion("updated_at is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIsNotNull() {
            addCriterion("updated_at is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtEqualTo(LocalDateTime value) {
            addCriterion("updated_at =", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotEqualTo(LocalDateTime value) {
            addCriterion("updated_at <>", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtGreaterThan(LocalDateTime value) {
            addCriterion("updated_at >", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtGreaterThanOrEqualTo(LocalDateTime value) {
            addCriterion("updated_at >=", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtLessThan(LocalDateTime value) {
            addCriterion("updated_at <", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtLessThanOrEqualTo(LocalDateTime value) {
            addCriterion("updated_at <=", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIn(List<LocalDateTime> values) {
            addCriterion("updated_at in", values, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotIn(List<LocalDateTime> values) {
            addCriterion("updated_at not in", values, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("updated_at between", value1, value2, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("updated_at not between", value1, value2, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(Long value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Long value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Long value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Long value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Long value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Long value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Long> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Long> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Long value1, Long value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Long value1, Long value2) {
            addCriterion("version not between", value1, value2, "version");
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