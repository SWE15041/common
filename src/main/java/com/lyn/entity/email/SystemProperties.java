package com.lyn.entity.email;

import com.lyn.util.SystemParamUtil;
import lombok.Data;

import java.util.Properties;

/**
 * @author lyn
 */
@Data
public class SystemProperties {

    public static String MAIL_SMTP_HOST;

    public static String MAIL_SMTP_PORT;

    public static String MAIL_TRANSPORT_PROTOCOL;

    public static String MAIL_SMTP_AUTH;

    public static String MAIL_SMTP_FROMADDRESS;

    public static String MAIL_SMTP_PASSWORD;

    static {
        init();
    }

    private static void init() {
        Properties properties = SystemParamUtil.getSystemConfProps();
        MAIL_SMTP_HOST = String.valueOf(properties.get("mail.smtp.host"));
        MAIL_SMTP_PORT = String.valueOf(properties.get("mail.smtp.port"));
        MAIL_TRANSPORT_PROTOCOL = String.valueOf(properties.get("mail.smtp.transport.protocol"));
        MAIL_SMTP_AUTH = String.valueOf(properties.get("mail.smtp.auth"));
        MAIL_SMTP_FROMADDRESS = String.valueOf(properties.get("mail.smtp.fromAddress"));
        MAIL_SMTP_PASSWORD = String.valueOf(properties.get("mail.smtp.password"));
    }

    public static void main(String[] args) {
//        new SystemProperties() ;
        String mailSmtpPort = SystemProperties.MAIL_SMTP_PORT;
        System.out.println(mailSmtpPort);

    }
}
