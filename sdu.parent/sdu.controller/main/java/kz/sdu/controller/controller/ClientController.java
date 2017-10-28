package kz.sdu.controller.controller;

import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.mvc.annotations.*;
import kz.sdu.controller.model.UserCtrlModel;
import kz.sdu.controller.register.ClientRegister;
import kz.sdu.controller.utils.Controller;

import java.util.List;

@Bean
@Mapping("/client")
public class ClientController implements Controller {
    public BeanGetter<ClientRegister> clientRegister;

    @ToJson
    @Mapping("/getClientById")
    public UserCtrlModel getClientByThisId(@Par("id") String id){
        return clientRegister.get().getClientById(id);
    }

    @ToJson
    @Mapping("/getClients")
    public List<UserCtrlModel> getClients(){
        return clientRegister.get().getClientsList();
    }

    @ToJson
    @Mapping("/saveClient")
    public String saveClient(@RequestInput String input){ return clientRegister.get().saveClient(input); }

    @ToJson
    @Mapping("/deleteClient")
    public String deleteClient(@RequestInput String input){
        return clientRegister.get().deleteClient(input);
    }
}
