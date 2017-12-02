package kz.sdu.register.impl;

import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.sdu.controller.model.CompanyInfo;
import kz.sdu.controller.register.CompanyRegister;
import kz.sdu.register.dao.CompanyDao;
import kz.sdu.register.models.CompanyDot;

import java.util.ArrayList;
import java.util.List;

@Bean
public class CompanyRegisterImpl implements CompanyRegister {

    public BeanGetter<CompanyDao> companyDaoBeanGetter;

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
    public String updateCompany(String companyID,String name, String telephone, String email){
        companyDaoBeanGetter.get().updateCompanyById(companyID, name, telephone, email);
        return "updated";
    }

    @Override
    public String acceptCompany(String companyID){
        companyDaoBeanGetter.get().acceptCompanyQuery(companyID);
        return "accepted";
    }
}
