package com.yanhuada.client.jwt;

import com.yanhuada.common.exception.BaseException;
import com.yanhuada.common.exception.BaseExceptionEnum;
import com.yanhuada.exception.ErrorCode;
import com.yanhuada.exception.JwtException;
import com.yanhuada.model.User;
import io.jsonwebtoken.expand.model.Constants;
import io.jsonwebtoken.expand.model.IUser;
import io.jsonwebtoken.expand.session.redis.RedisOperationsSessionRepository;
import io.jsonwebtoken.expand.session.redis.RedisSession;
import io.jsonwebtoken.expand.session.web.http.HttpSessionStrategyHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class JwtSessionUtil {

    Logger logger = LoggerFactory.getLogger(JwtSessionUtil.class);

    private static final Integer CAPTCHA_MAX_ERROR_TIMES = 5;
    private static final Long CAPTCHA_EXPIRATION = 900L; // 15分钟


    @Resource
    protected RedisOperationsSessionRepository redisOperationsSessionRepository;
    @Resource
    protected HttpSessionStrategyHelper httpSessionStrategyHelper;
    @Resource
    protected JwtUtil jwtUtil;
    @Value("${server.session.timeout:604800}")
    protected int maxInactiveInterval;

    public RedisSession getSession(HttpServletRequest request) {
        // 所有请求均经过AlwaysCreateJwtTokenFilter，request中已有session信息
        Object session = request.getAttribute(Constants.SESSION_KEY);
        if (session == null) {
            throw new JwtException(BaseExceptionEnum.ANNOYMOUS);
        }

        RedisSession redisSession = (RedisSession) session;
        return redisSession;
    }

    public RedisSession getAuthenticatedSession(HttpServletRequest request) {
        RedisSession session = getSession(request);
        if (session == null) {
            throw new JwtException(BaseExceptionEnum.ANNOYMOUS);
        }
        JwtUser jwtUser = (JwtUser) session.getJwtUserInfo();

        if (jwtUser.getAnonymous()) {
            throw new JwtException(BaseExceptionEnum.ANNOYMOUS);
        }
        return session;
    }

    public Boolean ifAnonymous(HttpServletRequest request) {
        RedisSession session = getSession(request);
        JwtUser jwtUser = (JwtUser) session.getJwtUserInfo();
        return jwtUser.getAnonymous();
    }

    public Long getUserIdFromAuthenticatedSession(HttpServletRequest request) {
        RedisSession session = getAuthenticatedSession(request);
        return ((JwtUser) session.getJwtUserInfo()).getUserId();
    }


    /**
     * 将IUser对象序列化为Jwt Token，并根据token策略(cookie／header)写入response
     *
     * @param iUser    用户对象
     * @param request
     * @param response
     * @return
     */
    public RedisSession createSession(IUser iUser, HttpServletRequest request, HttpServletResponse response) {
        // 生成新token
        String token = jwtUtil.generateToken(iUser, maxInactiveInterval);

        // 复制原会话缓存中的数据，新建会话
        RedisSession oldSession = (RedisSession) request.getAttribute(Constants.SESSION_KEY);
        RedisSession newSession = oldSession == null ?
                new RedisSession(redisOperationsSessionRepository, token)
                :
                new RedisSession(redisOperationsSessionRepository, token, oldSession.getCached()); // 保存会话
        redisOperationsSessionRepository.save(newSession);
        // 将token写入cookie或头部
        httpSessionStrategyHelper.onNewSession(newSession, request, response);

        return newSession;
    }

    /**
     * 清除会话记录
     *
     * @param request
     * @param response
     */
    public void clearSession(HttpServletRequest request, HttpServletResponse response) {
        RedisSession oldSession = (RedisSession) request.getAttribute(Constants.SESSION_KEY);

        if (oldSession != null) {
            redisOperationsSessionRepository.delete(oldSession.getToken());
            httpSessionStrategyHelper.onInvalidateSession(request, response);
        }

    }

    protected String getErrorTimesKey(String cacheKey) {
        return cacheKey + ":errorTimes";
    }

    public int getErrorTimes(RedisSession session, String cacheKey) {
        String errorTimesKey = getErrorTimesKey(cacheKey);
        Integer errorTimes = session.getAttribute(errorTimesKey);
        errorTimes = errorTimes == null ? 1 : errorTimes + 1;

        return errorTimes;
    }

    public int incrErrorTimes(RedisSession session, String cacheKey) {
        String errorTimesKey = getErrorTimesKey(cacheKey);
        int errorTimes = getErrorTimes(session, cacheKey);

        session.setAttribute(errorTimesKey, errorTimes);
        return errorTimes;
    }

    public void cacheCaptcha(RedisSession session, String captchaKey, String captcha) {
        session.removeAttribute(captchaKey);
        session.setAttribute(captchaKey, captcha, 900L);
    }

    public void verifyCaptcha(RedisSession session, String cacheKey, String captcha) {

        logger.info("输入的验证码：{}", captcha);
        String cacheCaptcha = session.getAttribute(cacheKey);
        logger.info("缓存的验证码：{}", cacheCaptcha);
        if (cacheCaptcha == null || !cacheCaptcha.equals(captcha)) {
            logger.error("验证码错误->缓存的验证码{} \n 输入的验证码：{}", cacheCaptcha, captcha);
            session.removeAttribute(cacheKey);
            throw new BaseException(ErrorCode.CAPTCHA_ERROR.getMessage(), ErrorCode.CAPTCHA_ERROR.getCode());
        }
        // 删除验证码
        session.removeAttribute(cacheKey);
    }

    public void cacheWxMaUserInfo(RedisSession session, String wxKey, User wxMaUserInfo) {
        session.removeAttribute(wxKey);
        session.setAttribute(wxKey, wxMaUserInfo, 900L);
    }

    public User getWxMaUserInfo(RedisSession session, String wxKey) {
        return session.getAttribute(wxKey);
    }
}
