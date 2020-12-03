package com.yanhuada.client.controller;

import com.yanhuada.client.model.feedback.req.FeedbackAddReq;
import com.yanhuada.client.service.ClientFeedbackService;
import com.yanhuada.common.model.ResponseDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author yanhuada
 * CREATE ON 2020/8/10 17:04
 */
@Api(tags = "意见反馈接口")
@Validated
@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {

    @Resource
    private ClientFeedbackService clientFeedbackService;

    @ApiOperation(value = "新增意见反馈", nickname = "add")
    @PostMapping(value = "add")
    public ResponseDto add(@Validated @RequestBody FeedbackAddReq req) {
        clientFeedbackService.add(req.getContent());
        return new ResponseDto();
    }

}
