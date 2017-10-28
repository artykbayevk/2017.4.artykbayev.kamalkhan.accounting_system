package kz.sdu.controller.register;

import kz.sdu.controller.model.AuthInfo;

public interface AuthRegister {
    AuthInfo getAuthInfo(String accountName, String password);

}
