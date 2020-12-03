package com.yanhuada.client.controller;

import com.yanhuada.client.model.banner.rsp.BannerListRsp;
import com.yanhuada.client.service.ClientBannerService;
import com.yanhuada.common.model.ListResponseDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author yanhuada
 * CREATE ON 2020/8/10 16:58
 */
@Api(tags = "Banner接口")
@Validated
@RestController
@RequestMapping("/api/banner")
public class BannerController {

    @Resource
    private ClientBannerService clientBannerService;

    @ApiOperation(value = "banner列表", nickname = "list")
    @GetMapping(value = "list")
    public ListResponseDto<BannerListRsp> list() {
        return new ListResponseDto<>(clientBannerService.list());
    }
}
