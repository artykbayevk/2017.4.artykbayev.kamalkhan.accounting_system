package kz.sdu.stand.register_stand_imlp.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserStandModel {
    public String id;
    public String surname;
    public String name;
    public String email;
    public String password;
    public String tel_number;
    public String age;
    public String companyId;
    public boolean isManager;
    public String regDate;
    public boolean isAccepted;
    public boolean isAdmin;

    public UserStandModel(String id, String surname, String name, String password, String age, String email, String tel_number, String companyId, boolean isManager, boolean isAccepted, boolean isAdmin){
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.age = age;
        this.password = password;
        this.email = email;
        this.tel_number = tel_number;
        this.companyId = companyId;
        this.isManager = isManager;
        this.regDate = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        this.isAccepted = isAccepted;
        this.isAdmin = isAdmin;
    }

    public UserStandModel(){

    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public void setAccepted(boolean accepted) {
        isAccepted = accepted;
    }
}
