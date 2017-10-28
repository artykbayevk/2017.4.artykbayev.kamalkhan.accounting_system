package kz.sdu.controller.controller;

import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.mvc.annotations.Mapping;
import kz.greetgo.mvc.annotations.Par;
import kz.greetgo.mvc.annotations.ToJson;
import kz.sdu.controller.model.AuthInfo;
import kz.sdu.controller.register.AuthRegister;
import kz.sdu.controller.utils.Controller;

@Bean
@Mapping("/auth")
public class AuthController implements Controller{
    public BeanGetter<AuthRegister> authRegister;

    @ToJson
    @Mapping("/login")
    public AuthInfo getAuthInfo(@Par("login")String login, @Par("password") String password) {
        return authRegister.get().getAuthInfo(login, password);
    }

}
