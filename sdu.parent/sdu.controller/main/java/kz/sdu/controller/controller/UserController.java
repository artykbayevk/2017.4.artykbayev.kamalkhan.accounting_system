package kz.sdu.controller.controller;


import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.mvc.annotations.Mapping;
import kz.greetgo.mvc.annotations.Par;
import kz.greetgo.mvc.annotations.RequestInput;
import kz.greetgo.mvc.annotations.ToJson;
import kz.sdu.controller.model.AuthInfo;
import kz.sdu.controller.model.UserCtrlModel;
import kz.sdu.controller.model.UserInfo;
import kz.sdu.controller.register.UserRegister;
import kz.sdu.controller.utils.Controller;

import java.util.List;

@Bean
@Mapping("/user")
public class UserController implements Controller {

    public BeanGetter<UserRegister> userRegister;

    @ToJson
    @Mapping("/info")
    public UserInfo getUserInfo(@Par("personId") String personId) {
        System.out.println(personId);
        return userRegister.get().getUserInfo(personId);
    }

    @ToJson
    @Mapping("/save")
    public String registerUser(@RequestInput String input){
        return userRegister.get().registerUser(input);
    }

    @ToJson
    @Mapping("/check")
    public AuthInfo checkUser(@RequestInput String input){
        return userRegister.get().authUser(input);
    }

    @ToJson
    @Mapping("/getInfo")
    public UserCtrlModel getWholeUserInfo(@Par("id") String id){ return userRegister.get().getWholeUserInfo(id);}

    @ToJson
    @Mapping("/getNotAccepted")
    public List<UserCtrlModel> getAllNotAcceptedUsers(){
        return userRegister.get().getNotAcceptedUsersList();
    }

    @ToJson
    @Mapping("/acceptUserFromAdmin")
    public String acceptUserFromAdmin(@Par("userid") String userid){
        return userRegister.get().acceptUser(userid);
    }

    @ToJson
    @Mapping("/declineUserFromAdmin")
    public String declineUserFromAdmin(@Par("userid") String userid){
        return userRegister.get().declineUser(userid);
    }
}