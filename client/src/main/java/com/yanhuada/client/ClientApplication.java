package com.yanhuada.client;

import com.yanhuada.client.filter.JwtTokenFilter;
import com.yanhuada.common.config.IdAndTimeAutoUpdatePlugin;
import com.yanhuada.common.exception.BaseJsonSerializeHandlerExceptionResolver;
import com.yanhuada.common.util.snowflake.SnowflakeUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * @author yanhuada
 * CREATE ON 2020/3/14 18:00
 */
@SpringBootApplication(
        exclude = {SecurityAutoConfiguration.class},
        scanBasePackages = {"com.yanhuada"}
)
@MapperScan({"com.yanhuada.dao", "com.yanhuada.client.dao"})
@EnableConfigurationProperties(MailProperties.class)
public class ClientApplication {

    public static void main(String[] args) {
        
        SpringApplication.run(ClientApplication.class, args);
    }

    /**
     * Mybatis插件，用于生成ID、版本号、创建时间、更新时间
     *
     * @param idWorker
     * @return
     */
    @Bean
    public IdAndTimeAutoUpdatePlugin idAndTimeAutoUpdatePlugin(SnowflakeUtil idWorker, SnowflakeUtil versionWorkder) throws Exception {
        return new IdAndTimeAutoUpdatePlugin(idWorker, versionWorkder);
    }

    @Bean
    public BaseJsonSerializeHandlerExceptionResolver baseJsonSerializeHandlerExceptionResolver() {
        return new BaseJsonSerializeHandlerExceptionResolver();
    }

    /**
     * token 生成策略过滤器
     *
     * @return
     */
    @Bean
    public JwtTokenFilter alwaysCreateJwtTokenFilter() {
        return new JwtTokenFilter();
    }

    @Bean
    public FilterRegistrationBean alwaysCreateJwtTokenFilterRegistrationBean(JwtTokenFilter jwtTokenFilter) {
        FilterRegistrationBean registBean = new FilterRegistrationBean();
        registBean.setFilter(jwtTokenFilter);
        registBean.addUrlPatterns("/api/*");
        //order的数值越小 则优先级越高
        registBean.setOrder(6);
        return registBean;
    }
}
