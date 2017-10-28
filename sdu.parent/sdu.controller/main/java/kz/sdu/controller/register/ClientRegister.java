package kz.sdu.controller.register;

import kz.sdu.controller.model.UserCtrlModel;

import java.util.List;

public interface ClientRegister {
    UserCtrlModel getClientById(String id);
    List<UserCtrlModel> getClientsList();
    String saveClient(String input);
    String deleteClient(String id);

}
