package kz.sdu.register.beans.all.any_db;

import com.sun.mail.smtp.SMTPTransport;
import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.sdu.register.config.DbConfig;
import kz.sdu.register.util.GCommonConstant;
import kz.greetgo.email.Email;
import kz.greetgo.email.EmailSaver;
import kz.greetgo.email.EmailSender;
import kz.greetgo.email.EmailSenderController;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.security.Security;
import java.util.Date;
import java.util.Properties;

@Bean
public class SendEmailFactory {
  public BeanGetter<DbConfig> dbConfig;

  @Bean
  public EmailSender createEmailSender(){
    return new EmailSaver("Education","build/toSend");
  }

  @Bean
  public EmailSenderController createEmailSenderController(){
    File sendDir = new File("build/toSend");
    File sendedDir = new File("build/sended");

    return new EmailSenderController(getRealEmailSender(),sendDir,sendedDir);
  }

  public EmailSender getRealEmailSender() {
    return new EmailSender() {
      @Override
      public void send(Email email) {
        try {
          sendInner(email);
        } catch (Exception e){
          throw new RuntimeException(e);
        }
      }

      private void sendInner(Email email) throws Exception{
        Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());

        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";

        Properties props = System.getProperties();
        props.setProperty("mail.smtps.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.port", "465");
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.ssl.trust", "smtp.gmail.com");
        props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);


        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
          protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(dbConfig.get().loginAccount(), dbConfig.get().accountPassword());
          }
        });
        session.setDebug(false);

        final MimeMessage msg = new MimeMessage(session);


        msg.setFrom(new InternetAddress(email.getFrom()));
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email.getTo(), true));

        msg.setSubject(email.getSubject());

        msg.setText(email.getBody(), "UTF-8");
        msg.setSentDate(new Date());

        SMTPTransport t = (SMTPTransport) session.getTransport("smtp");

        t.connect("smtp.gmail.com", dbConfig.get().loginAccount(), dbConfig.get().accountPassword());
        t.sendMessage(msg, msg.getAllRecipients());

        t.close();
      }
    };
  }
}
