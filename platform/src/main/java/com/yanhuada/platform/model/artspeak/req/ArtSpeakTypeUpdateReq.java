package com.yanhuada.platform.model.artspeak.req;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * @author yanhuada
 * CREATE ON 2020/8/17 14:01
 */
@Setter
@Getter
@ApiModel(value = "句子类型修改参数")
public class ArtSpeakTypeUpdateReq extends ArtSpeakTypeAddReq {
    @NotNull(message = "id不能为空")
    public Long id;
}
