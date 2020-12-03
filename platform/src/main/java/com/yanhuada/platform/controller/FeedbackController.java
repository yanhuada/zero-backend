package com.yanhuada.platform.controller;

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
 * CREATE ON 2020/8/13 14:53
 */
@Api(tags = "意见反馈相关接口")
@Validated
@RestController
@RequestMapping("/pf-api/feedback")
public class FeedbackController {

    @ApiOperation(value = "意见反馈分页", nickname = "pagination")
    @GetMapping(value = "pagination")
    public PagerResponseDto pagination() {

        return new PagerResponseDto();
    }

    @ApiOperation(value = "设置已处理", nickname = "handle")
    @PostMapping(value = "handle")
    public ResponseDto handle() {
        return new ResponseDto();
    }
}
