package com.yanhuada.platform.service.impl;

import com.yanhuada.common.enumeration.WeeklyStatus;
import com.yanhuada.common.model.Pager;
import com.yanhuada.common.util.aliyun.oss.OssUtil;
import com.yanhuada.model.Author;
import com.yanhuada.model.Weekly;
import com.yanhuada.platform.dao.PlatformAuthorMapper;
import com.yanhuada.platform.dao.PlatformWeeklyMapper;
import com.yanhuada.platform.model.weekly.WeeklyPoToDto;
import com.yanhuada.platform.model.weekly.req.WeeklyAddReq;
import com.yanhuada.platform.model.weekly.req.WeeklyPagerReq;
import com.yanhuada.platform.model.weekly.req.WeeklyUpdateReq;
import com.yanhuada.platform.model.weekly.rsp.WeeklyDetailRsp;
import com.yanhuada.platform.model.weekly.rsp.WeeklyPagerRsp;
import com.yanhuada.platform.service.PlatformWeeklyService;
import com.yanhuada.service.impl.BaseWeeklyServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yanhuada
 * CREATE ON 2020/8/13 17:48
 */
@Service
public class PlatformWeeklyServiceImpl extends BaseWeeklyServiceImpl implements PlatformWeeklyService {

    @Resource
    private PlatformAuthorMapper platformAuthorMapper;
    @Resource
    private PlatformWeeklyMapper platformWeeklyMapper;
    @Resource
    private OssUtil ossUtil;

    @Override
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public void add(WeeklyAddReq req) {
        Weekly weeklyForAdd = this.generateEditObj(req);
        weeklyForAdd.setPublishStatus(WeeklyStatus.UNPUBLISHED.getCode());
        platformWeeklyMapper.insertSelective(weeklyForAdd);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public void update(WeeklyUpdateReq req) {
        Weekly weekly = super.findByIdOrFail(req.getId());
        Weekly weeklyForUpdate = this.generateEditObj(req);
        weeklyForUpdate.setId(weekly.getId());
        platformWeeklyMapper.updateByPrimaryKeySelective(weeklyForUpdate);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public void updateStatus(Long id, WeeklyStatus weeklyStatus) {
        Weekly weekly = super.findByIdOrFail(id);
        weekly.setPublishStatus(weeklyStatus.getCode());
        switch (weeklyStatus) {
            case PUBLISHED:
                weekly.setPublishTime(LocalDateTime.now());
                break;
            case OFF:
                weekly.setOffTime(LocalDateTime.now());
                break;
            default:
        }
        platformWeeklyMapper.updateByPrimaryKeySelective(weekly);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public void delete(Long id) {
        Weekly weeklyForDelete = super.findByIdOrFail(id);
        platformWeeklyMapper.deleteByPrimaryKey(weeklyForDelete.getId());
    }

    @Override
    public Pager<WeeklyPagerRsp> pagination(WeeklyPagerReq req) {
        Pager<WeeklyPagerRsp> rspPager = new Pager<>(req.getPage(), req.getCount());
        Long total = platformWeeklyMapper.total(req.getAuthorId(), req.getTitle(), req.getPublishStatus());
        rspPager.setTotal(Math.toIntExact(total));
        if (total == 0) {
            return rspPager;
        }
        List<Weekly> weeklyList = platformWeeklyMapper.list(req.getAuthorId(), req.getTitle(), req.getPublishStatus(), req);
        rspPager.setArray(weeklyList.stream()
                .map(weekly -> WeeklyPoToDto.copyWeeklyPagerRsp(
                        weekly,
                        platformAuthorMapper.selectByPrimaryKey(weekly.getAuthorId()),
                        ossUtil))
                .collect(Collectors.toList()));
        return rspPager;
    }

    @Override
    public WeeklyDetailRsp detail(Long id) {
        Weekly weekly = super.findByIdOrFail(id);
        Author author = platformAuthorMapper.selectByPrimaryKey(weekly.getAuthorId());
        return WeeklyPoToDto.copyWeeklyDetailRsp(weekly, author, ossUtil);
    }


    private Weekly generateEditObj(WeeklyAddReq req) {
        Author author = platformAuthorMapper.selectByPrimaryKey(req.getAuthorId());
        Weekly weeklyForAdd = new Weekly();
        weeklyForAdd.setAuthorId(req.getAuthorId());
        weeklyForAdd.setAuthorId(author.getId());
        weeklyForAdd.setAuthorAvatar(author.getUserAvatar());
        weeklyForAdd.setAuthorName(author.getUserNickname());
        weeklyForAdd.setContent(req.getContent());
        weeklyForAdd.setTitle(req.getTitle());
        weeklyForAdd.setCover(req.getCover());
        return weeklyForAdd;
    }
}
