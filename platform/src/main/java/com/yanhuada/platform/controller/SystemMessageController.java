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
 * CREATE ON 2020/8/13 15:19
 */
@Api(tags = "系统信息相关接口")
@Validated
@RestController
@RequestMapping("/pf-api/system/message")
public class SystemMessageController {

    @ApiOperation(value = "新增", nickname = "add")
    @PostMapping(value = "add")
    public ResponseDto add() {
        return new ResponseDto();
    }

    @ApiOperation(value = "删除", nickname = "delete")
    @PostMapping(value = "delete")
    public ResponseDto delete() {
        return new ResponseDto();
    }

    @ApiOperation(value = "分页", nickname = "pagination")
    @GetMapping(value = "pagination")
    public PagerResponseDto pagination() {

        return new PagerResponseDto();
    }

}
