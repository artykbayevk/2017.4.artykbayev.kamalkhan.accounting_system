package kz.sdu.controller.controller;

import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.mvc.annotations.Mapping;
import kz.greetgo.mvc.annotations.ParPath;
import kz.sdu.controller.register.IntroductionRegister;
import kz.sdu.controller.register.UserRegister;
import kz.sdu.controller.utils.Controller;

@Bean
@Mapping("/email")
public class EmailSendController implements Controller {


    public BeanGetter<UserRegister> userRegisterBeanGetter;

    @Mapping("/{generatedNumber}")
    public void sentEmail(@ParPath("generatedNumber") String num){
        System.out.println(num);
//        String username = userRegisterBeanGetter.get().acceptUser(num);
//        System.out.println(username);
    }
}
