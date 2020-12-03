package com.yanhuada.client.model.artspeak.req;

import com.yanhuada.common.model.PagerDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * @author yanhuada
 * CREATE ON 2020/8/18 13:50
 */
@Setter
@Getter
@ApiModel(value = "句子请求分页参数")
public class ArtSpeakPagerReq extends PagerDto {
    @NotNull(message = "分类ID不能为空")
    @ApiModelProperty(value = "说话的艺术分类ID")
    private Long artSpeakTypeId;
}
