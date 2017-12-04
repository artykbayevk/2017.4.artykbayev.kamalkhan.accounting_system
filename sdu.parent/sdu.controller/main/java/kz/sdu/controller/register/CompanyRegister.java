package kz.sdu.controller.register;

import kz.sdu.controller.model.CompanyInfo;

import java.util.List;

public interface CompanyRegister {

    CompanyInfo getCompanyById(String companyID);
    List<CompanyInfo> getAllCompany();
    List<CompanyInfo> getNotAcceptedCompany();
    String saveCompany(String input);
    String acceptCompany(String companyID);
    String declineCompany(String companyID);

}
