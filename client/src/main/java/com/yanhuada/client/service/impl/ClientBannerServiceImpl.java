package com.yanhuada.client.service.impl;

import com.yanhuada.client.dao.ClientBannerMapper;
import com.yanhuada.client.model.banner.BannerPoToDto;
import com.yanhuada.client.model.banner.rsp.BannerListRsp;
import com.yanhuada.client.service.ClientBannerService;
import com.yanhuada.common.util.aliyun.oss.OssUtil;
import com.yanhuada.model.Banner;
import com.yanhuada.model.BannerExample;
import com.yanhuada.service.impl.BaseBannerServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yanhuada
 * CREATE ON 2020/8/10 17:49
 */
@Service
public class ClientBannerServiceImpl extends BaseBannerServiceImpl implements ClientBannerService {

    @Resource
    private ClientBannerMapper clientBannerMapper;
    @Resource
    private OssUtil ossUtil;

    @Override
    public List<BannerListRsp> list() {
        BannerExample example = new BannerExample();
        example.createCriteria().andIfEnableEqualTo(true);
        example.setOrderByClause("sort desc");
        List<Banner> bannerList = clientBannerMapper.selectByExample(example);
        return bannerList.stream()
                .map(banner -> BannerPoToDto.copyBannerListRsp(banner,ossUtil))
                .collect(Collectors.toList());
    }
}
