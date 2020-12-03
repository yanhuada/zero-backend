package com.yanhuada.platform.service.impl;

import com.yanhuada.common.util.PasswordUtil;
import com.yanhuada.exception.CommonException;
import com.yanhuada.exception.ErrorCode;
import com.yanhuada.model.Admin;
import com.yanhuada.platform.dao.PlatformAdminMapper;
import com.yanhuada.platform.jwt.JwtSessionUtil;
import com.yanhuada.platform.jwt.JwtUser;
import com.yanhuada.platform.model.admin.AdminPoToDto;
import com.yanhuada.platform.model.admin.rsp.AdminDetailRsp;
import com.yanhuada.platform.service.PlatformAdminService;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

/**
 * @author yanhuada
 * CREATE ON 2020/8/10 18:40
 */
@Service
public class PlatformAdminServiceImpl implements PlatformAdminService {


    @Resource
    private PlatformAdminMapper platformAdminMapper;
    @Resource
    private JwtSessionUtil jwtSessionUtil;
    @Resource
    private HttpServletRequest request;
    @Resource
    private HttpServletResponse response;

    private static final Logger logger = LoggerFactory.getLogger(PlatformAdminServiceImpl.class);

    @Override
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public AdminDetailRsp login(String name, String password) {
        Admin admin = platformAdminMapper.findByName(name);
        if (admin == null) {
            throw new CommonException(ErrorCode.ADMIN_NOT_FOUND);
        }
        if (!PasswordUtil.checkPwd(admin.getPassword(), password, admin.getSalt())) {
            throw new CommonException(ErrorCode.PASSWORD_ERROR);
        }
        return this.loginAfterToDo(admin);
    }

    private AdminDetailRsp loginAfterToDo(Admin admin) {

        JwtUser jwtUser = new JwtUser();
        jwtUser.setAnonymous(false);
        jwtUser.setUserId(admin.getId());
        jwtSessionUtil.createSession(jwtUser, request, response);
        logger.info("登陆成功：{}", admin.toString());
        return AdminPoToDto.copyAdminDetailRsp(admin);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public void add(String name, String password) {

        Admin admin = platformAdminMapper.findByName(name);

        if (admin != null) {
            throw new CommonException(ErrorCode.ADMIN_NAME_USED);
        }

        String salt = RandomStringUtils.randomAlphanumeric(10);
        password = PasswordUtil.encrypt(password, salt);
        Admin adminForAdd = new Admin();
        adminForAdd.setSalt(salt);
        adminForAdd.setPassword(password);
        adminForAdd.setIfLock(false);
        adminForAdd.setName(name);
        adminForAdd.setPhone("");
        adminForAdd.setIfEnable(true);
        adminForAdd.setEmail("");
        adminForAdd.setIfSuper(false);
        platformAdminMapper.insertSelective(adminForAdd);
    }

    @Override
    public AdminDetailRsp detail() {



        Admin admin = Optional.ofNullable(platformAdminMapper.selectByPrimaryKey(jwtSessionUtil.getUserIdFromAuthenticatedSession(request)))
                .orElseThrow(() -> new CommonException(ErrorCode.ADMIN_NOT_FOUND));

        return AdminPoToDto.copyAdminDetailRsp(admin);
    }
}
