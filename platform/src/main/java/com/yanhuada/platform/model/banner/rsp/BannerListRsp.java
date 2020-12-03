package com.yanhuada.platform.model.banner.rsp;

import com.alibaba.fastjson.annotation.JSONField;
import com.yanhuada.common.model.IdLongToStrSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author yanhuada
 * CREATE ON 2020/8/18 10:45
 */
@Data
@ApiModel(value = "banner列表参数")
public class BannerListRsp {
    @JSONField(serializeUsing = IdLongToStrSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;
    @ApiModelProperty(value = "标题")
    private String title;
    @ApiModelProperty(value = "图片key值")
    private String imageKey;
    @ApiModelProperty(value = "图片url")
    private String imageUrl;
    @ApiModelProperty(value = "跳转链接")
    private String link;
    @ApiModelProperty(value = "顺序")
    private Integer sort;
    @ApiModelProperty(value = "是否启用")
    private Boolean ifEnable;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createdAt;
}
