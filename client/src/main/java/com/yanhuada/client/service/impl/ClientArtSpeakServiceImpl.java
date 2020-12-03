package com.yanhuada.client.service.impl;

import com.yanhuada.client.dao.ClientArtSpeakMapper;
import com.yanhuada.client.dao.ClientArtSpeakRecordMapper;
import com.yanhuada.client.dao.ClientArtSpeakTypeMapper;
import com.yanhuada.client.jwt.JwtSessionUtil;
import com.yanhuada.client.model.artspeak.ArtSpeakPoToDto;
import com.yanhuada.client.model.artspeak.req.ArtSpeakPagerReq;
import com.yanhuada.client.model.artspeak.rsp.ArtSpeakPagerRsp;
import com.yanhuada.client.model.artspeak.rsp.ArtSpeakTypeListRsp;
import com.yanhuada.client.service.ClientArtSpeakService;
import com.yanhuada.common.model.Pager;
import com.yanhuada.model.ArtSpeak;
import com.yanhuada.model.ArtSpeakRecord;
import com.yanhuada.model.ArtSpeakType;
import com.yanhuada.model.ArtSpeakTypeExample;
import com.yanhuada.service.impl.BaseArtSpeakServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yanhuada
 * CREATE ON 2020/8/18 13:52
 */
@Service
public class ClientArtSpeakServiceImpl extends BaseArtSpeakServiceImpl implements ClientArtSpeakService {

    @Resource
    private ClientArtSpeakTypeMapper clientArtSpeakTypeMapper;
    @Resource
    private ClientArtSpeakMapper clientArtSpeakMapper;
    @Resource
    private ClientArtSpeakRecordMapper clientArtSpeakRecordMapper;
    @Resource
    private JwtSessionUtil jwtSessionUtil;
    @Resource
    private HttpServletRequest request;

    @Override
    public List<ArtSpeakTypeListRsp> typeList() {
        ArtSpeakTypeExample example = new ArtSpeakTypeExample();
        example.createCriteria().andIfEnableEqualTo(true);
        example.setOrderByClause("sort desc");
        List<ArtSpeakType> artSpeakTypeList = clientArtSpeakTypeMapper.selectByExample(example);
        return artSpeakTypeList.stream().map(ArtSpeakPoToDto::copyArtSpeakTypeListRsp).collect(Collectors.toList());
    }

    @Override
    public Pager<ArtSpeakPagerRsp> pagination(ArtSpeakPagerReq req) {
        Pager<ArtSpeakPagerRsp> rspPager = new Pager<>(req.getPage(), req.getCount());
        Long total = clientArtSpeakMapper.total(req.getArtSpeakTypeId());
        rspPager.setTotal(Math.toIntExact(total));
        if (total == 0) {
            return rspPager;
        }
        List<ArtSpeak> artSpeakList = clientArtSpeakMapper.list(req.getArtSpeakTypeId(), req);
        rspPager.setArray(artSpeakList.stream()
                .map(artSpeak -> ArtSpeakPoToDto.copyArtSpeakPagerRsp(artSpeak, null))
                .collect(Collectors.toList()));

        if (!jwtSessionUtil.ifAnonymous(request)) {
            Long userId = jwtSessionUtil.getUserIdFromAuthenticatedSession(request);
            List<Long> idList = artSpeakList.stream().map(ArtSpeak::getId).collect(Collectors.toList());
            this.artSpeakRecordBatchInsert(userId, idList);
        }
        return rspPager;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public void artSpeakRecordBatchInsert(Long userId, List<Long> artSpeakIdList) {
        List<ArtSpeakRecord> artSpeakRecordList = artSpeakIdList.stream()
                .map(id -> {
                    ArtSpeakRecord artSpeakRecord = new ArtSpeakRecord();
                    artSpeakRecord.setArtSpeakId(id);
                    artSpeakRecord.setUserId(userId);
                    return artSpeakRecord;
                })
                .collect(Collectors.toList());
        clientArtSpeakRecordMapper.batchInsert(artSpeakRecordList);
    }
}
