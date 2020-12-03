package com.yanhuada.platform.controller;

import com.yanhuada.common.model.EnableReq;
import com.yanhuada.common.model.ListResponseDto;
import com.yanhuada.common.model.ResponseDto;
import com.yanhuada.platform.model.commonproblem.req.CommonProblemAddReq;
import com.yanhuada.platform.model.commonproblem.req.CommonProblemUpdateReq;
import com.yanhuada.platform.model.commonproblem.rsp.CommonProblemListRsp;
import com.yanhuada.platform.service.PlatfromCommonProblemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author yanhuada
 * CREATE ON 2020/8/13 14:49
 */
@Api(tags = "常见问题相关接口")
@Validated
@RestController
@RequestMapping("/pf-api/common/problem")
public class CommonProblemController {

    @Resource
    private PlatfromCommonProblemService platfromCommonProblemService;

    @ApiOperation(value = "新增", nickname = "add")
    @PostMapping(value = "add")
    public ResponseDto add(@Validated @RequestBody CommonProblemAddReq req) {
        platfromCommonProblemService.add(req.getTitle(), req.getIfEnable(), req.getContent());
        return new ResponseDto();
    }

    @ApiOperation(value = "编辑", nickname = "update")
    @PostMapping(value = "update")
    public ResponseDto update(@Validated @RequestBody CommonProblemUpdateReq req) {
        platfromCommonProblemService.update(req.getId(), req.getTitle(), req.getIfEnable(), req.getContent());
        return new ResponseDto();
    }

    @ApiOperation(value = "是否启用", nickname = "enable")
    @PostMapping(value = "enable")
    public ResponseDto enable(@Validated @RequestBody EnableReq req) {
        platfromCommonProblemService.enable(req.getId(), req.getIfEnable());
        return new ResponseDto();
    }

    @ApiOperation(value = "列表", nickname = "list")
    @GetMapping(value = "list")
    public ListResponseDto<CommonProblemListRsp> list() {
        return new ListResponseDto<>(platfromCommonProblemService.list());
    }
}
