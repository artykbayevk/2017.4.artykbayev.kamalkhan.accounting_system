package kz.sdu.register.impl;
import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.depinject.testng.AbstractDepinjectTestNg;
import kz.greetgo.depinject.testng.ContainerConfig;
import kz.greetgo.util.RND;
import kz.sdu.controller.model.CompanyInfo;
import kz.sdu.register.models.CompanyDot;
import kz.sdu.register.test.dao.CompanyTestDao;
import kz.sdu.register.test.util.BeanConfigMainPostgresTests;
import org.fest.assertions.api.Assertions;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

@ContainerConfig(BeanConfigMainPostgresTests.class)
public class CompanyRegisterImplTest extends AbstractDepinjectTestNg {

    public BeanGetter<CompanyTestDao> testDaoBeanGetter;
    public BeanGetter<CompanyRegisterImpl> companyRegisterBeanGetter;
    @Test
    public void testGetCompanyById() throws Exception {
        String compID = RND.intStr(30);
        String name = RND.str(30);
        String email = RND.str(30);
        String telephone = RND.str(30);

        testDaoBeanGetter.get().insertIntoCompany(compID, name, telephone, email, "false");

        CompanyInfo x = companyRegisterBeanGetter.get().getCompanyById(compID);
        System.out.println(x.companyid);
        System.out.println(x.name);
        System.out.println(x.email);
        System.out.println(x.telephone);

        Assertions.assertThat(x).isNotNull();
        Assertions.assertThat(x.companyid).isEqualTo(compID);
        Assertions.assertThat(x.name).isEqualTo(name);
        Assertions.assertThat(x.email).isEqualTo(email);
        Assertions.assertThat(x.telephone).isEqualTo(telephone);

    }

    @Test
    public void testGetAllCompany() throws Exception {
        List<CompanyInfo> cl = companyRegisterBeanGetter.get().getAllCompany();
        for (CompanyInfo x : cl){
            System.out.println(x.name + ' '+ x.companyid);
        }
    }

    @Test
    public void testGetNotAcceptedCompany() throws Exception {
        List<CompanyInfo> cl = companyRegisterBeanGetter.get().getNotAcceptedCompany();
        if(cl!=null){
            for (CompanyInfo x : cl){
                System.out.println(x.name + ' '+ x.companyid);
            }
        }else{
            System.out.println("nothing");
        }

    }

    @Test
    public void testUpdateCompany() throws Exception {
        String compID = RND.intStr(30);
        String name = RND.str(30);
        String email = RND.str(30);
        String telephone = RND.str(30);

        testDaoBeanGetter.get().insertIntoCompany(compID, name, telephone, email, "false");


        CompanyDot x = testDaoBeanGetter.get().getCompanyById(compID);
//
        Assertions.assertThat(x).isNotNull();
        Assertions.assertThat(x.companyid).isEqualTo(compID);
        Assertions.assertThat(x.name).isEqualTo(name);
        Assertions.assertThat(x.telephone).isEqualTo(telephone);
        Assertions.assertThat(x.email).isEqualTo(email);



        name = RND.str(30);
        email = RND.str(30);
        telephone = RND.str(30);


        JSONObject jo = new JSONObject();
        jo.put("companyid", compID);
//        jo.put("companyid", "");
        jo.put("name", name);
        jo.put("email",email);
        jo.put("telephone", telephone);

        String res = companyRegisterBeanGetter.get().saveCompany(jo.toString());
        System.out.println(res);
        x = testDaoBeanGetter.get().getCompanyById(compID);
        Assertions.assertThat(x.companyid).isEqualTo(compID);
        System.out.println(x.companyid);
        Assertions.assertThat(x.name).isEqualTo(name);
        Assertions.assertThat(x.telephone).isEqualTo(telephone);
        Assertions.assertThat(x.email).isEqualTo(email);
    }

    @Test
    public void testAcceptCompany() throws Exception {
        String compID = RND.intStr(30);
        String name = RND.str(30);
        String email = RND.str(30);
        String telephone = RND.str(30);

        testDaoBeanGetter.get().insertIntoCompany(compID, name, telephone, email, "false");

        String res = companyRegisterBeanGetter.get().acceptCompany(compID);

        System.out.println(res);
        CompanyDot x = testDaoBeanGetter.get().getCompanyById(compID);
        Assertions.assertThat(x).isNotNull();
        Assertions.assertThat(x.isAccepted).isEqualTo("true");

    }

}