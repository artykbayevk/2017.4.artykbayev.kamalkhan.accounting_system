package kz.sdu.register.models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserDot {
    public String userid;
    public String name;
    public String surname;
    public String email;
    public String password;
    public String telephone;
    public String age;
    public String companyId;
    public String regDate;
    public boolean isaccepted;
    public boolean ismanager;
    public boolean isadmin;

    public UserDot(String userid, String surname, String name, String password, String age, String email, String tel_number, String companyId, boolean isManager, boolean isAccepted, boolean isAdmin){
        this.userid = userid;
        this.surname = surname;
        this.name = name;
        this.age = age;
        this.password = password;
        this.email = email;
        this.telephone = tel_number;
        this.companyId = companyId;
        this.ismanager = isManager;
        this.regDate = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        this.isaccepted = isAccepted;
        this.isadmin = isAdmin;
    }

    public UserDot(){

    }

    public boolean isAccepted() {
        return isaccepted;
    }

    public void setAccepted(boolean accepted) {
        isaccepted = accepted;
    }
}
