package kz.sdu.register.impl;

import kz.greetgo.depinject.core.Bean;
import kz.sdu.controller.model.ClientListDetails;
import kz.sdu.controller.model.UserCtrlModel;
import kz.sdu.controller.register.ClientRegister;

import java.util.List;


@Bean
public class ClientRegisterImpl implements ClientRegister {

  @Override
  public UserCtrlModel getClientById(String id){
    return null;
  }
  @Override
  public List<UserCtrlModel> getClientsList(){
    return null;
  }

  @Override
  public String saveClient(String input){
    return null;
  }

  @Override
  public String deleteClient(String id){
    return null;
  }
}
