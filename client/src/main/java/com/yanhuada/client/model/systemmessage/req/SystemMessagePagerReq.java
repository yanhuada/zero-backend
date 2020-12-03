package com.yanhuada.client.model.systemmessage.req;

import com.yanhuada.common.model.PagerDto;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

/**
 * @author yanhuada
 * CREATE ON 2020/8/24 15:07
 */
@Setter
@Getter
@ApiModel(value = "系统信息分页请求参数")
public class SystemMessagePagerReq extends PagerDto {
}
