package kz.sdu.register.impl;

import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.depinject.testng.AbstractDepinjectTestNg;
import kz.greetgo.depinject.testng.ContainerConfig;
import kz.greetgo.util.RND;
import kz.sdu.controller.model.LeadInfo;
import kz.sdu.register.models.LeadDot;
import kz.sdu.register.test.dao.LeadTestDao;
import kz.sdu.register.test.util.BeanConfigMainPostgresTests;
import org.fest.assertions.api.Assertions;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

@ContainerConfig(BeanConfigMainPostgresTests.class)
public class LeadRegisterImplTest extends AbstractDepinjectTestNg{

    public BeanGetter<LeadRegisterImpl> leadRegisterBeanGetter;
    public BeanGetter<LeadTestDao> leadTestDaoBeanGetter;

    @Test
    public void testGetLeadById() throws Exception{
        String leadid = RND.intStr(30);
        String name = RND.str(30);
        String type = RND.str(30);
        String managerid = RND.intStr(30);
        String clientid = RND.intStr(30);
        String status = "none";
        String isaccepted = "false";


        leadTestDaoBeanGetter.get().insertIntoLead(leadid, name, type, managerid, clientid, status, isaccepted);

        LeadInfo x = leadRegisterBeanGetter.get().getLeadById(leadid);


        Assertions.assertThat(x).isNotNull();
        Assertions.assertThat(x.leadid).isEqualTo(leadid);
        Assertions.assertThat(x.name).isEqualTo(name);
        Assertions.assertThat(x.type).isEqualTo(type);
        Assertions.assertThat(x.managerid).isEqualTo(managerid);
        Assertions.assertThat(x.clientid).isEqualTo(clientid);
        Assertions.assertThat(x.status).isEqualTo(status);
        Assertions.assertThat(x.isaccepted).isEqualTo(isaccepted);

    }

    @Test
    public void testSaveLead() throws Exception {
        String leadid = RND.intStr(30);
        String name = "name";
        String type = "type";
        String managerid = "managerid";
        String clientid = "clientid";
        String status = "none";
        String isAccepted = "false";

        JSONObject jo = new JSONObject();
//        jo.put("leadid","519807632884744336625459662209");
        jo.put("leadid", "");
        jo.put("name", name);
        jo.put("type", type);
        jo.put("managerid", managerid);
        jo.put("clientid", clientid);
        jo.put("status", status);
        jo.put("isaccepted", isAccepted);

        String res = leadRegisterBeanGetter.get().saveLead(jo.toString());
        System.out.println(res);
//
//        LeadInfo x = leadRegisterBeanGetter.get().getLeadById(leadid);
//
//        Assertions.assertThat(x).isNotNull();
//        Assertions.assertThat(x.leadid).isEqualTo(leadid);
//        Assertions.assertThat(x.name).isEqualTo(name);
//        Assertions.assertThat(x.type).isEqualTo(type);
//        Assertions.assertThat(x.managerid).isEqualTo(managerid);
//        Assertions.assertThat(x.clientid).isEqualTo(clientid);
//        Assertions.assertThat(x.status).isEqualTo(status);
//        Assertions.assertThat(x.isaccepted).isEqualTo(isAccepted);


    }

    @Test
    public void testGetAllLeadList() throws Exception {
        String leadid = RND.intStr(30);
        String name = "name";
        String type = "type";
        String managerid = "managerid";
        String clientid = "clientid";
        String status = "none";
        String isaccepted = "false";
        leadTestDaoBeanGetter.get().insertIntoLead(leadid, name, type, managerid, clientid, status, isaccepted);

        List<LeadInfo> cl = leadRegisterBeanGetter.get().getAllLeadList();
        if(cl.size() == 0){
            System.out.println("null");
        }else{
            System.out.println("smth");
        }
        for (LeadInfo x : cl){
            System.out.println(x.clientid+' '+x.leadid + ' ' + x.managerid + ' '+ x.type);
        }
    }

