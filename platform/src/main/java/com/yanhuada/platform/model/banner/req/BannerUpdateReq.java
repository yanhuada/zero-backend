package com.yanhuada.platform.model.banner.req;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * @author yanhuada
 * CREATE ON 2020/8/18 10:39
 */
@Setter
@Getter
@ApiModel(value = "banner修改参数")
public class BannerUpdateReq extends BannerAddReq {
    @NotNull(message = "id不能为空")
    public Long id;
}
