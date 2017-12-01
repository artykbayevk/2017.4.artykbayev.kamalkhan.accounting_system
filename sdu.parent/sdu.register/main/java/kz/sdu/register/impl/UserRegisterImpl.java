package kz.sdu.register.impl;

import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.sdu.controller.model.UserCtrlModel;
import kz.sdu.controller.model.UserInfo;
import kz.sdu.controller.register.UserRegister;
import kz.sdu.register.dao.UserDao;
import kz.sdu.register.models.UserDot;


@Bean

public class UserRegisterImpl implements UserRegister {

  public BeanGetter<UserDao> userDaoBeanGetter;

  @Override
  public UserCtrlModel getWholeUserInfo(String userid){
    UserDot tmp = userDaoBeanGetter.get().getWholeSelect(userid);
    UserCtrlModel x = new UserCtrlModel(tmp.userid, tmp.surname, tmp.name, tmp.password, tmp.age, tmp.email, tmp.telephone, tmp.companyId, tmp.ismanager,tmp.isadmin);
    return x;
  }

  @Override
  public UserInfo getUserInfo(String personId){return null;}

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
