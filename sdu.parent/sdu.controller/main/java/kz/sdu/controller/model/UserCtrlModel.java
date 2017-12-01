package kz.sdu.controller.model;



public class UserCtrlModel {
    public String surname;
    public String id;
    public String name;
    public String email;
    public String password;
    public String tel_number;
    public String age;
    public String companyId;
    public boolean isManager;
    public boolean isAdmin;

    public UserCtrlModel(String id, String surname, String name, String password, String age, String email, String tel_number, String companyId, boolean isManager, boolean
                          isAdmin){
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.age = age;
        this.email = email;
        this.tel_number = tel_number;
        this.companyId = companyId;
        this.isManager = isManager;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public UserCtrlModel(){

    }
}
