package kz.sdu.register.impl;

import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.email.Email;
import kz.greetgo.email.EmailSender;
import kz.greetgo.email.EmailSenderController;
import kz.sdu.controller.model.AuthInfo;
import kz.sdu.controller.register.AuthRegister;

@Bean
public class AuthRegisterImpl implements AuthRegister {



  @Override
  public AuthInfo getAuthInfo(String accountName, String password) {
    return null;
  }
}
