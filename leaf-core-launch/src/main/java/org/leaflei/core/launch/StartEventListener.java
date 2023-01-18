package org.leaflei.core.launch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Async;
import org.springframework.util.StringUtils;

/**
 * @Author leaflei
 * @Date 2023/1/18 16:14
 * @Description 项目启动监听器
 */
@Slf4j
@AutoConfiguration
public class StartEventListener {

    @Async
    @Order
    @EventListener(WebServerInitializedEvent.class) // 监听Web容器启动
    public void afterStart(WebServerInitializedEvent event) {
        // 获取环境对象
        Environment environment = event.getApplicationContext().getEnvironment();
        // 获取项目名称
        String appName = environment.getProperty("spring.application.name").toUpperCase();
        // 获取项目端口号
        int localPort = event.getWebServer().getPort();
        // 获取项目使用的配置文件
        String profile = StringUtils.arrayToCommaDelimitedString(environment.getActiveProfiles());
        // 打印日志
        log.info("---[{}]---启动完成，当前使用的端口:[{}]，环境变量:[{}]---", appName, localPort, profile);
    }
}
