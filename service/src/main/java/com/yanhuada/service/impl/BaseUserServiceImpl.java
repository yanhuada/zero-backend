package com.yanhuada.service.impl;

import com.yanhuada.dao.mapper.AuthorMapper;
import com.yanhuada.dao.mapper.UserMapper;
import com.yanhuada.exception.CommonException;
import com.yanhuada.exception.ErrorCode;
import com.yanhuada.model.Author;
import com.yanhuada.model.User;
import com.yanhuada.service.BaseUserService;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @author yanhuada
 * CREATE ON 2020/8/8 14:06
 */
public class BaseUserServiceImpl implements BaseUserService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private AuthorMapper authorMapper;

    @Override
    public User findById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public User findByIdFail(Long id) {
        return Optional.ofNullable(findById(id)).orElseThrow(() -> new CommonException(ErrorCode.USER_NOT_FONT));
    }

    @Override
    public Author findAuthorById(Long authorId) {
        return authorMapper.selectByPrimaryKey(authorId);
    }

    @Override
    public Author findAuthorByIdOrFail(Long authorId) {
        return Optional.ofNullable(findAuthorById(authorId)).orElseThrow(() -> new CommonException(ErrorCode.AUTHOR_NOT_FOUND));
    }
}
