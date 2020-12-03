package com.yanhuada.platform.model.circle;

import com.yanhuada.common.util.aliyun.oss.OssUtil;
import com.yanhuada.model.Circle;
import com.yanhuada.model.CircleResource;
import com.yanhuada.model.CircleTopic;
import com.yanhuada.model.CircleTopicContent;
import com.yanhuada.platform.model.circle.rsp.*;

/**
 * @author yanhuada
 * CREATE ON 2020/8/12 19:04
 */
public class CirclePoToDto {
    public static CirclePagerRsp copyCirclePagerRsp(Circle circle, OssUtil ossUtil) {
        CirclePagerRsp rsp = new CirclePagerRsp();
        rsp.setId(circle.getId());
        rsp.setIcon(ossUtil.getFileUrl(circle.getIcon()));
        rsp.setName(circle.getName());
        rsp.setUserNum(circle.getUserNum());
        rsp.setCreatedAt(circle.getCreatedAt());
        rsp.setIfEnable(true);
        return rsp;
    }

    public static CircleDetailRsp copyCircleDetailRsp(Circle circle) {
        CircleDetailRsp rsp = new CircleDetailRsp();
        rsp.setId(circle.getId());
        rsp.setIcon(circle.getIcon());
        rsp.setName(circle.getName());
        rsp.setUserNum(circle.getUserNum());
        rsp.setCreatedAt(circle.getCreatedAt());
        rsp.setIfEnable(true);
        return rsp;
    }

    public static CircleTopicListRsp copyCircleTopicListRsp(CircleTopic circleTopic, Circle circle) {
        CircleTopicListRsp rsp = new CircleTopicListRsp();
        rsp.setId(circleTopic.getId());
        rsp.setName(circleTopic.getName());
        rsp.setCircleId(circleTopic.getCircleId());
        rsp.setCircleName(circle.getName());
        rsp.setSort(circleTopic.getSort());
        rsp.setPublishStatus(circleTopic.getPublishStatus());
        rsp.setPublishTime(circleTopic.getPublishTime());
        rsp.setCreatedAt(circleTopic.getCreatedAt());
        return rsp;
    }

    public static CircleTopicContentPagerRsp copyCircleTopicContentPagerRsp(CircleTopicContent circleTopicContent, CircleTopic circleTopic, Circle circle) {
        CircleTopicContentPagerRsp rsp = new CircleTopicContentPagerRsp();
        rsp.setId(circleTopicContent.getId());
        rsp.setAuthor(circleTopicContent.getAuthor());
        rsp.setTitle(circleTopicContent.getTitle());
        rsp.setPublishStatus(circleTopicContent.getPublishStatus());
        rsp.setPublishTime(circleTopicContent.getPublishTime());
        rsp.setCreatedAt(circleTopicContent.getCreatedAt());
        rsp.setCircleId(circle.getId());
        rsp.setCircleName(circle.getName());
        rsp.setCircleTopicId(circleTopic.getId());
        rsp.setCircleTopicName(circleTopic.getName());
        return rsp;
    }

    public static CircleTopicContentDetailRsp copyCircleTopicContentDetailRsp(CircleTopicContent circleTopicContent, CircleTopic circleTopic, Circle circle) {
        CircleTopicContentDetailRsp rsp = new CircleTopicContentDetailRsp();
        rsp.setId(circleTopicContent.getId());
        rsp.setAuthor(circleTopicContent.getAuthor());
        rsp.setTitle(circleTopicContent.getTitle());
        rsp.setPublishStatus(circleTopicContent.getPublishStatus());
        rsp.setPublishTime(circleTopicContent.getPublishTime());
        rsp.setCreatedAt(circleTopicContent.getCreatedAt());
        rsp.setCircleId(circle.getId());
        rsp.setCircleName(circle.getName());
        rsp.setCircleTopicId(circleTopic.getId());
        rsp.setCircleTopicName(circleTopic.getName());
        rsp.setContent(circleTopicContent.getContent());
        return rsp;
    }


    public static CircleResourcePagerRsp copyCircleResourcePagerRsp(CircleResource circleResource,Circle circle) {
        CircleResourcePagerRsp rsp = new CircleResourcePagerRsp();

        rsp.setId(circleResource.getId());
        rsp.setCircleId(circleResource.getCircleId());
        rsp.setCircleName(circle.getName());
        rsp.setIfEnable(circleResource.getIfEnable());
        rsp.setTitle(circleResource.getTitle());
        rsp.setCreatedAt(circleResource.getCreatedAt());
        return rsp;
    }

    public static CircleResourceDetailRsp copyCircleResourceDetailRsp(CircleResource circleResource,Circle circle) {

        CircleResourceDetailRsp rsp = new CircleResourceDetailRsp();
        rsp.setId(circleResource.getId());
        rsp.setCircleId(circleResource.getCircleId());
        rsp.setCircleName(circle.getName());
        rsp.setIfEnable(circleResource.getIfEnable());
        rsp.setTitle(circleResource.getTitle());
        rsp.setContent(circleResource.getContent());
        rsp.setCreatedAt(circleResource.getCreatedAt());
        return rsp;
    }
}
