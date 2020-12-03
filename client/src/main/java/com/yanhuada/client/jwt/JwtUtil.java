package com.yanhuada.client.jwt;

import com.yanhuada.common.util.snowflake.SnowflakeUtil;
import com.yanhuada.exception.ErrorCode;
import com.yanhuada.exception.JwtException;
import io.jsonwebtoken.*;
import io.jsonwebtoken.expand.JwtUserException;
import io.jsonwebtoken.expand.model.ChannelEnum;
import io.jsonwebtoken.expand.model.IUser;
import io.jsonwebtoken.expand.util.JWTHelper;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author yanhuada
 * CREATE ON 2020/3/14 18:00
 */
public class JwtUtil extends JWTHelper {

    private SnowflakeUtil idWorker;

    public JwtUtil(SnowflakeUtil idWorker, String priKeyPath, String pubKeyPath) {
        super(priKeyPath, pubKeyPath);
        this.idWorker = idWorker;
    }

    @Override
    public IUser getAnonymousInfo() {
        JwtUser jwtInfo = new JwtUser();
        // 会话信息
        jwtInfo.setUuid(String.valueOf(idWorker.nextId()));
        jwtInfo.setAnonymous(true);

        return jwtInfo;
    }

    @Override
    public IUser getAnonymousInfo(Integer channel) {
        JwtUser jwtInfo = new JwtUser();
        // 会话信息
        jwtInfo.setUuid(String.valueOf(idWorker.nextId()));
        jwtInfo.setChannel(channel);
        jwtInfo.setAnonymous(true);

        return jwtInfo;
    }

    @Override
    public IUser getAnonymousInfo(ChannelEnum channelEnum) {
        return getAnonymousInfo(channelEnum.getCode());
    }

    @Override
    public String generateToken(IUser iUser, int expire) {
        if (!(iUser instanceof JwtUser)) {
            throw new JwtException(ErrorCode.JWT_ILLEGAL_USER);
        }

        JwtUser jwtUser = (JwtUser) iUser;
        if (!jwtUser.getAnonymous()) {
            if (jwtUser.getUserId() == null) {
                throw new JwtException(ErrorCode.JWT_USERID_IS_NULL);
            }
        } else {
            if (jwtUser.getUuid() == null) {
                throw new JwtException(ErrorCode.JWT_UUID_IS_NULL);
            }
        }

        ChannelEnum channelEnum = ChannelEnum.get(jwtUser.getChannel());
        if (channelEnum == null) {
            throw new JwtUserException("渠道类型不正确");
        }

        // 有效期
        LocalDateTime now = LocalDateTime.now().plusSeconds(expire);
        JwtBuilder jwtBuilder = Jwts.builder().setHeaderParam("typ", "JWT")
                .setExpiration(Date.from(now.atZone(ZoneId.systemDefault()).toInstant()));

        // 会话信息
        jwtBuilder.claim(JwtUser.IS_ANONYMOUS_KEY, jwtUser.getAnonymous());
        jwtBuilder.claim(JwtUser.CHANNEL_KEY, channelEnum.getCode());
        jwtBuilder.claim(JwtUser.UUID_KEY, jwtUser.getUuid());
        jwtBuilder.setId(jwtUser.getId());
        jwtBuilder.setSubject(jwtUser.getId());

        jwtBuilder.claim(JwtUser.USER_ID_KEY, jwtUser.getUserId());
        jwtBuilder.claim(JwtUser.USER_NICKNAME_KEY, jwtUser.getNickname());
        jwtBuilder.claim(JwtUser.USER_EMAIL_KEY, jwtUser.getEmail());
        jwtBuilder.claim(JwtUser.USER_HEAD_IMG_URL_KEY, jwtUser.getHeadimgurl());
        jwtBuilder.claim(JwtUser.WX_OPENID_KEY, jwtUser.getWxOpenid());
        jwtBuilder.claim(JwtUser.WX_IS_ASSISTANT_KEY, jwtUser.getIsAssistant());
        jwtBuilder.claim(JwtUser.ASSISTANT_ID_KEY,jwtUser.getAssistantId());
        jwtBuilder.claim(JwtUser.FACEBOOK_ID_KEY,jwtUser.getFacebookId());
        jwtBuilder.claim(JwtUser.ASSISTANT_GRADE,jwtUser.getGrade());
        jwtBuilder.claim(JwtUser.LOGIN_MODE,jwtUser.getLoginMode());
        jwtBuilder.claim(JwtUser.USER_SEX,jwtUser.getSex());

        // 压缩
        return jwtBuilder.signWith(SignatureAlgorithm.RS256, getPrivateKey()).compact();
    }

    @Override
    public IUser getInfoFromToken(String token) {
        Jws<Claims> claimsJws = parserToken(token);
        Claims body = claimsJws.getBody();
        long expiredSeconds = body.getExpiration().getTime() - System.currentTimeMillis();

        JwtUser jwtUser = new JwtUser();
        jwtUser.setExpiredSeconds(expiredSeconds);

        // 会话信息
        jwtUser.setAnonymous(objectToBoolean(body.get(JwtUser.IS_ANONYMOUS_KEY)));
        jwtUser.setUuid(objectToString(body.get(JwtUser.UUID_KEY)));
        jwtUser.setChannel(objectToInteger(body.get(JwtUser.CHANNEL_KEY)));

        // 解析获取用户信息
        jwtUser.setUserId(objectToLong(body.get(JwtUser.USER_ID_KEY)));
        jwtUser.setNickname(objectToString(body.get(JwtUser.USER_NICKNAME_KEY)));
        jwtUser.setEmail(objectToString(body.get(JwtUser.USER_EMAIL_KEY)));
        jwtUser.setHeadimgurl(objectToString(body.get(JwtUser.USER_HEAD_IMG_URL_KEY)));
        jwtUser.setWxOpenid(objectToString(body.get(JwtUser.WX_OPENID_KEY)));
        jwtUser.setIsAssistant(objectToBoolean(body.get(JwtUser.WX_IS_ASSISTANT_KEY)));
        jwtUser.setAssistantId(objectToLong(body.get(JwtUser.ASSISTANT_ID_KEY)));
        jwtUser.setFacebookId(objectToString(body.get(JwtUser.FACEBOOK_ID_KEY)));
        jwtUser.setGrade(objectToInteger(body.get(JwtUser.ASSISTANT_GRADE)));
        jwtUser.setLoginMode(objectToInteger(body.get(JwtUser.LOGIN_MODE)));
        jwtUser.setSex(objectToInteger(body.get(JwtUser.USER_SEX)));
        return jwtUser;
    }

    @Override
    public String refreshToken(String token, int expire) {
        JwtUser jwtInfo = (JwtUser) getInfoFromToken(token);
        return generateToken(jwtInfo, expire);
    }

}
