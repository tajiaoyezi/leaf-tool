package org.leaflei.core.tool.api;

import java.io.Serializable;

/**
 * @Author leaflei
 * @Date 2023/1/18 16:39
 * @Description 业务代码接口
 */
public interface IResultCode extends Serializable {

    /**
     * 消息
     *
     * @return String
     */
    String getMessage();

    /**
     * 状态码
     *
     * @return int
     */
    int getCode();

}

