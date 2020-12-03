package com.yanhuada.platform.controller;

import com.yanhuada.common.model.ListResponseDto;
import com.yanhuada.common.model.PagerResponseDto;
import com.yanhuada.common.model.ResponseDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yanhuada
 * CREATE ON 2020/8/13 14:57
 */
@Api(tags = "短视频相关接口")
@Validated
@RestController
@RequestMapping("/pf-api/video")
public class SmallVideoController {

    @ApiOperation(value = "短视频分页", nickname = "pagination")
    @GetMapping(value = "pagination")
    public PagerResponseDto pagination() {

        return new PagerResponseDto();
    }

    @ApiOperation(value = "详情", nickname = "detail")
    @GetMapping(value = "detail")
    public ResponseDto detail() {

        return new ResponseDto();
    }

    @ApiOperation(value = "新增", nickname = "add")
    @PostMapping(value = "add")
    public ResponseDto add() {
        return new ResponseDto();
    }

    @ApiOperation(value = "编辑", nickname = "update")
    @PostMapping(value = "update")
    public ResponseDto update() {
        return new ResponseDto();
    }

    @ApiOperation(value = "上架 下架", nickname = "publish")
    @PostMapping(value = "publish")
    public ResponseDto publish() {
        return new ResponseDto();
    }

    @ApiOperation(value = "评论分页", nickname = "comment/pagination")
    @GetMapping(value = "comment/pagination")
    public PagerResponseDto commentPagination() {

        return new PagerResponseDto();
    }

    @ApiOperation(value = "子评论列表", nickname = "sub/comment/pagination")
    @GetMapping(value = "sub/comment/pagination")
    public ListResponseDto subCommentPagination() {

        return new ListResponseDto();
    }

    @ApiOperation(value = "删除评论", nickname = "comment/delete")
    @PostMapping(value = "comment/delete")
    public ResponseDto commentDelete() {

        return new ResponseDto();
    }
}
