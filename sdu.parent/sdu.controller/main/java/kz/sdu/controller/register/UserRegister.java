package kz.sdu.controller.register;

import kz.sdu.controller.model.UserInfo;

public interface UserRegister {
    UserInfo getUserInfo(String personId);
    String registerUser(String input);
    String checkUser(String input);
    String acceptUser(String genNumber);
}
