package com.yanhuada.common.config;

import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.yanhuada.common.model.IdLongToStrSerializer;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;

import java.util.ArrayList;

/**
 * @author yanhuada
 * CREATE ON 2020/3/14 18:00
 */
@Configuration
public class HttpMessageConvertersConfig {

    /**
     * JSON序列化
     * @return
     */
    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters(){
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();

        // 2 添加fastjson 的配置信息 比如 是否要格式化 返回的json数据
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);

        SerializeConfig serializeConfig = new SerializeConfig();
        serializeConfig.put(Long.class, new IdLongToStrSerializer());
        serializeConfig.put(Long.TYPE, new IdLongToStrSerializer());
        fastJsonConfig.setSerializeConfig(serializeConfig);

        fastConverter.setFastJsonConfig(fastJsonConfig);
        // 当ContentType为application/json时，此converter才会生效
        fastConverter.setSupportedMediaTypes(new ArrayList<MediaType>() {
            {
                add(MediaType.APPLICATION_JSON_UTF8);
                add(MediaType.APPLICATION_JSON);
            }
        });

        return new HttpMessageConverters(fastConverter);
    }

}
