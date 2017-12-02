package kz.sdu.register.models;

public class CompanyDot {
    public String companyid;
    public String name;
    public String telephone;
    public String email;
    public String isAccepted;
    public CompanyDot(String companyid, String name, String telephone, String email, String isAccepted) {
        this.companyid = companyid;
        this.name = name;
        this.telephone = telephone;
        this.email = email;
        this.isAccepted = isAccepted;
    }

    public CompanyDot() {
    }
}
