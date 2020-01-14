package com.lyn.entity.email;

import lombok.Data;

import java.io.Serializable;

/**
 * @author lyn
 */
@Data
public class MailMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 邮件编码
     */
    private String id;

    /**
     * 发送方邮件地址
     */
    private String fromAddress;

    /**
     * 发送方密码（第三方授权码）
     */
    private String password;

    /**
     * 接收方邮件地址
     */

    private String toAddress;

    /**
     * 邮件文本内容
     */
    private String text;

    /**
     * 邮件题目
     */
    private String subject;





}