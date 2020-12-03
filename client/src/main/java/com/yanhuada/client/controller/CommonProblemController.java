package com.yanhuada.client.controller;

import com.yanhuada.client.model.commonproblem.rsp.CommonProblemDetailRsp;
import com.yanhuada.client.model.commonproblem.rsp.CommonProblemListRsp;
import com.yanhuada.client.service.ClientCommonProblemService;
import com.yanhuada.common.model.IdReq;
import com.yanhuada.common.model.ListResponseDto;
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
 * CREATE ON 2020/8/10 17:08
 */
@Api(tags = "常见问题接口")
@Validated
@RestController
@RequestMapping("/api/common-problem")
public class CommonProblemController {

    @Resource
    private ClientCommonProblemService clientCommonProblemService;

    @ApiOperation(value = "常见问题列表", nickname = "list")
    @GetMapping(value = "list")
    public ListResponseDto<CommonProblemListRsp> list() {
        return new ListResponseDto<>(clientCommonProblemService.list());
    }

    @ApiOperation(value = "详情", nickname = "detail")
    @GetMapping(value = "detail")
    public ResponseDto<CommonProblemDetailRsp> detail(@Validated IdReq req) {
        return new ResponseDto<>(clientCommonProblemService.detail(req.getId()));
    }

}
