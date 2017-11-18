package kz.sdu.register.impl;

import kz.greetgo.depinject.core.Bean;
import kz.sdu.controller.model.UserInfo;
import kz.sdu.controller.register.UserRegister;

@Bean
public class UserRegisterImpl implements UserRegister {

  public UserInfo getUserInfo(String personId) {
    return null;
  }

  @Override
  public String registerUser(String input){
    return null;
  }

  @Override
  public String checkUser(String input){
    return null;
  }

  @Override
  public String acceptUser(String genNumber){
    return null;
  }


}
