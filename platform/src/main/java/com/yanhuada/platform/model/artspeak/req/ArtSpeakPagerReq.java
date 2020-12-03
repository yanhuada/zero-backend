package com.yanhuada.platform.model.artspeak.req;

import com.yanhuada.common.model.PagerDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author yanhuada
 * CREATE ON 2020/8/17 13:03
 */
@Setter
@Getter
@ApiModel(value = "说话的艺术分页请求参数")
public class ArtSpeakPagerReq extends PagerDto {
    @ApiModelProperty(value="说话的艺术分类ID")
    private Long artSpeakTypeId;
    @ApiModelProperty(value="内容")
    private String content;
    @ApiModelProperty(value="是否启用")
    private Boolean ifEnable;
}
