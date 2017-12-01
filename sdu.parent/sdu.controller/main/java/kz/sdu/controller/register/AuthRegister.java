package kz.sdu.controller.register;

import kz.sdu.controller.model.AuthInfo;

import java.util.Date;

public interface AuthRegister {
    AuthInfo getAuthInfo(String accountName, String password);
    Date getSysdate();
}
