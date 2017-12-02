package kz.sdu.controller.model;

public class LeadInfo {
    public String leadid;
    public String name;
    public String type;
    public String managerid;
    public String clientid;
    public String status;
    public String isaccepted;

    public LeadInfo(String leadid, String name, String type, String managerid, String clientid, String status, String isaccepted) {
        this.leadid = leadid;
        this.name = name;
        this.type = type;
        this.managerid = managerid;
        this.clientid = clientid;
        this.status = status;
        this.isaccepted = isaccepted;
    }

    public LeadInfo() {
    }
}
