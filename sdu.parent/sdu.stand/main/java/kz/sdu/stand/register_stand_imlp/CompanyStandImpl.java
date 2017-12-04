package kz.sdu.stand.register_stand_imlp;

import kz.greetgo.depinject.core.Bean;
import kz.sdu.controller.model.CompanyInfo;
import kz.sdu.controller.register.CompanyRegister;

import java.util.List;

@Bean
public class CompanyStandImpl implements CompanyRegister{

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
    public String saveCompany(String input){return null;}

    @Override
    public String acceptCompany(String companyID){
        return null;
    }

    @Override
    public String declineCompany(String companyID) {
        return null;
    }
}
