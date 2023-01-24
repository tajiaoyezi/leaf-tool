package org.leaflei.core.tool.jackson;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author leaflei
 * @Date 2023/1/18 16:50
 * @Description jackson配置
 */
@Getter
@Setter
@ConfigurationProperties("leaf.jackson")
public class LeafJacksonProperties {

    /**
     * 支持 MediaType text/plain，用于和 blade-api-crypto 一起使用
     */
    private Boolean supportTextPlain = Boolean.FALSE;

}
