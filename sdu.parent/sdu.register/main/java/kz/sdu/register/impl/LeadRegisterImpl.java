package kz.sdu.register.impl;

import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.email.Email;
import kz.greetgo.email.EmailSender;
import kz.greetgo.util.RND;
import kz.sdu.controller.model.LeadInfo;
import kz.sdu.controller.register.LeadRegister;
import kz.sdu.register.dao.LeadDao;
import kz.sdu.register.dao.UserDao;
import kz.sdu.register.models.LeadDot;
import kz.sdu.register.models.UserDot;
import kz.sdu.register.util.GCommonConstant;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

@Bean
public class LeadRegisterImpl implements LeadRegister {

    public BeanGetter<LeadDao> leadDaoBeanGetter;
    public BeanGetter<UserDao> userDaoBeanGetter;
    public BeanGetter<EmailSender> emailSender;

    @Override
    public LeadInfo getLeadById(String leadid){
        LeadDot x = leadDaoBeanGetter.get().getLeadById(leadid);
        if(x == null){
            LeadInfo y = new LeadInfo();
            return y;
        }else{
            LeadInfo y = new LeadInfo(x.leadid, x.name, x.type, x.managerid, x.clientid, x.status, x.isaccepted);
            return y;
        }

    }

    @Override
    public String saveLead(String input) {

        JSONObject obj = new JSONObject(input);
        String leadid = obj.getString("leadid");

        String name = obj.getString("name");
        String type = obj.getString("type");

        String managerid = obj.getString("managerid");
        String clientid = obj.getString("clientid");
        String status = obj.getString("status");
        String isaccepted = obj.getString("isaccepted");

        if (leadid.length() == 0){
            leadid = RND.intStr(30);
            leadDaoBeanGetter.get().insertIntoLead(leadid, name,type, managerid, clientid, status, isaccepted);
            return "added";
        }else{
            leadDaoBeanGetter.get().updateLead(leadid, name, type);
            return "updated";
        }
    }

    @Override
    public List<LeadInfo> getAllLeadList() {
        List<LeadDot> cl = leadDaoBeanGetter.get().getAllLeadsListQuery();
        List<LeadInfo> out = new ArrayList<LeadInfo>();
        for(LeadDot x : cl){
            LeadInfo tmp  = new LeadInfo(x.leadid, x.name, x.type, x.managerid, x.clientid, x.status, x.isaccepted);
            out.add(tmp);
        }
        return out;
    }

    @Override
    public List<LeadInfo> getAllMyLeads(String userid) {
        List<LeadDot> cl = leadDaoBeanGetter.get().getAllMyLeadsQuery(userid);
        List<LeadInfo> out = new ArrayList<LeadInfo>();
        for(LeadDot x : cl){
            LeadInfo tmp  = new LeadInfo(x.leadid, x.name, x.type, x.managerid, x.clientid, x.status, x.isaccepted);
            out.add(tmp);
        }
        return out;
    }

    @Override
    public List<LeadInfo> getAllMyNotAcceptedLeads(String userid) {
        List<LeadDot> cl = leadDaoBeanGetter.get().getAllMyNotAcceptedLeadsQuery(userid);
        List<LeadInfo> out = new ArrayList<LeadInfo>();
        for(LeadDot x : cl){
            LeadInfo tmp  = new LeadInfo(x.leadid, x.name, x.type, x.managerid, x.clientid, x.status, x.isaccepted);
            out.add(tmp);
        }
        return out;
    }

    @Override
    public List<LeadInfo> getAllMyAcceptedLeads(String userid) {
        List<LeadDot> cl = leadDaoBeanGetter.get().getAllMyAcceptedLeadsQuery(userid);
        List<LeadInfo> out = new ArrayList<LeadInfo>();
        for(LeadDot x : cl){
            LeadInfo tmp  = new LeadInfo(x.leadid, x.name, x.type, x.managerid, x.clientid, x.status, x.isaccepted);
            out.add(tmp);
        }
        return out;
    }

    @Override
    public String stopLead(String leadid) {
        leadDaoBeanGetter.get().stopStatus(leadid);
        return "stopped";
    }

    @Override
    public String startLead(String leadid, String clientid){
        leadDaoBeanGetter.get().startStatus(leadid, clientid);
        return "started";
    }

    @Override
    public String acceptLead(String leadid) {
        leadDaoBeanGetter.get().acceptLeadQuery(leadid);
        LeadDot x = leadDaoBeanGetter.get().getLeadById(leadid);
        UserDot y = userDaoBeanGetter.get().getWholeSelect(x.managerid);
        if(x != null){
            Email email=new Email();
            email.setFrom(GCommonConstant.username);
            email.setTo(y.email);
            email.setSubject("Accept");
            email.setBody("Hey Bro, we accept your lead by ID: "+leadid);
            emailSender.get().send(email);
        }

        return "accepted";
    }

    @Override
    public String declineLead(String leadid) {
        leadDaoBeanGetter.get().declineLeadQuery(leadid);
        LeadDot x = leadDaoBeanGetter.get().getLeadById(leadid);
        UserDot y = userDaoBeanGetter.get().getWholeSelect(x.managerid);
        if(x != null){
            Email email=new Email();
            email.setFrom(GCommonConstant.username);
            email.setTo(y.email);
            email.setSubject("Decline");
            email.setBody("Hey Bro, we decline your lead by ID: "+leadid);
            emailSender.get().send(email);
        }
        return "declined";
    }

    @Override
    public List<LeadInfo> getAllNotMyAcceptedLeads(String clientid) {
        List<LeadDot> cl = leadDaoBeanGetter.get().getAllNotMyAcceptedLeads(clientid);
        List<LeadInfo> out = new ArrayList<LeadInfo>();
        for(LeadDot x : cl){
            LeadInfo tmp  = new LeadInfo(x.leadid, x.name, x.type, x.managerid, x.clientid, x.status, x.isaccepted);
            out.add(tmp);
        }
        System.out.println(clientid+" came here");
        return out;
    }

    @Override
    public List<LeadInfo> getAllMyActiveLeads(String clientid) {
        List<LeadDot> cl = leadDaoBeanGetter.get().getAllMyActiveLeads(clientid);
        List<LeadInfo> out = new ArrayList<LeadInfo>();
        for(LeadDot x : cl){
            LeadInfo tmp  = new LeadInfo(x.leadid, x.name, x.type, x.managerid, x.clientid, x.status, x.isaccepted);
            out.add(tmp);
        }
        System.out.println(clientid+" came here");
        return out;
//
    }

    @Override
    public List<LeadInfo> getAllNotAcceptedLeads() {
        List<LeadDot> cl = leadDaoBeanGetter.get().getAllNotAcceptedLeadsQuery();
        List<LeadInfo> out = new ArrayList<LeadInfo>();
        for(LeadDot x : cl){
            LeadInfo tmp  = new LeadInfo(x.leadid, x.name, x.type, x.managerid, x.clientid, x.status, x.isaccepted);
            out.add(tmp);
        }
        return out;
    }

    @Override
    public List<LeadInfo> getAllMyFinishedLeads(String clientid) {
        List<LeadDot> cl = leadDaoBeanGetter.get().getAllMyFinishedLeads(clientid);
        List<LeadInfo> out = new ArrayList<LeadInfo>();
        for(LeadDot x : cl){
            LeadInfo tmp  = new LeadInfo(x.leadid, x.name, x.type, x.managerid, x.clientid, x.status, x.isaccepted);
            out.add(tmp);
        }
        System.out.println(clientid+" came here");
        return out;
    }
}
