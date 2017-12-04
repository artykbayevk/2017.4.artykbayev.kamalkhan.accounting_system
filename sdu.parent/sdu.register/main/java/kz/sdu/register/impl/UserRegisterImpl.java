package kz.sdu.register.impl;

import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.email.Email;
import kz.greetgo.email.EmailSender;
import kz.greetgo.email.EmailSenderController;
import kz.greetgo.util.RND;
import kz.sdu.controller.model.AuthInfo;
import kz.sdu.controller.model.UserCtrlModel;
import kz.sdu.controller.model.UserInfo;
import kz.sdu.controller.register.UserRegister;
import kz.sdu.register.dao.CompanyDao;
import kz.sdu.register.dao.UserDao;
import kz.sdu.register.models.CompanyDot;
import kz.sdu.register.models.UserDot;
import kz.sdu.register.util.GCommonConstant;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

@Bean
public class UserRegisterImpl implements UserRegister {


  public BeanGetter<EmailSender> emailSender;
  public BeanGetter<EmailSenderController> emailSenderController;
  public BeanGetter<UserDao> userDaoBeanGetter;
  public BeanGetter<CompanyDao> companyDaoBeanGetter;

  @Override
  public UserCtrlModel getWholeUserInfo(String userid){
    UserDot tmp = userDaoBeanGetter.get().getWholeSelect(userid);
    UserCtrlModel x = new UserCtrlModel(tmp.userid, tmp.surname, tmp.name, tmp.password, tmp.age, tmp.email, tmp.telephone, tmp.companyId, tmp.ismanager,tmp.isadmin);
    return x;
  }

  @Override
  public List<UserCtrlModel> getUsersList(){
    List<UserDot> cl = userDaoBeanGetter.get().getAllUsersList();
    List<UserCtrlModel> out = new ArrayList<UserCtrlModel>();
    for (UserDot x: cl) {
        UserCtrlModel tmp = new UserCtrlModel(x.userid, x.surname, x.name, x.password, x.age, x.email, x.telephone,x.companyId, x.ismanager, x.isadmin);
        out.add(tmp);
    }
    return out;
  }

  @Override
  public List<UserCtrlModel> getNotAcceptedUsersList(){
      List<UserDot> cl = userDaoBeanGetter.get().getNotAcceptedUsers();
      List<UserCtrlModel> out = new ArrayList<UserCtrlModel>();
      for (UserDot x: cl) {
          UserCtrlModel tmp = new UserCtrlModel(x.userid, x.surname, x.name, x.password, x.age, x.email, x.telephone,x.companyId, x.ismanager, x.isadmin);
          out.add(tmp);
      }
      return out;
  }

  @Override
  public AuthInfo authUser(String input){
    JSONObject obj = new JSONObject(input);
    String email = obj.getString("email");
    String password = obj.getString("password");
    String userid = userDaoBeanGetter.get().getUserIdSelect(email, password);
    AuthInfo x = new AuthInfo();
    if(userid == null){
      x.token = "not found";
      x.personId = userid;
    }else {
      String isAccepted = userDaoBeanGetter.get().checkIsAccepted(userid);
      if(isAccepted.equals("false")) {
        x.token = "not accepted";
        x.personId = userid;
      }
      else{
        String out_token = userDaoBeanGetter.get().getUserToken(userid);
        if (out_token == null) {
          x.token = RND.str(15);
          x.personId = userid;
          userDaoBeanGetter.get().insertToken(userid, x.token);
        } else {
          x.token = RND.str(15);
          x.personId = userid;
          userDaoBeanGetter.get().updateToken(userid, x.token);
        }
      }
    }
    return x;
  }

  @Override
  public String registerUser(String input){
    String res = "";


    JSONObject obj = new JSONObject(input);
    String uuid = obj.getString("id");
    String name = obj.getString("name");
    String surname = obj.getString("surname");
    String age = obj.getString("age");
    String email = obj.getString("email");
    String tel_number = obj.getString("telephone");
    String companyId = obj.getString("companyId");
    String isManager = obj.getString("isManager").equals("1") ? "true" : "false";
    String password = obj.getString("password");
    String isAccepted = obj.getString("isAccepted").equals("1") ? "true":"false";
    String isAdmin = "false";


    if(uuid.length() == 0){
        String check = userDaoBeanGetter.get().checkEmail(email);
        String companyName = companyDaoBeanGetter.get().getNameOfCompany(companyId);
        if(check != null){
            res = "email";
        }else if(companyName == null){
            res = "company";
        }else{
            uuid = RND.intStr(15);
            userDaoBeanGetter.get().insertPerson(uuid, name, surname, email, password, tel_number, age, companyId, isAccepted, isAdmin, isManager);
            res = "added";
        }
    }else{
        userDaoBeanGetter.get().updatePerson(uuid, name, surname, email, password, tel_number, age, companyId);
        res = "updated";
    }

    return res;
  }

  @Override
  public String acceptUser(String userid){
      String generatedNumber = RND.str(30);
      System.out.println(userid);
      userDaoBeanGetter.get().insertIntoAcceptTable(userid, generatedNumber);
      String emailTo = userDaoBeanGetter.get().getUserEmail(userid);
      userDaoBeanGetter.get().updateIsAccept(userid);

      if(emailTo != null){
          Email email=new Email();
          email.setFrom(GCommonConstant.username);
          email.setTo(emailTo);
          email.setSubject("Accept");
          email.setBody("Hey Bro, we are accept you.\n You can auth in our service");
          emailSender.get().send(email);
      }
      return generatedNumber;
  }

  @Override
  public String declineUser(String userid) {
      System.out.println(userid);
      String emailTo = userDaoBeanGetter.get().getUserEmail(userid);
      userDaoBeanGetter.get().declineUser(userid);
      if(emailTo != null){
          Email email=new Email();
          email.setFrom(GCommonConstant.username);
          email.setTo(emailTo);
          email.setSubject("Decline");
          email.setBody("Hey Bro, sorry but we decline you.\n Goog luck");
          emailSender.get().send(email);
      }
      return "Declined";
  }







  @Override
  public String checkUser(String input){
    return null;
  }

  @Override
  public UserInfo getUserInfo(String personId){
    return null;
  }

  @Override
  public String updateIsAccept(String genNumber){return null;}
}
