package kz.sdu.register.impl;

import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.email.Email;
import kz.greetgo.email.EmailSender;
import kz.greetgo.email.EmailSenderController;
import kz.sdu.controller.register.SendEmailRegister;

@Bean
public class SendEmailRegisterImpl implements SendEmailRegister {

    public BeanGetter<EmailSender> emailSender;

    public BeanGetter<EmailSenderController> emailSenderController;

    @Override
    public void toSend(){
        emailSenderController.get().sendAllExistingEmails();
    }

    @Override
    public void prepareSendEmail(){
        Email email = new Email();
        email.setFrom("kamalkhan.sdu@gmail.com");
        email.setTo("dandibobo537@gmail.com");
        email.setSubject("This is subj");
        email.setBody("Hi bro");
        emailSender.get().send(email);
    }
}
