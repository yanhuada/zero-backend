package com.yanhuada.platform.controller;

import com.yanhuada.common.model.IdReq;
import com.yanhuada.common.model.ListResponseDto;
import com.yanhuada.common.model.ResponseDto;
import com.yanhuada.platform.model.banner.req.BannerAddReq;
import com.yanhuada.platform.model.banner.req.BannerEnableReq;
import com.yanhuada.platform.model.banner.req.BannerSortUpdateReq;
import com.yanhuada.platform.model.banner.req.BannerUpdateReq;
import com.yanhuada.platform.model.banner.rsp.BannerListRsp;
import com.yanhuada.platform.service.PlatformBannerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author yanhuada
 * CREATE ON 2020/8/13 14:23
 */
@Api(tags = "Banner相关接口")
@Validated
@RestController
@RequestMapping("/pf-api/banner")
public class BannerController {

    @Resource
    private PlatformBannerService platformBannerService;

    @ApiOperation(value = "banner列表", nickname = "list")
    @GetMapping(value = "list")
    public ListResponseDto<BannerListRsp> list() {
        return new ListResponseDto<>(platformBannerService.list());
    }

    @ApiOperation(value = "新增", nickname = "add")
    @PostMapping(value = "add")
    public ResponseDto add(@Validated @RequestBody BannerAddReq req) {
        platformBannerService.add(req.getTitle(), req.getImageKey(), req.getLink(), req.getSort(), req.getIfEnable());
        return new ResponseDto();
    }

    @ApiOperation(value = "修改", nickname = "update")
    @PostMapping(value = "update")
    public ResponseDto update(@Validated @RequestBody BannerUpdateReq req) {
        platformBannerService.update(req.getId(), req.getTitle(), req.getImageKey(), req.getLink(), req.getSort(), req.getIfEnable());
        return new ResponseDto();
    }

    @ApiOperation(value = "删除", nickname = "delete")
    @PostMapping(value = "delete")
    public ResponseDto delete(@Validated @RequestBody IdReq req) {
        platformBannerService.delete(req.getId());
        return new ResponseDto();
    }

    @ApiOperation(value = "设置顺序", nickname = "sort")
    @PostMapping(value = "sort")
    public ResponseDto sort(@Validated @RequestBody BannerSortUpdateReq req) {
        platformBannerService.sort(req.getId(), req.getSort());
        return new ResponseDto();
    }

    @ApiOperation(value = "设置是否启动", nickname = "enable")
    @PostMapping(value = "enable")
    public ResponseDto enable(@Validated @RequestBody BannerEnableReq req) {
        platformBannerService.enable(req.getId(), req.getIfEnable());
        return new ResponseDto();
    }
}
