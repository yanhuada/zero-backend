package com.yanhuada.platform.model.weekly;

import com.yanhuada.common.enumeration.WeeklyStatus;
import com.yanhuada.common.util.aliyun.oss.OssUtil;
import com.yanhuada.model.Author;
import com.yanhuada.model.Weekly;
import com.yanhuada.platform.model.weekly.rsp.WeeklyDetailRsp;
import com.yanhuada.platform.model.weekly.rsp.WeeklyPagerRsp;

import java.util.Objects;

/**
 * @author yanhuada
 * CREATE ON 2020/8/16 12:22
 */
public class WeeklyPoToDto {

    public static WeeklyPagerRsp copyWeeklyPagerRsp(Weekly weekly, Author author, OssUtil ossUtil) {
        WeeklyPagerRsp rsp = new WeeklyPagerRsp();
        rsp.setId(weekly.getId());
        rsp.setCover(ossUtil.getFileUrl(weekly.getCover()));
        rsp.setTitle(weekly.getTitle());
        rsp.setPublishStatus(weekly.getPublishStatus());
        rsp.setPublishTime(Objects.equals(weekly.getPublishStatus(), WeeklyStatus.UNPUBLISHED.getCode()) ? null : weekly.getPublishTime());
        rsp.setOffTime(Objects.equals(weekly.getPublishStatus(), WeeklyStatus.OFF.getCode()) ? weekly.getOffTime() : null);
        rsp.setAuthorName(author.getUserNickname());
        return rsp;
    }

    public static WeeklyDetailRsp copyWeeklyDetailRsp(Weekly weekly, Author author, OssUtil ossUtil) {
        WeeklyDetailRsp rsp = new WeeklyDetailRsp();
        rsp.setId(weekly.getId());
        rsp.setCover(ossUtil.getFileUrl(weekly.getCover()));
        rsp.setTitle(weekly.getTitle());
        rsp.setPublishStatus(weekly.getPublishStatus());
        rsp.setPublishTime(Objects.equals(weekly.getPublishStatus(), WeeklyStatus.UNPUBLISHED.getCode()) ? null : weekly.getPublishTime());
        rsp.setOffTime(Objects.equals(weekly.getPublishStatus(), WeeklyStatus.OFF.getCode()) ? weekly.getOffTime() : null);
        rsp.setContent(weekly.getContent());
        rsp.setAuthorId(author.getId());
        rsp.setAuthorName(author.getUserNickname());
        rsp.setAuthorAvatar(author.getUserAvatar());
        return rsp;
    }
}
