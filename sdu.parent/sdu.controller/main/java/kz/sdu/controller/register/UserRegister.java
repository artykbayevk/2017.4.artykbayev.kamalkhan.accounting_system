package kz.sdu.controller.register;

import kz.sdu.controller.model.AuthInfo;
import kz.sdu.controller.model.UserCtrlModel;
import kz.sdu.controller.model.UserInfo;

import java.util.List;

public interface UserRegister {
    UserCtrlModel getWholeUserInfo(String id);
    String registerUser(String input);
    AuthInfo authUser(String input);
    List<UserCtrlModel> getUsersList();
    List<UserCtrlModel> getNotAcceptedUsersList();
    String acceptUser(String userid);
    String declineUser(String userid);

    String updateIsAccept(String genNumber);

    UserInfo getUserInfo(String personId);
    String checkUser(String input);

}
