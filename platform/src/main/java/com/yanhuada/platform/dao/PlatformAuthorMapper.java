package com.yanhuada.platform.dao;

import com.yanhuada.dao.mapper.AuthorMapper;
import com.yanhuada.model.Author;
import org.apache.ibatis.annotations.Param;

/**
 * @author yanhuada
 * CREATE ON 2020/8/14 16:28
 */
public interface PlatformAuthorMapper extends AuthorMapper {

    /**
     * 查询作者
     *
     * @param userId 用户ID
     * @return 作者
     */
    Author findByUserId(@Param("userId") Long userId);
}
