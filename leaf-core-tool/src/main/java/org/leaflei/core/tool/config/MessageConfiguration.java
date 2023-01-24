package org.leaflei.core.tool.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.leaflei.core.tool.jackson.LeafJacksonProperties;
import org.leaflei.core.tool.jackson.MappingApiJackson2HttpMessageConverter;
import org.leaflei.core.tool.utils.Charsets;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.converter.*;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @Author leaflei
 * @Date 2023/1/18 17:33
 * @Description 消息配置类
 */
@AutoConfiguration
@AllArgsConstructor
@Order(Ordered.HIGHEST_PRECEDENCE)
public class MessageConfiguration implements WebMvcConfigurer {

    private final ObjectMapper objectMapper;
    private final LeafJacksonProperties properties;

    /**
     * 使用 JACKSON 作为JSON MessageConverter
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.removeIf(x -> x instanceof StringHttpMessageConverter || x instanceof AbstractJackson2HttpMessageConverter);
        converters.add(new StringHttpMessageConverter(Charsets.UTF_8));
        converters.add(new ByteArrayHttpMessageConverter());
        converters.add(new ResourceHttpMessageConverter());
        converters.add(new ResourceRegionHttpMessageConverter());
        converters.add(new MappingApiJackson2HttpMessageConverter(objectMapper, properties));
    }

}
