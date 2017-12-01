package kz.sdu.stand.register_stand_imlp;

import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.sdu.controller.model.UserCtrlModel;
import kz.sdu.controller.register.ClientRegister;
import kz.sdu.stand.register_stand_imlp.db.Db;
import kz.sdu.stand.register_stand_imlp.model.UserStandModel;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Bean
public class ClientRegisterStandImpl implements ClientRegister {

    public BeanGetter<Db> db;

    @Override
    public UserCtrlModel getClientById(String id) {
        UserStandModel cl = db.get().clientsList.get(id);
        UserCtrlModel x = new UserCtrlModel(cl.id, cl.surname, cl.name, cl.password, cl.age, cl.email, cl.tel_number, cl.companyId, cl.isManager, cl.isAdmin);
        return x;
    }

    @Override
    public List<UserCtrlModel> getClientsList() {
        List<UserCtrlModel> list = new ArrayList<UserCtrlModel>();
        for (String id : db.get().clientsList.keySet()) {
            UserStandModel cl = db.get().clientsList.get(id);
            UserCtrlModel x = new UserCtrlModel(cl.id, cl.surname, cl.name, cl.password, cl.age, cl.email, cl.tel_number, cl.companyId, cl.isManager, cl.isAdmin);
            list.add(x);
        }
        return list;
    }

    @Override
    public String saveClient(String data) {
            return "Ok";
    }

    public String deleteClient(String data) {
        JSONObject obj = new JSONObject(data);
        db.get().clientsList.remove(obj.getString("id"));
        return "Ok, deleted";
    }
}