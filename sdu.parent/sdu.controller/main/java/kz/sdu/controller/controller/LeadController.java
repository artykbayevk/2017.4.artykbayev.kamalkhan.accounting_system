package kz.sdu.controller.controller;

import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.mvc.annotations.Mapping;
import kz.greetgo.mvc.annotations.RequestInput;
import kz.greetgo.mvc.annotations.ToJson;
import kz.sdu.controller.register.CompanyRegister;
import kz.sdu.controller.register.LeadRegister;
import kz.sdu.controller.utils.Controller;


@Bean
@Mapping("/lead")
public class LeadController implements Controller {
    public BeanGetter<LeadRegister> leadRegisterBeanGetter;

    @ToJson
    @Mapping("/save")
    public String registerCompany(@RequestInput String input){
        return leadRegisterBeanGetter.get().saveLead(input);
    }
}
