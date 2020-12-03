package com.yanhuada.client.controller;

import com.yanhuada.client.model.systemmessage.req.SystemMessagePagerReq;
import com.yanhuada.client.model.systemmessage.rsp.SystemMessageOverviewRsp;
import com.yanhuada.client.model.systemmessage.rsp.SystemMessagePagerRsp;
import com.yanhuada.client.service.ClientSystemMessageRecordService;
import com.yanhuada.common.model.PagerResponseDto;
import com.yanhuada.common.model.ResponseDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author yanhuada
 * CREATE ON 2020/8/10 17:34
 */
@Api(tags = "系统信息相关接口")
@Validated
@RestController
@RequestMapping("/api/system-message")
public class SystemMessageController {

    @Resource
    private ClientSystemMessageRecordService clientSystemMessageRecordService;

    @ApiOperation(value = "系统信息分页", nickname = "pagination")
    @GetMapping(value = "pagination")
    public PagerResponseDto<SystemMessagePagerRsp> pagination(@Validated SystemMessagePagerReq req) {
        return new PagerResponseDto<>(clientSystemMessageRecordService.pagination(req));
    }

    @ApiOperation(value = "新系统信息",nickname = "overview")
    @GetMapping(value = "overview")
    public ResponseDto<SystemMessageOverviewRsp> overview() {

        return new ResponseDto<>(clientSystemMessageRecordService.overview());
    }

}
