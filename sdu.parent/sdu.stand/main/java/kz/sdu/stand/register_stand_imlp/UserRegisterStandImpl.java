package kz.sdu.stand.register_stand_imlp;

import com.google.common.base.Strings;
import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.email.Email;
import kz.greetgo.email.EmailSender;
import kz.greetgo.email.EmailSenderController;
import kz.sdu.controller.model.UserCtrlModel;
import kz.sdu.controller.model.UserInfo;
import kz.sdu.controller.register.UserRegister;
import kz.sdu.stand.register_stand_imlp.db.Db;
import kz.sdu.stand.register_stand_imlp.model.UserStandModel;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Bean
public class UserRegisterStandImpl implements UserRegister {
    public BeanGetter<Db> db;

    public BeanGetter<EmailSender> emailSenderBeanGetter;

    public BeanGetter<EmailSenderController> emailSenderControllerBeanGetter;

    @Override
    public UserInfo getUserInfo(String personId) {
        UserInfo userInfo = new UserInfo();

        String role = db.get().personRoleMapping.get(personId);

        if(!Strings.isNullOrEmpty(role)){
            userInfo.cans.addAll(db.get().roleFuncMapping.get(role)==null?
                    new ArrayList<>():db.get().roleFuncMapping.get(role));
        }

        return userInfo;
    }

    @Override
    public String registerUser(String input){
        JSONObject obj = new JSONObject(input);
        String uuid = obj.getString("id");
        String name = obj.getString("name");
        String surname = obj.getString("surname");
        String age = obj.getString("age");
        String email = obj.getString("email");
        String tel_number = obj.getString("tel_number");
        String companyId = obj.getString("companyId");
        boolean isManager = obj.getString("isManager").equals("1") ? true : false;
        System.out.println(isManager);
        String password = obj.getString("password");


        //validation part
        for (String id : db.get().clientsList.keySet()) {
            UserStandModel cl = db.get().clientsList.get(id);
            if(cl.email.equals(email) && cl.email.equals(tel_number)){
                return "Not saved";
            }
        }
        if (uuid.length() == 0) {
            uuid = UUID.randomUUID().toString();
            UserStandModel x = new UserStandModel(uuid, surname, name, password, age, email, tel_number, companyId, isManager);
            db.get().clientsList.put(uuid, x);
            Email emailSend = new Email();
            emailSend.setFrom("kamalkhan.sdu@gmail.com");
            emailSend.setTo(email);
            emailSend.setSubject("This is subj from my life");
            emailSend.setBody("Hi bro");
            emailSenderBeanGetter.get().send(emailSend);
            emailSenderControllerBeanGetter.get().sendAllExistingEmails();
            return "Ok, saved and sent email";
        } else {
            UserStandModel x = new UserStandModel(uuid, surname, name, password, age, email, tel_number, companyId, isManager);
            db.get().clientsList.put(uuid, x);
            db.get().clientsList.put(uuid, x);
            return "Ok, updated";
        }
    }

    @Override
    public String checkUser(String input){
        JSONObject obj = new JSONObject(input);
        String email = obj.getString("email");
        String password = obj.getString("password");
        String found = "not";
        for (String id : db.get().clientsList.keySet()) {
            UserStandModel cl = db.get().clientsList.get(id);
            if(cl.email.equals(email ) && cl.password.equals(password)){
                String tmp = cl.isManager == true?"1":"2";
                return "found,"+tmp;
            }
        }
        return found;
    }
}
