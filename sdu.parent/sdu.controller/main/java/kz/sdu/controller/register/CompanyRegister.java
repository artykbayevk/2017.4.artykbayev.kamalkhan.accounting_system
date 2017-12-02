package kz.sdu.controller.register;

import kz.sdu.controller.model.CompanyInfo;

import java.util.List;

public interface CompanyRegister {

    CompanyInfo getCompanyById(String companyID);
    List<CompanyInfo> getAllCompany();
    List<CompanyInfo> getNotAcceptedCompany();
    String updateCompany(String name, String telephone, String email);
    String acceptCompany(String companyID);

}
