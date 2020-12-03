package com.yanhuada.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ArtSpeakExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ArtSpeakExample() {
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

        public Criteria andArtSpeakTypeIdIsNull() {
            addCriterion("art_speak_type_id is null");
            return (Criteria) this;
        }

        public Criteria andArtSpeakTypeIdIsNotNull() {
            addCriterion("art_speak_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andArtSpeakTypeIdEqualTo(Long value) {
            addCriterion("art_speak_type_id =", value, "artSpeakTypeId");
            return (Criteria) this;
        }

        public Criteria andArtSpeakTypeIdNotEqualTo(Long value) {
            addCriterion("art_speak_type_id <>", value, "artSpeakTypeId");
            return (Criteria) this;
        }

        public Criteria andArtSpeakTypeIdGreaterThan(Long value) {
            addCriterion("art_speak_type_id >", value, "artSpeakTypeId");
            return (Criteria) this;
        }

        public Criteria andArtSpeakTypeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("art_speak_type_id >=", value, "artSpeakTypeId");
            return (Criteria) this;
        }

        public Criteria andArtSpeakTypeIdLessThan(Long value) {
            addCriterion("art_speak_type_id <", value, "artSpeakTypeId");
            return (Criteria) this;
        }

        public Criteria andArtSpeakTypeIdLessThanOrEqualTo(Long value) {
            addCriterion("art_speak_type_id <=", value, "artSpeakTypeId");
            return (Criteria) this;
        }

        public Criteria andArtSpeakTypeIdIn(List<Long> values) {
            addCriterion("art_speak_type_id in", values, "artSpeakTypeId");
            return (Criteria) this;
        }

        public Criteria andArtSpeakTypeIdNotIn(List<Long> values) {
            addCriterion("art_speak_type_id not in", values, "artSpeakTypeId");
            return (Criteria) this;
        }

        public Criteria andArtSpeakTypeIdBetween(Long value1, Long value2) {
            addCriterion("art_speak_type_id between", value1, value2, "artSpeakTypeId");
            return (Criteria) this;
        }

        public Criteria andArtSpeakTypeIdNotBetween(Long value1, Long value2) {
            addCriterion("art_speak_type_id not between", value1, value2, "artSpeakTypeId");
            return (Criteria) this;
        }

        public Criteria andArtSpeakTypeNameIsNull() {
            addCriterion("art_speak_type_name is null");
            return (Criteria) this;
        }

        public Criteria andArtSpeakTypeNameIsNotNull() {
            addCriterion("art_speak_type_name is not null");
            return (Criteria) this;
        }

        public Criteria andArtSpeakTypeNameEqualTo(String value) {
            addCriterion("art_speak_type_name =", value, "artSpeakTypeName");
            return (Criteria) this;
        }

        public Criteria andArtSpeakTypeNameNotEqualTo(String value) {
            addCriterion("art_speak_type_name <>", value, "artSpeakTypeName");
            return (Criteria) this;
        }

        public Criteria andArtSpeakTypeNameGreaterThan(String value) {
            addCriterion("art_speak_type_name >", value, "artSpeakTypeName");
            return (Criteria) this;
        }

        public Criteria andArtSpeakTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("art_speak_type_name >=", value, "artSpeakTypeName");
            return (Criteria) this;
        }

        public Criteria andArtSpeakTypeNameLessThan(String value) {
            addCriterion("art_speak_type_name <", value, "artSpeakTypeName");
            return (Criteria) this;
        }

        public Criteria andArtSpeakTypeNameLessThanOrEqualTo(String value) {
            addCriterion("art_speak_type_name <=", value, "artSpeakTypeName");
            return (Criteria) this;
        }

        public Criteria andArtSpeakTypeNameLike(String value) {
            addCriterion("art_speak_type_name like", value, "artSpeakTypeName");
            return (Criteria) this;
        }

        public Criteria andArtSpeakTypeNameNotLike(String value) {
            addCriterion("art_speak_type_name not like", value, "artSpeakTypeName");
            return (Criteria) this;
        }

        public Criteria andArtSpeakTypeNameIn(List<String> values) {
            addCriterion("art_speak_type_name in", values, "artSpeakTypeName");
            return (Criteria) this;
        }

        public Criteria andArtSpeakTypeNameNotIn(List<String> values) {
            addCriterion("art_speak_type_name not in", values, "artSpeakTypeName");
            return (Criteria) this;
        }

        public Criteria andArtSpeakTypeNameBetween(String value1, String value2) {
            addCriterion("art_speak_type_name between", value1, value2, "artSpeakTypeName");
            return (Criteria) this;
        }

        public Criteria andArtSpeakTypeNameNotBetween(String value1, String value2) {
            addCriterion("art_speak_type_name not between", value1, value2, "artSpeakTypeName");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andLikeNumIsNull() {
            addCriterion("like_num is null");
            return (Criteria) this;
        }

        public Criteria andLikeNumIsNotNull() {
            addCriterion("like_num is not null");
            return (Criteria) this;
        }

        public Criteria andLikeNumEqualTo(Integer value) {
            addCriterion("like_num =", value, "likeNum");
            return (Criteria) this;
        }

        public Criteria andLikeNumNotEqualTo(Integer value) {
            addCriterion("like_num <>", value, "likeNum");
            return (Criteria) this;
        }

        public Criteria andLikeNumGreaterThan(Integer value) {
            addCriterion("like_num >", value, "likeNum");
            return (Criteria) this;
        }

        public Criteria andLikeNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("like_num >=", value, "likeNum");
            return (Criteria) this;
        }

        public Criteria andLikeNumLessThan(Integer value) {
            addCriterion("like_num <", value, "likeNum");
            return (Criteria) this;
        }

        public Criteria andLikeNumLessThanOrEqualTo(Integer value) {
            addCriterion("like_num <=", value, "likeNum");
            return (Criteria) this;
        }

        public Criteria andLikeNumIn(List<Integer> values) {
            addCriterion("like_num in", values, "likeNum");
            return (Criteria) this;
        }

        public Criteria andLikeNumNotIn(List<Integer> values) {
            addCriterion("like_num not in", values, "likeNum");
            return (Criteria) this;
        }

        public Criteria andLikeNumBetween(Integer value1, Integer value2) {
            addCriterion("like_num between", value1, value2, "likeNum");
            return (Criteria) this;
        }

        public Criteria andLikeNumNotBetween(Integer value1, Integer value2) {
            addCriterion("like_num not between", value1, value2, "likeNum");
            return (Criteria) this;
        }

        public Criteria andDislikeNumIsNull() {
            addCriterion("dislike_num is null");
            return (Criteria) this;
        }

        public Criteria andDislikeNumIsNotNull() {
            addCriterion("dislike_num is not null");
            return (Criteria) this;
        }

        public Criteria andDislikeNumEqualTo(Integer value) {
            addCriterion("dislike_num =", value, "dislikeNum");
            return (Criteria) this;
        }

        public Criteria andDislikeNumNotEqualTo(Integer value) {
            addCriterion("dislike_num <>", value, "dislikeNum");
            return (Criteria) this;
        }

        public Criteria andDislikeNumGreaterThan(Integer value) {
            addCriterion("dislike_num >", value, "dislikeNum");
            return (Criteria) this;
        }

        public Criteria andDislikeNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("dislike_num >=", value, "dislikeNum");
            return (Criteria) this;
        }

        public Criteria andDislikeNumLessThan(Integer value) {
            addCriterion("dislike_num <", value, "dislikeNum");
            return (Criteria) this;
        }

        public Criteria andDislikeNumLessThanOrEqualTo(Integer value) {
            addCriterion("dislike_num <=", value, "dislikeNum");
            return (Criteria) this;
        }

        public Criteria andDislikeNumIn(List<Integer> values) {
            addCriterion("dislike_num in", values, "dislikeNum");
            return (Criteria) this;
        }

        public Criteria andDislikeNumNotIn(List<Integer> values) {
            addCriterion("dislike_num not in", values, "dislikeNum");
            return (Criteria) this;
        }

        public Criteria andDislikeNumBetween(Integer value1, Integer value2) {
            addCriterion("dislike_num between", value1, value2, "dislikeNum");
            return (Criteria) this;
        }

        public Criteria andDislikeNumNotBetween(Integer value1, Integer value2) {
            addCriterion("dislike_num not between", value1, value2, "dislikeNum");
            return (Criteria) this;
        }

        public Criteria andIfEnableIsNull() {
            addCriterion("if_enable is null");
            return (Criteria) this;
        }

        public Criteria andIfEnableIsNotNull() {
            addCriterion("if_enable is not null");
            return (Criteria) this;
        }

        public Criteria andIfEnableEqualTo(Boolean value) {
            addCriterion("if_enable =", value, "ifEnable");
            return (Criteria) this;
        }

        public Criteria andIfEnableNotEqualTo(Boolean value) {
            addCriterion("if_enable <>", value, "ifEnable");
            return (Criteria) this;
        }

        public Criteria andIfEnableGreaterThan(Boolean value) {
            addCriterion("if_enable >", value, "ifEnable");
            return (Criteria) this;
        }

        public Criteria andIfEnableGreaterThanOrEqualTo(Boolean value) {
            addCriterion("if_enable >=", value, "ifEnable");
            return (Criteria) this;
        }

        public Criteria andIfEnableLessThan(Boolean value) {
            addCriterion("if_enable <", value, "ifEnable");
            return (Criteria) this;
        }

        public Criteria andIfEnableLessThanOrEqualTo(Boolean value) {
            addCriterion("if_enable <=", value, "ifEnable");
            return (Criteria) this;
        }

        public Criteria andIfEnableIn(List<Boolean> values) {
            addCriterion("if_enable in", values, "ifEnable");
            return (Criteria) this;
        }

        public Criteria andIfEnableNotIn(List<Boolean> values) {
            addCriterion("if_enable not in", values, "ifEnable");
            return (Criteria) this;
        }

        public Criteria andIfEnableBetween(Boolean value1, Boolean value2) {
            addCriterion("if_enable between", value1, value2, "ifEnable");
            return (Criteria) this;
        }

        public Criteria andIfEnableNotBetween(Boolean value1, Boolean value2) {
            addCriterion("if_enable not between", value1, value2, "ifEnable");
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