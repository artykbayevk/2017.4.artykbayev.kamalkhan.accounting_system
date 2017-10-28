package kz.sdu.stand.register_stand_imlp.model;

public class PersonDot {
    public String id;
    public String accountName;
    public boolean disabled= false;
    public String surname, name, patronymic;

    public PersonDot(String id,String accountName) {
        this.id = id;
        this.accountName=accountName;
    }
}
