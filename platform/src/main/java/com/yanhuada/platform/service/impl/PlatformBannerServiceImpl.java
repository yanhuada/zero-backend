package com.yanhuada.platform.service.impl;

import com.yanhuada.common.util.aliyun.oss.OssUtil;
import com.yanhuada.model.Banner;
import com.yanhuada.model.BannerExample;
import com.yanhuada.platform.dao.PlatformBannerMapper;
import com.yanhuada.platform.model.banner.BannerPoToDto;
import com.yanhuada.platform.model.banner.rsp.BannerListRsp;
import com.yanhuada.platform.service.PlatformBannerService;
import com.yanhuada.service.impl.BaseBannerServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yanhuada
 * CREATE ON 2020/8/18 10:40
 */
@Service
public class PlatformBannerServiceImpl extends BaseBannerServiceImpl implements PlatformBannerService {

    @Resource
    private PlatformBannerMapper platformBannerMapper;
    @Resource
    private OssUtil ossUtil;

    @Override
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public void add(String title, String imageKey, String link, Integer sort, Boolean ifEnable) {
        Banner bannerForAdd = this.generateBanner(title, imageKey, link, sort, ifEnable);
        platformBannerMapper.insertSelective(bannerForAdd);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public void update(Long id, String title, String imageKey, String link, Integer sort, Boolean ifEnable) {
        Banner banner = super.findByIdOrFail(id);
        Banner bannerForUpdate = this.generateBanner(title, imageKey, link, sort, ifEnable);
        bannerForUpdate.setId(banner.getId());
        platformBannerMapper.updateByPrimaryKeySelective(bannerForUpdate);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public void sort(Long id, Integer sort) {
        Banner banner = super.findByIdOrFail(id);
        banner.setSort(sort);
        platformBannerMapper.updateByPrimaryKeySelective(banner);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public void enable(Long id, Boolean enable) {
        Banner banner = super.findByIdOrFail(id);
        banner.setIfEnable(enable);
        platformBannerMapper.updateByPrimaryKeySelective(banner);
    }

    @Override
    public List<BannerListRsp> list() {
        BannerExample example = new BannerExample();
        example.setOrderByClause("sort desc");
        List<Banner> bannerList = platformBannerMapper.selectByExample(example);
        return bannerList.stream()
                .map(banner -> BannerPoToDto.copyBannerListRsp(banner, ossUtil))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public void delete(Long id) {
        Banner banner = super.findByIdOrFail(id);
        platformBannerMapper.deleteByPrimaryKey(banner.getId());
    }

    private Banner generateBanner(String title, String imageKey, String link, Integer sort, Boolean ifEnable) {
        Banner bannerForAdd = new Banner();
        bannerForAdd.setTitle(title);
        bannerForAdd.setImageKey(imageKey);
        bannerForAdd.setLink(link);
        bannerForAdd.setSort(sort);
        bannerForAdd.setIfEnable(ifEnable);
        return bannerForAdd;
    }
}
