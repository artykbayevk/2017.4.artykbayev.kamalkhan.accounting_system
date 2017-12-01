package kz.sdu.controller.register;

import kz.sdu.controller.model.UserCtrlModel;
import kz.sdu.controller.model.UserInfo;

public interface UserRegister {
    UserCtrlModel getWholeUserInfo(String id);
    UserInfo getUserInfo(String personId);
    String registerUser(String input);
    String checkUser(String input);
    String acceptUser(String genNumber);
}
