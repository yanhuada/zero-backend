package com.yanhuada.client.controller;

import com.yanhuada.client.model.artspeak.req.ArtSpeakPagerReq;
import com.yanhuada.client.model.artspeak.rsp.ArtSpeakPagerRsp;
import com.yanhuada.client.model.artspeak.rsp.ArtSpeakTypeListRsp;
import com.yanhuada.client.service.ClientArtSpeakService;
import com.yanhuada.common.model.IdReq;
import com.yanhuada.common.model.ListResponseDto;
import com.yanhuada.common.model.PagerResponseDto;
import com.yanhuada.common.model.ResponseDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author yanhuada
 * CREATE ON 2020/8/10 17:36
 */
@Api(tags = "说话的艺术相关接口")
@Validated
@RestController
@RequestMapping("/api/art-speak")
public class ArtSpeakController {
    @Resource
    private ClientArtSpeakService clientArtSpeakService;

    @ApiOperation(value = "类型列表", nickname = "type/list")
    @GetMapping(value = "type/list")
    public ListResponseDto<ArtSpeakTypeListRsp> typeList() {
        return new ListResponseDto<>(clientArtSpeakService.typeList());
    }

    @ApiOperation(value = "句子分页", nickname = "pagination")
    @GetMapping(value = "pagination")
    public PagerResponseDto<ArtSpeakPagerRsp> pagination(@Validated ArtSpeakPagerReq req) {
        return new PagerResponseDto<>(clientArtSpeakService.pagination(req));
    }

    @ApiOperation(value = "喜欢",nickname = "like")
    @PostMapping(value = "like")
    public ResponseDto like(@Validated @RequestBody IdReq req) {

        return new ResponseDto();
    }

    @ApiOperation(value = "不喜欢",nickname = "dislike")
    @PostMapping(value = "dislike")
    public ResponseDto dislike(@Validated @RequestBody IdReq req) {

        return new ResponseDto();
    }
}
