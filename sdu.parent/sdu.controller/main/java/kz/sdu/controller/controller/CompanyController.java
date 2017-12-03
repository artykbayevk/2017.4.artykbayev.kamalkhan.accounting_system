package kz.sdu.controller.controller;

import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.mvc.annotations.Mapping;
import kz.greetgo.mvc.annotations.RequestInput;
import kz.greetgo.mvc.annotations.ToJson;
import kz.sdu.controller.register.CompanyRegister;
import kz.sdu.controller.register.UserRegister;
import kz.sdu.controller.utils.Controller;


@Bean
@Mapping("/company")
public class CompanyController implements Controller {
    public BeanGetter<CompanyRegister> companyRegisterBeanGetter;

    @ToJson
    @Mapping("/save")
    public String registerCompany(@RequestInput String input){
        return companyRegisterBeanGetter.get().saveCompany(input);
    }
}
