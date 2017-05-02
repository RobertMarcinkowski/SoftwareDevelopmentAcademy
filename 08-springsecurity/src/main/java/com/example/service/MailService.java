package com.example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Created by USER on 2017-03-11.
 */
@Service
public class MailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MailService.class);

    @Value("${app.registrationAddress}")
    private String APP_REGISTRATION;

    @Value("${mail.smtp.port}")
    private String SMTP_PORT;

    @Value("${mail.smtp.auth}")
    private String SMTP_AUTH;

    @Value("${mail.smtp.starttls.enable}")
    private String SMTP_STARTTLS_ENABLE;

    @Value("${mail.smtp.address}")
    private String SMTP_ADDRESS;

    @Value("${mail.smtp.login}")
    private String SMTP_LOGIN;

    @Value("${mail.smtp.password}")
    private String SMTP_PASSWORD;

    /*
    https://www.google.com/settings/security/lesssecureapps
    go to your account and turn on the security it will work
    */
    public void sendMail(String eMail, String code) throws MessagingException {
        // Set mail properties
        Properties mailServerProperties = System.getProperties();
        mailServerProperties.put("mail.smtp.port", SMTP_PORT);
        mailServerProperties.put("mail.smtp.auth", SMTP_AUTH);
        mailServerProperties.put("mail.smtp.starttls.enable", SMTP_STARTTLS_ENABLE);

        // Set session properties
        Session getMailSession = Session.getDefaultInstance(mailServerProperties, null);
        MimeMessage generateMailMessage = new MimeMessage(getMailSession);
        generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(eMail));
        try {
            generateMailMessage.setSubject("Registration SpringSec");
        } catch (MessagingException e) {
            LOGGER.error(e.getMessage());
        }
        String registartionAddress = APP_REGISTRATION + code;
        String emailBody = "Confirm your registration. <br>"
                + "<a href=&quot;" + registartionAddress + "&quot;>" + registartionAddress + "</a>";
        generateMailMessage.setContent(emailBody, "text/html");

        // Step3
        Transport transport = getMailSession.getTransport("smtp");

        // Enter your correct gmail UserID and Password
        // if you have 2FA enabled then provide App Specific Password
        transport.connect(SMTP_ADDRESS, SMTP_LOGIN, SMTP_PASSWORD);
        transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
        transport.close();
    }
}