package com.yanhuada.client.model.weekly.req;

import com.yanhuada.common.model.PagerDto;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

/**
 * @author yanhuada
 * CREATE ON 2020/8/10 17:19
 */
@Setter
@Getter
@ApiModel(value = "周刊分页请求参数")
public class WeeklyPagerReq extends PagerDto {

}
