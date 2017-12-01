package kz.sdu.register.models;

public class CompanyDot {
    public String companyid;
    public String name;
    public String telephone;
    public String email;

    public CompanyDot(String companyid, String name, String telephone, String email) {
        this.companyid = companyid;
        this.name = name;
        this.telephone = telephone;
        this.email = email;
    }

    public CompanyDot() {
    }
}
