package com.example.sqlite_connect.utilities;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * The type Email.
 */
public class Email {
    /**
     * The To.
     */
    String to, /**
     * The From.
     */
    from, /**
     * The Password.
     */
    password, /**
     * The Subject.
     */
    subject, /**
     * The Text.
     */
    text;

    /**
     * Instantiates a new Email.
     *
     * @param to       the to
     * @param from     the from
     * @param password the password
     * @param subject  the subject
     * @param text     the text
     */
    public Email(String to, String from, String password, String subject, String text) {
        this.to = to;
        this.from = from;
        this.password = password;
        this.subject = subject;
        this.text = text;
    }

    /**
     * Send.
     */
    public void send() {
        //https://myaccount.google.com/lesssecureapps
        //https://accounts.google.com/b/0/DisplayUnlockCaptcha

        final String username = this.from;
        final String password = this.password;

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true"); //TLS

        Authenticator auth = new Authenticator() {
            // override the getPasswordAuthentication method
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        };

        Session session = Session.getDefaultInstance(props, auth);
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(this.from));
            message.setRecipients(
                Message.RecipientType.TO,
                InternetAddress.parse(this.to)
            );
            message.setSubject(this.subject);
            message.setText(this.text);

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
