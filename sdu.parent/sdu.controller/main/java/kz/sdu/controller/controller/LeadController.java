package kz.sdu.controller.controller;

import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.mvc.annotations.*;
import kz.sdu.controller.model.LeadInfo;
import kz.sdu.controller.register.CompanyRegister;
import kz.sdu.controller.register.LeadRegister;
import kz.sdu.controller.utils.Controller;

import java.util.List;


@Bean
@Mapping("/lead")
public class LeadController implements Controller {
    public BeanGetter<LeadRegister> leadRegisterBeanGetter;

    @ToJson
    @Mapping("/save")
    public String registerCompany(@RequestInput String input){
        return leadRegisterBeanGetter.get().saveLead(input);
    }

    @ToJson
    @Mapping("/getNotAcceptedLeads")
    public List<LeadInfo> getAllNotAcceptedLeads(){
        return leadRegisterBeanGetter.get().getAllNotAcceptedLeads();
    }

    @ToJson
    @Mapping("/getAllLeads")
    public List<LeadInfo> getAllLeads(){
        return leadRegisterBeanGetter.get().getAllLeadList();
    }





    @ToJson
    @Mapping("/getAllMyNotAcceptedLeads")
    public List<LeadInfo> getAllMyNotAcceptedLeads(@Par("managerid") String userid){ return leadRegisterBeanGetter.get().getAllMyNotAcceptedLeads(userid); }





    @ToJson
    @Mapping("/getAllMyAcceptedLeads")
    public List<LeadInfo> getAllMyAcceptedLeads(@Par("managerid") String userid){ return leadRegisterBeanGetter.get().getAllMyAcceptedLeads(userid); }

    @ToJson
    @Mapping("/getAllNotMyAcceptedLeads")
    public List<LeadInfo> getAllNotMyAcceptedLeads(@Par("clientid") String clientid){
        return leadRegisterBeanGetter.get().getAllNotMyAcceptedLeads(clientid);
    }

    @ToJson()
    @Mapping("/getAllMyActiveLeads")
    public List<LeadInfo> getAllMyActiveLeads(@Par("clientid") String clientid){
        return leadRegisterBeanGetter.get().getAllMyActiveLeads(clientid);
    }

    @ToJson
    @Mapping("/getAllMyFinishedLeads")
    public List<LeadInfo> getAllMyFinishedLeads(@Par("clientid") String clientid){
        return leadRegisterBeanGetter.get().getAllMyFinishedLeads(clientid);
    }


    @ToJson
    @Mapping("/acceptLead")
    public String acceptLead(@Par("leadid") String leadid){
        return leadRegisterBeanGetter.get().acceptLead(leadid);
    }

    @ToJson
    @Mapping("/declineLead")
    public String declineLead(@Par("leadid") String leadid){
        return leadRegisterBeanGetter.get().declineLead(leadid);
    }



    @ToJson
    @Mapping("/startLead")
    public String startLead(@Par("clid") String clientid, @Par("lid") String leadid){
        return leadRegisterBeanGetter.get().startLead(leadid, clientid);
    }

    @ToJson
    @Mapping("/stopLead")
    public String stopLead(@Par("lid") String leadid){
        return leadRegisterBeanGetter.get().stopLead(leadid);
    }
}
