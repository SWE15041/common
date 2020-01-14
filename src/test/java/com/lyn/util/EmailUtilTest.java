package com.lyn.util;

import com.lyn.entity.email.MailMessage;
import com.lyn.entity.email.SystemProperties;
import org.junit.Test;

public class EmailUtilTest {

    @Test
    public void sendTextMail() {
        MailMessage mailMessage = new MailMessage();
        mailMessage.setFromAddress(SystemProperties.MAIL_SMTP_FROMADDRESS);
        mailMessage.setPassword(SystemProperties.MAIL_SMTP_PASSWORD);
        mailMessage.setToAddress("851059946@qq.com");
        mailMessage.setSubject("test2");
        mailMessage.setText("text content");
        EmailUtil.sendTextMail(mailMessage);
//        sendTextMail(mailMessage);
    }
}