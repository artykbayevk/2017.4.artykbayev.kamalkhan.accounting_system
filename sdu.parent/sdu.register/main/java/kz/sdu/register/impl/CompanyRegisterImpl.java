package kz.sdu.register.impl;

import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.email.Email;
import kz.greetgo.email.EmailSender;
import kz.greetgo.util.RND;
import kz.sdu.controller.model.CompanyInfo;
import kz.sdu.controller.register.CompanyRegister;
import kz.sdu.register.dao.CompanyDao;
import kz.sdu.register.models.CompanyDot;
import kz.sdu.register.util.GCommonConstant;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

@Bean
public class CompanyRegisterImpl implements CompanyRegister {

    public BeanGetter<CompanyDao> companyDaoBeanGetter;
    public BeanGetter<EmailSender> emailSender;

    @Override
    public CompanyInfo getCompanyById(String companyID){
        CompanyDot tmp = companyDaoBeanGetter.get().getCompanyById(companyID);
        CompanyInfo x = new CompanyInfo(tmp.companyid, tmp.name, tmp.telephone, tmp.email, tmp.isAccepted);
        return x;
    }

    @Override
    public List<CompanyInfo> getAllCompany(){
        List<CompanyInfo> x = new ArrayList<CompanyInfo>();
        List<CompanyDot> tmp = companyDaoBeanGetter.get().getAllCompanies();
        for (CompanyDot cl : tmp){
            CompanyInfo c = new CompanyInfo(cl.companyid, cl.name, cl.telephone, cl.email, cl.isAccepted);
            x.add(c);
        }
        return x;
    }

    @Override
    public List<CompanyInfo> getNotAcceptedCompany(){
        List<CompanyInfo> x = new ArrayList<CompanyInfo>();
        List<CompanyDot> tmp = companyDaoBeanGetter.get().getAllNotAcceptedCompanies();
        for (CompanyDot cl : tmp){
            CompanyInfo c = new CompanyInfo(cl.companyid, cl.name, cl.telephone, cl.email, cl.isAccepted);
            x.add(c);
        }
        return x;
    }

    @Override
    public String saveCompany(String input){

        JSONObject obj = new JSONObject(input);
        String companyid = obj.getString("companyid");
        String name = obj.getString("name");
        String telephone = obj.getString("telephone");
        String email = obj.getString("email");

        if(companyid.length() == 0){
            companyid = RND.intStr(30);
            companyDaoBeanGetter.get().insertIntoCompany(companyid, name, telephone, email, "false");
            System.out.println("Company added");
            return companyid;
        }else{
            companyDaoBeanGetter.get().updateCompanyById(companyid, name, telephone, email);
            System.out.println("Company updated");
            return "updated";
        }


    }

    @Override
    public String acceptCompany(String companyID){
        companyDaoBeanGetter.get().acceptCompanyQuery(companyID);
        CompanyDot x = companyDaoBeanGetter.get().getCompanyById(companyID);
        if(x != null){
            Email email=new Email();
            email.setFrom(GCommonConstant.username);
            email.setTo(x.email);
            email.setSubject("Accept");
            email.setBody("Hey Bro, we are accept your company.Your company ID: "+companyID);
            emailSender.get().send(email);
        }
        return "accepted";
    }

    @Override
    public String declineCompany(String companyID) {
        companyDaoBeanGetter.get().declineCompanyQuery(companyID);
        CompanyDot x = companyDaoBeanGetter.get().getCompanyById(companyID);
        if(x != null){
            Email email=new Email();
            email.setFrom(GCommonConstant.username);
            email.setTo(x.email);
            email.setSubject("Decline");
            email.setBody("Hey Bro, we are decline your company.");
            emailSender.get().send(email);
        }
        return "declined";
    }
}
