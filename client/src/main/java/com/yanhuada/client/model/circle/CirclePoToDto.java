package com.yanhuada.client.model.circle;

import com.yanhuada.client.model.circle.rsp.*;
import com.yanhuada.common.util.aliyun.oss.OssUtil;
import com.yanhuada.model.*;

/**
 * @author yanhuada
 * CREATE ON 2020/8/21 17:47
 */
public class CirclePoToDto {

    public static CircleListRsp copyCircleListRsp(Circle circle, OssUtil ossUtil) {
        CircleListRsp rsp = new CircleListRsp();
        rsp.setId(circle.getId());
        rsp.setIcon(ossUtil.getFileUrl(circle.getIcon()));
        rsp.setCover(ossUtil.getFileUrl(circle.getCover()));
        rsp.setName(circle.getName());
        rsp.setUserNum(circle.getUserNum());
        return rsp;
    }

    public static CircleDetailRsp copyCircleDetailRsp(Circle circle, Boolean ifJoin, Boolean ifInGroup, OssUtil ossUtil) {
        CircleDetailRsp rsp = new CircleDetailRsp();
        rsp.setId(circle.getId());
        rsp.setIcon(ossUtil.getFileUrl(circle.getIcon()));
        rsp.setCover(ossUtil.getFileUrl(circle.getCover()));
        rsp.setName(circle.getName());
        rsp.setUserNum(circle.getUserNum());
        rsp.setIntroduce(circle.getIntroduce());
        rsp.setIfJoin(ifJoin);
        rsp.setIfInGroup(ifInGroup);
        return rsp;
    }

    public static CircleTopicListRsp copyCircleTopicListRsp(CircleTopic circleTopic) {
        CircleTopicListRsp rsp = new CircleTopicListRsp();
        rsp.setId(circleTopic.getId());
        rsp.setName(circleTopic.getName());
        return rsp;
    }

    public static CircleTopicContentDetailRsp copyCircleTopicContentDetailRsp(CircleTopicContent circleTopicContent) {
        CircleTopicContentDetailRsp rsp = new CircleTopicContentDetailRsp();
        rsp.setId(circleTopicContent.getId());
        rsp.setContent(circleTopicContent.getContent());
        rsp.setTitle(circleTopicContent.getTitle());
        rsp.setAuthor(circleTopicContent.getAuthor());
        rsp.setPublishTime(circleTopicContent.getPublishTime());
        return rsp;
    }

    public static CircleTopicContentPagerRsp copyCircleTopicContentPagerRsp(CircleTopicContent circleTopicContent) {
        CircleTopicContentPagerRsp rsp = new CircleTopicContentPagerRsp();
        rsp.setId(circleTopicContent.getId());
        rsp.setTitle(circleTopicContent.getTitle());
        rsp.setAuthor(circleTopicContent.getAuthor());
        rsp.setPublishTime(circleTopicContent.getPublishTime());
        return rsp;
    }

    public static CircleResourcePagerRsp copyCircleResourcePagerRsp(CircleResource circleResource) {
        CircleResourcePagerRsp rsp = new CircleResourcePagerRsp();
        rsp.setId(circleResource.getId());
        rsp.setTitle(circleResource.getTitle());
        return rsp;
    }

    public static CircleResourceDetailRsp copyCircleResourceDetailRsp(CircleResource circleResource) {
        CircleResourceDetailRsp rsp = new CircleResourceDetailRsp();
        rsp.setId(circleResource.getId());
        rsp.setTitle(circleResource.getTitle());
        rsp.setContent(circleResource.getContent());
        return rsp;
    }

    public static CircleUserListRsp copyCircleUserListRsp(CircleUser circleUser,OssUtil ossUtil) {
        CircleUserListRsp rsp = new CircleUserListRsp();
        rsp.setId(circleUser.getId());
        rsp.setNickname(circleUser.getUserNickname());
        rsp.setAvatar(ossUtil.getFileUrl(circleUser.getUserAvatar()));
        return rsp;
    }
}
