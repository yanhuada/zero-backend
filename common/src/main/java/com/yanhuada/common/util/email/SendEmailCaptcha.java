package com.yanhuada.common.util.email;

import com.yanhuada.common.exception.BaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;

import java.util.Map;

/**
 * @author yanhuada
 * CREATE ON 2020/3/17 16:22
 */
public class SendEmailCaptcha {

    private static final Logger logger  = LoggerFactory.getLogger(SendEmailCaptcha.class);

    private EmailCaptchaRequest emailCaptchaRequest;

    public SendEmailCaptcha(EmailCaptchaRequest emailCaptchaRequest) {
        this.emailCaptchaRequest = emailCaptchaRequest;
    }

    public void send() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(emailCaptchaRequest.getTo());
        message.setFrom(emailCaptchaRequest.getFrom());
        message.setSubject(emailCaptchaRequest.getSubject());
        message.setText(generateText());
        try{
            emailCaptchaRequest.getJavaMailSender().send(message);
        }catch (MailException e){
            logger.error("邮件发送报错原因：{}",e.getCause());
            throw new BaseException(EmailErrorCode.SEND_EMAIL_ERROR.getMessage(),EmailErrorCode.SEND_EMAIL_ERROR.getCode());
        }
    }

    private String generateText(){
        Map<String, String> paras = emailCaptchaRequest.getParas();
        String text = emailCaptchaRequest.getText();
        if (emailCaptchaRequest.getText() != null) {
            for (String key : paras.keySet()) {
                text = text.replace(String.format("${%s}", key), paras.get(key));
            }
            return text;
        }
        return "";
    }
}
