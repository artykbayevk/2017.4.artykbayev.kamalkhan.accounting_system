package kz.sdu.stand.register_stand_imlp.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserStandModel {
    public String surname;
    public String id;
    public String name;
    public String email;
    public String password;
    public String tel_number;
    public String age;
    public String companyId;
    public boolean isManager;
    public String regDate;

    public UserStandModel(String id, String surname, String name, String password, String age, String email, String tel_number, String companyId, boolean isManager){
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
    }

    public UserStandModel(){

    }
}