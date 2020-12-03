package com.yanhuada.platform.controller;

import com.yanhuada.common.model.IdReq;
import com.yanhuada.common.model.ListResponseDto;
import com.yanhuada.common.model.PagerResponseDto;
import com.yanhuada.common.model.ResponseDto;
import com.yanhuada.platform.model.artspeak.req.*;
import com.yanhuada.platform.model.artspeak.rsp.ArtSpeackPagerRsp;
import com.yanhuada.platform.model.artspeak.rsp.ArtSpeakTypeListRsp;
import com.yanhuada.platform.service.PlatformArtSpeakService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author yanhuada
 * CREATE ON 2020/8/13 15:27
 */
@Api(tags = "说话的艺术相关接口")
@Validated
@RestController
@RequestMapping("/pf-api/ark/speak")
public class ArtSpeakController {

    @Resource
    private PlatformArtSpeakService platformArtSpeakService;

    @ApiOperation(value = "新增类型", nickname = "type/add")
    @PostMapping(value = "type/add")
    public ResponseDto typeAdd(@Validated @RequestBody ArtSpeakTypeAddReq req) {
        platformArtSpeakService.typeAdd(req.getName(), req.getSort(), req.getIfEnable());
        return new ResponseDto();
    }

    @ApiOperation(value = "编辑类型", nickname = "type/update")
    @PostMapping(value = "type/update")
    public ResponseDto typeUpdate(@Validated @RequestBody ArtSpeakTypeUpdateReq req) {
        platformArtSpeakService.typeUpdate(req.getId(), req.getName(), req.getSort(), req.getIfEnable());
        return new ResponseDto();
    }

    @ApiOperation(value = "删除类型", nickname = "type/delete")
    @PostMapping(value = "type/delete")
    public ResponseDto typeDelete(@Validated @RequestBody IdReq req) {
        platformArtSpeakService.typeDelete(req.getId());
        return new ResponseDto();
    }

    @ApiOperation(value = "类型顺序", nickname = "type/sort")
    @PostMapping(value = "type/sort")
    public ResponseDto typeSort(@Validated @RequestBody ArtSpeakTypeSortUpdateReq req) {
        platformArtSpeakService.typeSort(req.getId(), req.getSort());
        return new ResponseDto();
    }

    @ApiOperation(value = "类型是否启动", nickname = "type/enable")
    @PostMapping(value = "type/enable")
    public ResponseDto typeEnable(@Validated @RequestBody ArtSpeakTypeEnableReq req) {
        platformArtSpeakService.typeEnable(req.getId(), req.getIfEnable());
        return new ResponseDto();
    }

    @ApiOperation(value = "类型列表", nickname = "type/list")
    @GetMapping(value = "type/list")
    public ListResponseDto<ArtSpeakTypeListRsp> typeList(@Validated ArtSpeakTypeListReq req) {
        return new ListResponseDto<>(platformArtSpeakService.typeList(req.getName(), req.getIfEnable()));
    }

    @ApiOperation(value = "新增", nickname = "add")
    @PostMapping(value = "add")
    public ResponseDto add(@Validated @RequestBody ArtSpeakAddReq req) {
        platformArtSpeakService.add(req.getArtSpeakTypeId(), req.getContent(), req.getIfEnable());
        return new ResponseDto();
    }

    @ApiOperation(value = "编辑", nickname = "update")
    @PostMapping(value = "update")
    public ResponseDto update(@Validated @RequestBody ArtSpeakUpdateReq req) {
        platformArtSpeakService.update(req.getId(), req.getContent(), req.getIfEnable());
        return new ResponseDto();
    }

    @ApiOperation(value = "删除", nickname = "delete")
    @PostMapping(value = "delete")
    public ResponseDto delete(@Validated @RequestBody IdReq req) {
        platformArtSpeakService.delete(req.getId());
        return new ResponseDto();
    }

    @ApiOperation(value = "句子是否启动", nickname = "enable")
    @PostMapping(value = "enable")
    public ResponseDto enable(@Validated @RequestBody ArtSpeakEnableReq req) {
        platformArtSpeakService.enable(req.getId(), req.getIfEnable());
        return new ResponseDto();
    }

    @ApiOperation(value = "分页", nickname = "pagination")
    @GetMapping(value = "pagination")
    public PagerResponseDto<ArtSpeackPagerRsp> pagination(@Validated ArtSpeakPagerReq req) {
        return new PagerResponseDto<>(platformArtSpeakService.pagination(req));
    }
}
