package org.leaflei.core.launch.config;

import lombok.AllArgsConstructor;
import org.leaflei.core.launch.props.LeafProperties;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * @Author leaflei
 * @Date 2023/1/18 15:52
 * @Description 配置类
 */
@AutoConfiguration // 开启自动配置
@AllArgsConstructor
@Order(Ordered.HIGHEST_PRECEDENCE) // 优先级最高
@EnableConfigurationProperties({LeafProperties.class}) // 开启指定的配置类读取配置文件
public class LeafLaunchConfiguration {
}
