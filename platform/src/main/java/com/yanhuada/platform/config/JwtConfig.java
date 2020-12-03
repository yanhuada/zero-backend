package com.yanhuada.platform.config;

import com.yanhuada.common.util.snowflake.SnowflakeUtil;
import com.yanhuada.platform.jwt.JwtUtil;
import io.jsonwebtoken.expand.session.redis.RedisOperationsSessionRepository;
import io.jsonwebtoken.expand.session.web.http.CookieHttpSessionStrategy;
import io.jsonwebtoken.expand.session.web.http.DefaultCookieSerializer;
import io.jsonwebtoken.expand.session.web.http.HttpSessionStrategyHelper;
import io.jsonwebtoken.expand.util.JWTHelper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;

/**
 * @author yanhuada
 * CREATE ON 2020/3/14 18:00
 */
@Configuration
@ConfigurationProperties(ignoreUnknownFields = false, prefix = "jwt.rsa")
public class JwtConfig {

    /**
     * 私钥，JWT Token解密用
     */
    private String privateKey;

    /**
     * 公钥，加密生成JWT Token
     */
    private String publicKey;

    @Value("${server.session.timeout:604800}")
    private int maxInactiveInterval;

    /**
     * JWT Token生成辅助类
     *
     * @param anonymousIdWorker
     * @return
     */
    @Bean
    public JwtUtil jwtUtil(SnowflakeUtil anonymousIdWorker) {
        return new JwtUtil(anonymousIdWorker, privateKey, publicKey);
    }

    @Bean
    public RedisOperationsSessionRepository redisOperationsSessionRepository(RedisConnectionFactory redisConnectionFactory, JWTHelper jwtHelper) {
        RedisOperationsSessionRepository sessionRepository = new RedisOperationsSessionRepository(redisConnectionFactory, jwtHelper);
        sessionRepository.setDefaultMaxInactiveInterval(maxInactiveInterval);

        return sessionRepository;
    }

    @Bean
    public HttpSessionStrategyHelper httpSessionStrategyUtil() {
        DefaultCookieSerializer cookieSerializer = new DefaultCookieSerializer();
        cookieSerializer.setCookieMaxAge(maxInactiveInterval);

        CookieHttpSessionStrategy cookieStrategy = new CookieHttpSessionStrategy();
        cookieStrategy.setCookieSerializer(cookieSerializer);

        HttpSessionStrategyHelper strategyHelper = new HttpSessionStrategyHelper();
        strategyHelper.setCookieStrategy(cookieStrategy);

        return strategyHelper;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public int getMaxInactiveInterval() {
        return maxInactiveInterval;
    }

    public void setMaxInactiveInterval(int maxInactiveInterval) {
        this.maxInactiveInterval = maxInactiveInterval;
    }
}
