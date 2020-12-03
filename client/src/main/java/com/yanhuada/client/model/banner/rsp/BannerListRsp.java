package com.yanhuada.client.model.banner.rsp;

import com.alibaba.fastjson.annotation.JSONField;
import com.yanhuada.common.model.IdLongToStrSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author yanhuada
 * CREATE ON 2020/8/10 17:02
 */
@Data
@ApiModel(value = "banner列表参数")
public class BannerListRsp {

    @JSONField(serializeUsing = IdLongToStrSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value="标题")
    private String title;

    @ApiModelProperty(value="图片链接")
    private String imageUrl;

    @ApiModelProperty(value="跳转链接")
    private String link;
}
