package com.yanhuada.platform.controller;

import com.aliyuncs.sts.model.v20150401.AssumeRoleResponse;
import com.yanhuada.common.model.ResponseDto;
import com.yanhuada.common.util.aliyun.sts.StsToken;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author yanhuada
 * CREATE ON 2020/8/12 23:05
 */
@Api(tags = "阿里云接口管理")
@Validated
@RestController
@RequestMapping("/pf-api/aliyun")
public class AliyunController {

    @Resource
    private StsToken stsToken;

    @ApiOperation(value = "sts token", nickname = "sts/token")
    @GetMapping(value = "sts/token")
    public ResponseDto<AssumeRoleResponse> stsToken(){
        return new ResponseDto<>(stsToken.get());
    }
}
