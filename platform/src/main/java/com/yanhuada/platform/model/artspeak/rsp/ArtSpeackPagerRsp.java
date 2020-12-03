package com.yanhuada.platform.model.artspeak.rsp;

import com.alibaba.fastjson.annotation.JSONField;
import com.yanhuada.common.model.IdLongToStrSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author yanhuada
 * CREATE ON 2020/8/17 13:02
 */
@Data
@ApiModel(value = "说话的艺术分页列表")
public class ArtSpeackPagerRsp {
    @JSONField(serializeUsing = IdLongToStrSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;
    @ApiModelProperty(value="说话的艺术分类ID")
    private Long artSpeakTypeId;
    @JSONField(serializeUsing = IdLongToStrSerializer.class)
    @ApiModelProperty(value="说话的艺术分类名称")
    private String artSpeakTypeName;
    @ApiModelProperty(value="内容")
    private String content;
    @ApiModelProperty(value="点赞数量")
    private Integer likeNum;
    @ApiModelProperty(value="不喜欢数量")
    private Integer dislikeNum;
    @ApiModelProperty(value="是否启用")
    private Boolean ifEnable;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createdAt;
}
