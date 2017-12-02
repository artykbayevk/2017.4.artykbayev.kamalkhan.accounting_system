package kz.sdu.register.impl;

import kz.greetgo.depinject.core.Bean;
import kz.sdu.controller.model.CompanyInfo;
import kz.sdu.controller.register.CompanyRegister;

import java.util.List;

@Bean
public class CompanyRegisterImpl implements CompanyRegister {

    @Override
    public CompanyInfo getCompanyById(String companyID){
        return null;
    }
    @Override
    public List<CompanyInfo> getAllCompany(){
        return null;
    }

    @Override
    public List<CompanyInfo> getNotAcceptedCompany(){
        return null;
    }

    @Override
    public String updateCompany(String name, String telephone, String email){
        return null;
    }

    @Override
    public String acceptCompany(String companyID){
        return null;
    }
}
