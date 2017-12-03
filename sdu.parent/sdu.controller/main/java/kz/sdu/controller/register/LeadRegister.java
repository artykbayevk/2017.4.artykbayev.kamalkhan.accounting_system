package kz.sdu.controller.register;

import kz.sdu.controller.model.LeadInfo;

import java.util.List;

public interface LeadRegister {
    String saveLead(String input);
    List<LeadInfo> getAllLeadList();
    List<LeadInfo> getAllNotAcceptedLeads();

    List<LeadInfo> getAllMyLeads(String userid);
    List<LeadInfo> getAllMyNotAcceptedLeads(String userid);
    List<LeadInfo> getAllMyAcceptedLeads(String userid);
    String stopLead(String leadid);
    String startLead(String leadid, String clientid);
    LeadInfo getLeadById(String leadid);
    String acceptLead(String leadid);
}
