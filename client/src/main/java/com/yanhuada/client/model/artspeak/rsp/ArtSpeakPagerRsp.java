package com.yanhuada.client.model.artspeak.rsp;

import com.alibaba.fastjson.annotation.JSONField;
import com.yanhuada.common.model.IdLongToStrSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author yanhuada
 * CREATE ON 2020/8/18 13:48
 */
@Data
@ApiModel(value = "句子分页参数")
public class ArtSpeakPagerRsp {
    @JSONField(serializeUsing = IdLongToStrSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;
    @ApiModelProperty(value="内容")
    private String content;
    @ApiModelProperty(value="点赞数量")
    private Integer likeNum;
    @ApiModelProperty(value="不喜欢数量")
    private Integer dislikeNum;
    @ApiModelProperty(value="态度 0：不知道 1：喜欢 2：不喜欢")
    private Integer attitude;
}
