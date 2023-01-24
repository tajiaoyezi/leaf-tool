package org.leaflei.core.tool.config;


import org.leaflei.core.tool.utils.SpringUtil;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author leaflei
 * @Date 2023/1/18 18:01
 * @Description 工具配置类
 */
@AutoConfiguration
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ToolConfiguration implements WebMvcConfigurer {

    /**
     * Spring上下文缓存
     *
     * @return SpringUtil
     */
    @Bean
    public SpringUtil springUtil() {
        return new SpringUtil();
    }

}
