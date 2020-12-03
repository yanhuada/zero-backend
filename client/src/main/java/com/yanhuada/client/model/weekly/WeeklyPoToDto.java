package com.yanhuada.client.model.weekly;

import com.yanhuada.client.model.weekly.rsp.WeeklyDetailRsp;
import com.yanhuada.client.model.weekly.rsp.WeeklyPagerRsp;
import com.yanhuada.common.util.aliyun.oss.OssUtil;
import com.yanhuada.model.Author;
import com.yanhuada.model.Weekly;

/**
 * @author yanhuada
 * CREATE ON 2020/8/16 19:38
 */
public class WeeklyPoToDto {

    public static WeeklyPagerRsp copyWeeklyPagerRsp(Weekly weekly, Author author, OssUtil ossUtil){
        WeeklyPagerRsp rsp = new WeeklyPagerRsp();
        rsp.setId(weekly.getId());
        rsp.setCover(ossUtil.getFileUrl(weekly.getCover()));
        rsp.setPublishTime(weekly.getPublishTime());
        rsp.setTitle(weekly.getTitle());
        rsp.setAuthorId(author.getId());
        rsp.setAuthorName(author.getUserNickname());
        return rsp;
    }
    public static WeeklyDetailRsp copyWeeklyDetailRsp(Weekly weekly, Author author, OssUtil ossUtil){
        WeeklyDetailRsp rsp = new WeeklyDetailRsp();
        rsp.setId(weekly.getId());
        rsp.setCover(ossUtil.getFileUrl(weekly.getCover()));
        rsp.setPublishTime(weekly.getPublishTime());
        rsp.setTitle(weekly.getTitle());
        rsp.setAuthorId(author.getId());
        rsp.setAuthorName(author.getUserNickname());
        rsp.setContent(weekly.getContent());
        return rsp;
    }

}
