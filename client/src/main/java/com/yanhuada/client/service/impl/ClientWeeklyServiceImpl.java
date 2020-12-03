package com.yanhuada.client.service.impl;

import com.yanhuada.client.dao.ClientAuthorMapper;
import com.yanhuada.client.dao.ClientWeeklyMapper;
import com.yanhuada.client.model.weekly.WeeklyPoToDto;
import com.yanhuada.client.model.weekly.req.WeeklyPagerReq;
import com.yanhuada.client.model.weekly.rsp.WeeklyDetailRsp;
import com.yanhuada.client.model.weekly.rsp.WeeklyPagerRsp;
import com.yanhuada.client.service.ClientWeeklyService;
import com.yanhuada.common.model.Pager;
import com.yanhuada.common.util.aliyun.oss.OssUtil;
import com.yanhuada.model.Author;
import com.yanhuada.model.Weekly;
import com.yanhuada.service.impl.BaseWeeklyServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yanhuada
 * CREATE ON 2020/8/16 19:33
 */
@Service
public class ClientWeeklyServiceImpl extends BaseWeeklyServiceImpl implements ClientWeeklyService {

    @Resource
    private ClientWeeklyMapper clientWeeklyMapper;
    @Resource
    private ClientAuthorMapper clientAuthorMapper;
    @Resource
    private OssUtil ossUtil;

    @Override
    public Pager<WeeklyPagerRsp> pagination(WeeklyPagerReq req) {
        Pager<WeeklyPagerRsp> rspPager = new Pager<>(req.getPage(), req.getCount());
        Long total = clientWeeklyMapper.total();
        rspPager.setTotal(Math.toIntExact(total));
        if (total == 0) {
            return rspPager;
        }
        List<Weekly> weeklyList = clientWeeklyMapper.list(req);
        rspPager.setArray(weeklyList.stream()
                .map(weekly -> WeeklyPoToDto.copyWeeklyPagerRsp(weekly,clientAuthorMapper.selectByPrimaryKey(weekly.getAuthorId()),ossUtil))
                .collect(Collectors.toList()));
        return rspPager;
    }

    @Override
    public WeeklyDetailRsp detail(Long id) {
        Weekly weekly = super.findByIdOrFail(id);
        Author author = clientAuthorMapper.selectByPrimaryKey(weekly.getAuthorId());
        return WeeklyPoToDto.copyWeeklyDetailRsp(weekly, author, ossUtil);
    }
}
