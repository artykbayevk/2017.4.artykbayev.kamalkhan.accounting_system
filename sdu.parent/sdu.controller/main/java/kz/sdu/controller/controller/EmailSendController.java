package kz.sdu.controller.controller;

import kz.greetgo.depinject.core.Bean;
import kz.greetgo.mvc.annotations.Mapping;
import kz.greetgo.mvc.annotations.ParPath;
import kz.sdu.controller.utils.Controller;

@Bean
@Mapping("/email")
public class EmailSendController implements Controller {

    @Mapping("/{generatedNumber}")
    public void sentEmail(@ParPath("generatedNumber") String num){
        System.out.println(num);
    }
}
