package org.leaflei.core.launch.constant;

/**
 * @Author leaflei
 * @Date 2023/1/18 16:02
 * @Description token常量池
 */
public interface TokenConstant {
    /**
     * 头像
     */
    String AVATAR = "avatar";
    /**
     * 认证头
     */
    String HEADER = "leaf-auth";
    /**
     * token头类型
     */
    String BEARER = "bearer";
    /**
     * 认证token
     */
    String ACCESS_TOKEN = "access_token";
    /**
     * 重刷token
     */
    String REFRESH_TOKEN = "refresh_token";
    /**
     * token类型
     */
    String TOKEN_TYPE = "token_type";
    /**
     * token声明周期
     */
    String EXPIRES_IN = "expires_in";
    /**
     * 账号
     */
    String ACCOUNT = "account";
    /**
     * 用户ID
     */
    String USER_ID = "user_id";
    /**
     * 角色Id
     */
    String ROLE_ID = "role_id";
    /**
     * 部门ID
     */
    String DEPT_ID = "dept_id";
    /**
     * 用户名称
     */
    String USER_NAME = "user_name";
    /**
     * 角色名称
     */
    String ROLE_NAME = "role_name";
    /**
     * 租户ID
     */
    String TENANT_ID = "tenant_id";
    /**
     * oauthId
     */
    String OAUTH_ID = "oauth_id";
    /**
     * 客户端ID
     */
    String CLIENT_ID = "client_id";
    /**
     * 授权
     */
    String LICENSE = "license";
    /**
     * 授权于
     */
    String LICENSE_NAME = "powered by leaf";
    /**
     * 默认的头衔地址
     */
    String DEFAULT_AVATAR = "https://gw.alipayobjects.com/zos/rmsportal/BiazfanxmamNRoxxVxka.png";
    /**
     * 权限长度
     */
    Integer AUTH_LENGTH = 7;

    /**
     * token签名
     */
    String SIGN_KEY = "leafxisapowerfulmicroservicearchitectureupgradedandoptimizedfromacommercialproject";
    /**
     * key安全长度，具体见：https://tools.ietf.org/html/rfc7518#section-3.2
     */
    int SIGN_KEY_LENGTH = 32;
}
