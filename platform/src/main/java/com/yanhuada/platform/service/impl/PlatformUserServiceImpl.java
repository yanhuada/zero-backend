package com.yanhuada.platform.service.impl;

import com.yanhuada.common.model.Pager;
import com.yanhuada.common.util.aliyun.oss.OssUtil;
import com.yanhuada.exception.CommonException;
import com.yanhuada.exception.ErrorCode;
import com.yanhuada.model.Author;
import com.yanhuada.model.AuthorExample;
import com.yanhuada.model.User;
import com.yanhuada.platform.dao.PlatformAuthorMapper;
import com.yanhuada.platform.dao.PlatformUserMapper;
import com.yanhuada.platform.model.user.UserPoToDto;
import com.yanhuada.platform.model.user.req.UserPagerReq;
import com.yanhuada.platform.model.user.rsp.UserAuthorRsp;
import com.yanhuada.platform.model.user.rsp.UserDetailRsp;
import com.yanhuada.platform.model.user.rsp.UserPagerRsp;
import com.yanhuada.platform.service.PlatformUserService;
import com.yanhuada.service.impl.BaseUserServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yanhuada
 * CREATE ON 2020/8/10 18:17
 */
@Service
public class PlatformUserServiceImpl extends BaseUserServiceImpl implements PlatformUserService {


    @Resource
    private PlatformUserMapper platformUserMapper;
    @Resource
    private PlatformAuthorMapper platformAuthorMapper;
    @Resource
    private OssUtil ossUtil;

    @Override
    public Pager<UserPagerRsp> pagination(UserPagerReq req) {
        Pager<UserPagerRsp> rspPager = new Pager<>(req.getPage(), req.getCount());
        Long total = platformUserMapper.total(req.getPhone(), req.getNickname(), null, null, req.getIfEnable());
        rspPager.setTotal(Math.toIntExact(total));
        if (total == 0) {
            return rspPager;
        }
        List<User> userList = platformUserMapper.list(req.getPhone(), req.getNickname(), null, null, req.getIfEnable(), req);
        rspPager.setArray(userList.stream()
                .map(user -> UserPoToDto.copyUserPagerRsp(user, ossUtil))
                .collect(Collectors.toList()));
        return rspPager;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public void enable(Long id, boolean ifEnable) {
        User user = super.findByIdFail(id);
        user.setIfEnable(ifEnable);
        platformUserMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public UserDetailRsp detail(Long id) {
        User user = super.findByIdFail(id);
        return UserPoToDto.copyUserDetailRsp(user);
    }

    @Override
    public List<UserAuthorRsp> authorList() {
        List<Author> authorList = platformAuthorMapper.selectByExample(new AuthorExample());
        return authorList.stream()
                .map(author -> UserPoToDto.copyUserAuthorRsp(author, ossUtil))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public void authorSet(Long userId) {
        User user = super.findByIdFail(userId);
        Author author = platformAuthorMapper.findByUserId(user.getId());
        if (author != null) {
            throw new CommonException(ErrorCode.AUTHOR_ALREADY_EXISTS);
        }

        Author authorForAdd = new Author();
        authorForAdd.setUserId(user.getId());
        authorForAdd.setUserNickname(user.getNickname());
        authorForAdd.setUserAvatar(user.getAvatar());

        platformAuthorMapper.insertSelective(authorForAdd);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public void authorDelete(Long userId) {
        User user = super.findByIdFail(userId);
        Author author = platformAuthorMapper.findByUserId(user.getId());
        platformAuthorMapper.deleteByPrimaryKey(author.getId());
    }

    @Override
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public void customerServiceSet(Long userId) {
        User user = super.findByIdFail(userId);
        user.setIfCustomerService(true);
        platformUserMapper.updateByPrimaryKeySelective(user);
    }
}
