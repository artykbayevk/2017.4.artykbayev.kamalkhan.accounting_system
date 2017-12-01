package kz.sdu.register.impl;

import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.sdu.controller.model.AuthInfo;
import kz.sdu.controller.register.AuthRegister;
import kz.sdu.register.dao.AuthDao;
import kz.greetgo.util.RND;

import java.util.Date;


@Bean
public class AuthRegisterImpl implements AuthRegister {

  public BeanGetter<AuthDao> authDao;

  @Override
  public AuthInfo getAuthInfo(String accountName, String password) {
    AuthInfo ret=new AuthInfo();
    ret.personId=authDao.get().getPersonId(accountName,password);
    ret.token= RND.str(15);
    return ret;
  }

  @Override
  public Date getSysdate() {
    return authDao.get().getSysdate();
  }
}
