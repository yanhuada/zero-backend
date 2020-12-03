package com.yanhuada.client.service.impl;

import cn.binarywang.wx.miniapp.bean.WxMaUserInfo;
import com.yanhuada.client.dao.ClientUserMapper;
import com.yanhuada.client.jwt.JwtSessionUtil;
import com.yanhuada.client.jwt.JwtUser;
import com.yanhuada.client.model.user.UserPoToDto;
import com.yanhuada.client.model.user.rsp.UserLoginRsp;
import com.yanhuada.client.service.ClientSmsService;
import com.yanhuada.client.service.ClientUserService;
import com.yanhuada.common.model.CaptchaType;
import com.yanhuada.common.util.aliyun.oss.OssUtil;
import com.yanhuada.common.util.webchat.miniapp.MiniappInfoReq;
import com.yanhuada.common.util.webchat.miniapp.MiniappUtil;
import com.yanhuada.model.User;
import com.yanhuada.service.impl.BaseUserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author yanhuada
 * CREATE ON 2020/8/8 14:07
 */
@Service
public class ClientUserServiceImpl extends BaseUserServiceImpl implements ClientUserService {

    @Resource
    private JwtSessionUtil jwtSessionUtil;
    @Resource
    private HttpServletRequest request;
    @Resource
    private HttpServletResponse response;
    @Resource
    private ClientUserMapper clientUserMapper;
    @Resource
    private MiniappUtil miniappUtil;
    @Resource
    private ClientSmsService clientSmsService;
    @Resource
    private OssUtil ossUtil;

    private static final Logger logger = LoggerFactory.getLogger(ClientUserServiceImpl.class);

    /**
     * 默认头像
     */
    private static final String DEFAULT_AVATAR = "zero/common/avatar.png";

    @Override
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public UserLoginRsp loginByMiniappLogin(MiniappInfoReq req) {
        WxMaUserInfo wxMaUserInfo = miniappUtil.getWxUserInfo(req);
        User user = clientUserMapper.selectByOpenId(wxMaUserInfo.getOpenId());
        User loginUser = user == null ? createUser(wxMaUserInfo) : updateWxUserInfo(user, wxMaUserInfo);
        return this.loginAfterToDo(loginUser);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public UserLoginRsp phoneLogin(String phone, String captcha) {
        clientSmsService.phoneCaptchaCheck(CaptchaType.PHONE_LOGIN, "+86", phone, captcha);
        User user = clientUserMapper.selectByPhone(phone);
        User loginUser = user == null ? createUser(phone) : user;
        return this.loginAfterToDo(loginUser);
    }

    @Override
    public UserLoginRsp detail() {
        Long userId = jwtSessionUtil.getUserIdFromAuthenticatedSession(request);
        User user = super.findByIdFail(userId);
        return UserPoToDto.copyUserLoginRsp(user, ossUtil);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public UserLoginRsp avatarUpdate(String avatar) {
        Long userId = jwtSessionUtil.getUserIdFromAuthenticatedSession(request);
        User user = super.findByIdFail(userId);
        user.setAvatar(avatar);
        clientUserMapper.updateByPrimaryKeySelective(user);
        return UserPoToDto.copyUserLoginRsp(user, ossUtil);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public UserLoginRsp nicknameUpdate(String nickname) {
        Long userId = jwtSessionUtil.getUserIdFromAuthenticatedSession(request);
        User user = super.findByIdFail(userId);
        user.setNickname(nickname);
        clientUserMapper.updateByPrimaryKeySelective(user);
        return UserPoToDto.copyUserLoginRsp(user, ossUtil);
    }

    private UserLoginRsp loginAfterToDo(User loginUser) {

        //句子记录


        JwtUser jwtUser = new JwtUser();
        jwtUser.setAnonymous(false);
        jwtUser.setUserId(loginUser.getId());
        jwtSessionUtil.createSession(jwtUser, request, response);
        logger.info("登陆成功：{}", loginUser.toString());
        return UserPoToDto.copyUserLoginRsp(loginUser, ossUtil);
    }

    private User createUser(String phone) {
        User userForCreate = new User();
        userForCreate.setPhone(phone);
        userForCreate.setNickname(phone);
        userForCreate.setAvatar(DEFAULT_AVATAR);
        userForCreate.setPassword("");
        userForCreate.setSex(0);
        clientUserMapper.insertSelective(userForCreate);
        return userForCreate;
    }

    private User createUser(WxMaUserInfo wxMaUserInfo) {
        User userForCreate = new User();
        userForCreate.setOpenId(wxMaUserInfo.getOpenId());
        userForCreate.setNickname(wxMaUserInfo.getNickName());
        userForCreate.setAvatar(wxMaUserInfo.getAvatarUrl());
        userForCreate.setLocation(wxMaUserInfo.getProvince() + " " + wxMaUserInfo.getCity());
        userForCreate.setPassword("");
        userForCreate.setSex(0);
        clientUserMapper.insertSelective(userForCreate);
        return userForCreate;
    }

    private User updateWxUserInfo(User loginUser, WxMaUserInfo wxMaUserInfo) {
        loginUser.setNickname(wxMaUserInfo.getNickName());
        loginUser.setAvatar(wxMaUserInfo.getAvatarUrl());
        loginUser.setLocation(wxMaUserInfo.getProvince() + " " + wxMaUserInfo.getCity());
        clientUserMapper.updateByPrimaryKeySelective(loginUser);
        return loginUser;
    }
}

