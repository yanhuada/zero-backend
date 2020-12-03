package com.yanhuada.client.filter;

import com.yanhuada.client.jwt.JwtUser;
import com.yanhuada.client.jwt.JwtUtil;
import com.yanhuada.common.exception.BaseExceptionEnum;
import com.yanhuada.exception.JwtException;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.expand.model.Constants;
import io.jsonwebtoken.expand.model.IUser;
import io.jsonwebtoken.expand.session.redis.RedisOperationsSessionRepository;
import io.jsonwebtoken.expand.session.redis.RedisSession;
import io.jsonwebtoken.expand.session.web.http.HttpSessionStrategyHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author yanhuada
 * CREATE ON 2020/3/17 16:13
 */
public class JwtTokenFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(JwtTokenFilter.class);

    @Resource
    RedisOperationsSessionRepository redisOperationsSessionRepository;
    @Resource
    HttpSessionStrategyHelper httpSessionStrategyHelper;
    @Resource
    JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = httpSessionStrategyHelper.getRequestedSessionToken(request);
        RedisSession session = null;
        boolean needNew = false;

        if (token == null || "".equals(token)) {
            session = createAnonymousSession();
            needNew = true;
        } else {
            try {
                session = redisOperationsSessionRepository.getSession(token);

                if (session == null) {
                    session = createAnonymousSession();
                    needNew = true;
                }

                // token快过期，迁移session
                IUser jwtUser = session.getJwtUserInfo();
                if (jwtUser.getExpiredSeconds() < redisOperationsSessionRepository.getDefaultMaxInactiveInterval() / 2) {
                    session = redisOperationsSessionRepository.migrateSession(session);
                    // 删除旧会话
                    redisOperationsSessionRepository.delete(token);
                    needNew = true;
                }
            } catch (ExpiredJwtException e){
                redisOperationsSessionRepository.delete(token);

                throw new JwtException(BaseExceptionEnum.ANNOYMOUS.getMessage(), e, BaseExceptionEnum.ANNOYMOUS.getCode());
            } catch (UnsupportedJwtException | MalformedJwtException | IllegalArgumentException | SignatureException e) {
                redisOperationsSessionRepository.delete(token);

                logger.warn("jwt token解析异常: {}", token);
                throw new JwtException(BaseExceptionEnum.ANNOYMOUS.getMessage(), e, BaseExceptionEnum.ANNOYMOUS.getCode());
            } catch (Exception e) {
                redisOperationsSessionRepository.delete(token);

                logger.warn("jwt token解析遇到未知错误: {}", token);
                throw new JwtException(BaseExceptionEnum.ANNOYMOUS.getMessage(), e, BaseExceptionEnum.ANNOYMOUS.getCode());
            }
        }

        // 缓存请求session，便于后续比较确定是否需要更换
        request.setAttribute(Constants.SESSION_KEY, session);
        // 如果需要更新会话，则将信息更新到HTTP头部
        if (needNew) {
            httpSessionStrategyHelper.onNewSession(session, request, response);
        }

        filterChain.doFilter(request, response);
    }

    private RedisSession createAnonymousSession() {
        // 创建匿名用户token
        JwtUser jwtUser = (JwtUser) jwtUtil.getAnonymousInfo();

        // 保存会话
        RedisSession redisSession = redisOperationsSessionRepository.createSession(jwtUser);
        redisOperationsSessionRepository.save(redisSession);

        return redisSession;
    }
}
