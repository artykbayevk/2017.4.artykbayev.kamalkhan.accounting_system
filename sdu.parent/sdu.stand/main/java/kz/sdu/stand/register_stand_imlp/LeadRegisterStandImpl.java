package kz.sdu.stand.register_stand_imlp;

import kz.greetgo.depinject.core.Bean;
import kz.sdu.controller.model.LeadInfo;
import kz.sdu.controller.register.LeadRegister;

import java.util.List;

@Bean
public class LeadRegisterStandImpl implements LeadRegister{
    @Override
    public List<LeadInfo> getAllNotMyAcceptedLeads(String clientid) {
        return null;
    }

    @Override
    public String acceptLead(String leadid) {
        return null;
    }

    @Override
    public String saveLead(String input) {
        return null;
    }

    @Override
    public List<LeadInfo> getAllLeadList() {
        return null;
    }

    @Override
    public List<LeadInfo> getAllMyActiveLeads(String clientid) {
        return null;
    }

    @Override
    public List<LeadInfo> getAllNotAcceptedLeads() {
        return null;
    }

    @Override
    public List<LeadInfo> getAllMyLeads(String userid) {
        return null;
    }

    @Override
    public List<LeadInfo> getAllMyNotAcceptedLeads(String userid) {
        return null;
    }

    @Override
    public List<LeadInfo> getAllMyAcceptedLeads(String userid) {
        return null;
    }

    @Override
    public String stopLead(String leadid) {
        return null;
    }

    @Override
    public String startLead(String leadid, String clientid) {
        return null;
    }

    @Override
    public LeadInfo getLeadById(String leadid) {
        return null;
    }

    @Override
    public List<LeadInfo> getAllMyFinishedLeads(String clientid) {
        return null;
    }

    @Override
    public String declineLead(String leadid) {
        return null;
    }
}
