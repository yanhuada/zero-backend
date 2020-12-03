package com.yanhuada.common.model;

/**
 * @author yanhuada
 * CREATE ON 2020/3/14 17:41
 */
public class BaseModelWithId extends BaseModel {
    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
