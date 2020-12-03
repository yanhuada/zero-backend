package com.yanhuada.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CircleTopicContentSubCommentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CircleTopicContentSubCommentExample() {
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

        public Criteria andCircleTopicContentCommentIdIsNull() {
            addCriterion("circle_topic_content_comment_id is null");
            return (Criteria) this;
        }

        public Criteria andCircleTopicContentCommentIdIsNotNull() {
            addCriterion("circle_topic_content_comment_id is not null");
            return (Criteria) this;
        }

        public Criteria andCircleTopicContentCommentIdEqualTo(Long value) {
            addCriterion("circle_topic_content_comment_id =", value, "circleTopicContentCommentId");
            return (Criteria) this;
        }

        public Criteria andCircleTopicContentCommentIdNotEqualTo(Long value) {
            addCriterion("circle_topic_content_comment_id <>", value, "circleTopicContentCommentId");
            return (Criteria) this;
        }

        public Criteria andCircleTopicContentCommentIdGreaterThan(Long value) {
            addCriterion("circle_topic_content_comment_id >", value, "circleTopicContentCommentId");
            return (Criteria) this;
        }

        public Criteria andCircleTopicContentCommentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("circle_topic_content_comment_id >=", value, "circleTopicContentCommentId");
            return (Criteria) this;
        }

        public Criteria andCircleTopicContentCommentIdLessThan(Long value) {
            addCriterion("circle_topic_content_comment_id <", value, "circleTopicContentCommentId");
            return (Criteria) this;
        }

        public Criteria andCircleTopicContentCommentIdLessThanOrEqualTo(Long value) {
            addCriterion("circle_topic_content_comment_id <=", value, "circleTopicContentCommentId");
            return (Criteria) this;
        }

        public Criteria andCircleTopicContentCommentIdIn(List<Long> values) {
            addCriterion("circle_topic_content_comment_id in", values, "circleTopicContentCommentId");
            return (Criteria) this;
        }

        public Criteria andCircleTopicContentCommentIdNotIn(List<Long> values) {
            addCriterion("circle_topic_content_comment_id not in", values, "circleTopicContentCommentId");
            return (Criteria) this;
        }

        public Criteria andCircleTopicContentCommentIdBetween(Long value1, Long value2) {
            addCriterion("circle_topic_content_comment_id between", value1, value2, "circleTopicContentCommentId");
            return (Criteria) this;
        }

        public Criteria andCircleTopicContentCommentIdNotBetween(Long value1, Long value2) {
            addCriterion("circle_topic_content_comment_id not between", value1, value2, "circleTopicContentCommentId");
            return (Criteria) this;
        }

        public Criteria andRootUserIdIsNull() {
            addCriterion("root_user_id is null");
            return (Criteria) this;
        }

        public Criteria andRootUserIdIsNotNull() {
            addCriterion("root_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andRootUserIdEqualTo(Long value) {
            addCriterion("root_user_id =", value, "rootUserId");
            return (Criteria) this;
        }

        public Criteria andRootUserIdNotEqualTo(Long value) {
            addCriterion("root_user_id <>", value, "rootUserId");
            return (Criteria) this;
        }

        public Criteria andRootUserIdGreaterThan(Long value) {
            addCriterion("root_user_id >", value, "rootUserId");
            return (Criteria) this;
        }

        public Criteria andRootUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("root_user_id >=", value, "rootUserId");
            return (Criteria) this;
        }

        public Criteria andRootUserIdLessThan(Long value) {
            addCriterion("root_user_id <", value, "rootUserId");
            return (Criteria) this;
        }

        public Criteria andRootUserIdLessThanOrEqualTo(Long value) {
            addCriterion("root_user_id <=", value, "rootUserId");
            return (Criteria) this;
        }

        public Criteria andRootUserIdIn(List<Long> values) {
            addCriterion("root_user_id in", values, "rootUserId");
            return (Criteria) this;
        }

        public Criteria andRootUserIdNotIn(List<Long> values) {
            addCriterion("root_user_id not in", values, "rootUserId");
            return (Criteria) this;
        }

        public Criteria andRootUserIdBetween(Long value1, Long value2) {
            addCriterion("root_user_id between", value1, value2, "rootUserId");
            return (Criteria) this;
        }

        public Criteria andRootUserIdNotBetween(Long value1, Long value2) {
            addCriterion("root_user_id not between", value1, value2, "rootUserId");
            return (Criteria) this;
        }

        public Criteria andRootUserNicknameIsNull() {
            addCriterion("root_user_nickname is null");
            return (Criteria) this;
        }

        public Criteria andRootUserNicknameIsNotNull() {
            addCriterion("root_user_nickname is not null");
            return (Criteria) this;
        }

        public Criteria andRootUserNicknameEqualTo(String value) {
            addCriterion("root_user_nickname =", value, "rootUserNickname");
            return (Criteria) this;
        }

        public Criteria andRootUserNicknameNotEqualTo(String value) {
            addCriterion("root_user_nickname <>", value, "rootUserNickname");
            return (Criteria) this;
        }

        public Criteria andRootUserNicknameGreaterThan(String value) {
            addCriterion("root_user_nickname >", value, "rootUserNickname");
            return (Criteria) this;
        }

        public Criteria andRootUserNicknameGreaterThanOrEqualTo(String value) {
            addCriterion("root_user_nickname >=", value, "rootUserNickname");
            return (Criteria) this;
        }

        public Criteria andRootUserNicknameLessThan(String value) {
            addCriterion("root_user_nickname <", value, "rootUserNickname");
            return (Criteria) this;
        }

        public Criteria andRootUserNicknameLessThanOrEqualTo(String value) {
            addCriterion("root_user_nickname <=", value, "rootUserNickname");
            return (Criteria) this;
        }

        public Criteria andRootUserNicknameLike(String value) {
            addCriterion("root_user_nickname like", value, "rootUserNickname");
            return (Criteria) this;
        }

        public Criteria andRootUserNicknameNotLike(String value) {
            addCriterion("root_user_nickname not like", value, "rootUserNickname");
            return (Criteria) this;
        }

        public Criteria andRootUserNicknameIn(List<String> values) {
            addCriterion("root_user_nickname in", values, "rootUserNickname");
            return (Criteria) this;
        }

        public Criteria andRootUserNicknameNotIn(List<String> values) {
            addCriterion("root_user_nickname not in", values, "rootUserNickname");
            return (Criteria) this;
        }

        public Criteria andRootUserNicknameBetween(String value1, String value2) {
            addCriterion("root_user_nickname between", value1, value2, "rootUserNickname");
            return (Criteria) this;
        }

        public Criteria andRootUserNicknameNotBetween(String value1, String value2) {
            addCriterion("root_user_nickname not between", value1, value2, "rootUserNickname");
            return (Criteria) this;
        }

        public Criteria andRootUserAvatarIsNull() {
            addCriterion("root_user_avatar is null");
            return (Criteria) this;
        }

        public Criteria andRootUserAvatarIsNotNull() {
            addCriterion("root_user_avatar is not null");
            return (Criteria) this;
        }

        public Criteria andRootUserAvatarEqualTo(String value) {
            addCriterion("root_user_avatar =", value, "rootUserAvatar");
            return (Criteria) this;
        }

        public Criteria andRootUserAvatarNotEqualTo(String value) {
            addCriterion("root_user_avatar <>", value, "rootUserAvatar");
            return (Criteria) this;
        }

        public Criteria andRootUserAvatarGreaterThan(String value) {
            addCriterion("root_user_avatar >", value, "rootUserAvatar");
            return (Criteria) this;
        }

        public Criteria andRootUserAvatarGreaterThanOrEqualTo(String value) {
            addCriterion("root_user_avatar >=", value, "rootUserAvatar");
            return (Criteria) this;
        }

        public Criteria andRootUserAvatarLessThan(String value) {
            addCriterion("root_user_avatar <", value, "rootUserAvatar");
            return (Criteria) this;
        }

        public Criteria andRootUserAvatarLessThanOrEqualTo(String value) {
            addCriterion("root_user_avatar <=", value, "rootUserAvatar");
            return (Criteria) this;
        }

        public Criteria andRootUserAvatarLike(String value) {
            addCriterion("root_user_avatar like", value, "rootUserAvatar");
            return (Criteria) this;
        }

        public Criteria andRootUserAvatarNotLike(String value) {
            addCriterion("root_user_avatar not like", value, "rootUserAvatar");
            return (Criteria) this;
        }

        public Criteria andRootUserAvatarIn(List<String> values) {
            addCriterion("root_user_avatar in", values, "rootUserAvatar");
            return (Criteria) this;
        }

        public Criteria andRootUserAvatarNotIn(List<String> values) {
            addCriterion("root_user_avatar not in", values, "rootUserAvatar");
            return (Criteria) this;
        }

        public Criteria andRootUserAvatarBetween(String value1, String value2) {
            addCriterion("root_user_avatar between", value1, value2, "rootUserAvatar");
            return (Criteria) this;
        }

        public Criteria andRootUserAvatarNotBetween(String value1, String value2) {
            addCriterion("root_user_avatar not between", value1, value2, "rootUserAvatar");
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

        public Criteria andUserNicknameIsNull() {
            addCriterion("user_nickname is null");
            return (Criteria) this;
        }

        public Criteria andUserNicknameIsNotNull() {
            addCriterion("user_nickname is not null");
            return (Criteria) this;
        }

        public Criteria andUserNicknameEqualTo(String value) {
            addCriterion("user_nickname =", value, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameNotEqualTo(String value) {
            addCriterion("user_nickname <>", value, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameGreaterThan(String value) {
            addCriterion("user_nickname >", value, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameGreaterThanOrEqualTo(String value) {
            addCriterion("user_nickname >=", value, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameLessThan(String value) {
            addCriterion("user_nickname <", value, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameLessThanOrEqualTo(String value) {
            addCriterion("user_nickname <=", value, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameLike(String value) {
            addCriterion("user_nickname like", value, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameNotLike(String value) {
            addCriterion("user_nickname not like", value, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameIn(List<String> values) {
            addCriterion("user_nickname in", values, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameNotIn(List<String> values) {
            addCriterion("user_nickname not in", values, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameBetween(String value1, String value2) {
            addCriterion("user_nickname between", value1, value2, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameNotBetween(String value1, String value2) {
            addCriterion("user_nickname not between", value1, value2, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserAvatarIsNull() {
            addCriterion("user_avatar is null");
            return (Criteria) this;
        }

        public Criteria andUserAvatarIsNotNull() {
            addCriterion("user_avatar is not null");
            return (Criteria) this;
        }

        public Criteria andUserAvatarEqualTo(String value) {
            addCriterion("user_avatar =", value, "userAvatar");
            return (Criteria) this;
        }

        public Criteria andUserAvatarNotEqualTo(String value) {
            addCriterion("user_avatar <>", value, "userAvatar");
            return (Criteria) this;
        }

        public Criteria andUserAvatarGreaterThan(String value) {
            addCriterion("user_avatar >", value, "userAvatar");
            return (Criteria) this;
        }

        public Criteria andUserAvatarGreaterThanOrEqualTo(String value) {
            addCriterion("user_avatar >=", value, "userAvatar");
            return (Criteria) this;
        }

        public Criteria andUserAvatarLessThan(String value) {
            addCriterion("user_avatar <", value, "userAvatar");
            return (Criteria) this;
        }

        public Criteria andUserAvatarLessThanOrEqualTo(String value) {
            addCriterion("user_avatar <=", value, "userAvatar");
            return (Criteria) this;
        }

        public Criteria andUserAvatarLike(String value) {
            addCriterion("user_avatar like", value, "userAvatar");
            return (Criteria) this;
        }

        public Criteria andUserAvatarNotLike(String value) {
            addCriterion("user_avatar not like", value, "userAvatar");
            return (Criteria) this;
        }

        public Criteria andUserAvatarIn(List<String> values) {
            addCriterion("user_avatar in", values, "userAvatar");
            return (Criteria) this;
        }

        public Criteria andUserAvatarNotIn(List<String> values) {
            addCriterion("user_avatar not in", values, "userAvatar");
            return (Criteria) this;
        }

        public Criteria andUserAvatarBetween(String value1, String value2) {
            addCriterion("user_avatar between", value1, value2, "userAvatar");
            return (Criteria) this;
        }

        public Criteria andUserAvatarNotBetween(String value1, String value2) {
            addCriterion("user_avatar not between", value1, value2, "userAvatar");
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

        public Criteria andIfDeleteIsNull() {
            addCriterion("if_delete is null");
            return (Criteria) this;
        }

        public Criteria andIfDeleteIsNotNull() {
            addCriterion("if_delete is not null");
            return (Criteria) this;
        }

        public Criteria andIfDeleteEqualTo(Boolean value) {
            addCriterion("if_delete =", value, "ifDelete");
            return (Criteria) this;
        }

        public Criteria andIfDeleteNotEqualTo(Boolean value) {
            addCriterion("if_delete <>", value, "ifDelete");
            return (Criteria) this;
        }

        public Criteria andIfDeleteGreaterThan(Boolean value) {
            addCriterion("if_delete >", value, "ifDelete");
            return (Criteria) this;
        }

        public Criteria andIfDeleteGreaterThanOrEqualTo(Boolean value) {
            addCriterion("if_delete >=", value, "ifDelete");
            return (Criteria) this;
        }

        public Criteria andIfDeleteLessThan(Boolean value) {
            addCriterion("if_delete <", value, "ifDelete");
            return (Criteria) this;
        }

        public Criteria andIfDeleteLessThanOrEqualTo(Boolean value) {
            addCriterion("if_delete <=", value, "ifDelete");
            return (Criteria) this;
        }

        public Criteria andIfDeleteIn(List<Boolean> values) {
            addCriterion("if_delete in", values, "ifDelete");
            return (Criteria) this;
        }

        public Criteria andIfDeleteNotIn(List<Boolean> values) {
            addCriterion("if_delete not in", values, "ifDelete");
            return (Criteria) this;
        }

        public Criteria andIfDeleteBetween(Boolean value1, Boolean value2) {
            addCriterion("if_delete between", value1, value2, "ifDelete");
            return (Criteria) this;
        }

        public Criteria andIfDeleteNotBetween(Boolean value1, Boolean value2) {
            addCriterion("if_delete not between", value1, value2, "ifDelete");
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