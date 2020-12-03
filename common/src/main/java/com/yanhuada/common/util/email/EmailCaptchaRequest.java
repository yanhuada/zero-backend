package com.yanhuada.common.util.email;

import io.jsonwebtoken.expand.session.redis.RedisSession;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.Map;

/**
 * @author yanhuada
 * CREATE ON 2020/3/17 16:34
 */
public class EmailCaptchaRequest {

    public EmailCaptchaRequest(RedisSession redisSession, JavaMailSender javaMailSender, String host, String from, String to, String redisKey, String subject, String text, Map<String, String> paras) {
        this.redisSession = redisSession;
        this.javaMailSender = javaMailSender;
        this.host = host;
        this.from = from;
        this.to = to;
        this.redisKey = redisKey;
        this.subject = subject;
        this.text = text;
        this.paras = paras;
    }

    /**
     * 当前session
     */
    private RedisSession redisSession;

    /**
     * 发送者对象，直接注入使用
     */
    private JavaMailSender javaMailSender;

    private String host;

    /**
     * 发送者邮箱
     */
    private String from;

    /**
     * 收件者邮箱
     */
    private String to;

    /**
     * 保存在redis中的key
     */
    private String redisKey;

    /**
     * 主题
     */
    private String subject;

    /**
     * 发送的文本
     */
    private String text;

    /**
     * 需要替换的参数
     */
    private Map<String, String> paras;

    public RedisSession getRedisSession() {
        return redisSession;
    }

    public void setRedisSession(RedisSession redisSession) {
        this.redisSession = redisSession;
    }

    public JavaMailSender getJavaMailSender() {
        return javaMailSender;
    }

    public void setJavaMailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getRedisKey() {
        return redisKey;
    }

    public void setRedisKey(String redisKey) {
        this.redisKey = redisKey;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Map<String, String> getParas() {
        return paras;
    }

    public void setParas(Map<String, String> paras) {
        this.paras = paras;
    }
}
