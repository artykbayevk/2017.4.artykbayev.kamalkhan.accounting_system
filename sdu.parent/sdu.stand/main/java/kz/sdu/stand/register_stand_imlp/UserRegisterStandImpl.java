package kz.sdu.stand.register_stand_imlp;

import com.google.common.base.Strings;
import kz.greetgo.depinject.Depinject;
import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.email.Email;
import kz.greetgo.email.EmailSender;
import kz.greetgo.email.EmailSenderController;
import kz.sdu.controller.model.AuthInfo;
import kz.sdu.controller.model.UserCtrlModel;
import kz.sdu.controller.model.UserInfo;
import kz.sdu.controller.register.UserRegister;
import kz.sdu.stand.bean_containers.StandBeanContainer;
import kz.sdu.stand.register_stand_imlp.db.Db;
import kz.sdu.stand.register_stand_imlp.model.UserStandModel;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Bean
public class UserRegisterStandImpl implements UserRegister {
    public BeanGetter<Db> db;

    public BeanGetter<EmailSender> emailSenderBeanGetter;


    @Override
    public List<UserCtrlModel> getNotAcceptedUsersList(){return null;}

    @Override
    public UserCtrlModel getWholeUserInfo(String id){
        return null;
    }

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
    public AuthInfo authUser(String input){return null;}

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
            UserStandModel x = new UserStandModel(uuid, surname, name, password, age, email, tel_number, companyId, isManager,false, false);
            db.get().clientsList.put(uuid, x);


            String body = "This is your link for registration:\n http://localhost:1313/sdu/api/email/"+urlGenerator(email);



            Email emailSend = new Email();
            emailSend.setFrom("checker@gmail.com");
            emailSend.setTo(email);
            emailSend.setSubject("Registration Finish");
            emailSend.setBody(body);


            emailSenderBeanGetter.get().send(emailSend);
            return "Ok, saved and prepare for sending your email";
        } else {
            UserStandModel x = new UserStandModel(uuid, surname, name, password, age, email, tel_number, companyId, isManager,false,false);
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
                System.out.println(cl.isAccepted);
                if (cl.isAccepted){
                    return "found,"+tmp;
                }else{
                    return "not activated";
                }
            }
        }
        return found;
    }


    public String urlGenerator(String username){
        long lowerLimit = 123456712L;
        long upperLimit = 234567892L;
        Random r = new Random();
        long number = lowerLimit+((long)(r.nextDouble()*(upperLimit-lowerLimit)));
        db.get().linkStorage.put(number, username);
        String strLong = Long.toString(number);
        return strLong;
    }

    @Override
    public List<UserCtrlModel> getUsersList(){
        return null;
    }

    @Override
    public String acceptUser(String userid){
//        String username = db.get().linkStorage.get(Long.valueOf(genNumber));
//        for (String id : db.get().clientsList.keySet()) {
//            UserStandModel cl = db.get().clientsList.get(id);
//            if(cl.email.equals(username)){
//                cl.setAccepted(true);
//            }
//        }
//        return username;
        return userid;
    }

    @Override
    public String updateIsAccept(String genNumber){return null;}

    @Override
    public String declineUser(String userid) {
        return null;
    }
}
