package com.lyn.entity.email;

/**
 * 发送方服务器配置信息
 *
 * @author lyn
 */
public class ServerConfig {

    /**
     * 发送方服务器地址；
     * 例：smtp.qq.com
     */
    private String host;

    /**
     * 服务器端口；
     * 例：587
     */
    private String port;

    /**
     * 邮箱地址；
     * 例：xxx@qq.com
     */
    private String address;

    /**
     * 发送方邮箱密码；
     * 由于是第三方，使用官方授权生成的授权码
     */
    private String password;

}
