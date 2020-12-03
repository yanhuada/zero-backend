package com.yanhuada.client.config;

import com.yanhuada.common.util.snowflake.SnowflakeUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yanhuada
 * CREATE ON 2020/3/14 18:00
 */
@Configuration
public class SnowflakeConfig {

    /**
     * ID生成器，机器位
     */
    @Value("${snowflake.workerId:1}")
    private Long workerId;

    /**
     * 数据表ID生成器，将注入到 IdAndTimeAutoUpdatePlugin下｀
     * @return
     */
    @Bean
    public SnowflakeUtil idWorker() {
        return new SnowflakeUtil(workerId);
    }

    /**
     * 数据表版本号生成器，将注入到 IdAndTimeAutoUpdatePlugin下｀
     * @return
     */
    @Bean
    public SnowflakeUtil versionWorkder() {
        return new SnowflakeUtil(workerId);
    }

    /**
     * JWT匿名用户ID生成器，将注入到 JWT
     * @return
     */
    @Bean
    public SnowflakeUtil anonymousIdWorker() {
        return new SnowflakeUtil(workerId);
    }

    public Long getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Long workerId) {
        this.workerId = workerId;
    }
}