    @Test
    public void testGetAllMyLeads() throws Exception {
        String leadid = RND.intStr(30);
        String name = "name";
        String type = "type";
        String managerid = "managerid";
        String clientid = "myclientid";
        String status = "none";
        String isaccepted = "false";
        leadTestDaoBeanGetter.get().insertIntoLead(leadid, name, type, managerid, clientid, status, isaccepted);

        List<LeadInfo> cl = leadRegisterBeanGetter.get().getAllMyLeads(managerid);
        if(cl.size() == 0){
            System.out.println("null");
        }else{
            System.out.println("smth");
        }


        for (LeadInfo x : cl){
            System.out.println(x.clientid+' '+x.leadid + ' ' + x.managerid + ' '+ x.type);
        }
    }

    @Test
    public void testGetAllMyNotAcceptedLeads() throws Exception {
        String leadid = RND.intStr(30);
        String name = "name";
        String type = "type";
        String managerid = "managerid";
        String clientid = "myclientid";
        String status = "none";
        String isaccepted = "false";
        leadTestDaoBeanGetter.get().insertIntoLead(leadid, name, type, managerid, clientid, status, isaccepted);

        List<LeadInfo> cl = leadRegisterBeanGetter.get().getAllMyNotAcceptedLeads(clientid);
        if(cl.size() == 0){
            System.out.println("null");
        }else{
            System.out.println("smth");
        }


        for (LeadInfo x : cl){
            System.out.println(x.clientid+' '+x.leadid + ' ' + x.managerid + ' '+ x.type);
        }
    }

    @Test
    public void testGetAllMyAcceptedLeads() throws Exception {
        String leadid = RND.intStr(30);
        String name = "name";
        String type = "type";
        String managerid = "managerid";
        String clientid = "myclientid";
        String status = "none";
        String isaccepted = "false";
        leadTestDaoBeanGetter.get().insertIntoLead(leadid, name, type, managerid, clientid, status, isaccepted);

        List<LeadInfo> cl = leadRegisterBeanGetter.get().getAllMyAcceptedLeads(clientid);
        if(cl.size() == 0){
            System.out.println("null");
        }else{
            System.out.println("smth");
        }


        for (LeadInfo x : cl){
            System.out.println(x.clientid+' '+x.leadid + ' ' + x.managerid + ' '+ x.type + ' ' + x.isaccepted);
        }
    }

    @Test
    public void testStopLead() throws Exception {
        String leadid = RND.intStr(30);
        String name = RND.str(30);
        String type = RND.str(30);
        String managerid = "managerid";
        String clientid = "clientid";
        String status = "started";
        String isaccepted = "false";
        leadTestDaoBeanGetter.get().insertIntoLead(leadid, name, type, managerid, clientid, status, isaccepted);

        String res = leadRegisterBeanGetter.get().stopLead(leadid);

        LeadInfo x = leadRegisterBeanGetter.get().getLeadById(leadid);

        System.out.println(x.status);

    }

    @Test
    public void testStartLead() throws Exception{
        String leadid = RND.intStr(30);
        String name = RND.str(30);
        String type = RND.str(30);
        String managerid = "managerid";
        String clientid = "clientid";
        String status = "none";
        String isaccepted = "false";
        leadTestDaoBeanGetter.get().insertIntoLead(leadid, name, type, managerid, "0", status, isaccepted);

        String res = leadRegisterBeanGetter.get().startLead(leadid, clientid);
        LeadInfo x = leadRegisterBeanGetter.get().getLeadById(leadid);

        System.out.println(x.status);
    }

    @Test
    public void testAcceptLead() throws Exception{
        String leadid = RND.intStr(30);
        String name = RND.str(30);
        String type = RND.str(30);
        String managerid = "managerid";
        String clientid = "clientid";
        String status = "none";
        String isaccepted = "false";
        leadTestDaoBeanGetter.get().insertIntoLead(leadid, name, type, managerid, "0", status, isaccepted);

        String res = leadRegisterBeanGetter.get().acceptLead(leadid);

        LeadInfo x = leadRegisterBeanGetter.get().getLeadById(leadid);

        System.out.println(res);
        System.out.println(x.isaccepted);
    }
}