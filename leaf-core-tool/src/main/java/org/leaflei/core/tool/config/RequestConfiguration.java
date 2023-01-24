package org.leaflei.core.tool.config;

import lombok.AllArgsConstructor;
import org.leaflei.core.tool.request.LeafRequestFilter;
import org.leaflei.core.tool.request.RequestProperties;
import org.leaflei.core.tool.request.XssProperties;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;

import javax.servlet.DispatcherType;

/**
 * @Author leaflei
 * @Date 2023/1/18 17:43
 * @Description 过滤器配置类
 */
@AutoConfiguration
@AllArgsConstructor
@EnableConfigurationProperties({RequestProperties.class, XssProperties.class})
public class RequestConfiguration {

    private final RequestProperties requestProperties;
    private final XssProperties xssProperties;

    /**
     * 全局过滤器
     */
    @Bean
    public FilterRegistrationBean<LeafRequestFilter> bladeFilterRegistration() {
        FilterRegistrationBean<LeafRequestFilter> registration = new FilterRegistrationBean<>();
        registration.setDispatcherTypes(DispatcherType.REQUEST);
        registration.setFilter(new LeafRequestFilter(requestProperties, xssProperties));
        registration.addUrlPatterns("/*");
        registration.setName("leafRequestFilter");
        registration.setOrder(Ordered.LOWEST_PRECEDENCE);
        return registration;
    }
}
