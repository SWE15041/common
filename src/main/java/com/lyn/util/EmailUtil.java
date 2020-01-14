package com.lyn.util;


import com.lyn.entity.email.MailMessage;
import com.lyn.entity.email.SystemProperties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.net.StandardSocketOptions;
import java.util.Date;
import java.util.Properties;

/**
 * @author lyn
 */
public class EmailUtil {

    private static Properties properties;
    private static Session session;


    /**
     * 1.初始化发送方服务器配置
     */
    private static void initSenderServerConfig() {
        properties = new Properties();
        properties.setProperty("mail.smtp.host", SystemProperties.MAIL_SMTP_HOST);
        properties.setProperty("mail.smtp.port", SystemProperties.MAIL_SMTP_PORT);
        properties.setProperty("mail.transport.protocol", SystemProperties.MAIL_TRANSPORT_PROTOCOL);
        properties.setProperty("mail.smtp.auth", SystemProperties.MAIL_SMTP_AUTH);
    }

    /**
     * 2.发送简单的文本类型的邮件
     *
     * @param mailMessage
     */
    public static void sendTextMail(final MailMessage mailMessage) {
        try {
            initSenderServerConfig();
            if (properties == null) {
                return;
            }
            session = Session.getDefaultInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(mailMessage.getFromAddress(), mailMessage.getPassword());
                }
            });
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(mailMessage.getFromAddress()));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(mailMessage.getToAddress()));
            message.setSubject(mailMessage.getSubject());
            message.setText(mailMessage.getText());
            message.setSentDate(new Date());
            Transport.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * todo 发送html内容格式的邮件
     */
    public static void sendHtmlTextMail() {

    }

    /**
     * todo 发送带附件的邮件
     */
    public static void sendFileMail(){

    }
    public static void main(String[] args) {
    }

}
