package com.yanhuada.service;

import com.yanhuada.model.Author;
import com.yanhuada.model.User;

/**
 * @author yanhuada
 * CREATE ON 2020/8/8 14:06
 */
public interface BaseUserService {

    /**
     * 根据ID查询用户
     *
     * @param id ID
     * @return user
     */
    User findById(Long id);

    /**
     * 根据ID查询用户，如果用户不存在，则抛出异常
     *
     * @param id ID
     * @return user
     */
    User findByIdFail(Long id);

    /**
     * 根据ID查询作者
     *
     * @param authorId 作者ID
     * @return 作者
     */
    Author findAuthorById(Long authorId);

    /**
     * 根据ID查询作者 为空时抛出异常
     *
     * @param authorId 作者ID
     * @return 作者
     */
    Author findAuthorByIdOrFail(Long authorId);


}
