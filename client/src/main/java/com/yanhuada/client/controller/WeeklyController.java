package com.yanhuada.client.controller;

import com.yanhuada.client.model.weekly.req.WeeklyPagerReq;
import com.yanhuada.client.model.weekly.rsp.WeeklyDetailRsp;
import com.yanhuada.client.model.weekly.rsp.WeeklyPagerRsp;
import com.yanhuada.client.service.ClientWeeklyService;
import com.yanhuada.common.model.IdReq;
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
 * CREATE ON 2020/8/10 17:14
 */
@Api(tags = "周刊相关")
@Validated
@RestController
@RequestMapping("/api/weekly")
public class WeeklyController {

    @Resource
    private ClientWeeklyService clientWeeklyService;

    @ApiOperation(value = "周刊分页", nickname = "pagination")
    @GetMapping(value = "pagination")
    public PagerResponseDto<WeeklyPagerRsp> pagination(@Validated WeeklyPagerReq req) {
        return new PagerResponseDto<>(clientWeeklyService.pagination(req));
    }

    @ApiOperation(value = "周刊详情", nickname = "detail")
    @GetMapping(value = "detail")
    public ResponseDto<WeeklyDetailRsp> detail(@Validated IdReq req) {
        return new ResponseDto<>(clientWeeklyService.detail(req.getId()));
    }
}
