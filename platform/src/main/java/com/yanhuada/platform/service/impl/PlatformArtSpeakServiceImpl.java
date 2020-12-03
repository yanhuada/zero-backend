package com.yanhuada.platform.service.impl;

import com.yanhuada.common.model.Pager;
import com.yanhuada.exception.CommonException;
import com.yanhuada.exception.ErrorCode;
import com.yanhuada.model.ArtSpeak;
import com.yanhuada.model.ArtSpeakType;
import com.yanhuada.platform.dao.PlatformArtSpeakMapper;
import com.yanhuada.platform.dao.PlatformArtSpeakRecordMapper;
import com.yanhuada.platform.dao.PlatformArtSpeakTypeMapper;
import com.yanhuada.platform.model.artspeak.ArtSpeakPoToDto;
import com.yanhuada.platform.model.artspeak.req.ArtSpeakPagerReq;
import com.yanhuada.platform.model.artspeak.rsp.ArtSpeackPagerRsp;
import com.yanhuada.platform.model.artspeak.rsp.ArtSpeakTypeListRsp;
import com.yanhuada.platform.service.PlatformArtSpeakService;
import com.yanhuada.service.impl.BaseArtSpeakServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yanhuada
 * CREATE ON 2020/8/17 12:53
 */
@Service
public class PlatformArtSpeakServiceImpl extends BaseArtSpeakServiceImpl implements PlatformArtSpeakService {

    @Resource
    private PlatformArtSpeakTypeMapper platformArtSpeakTypeMapper;
    @Resource
    private PlatformArtSpeakMapper platformArtSpeakMapper;
    @Resource
    private PlatformArtSpeakRecordMapper platformArtSpeakRecordMapper;

    @Override
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public void typeAdd(String name, Integer sort, Boolean ifEnable) {
        ArtSpeakType artSpeakType = platformArtSpeakTypeMapper.findByName(name);
        if (artSpeakType != null) {
            throw new CommonException(ErrorCode.ART_SPEAK_TYPE_EXISTS);
        }
        ArtSpeakType artSpeakTypeForAdd = new ArtSpeakType();
        artSpeakTypeForAdd.setName(name);
        artSpeakTypeForAdd.setSort(sort);
        artSpeakTypeForAdd.setIfEnable(ifEnable);
        platformArtSpeakTypeMapper.insertSelective(artSpeakTypeForAdd);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public void typeUpdate(Long id, String name, Integer sort, Boolean ifEnable) {
        ArtSpeakType artSpeakTypeForUpdate = super.findTypeByIdOrFail(id);
        if (!StringUtils.equals(artSpeakTypeForUpdate.getName(), name) && platformArtSpeakTypeMapper.findByName(name) != null) {
            throw new CommonException(ErrorCode.ART_SPEAK_TYPE_EXISTS);
        }
        artSpeakTypeForUpdate.setName(name);
        artSpeakTypeForUpdate.setSort(sort);
        artSpeakTypeForUpdate.setIfEnable(ifEnable);
        platformArtSpeakTypeMapper.updateByPrimaryKeySelective(artSpeakTypeForUpdate);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public void typeEnable(Long id, Boolean ifEnable) {
        ArtSpeakType artSpeakType = super.findTypeByIdOrFail(id);
        artSpeakType.setIfEnable(ifEnable);
        platformArtSpeakTypeMapper.updateByPrimaryKeySelective(artSpeakType);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public void typeSort(Long id, Integer sort) {
        ArtSpeakType artSpeakType = super.findTypeByIdOrFail(id);
        artSpeakType.setSort(sort);
        platformArtSpeakTypeMapper.updateByPrimaryKeySelective(artSpeakType);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public void typeDelete(Long id) {
        ArtSpeakType artSpeakType = super.findTypeByIdOrFail(id);
        platformArtSpeakTypeMapper.deleteByPrimaryKey(artSpeakType.getId());
    }

    @Override
    public List<ArtSpeakTypeListRsp> typeList(String name, Boolean ifEnable) {
        List<ArtSpeakType> artSpeakTypeList = platformArtSpeakTypeMapper.list(name, ifEnable);
        return artSpeakTypeList.stream().map(ArtSpeakPoToDto::copyArtSpeakTypeListRsp).collect(Collectors.toList());
    }

    @Override
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public void add(Long artSpeakTypeId, String content, Boolean ifEnable) {
        ArtSpeakType artSpeakType = super.findTypeByIdOrFail(artSpeakTypeId);
        ArtSpeak artSpeakForAdd = new ArtSpeak();
        artSpeakForAdd.setArtSpeakTypeId(artSpeakType.getId());
        artSpeakForAdd.setArtSpeakTypeName(artSpeakType.getName());
        artSpeakForAdd.setContent(content);
        artSpeakForAdd.setIfEnable(ifEnable);
        artSpeakForAdd.setDislikeNum(0);
        artSpeakForAdd.setLikeNum(0);
        platformArtSpeakMapper.insertSelective(artSpeakForAdd);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public void update(Long id, String content, Boolean ifEnable) {
        ArtSpeak artSpeak = super.findByIdOrFail(id);
        artSpeak.setContent(content);
        artSpeak.setIfEnable(ifEnable);
        platformArtSpeakMapper.updateByPrimaryKeySelective(artSpeak);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public void enable(Long id, Boolean ifEnable) {
        ArtSpeak artSpeak = super.findByIdOrFail(id);
        artSpeak.setIfEnable(ifEnable);
        platformArtSpeakMapper.updateByPrimaryKeySelective(artSpeak);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public void delete(Long id) {
        ArtSpeak artSpeak = super.findByIdOrFail(id);
        platformArtSpeakMapper.deleteByPrimaryKey(artSpeak.getId());
    }

    @Override
    public Pager<ArtSpeackPagerRsp> pagination(ArtSpeakPagerReq req) {
        Pager<ArtSpeackPagerRsp> rspPager = new Pager<>(req.getPage(), req.getCount());
        Long total = platformArtSpeakMapper.total(req.getArtSpeakTypeId(), req.getContent(), req.getIfEnable());
        rspPager.setTotal(Math.toIntExact(total));
        if (total == 0) {
            return rspPager;
        }

        List<ArtSpeak> artSpeakList = platformArtSpeakMapper.list(req.getArtSpeakTypeId(), req.getContent(), req.getIfEnable(), req);
        rspPager.setArray(artSpeakList.stream().map(ArtSpeakPoToDto::copyArtSpeackPagerRsp).collect(Collectors.toList()));
        return rspPager;
    }
}
