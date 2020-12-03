package com.yanhuada.platform.controller;

import com.yanhuada.common.enumeration.WeeklyStatus;
import com.yanhuada.common.model.IdReq;
import com.yanhuada.common.model.PagerResponseDto;
import com.yanhuada.common.model.ResponseDto;
import com.yanhuada.platform.model.weekly.req.WeeklyAddReq;
import com.yanhuada.platform.model.weekly.req.WeeklyPagerReq;
import com.yanhuada.platform.model.weekly.req.WeeklyUpdateReq;
import com.yanhuada.platform.model.weekly.rsp.WeeklyDetailRsp;
import com.yanhuada.platform.model.weekly.rsp.WeeklyPagerRsp;
import com.yanhuada.platform.service.PlatformWeeklyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author yanhuada
 * CREATE ON 2020/8/13 13:33
 */
@Api(tags = "周刊相关接口")
@Validated
@RestController
@RequestMapping("/pf-api/weekly")
public class WeeklyController {

    @Resource
    private PlatformWeeklyService platformWeeklyService;

    @ApiOperation(value = "新增", nickname = "add")
    @PostMapping(value = "add")
    public ResponseDto add(@Validated @RequestBody WeeklyAddReq req) {
        platformWeeklyService.add(req);
        return new ResponseDto();
    }

    @ApiOperation(value = "编辑", nickname = "update")
    @PostMapping(value = "update")
    public ResponseDto update(@Validated @RequestBody WeeklyUpdateReq req) {
        platformWeeklyService.update(req);
        return new ResponseDto();
    }

    @ApiOperation(value = "分页", nickname = "pagination")
    @GetMapping(value = "pagination")
    public PagerResponseDto<WeeklyPagerRsp> pagination(@Validated WeeklyPagerReq req) {
        return new PagerResponseDto<>(platformWeeklyService.pagination(req));
    }

    @ApiOperation(value = "详情", nickname = "detail")
    @GetMapping(value = "detail")
    public ResponseDto<WeeklyDetailRsp> detail(@Validated IdReq req) {
        return new ResponseDto<>(platformWeeklyService.detail(req.getId()));
    }

    @ApiOperation(value = "上架", nickname = "publish")
    @PostMapping(value = "publish")
    public ResponseDto publish(@Validated @RequestBody IdReq req) {
        platformWeeklyService.updateStatus(req.getId(), WeeklyStatus.PUBLISHED);
        return new ResponseDto();
    }

    @ApiOperation(value = "下架", nickname = "off")
    @PostMapping(value = "off")
    public ResponseDto off(@Validated @RequestBody IdReq req) {
        platformWeeklyService.updateStatus(req.getId(), WeeklyStatus.OFF);
        return new ResponseDto();
    }

    @ApiOperation(value = "删除", nickname = "delete")
    @PostMapping(value = "delete")
    public ResponseDto delete(@Validated @RequestBody IdReq req) {
        platformWeeklyService.delete(req.getId());
        return new ResponseDto();
    }

    @ApiOperation(value = "周刊评论分页", nickname = "weekly/comment/pagination")
    @GetMapping(value = "weekly/comment/pagination")
    public PagerResponseDto weeklyCommentPagination() {

        return new PagerResponseDto();
    }

    @ApiOperation(value = "周刊子评论分页", nickname = "weekly/sub/comment/pagination")
    @GetMapping(value = "weekly/sub/comment/pagination")
    public PagerResponseDto weeklySubCommentPagination() {

        return new PagerResponseDto();
    }

    @ApiOperation(value = "删除评论", nickname = "weekly/comment/delete")
    @PostMapping(value = "weekly/comment/delete")
    public ResponseDto weeklyCommentDelete() {

        return new ResponseDto();
    }
}
