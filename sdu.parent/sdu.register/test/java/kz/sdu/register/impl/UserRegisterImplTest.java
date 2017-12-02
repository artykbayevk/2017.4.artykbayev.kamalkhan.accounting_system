package kz.sdu.register.impl;

import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.depinject.testng.AbstractDepinjectTestNg;
import kz.greetgo.depinject.testng.ContainerConfig;
import kz.greetgo.util.RND;
import kz.sdu.controller.model.AuthInfo;
import kz.sdu.controller.model.UserCtrlModel;
import kz.sdu.controller.register.UserRegister;
import kz.sdu.register.test.dao.CompanyTestDao;
import kz.sdu.register.test.dao.UserTestDao;
import kz.sdu.register.test.util.BeanConfigMainPostgresTests;
import org.fest.assertions.api.Assertions;
import org.json.JSONObject;
import org.testng.annotations.Test;
import java.util.List;

@ContainerConfig(BeanConfigMainPostgresTests.class)
public class UserRegisterImplTest extends AbstractDepinjectTestNg{

    public BeanGetter<UserTestDao> userTestDaoBeanGetter;
    public BeanGetter<UserRegister> userRegisterBeanGetter;
    public BeanGetter<CompanyTestDao> companyTestDaoBeanGetter;

    @Test
    public void testGetUsersList(){
        List<UserCtrlModel> cl = userRegisterBeanGetter.get().getUsersList();
        for (UserCtrlModel x:cl) {
            System.out.println(x.name + ':' + x.surname);
        }
    }

    @Test
    public void testGetNotAcceptedUsersList(){
        List<UserCtrlModel> cl = userRegisterBeanGetter.get().getNotAcceptedUsersList();
        if(cl != null){
            for (UserCtrlModel x:cl) {
                System.out.println(x.name + ':' + x.surname + ':' + x.email);
            }
        }else{
            System.out.println("null");
        }
    }

    @Test
    public void testAuthUser() throws  Exception{
        String userid= RND.intStr(15);
        String name = RND.str(30);
        String surname = RND.str(30);
        String email = RND.str(30);
        String password = RND.str(30);
        String telephone = RND.str(30);
        String age = RND.str(30);
        String companyid = RND.str(30);
        String isaccepted = "true";
        String isadmin = "false";
        String ismanager = "false";
        userTestDaoBeanGetter.get().insertPerson(userid, name, surname, email, password, telephone, age, companyid, isaccepted, isadmin, ismanager);

        JSONObject jo = new JSONObject();
        jo.put("email", email);
        jo.put("password", password);
        AuthInfo x = userRegisterBeanGetter.get().authUser(jo.toString());
        System.out.println(x.personId);
        System.out.println(x.token);
    }

    @Test
    public void testGetWholeUserInfo() throws Exception {
        String userid= RND.intStr(15);
        String name = RND.str(30);
        String surname = RND.str(30);
        String email = RND.str(30);
        String password = RND.str(30);
        String telephone = RND.str(30);
        String age = RND.str(30);
        String companyid = RND.str(30);
        String isaccepted = "false";
        String isadmin = "false";
        String ismanager = "false";
        userTestDaoBeanGetter.get().insertPerson(userid, name, surname, email, password, telephone, age, companyid, isaccepted, isadmin, ismanager);

        UserCtrlModel x = userRegisterBeanGetter.get().getWholeUserInfo(userid);


        System.out.println(x.isAdmin);
        System.out.println(x.isManager);

        Assertions.assertThat(x).isNotNull();
        Assertions.assertThat(x.id).isEqualTo(userid);
        Assertions.assertThat(x.name).isEqualTo(name);
        Assertions.assertThat(x.surname).isEqualTo(surname);
        Assertions.assertThat(x.email).isEqualTo(email);
        Assertions.assertThat(x.password).isEqualTo(password);
        Assertions.assertThat(x.tel_number).isEqualTo(telephone);
        Assertions.assertThat(x.age).isEqualTo(age);
        Assertions.assertThat(x.companyId).isEqualTo(companyid);
        Assertions.assertThat(x.isAdmin).isEqualTo(false);
        Assertions.assertThat(x.isManager).isEqualTo(false);





        userTestDaoBeanGetter.get().deleteUser(userid);
    }

    @Test
    public void testRegisterUser() throws Exception {


        String userid= RND.intStr(15);
        String name = RND.str(30);
        String surname = RND.str(30);
        String email = RND.str(30);
        String password = RND.str(30);
        String telephone = RND.str(30);
        String age = RND.str(30);
        String companyid = RND.str(30);


//        companyTestDaoBeanGetter.get().insertIntoCompany(companyid, name, telephone, email);

        JSONObject jo = new JSONObject();
        jo.put("id", userid);
        jo.put("name", name);
        jo.put("surname", surname);
        jo.put("email",email);
        jo.put("password",password);
        jo.put("telephone", telephone);
        jo.put("age",age);
        jo.put("companyId",companyid);
//        jo.put("companyId","824280833506907100897200929422");
//        jo.put("companyId","554014646149592020495124675967");
        jo.put("isManager", "1");

        String res = userRegisterBeanGetter.get().registerUser(jo.toString());
        System.out.println(res);
//        userTestDaoBeanGetter.get().deleteUser(userid);

    }

    @Test
    public void testGetUserInfo() throws Exception {}

    @Test
    public void testCheckUser() throws Exception {}

    @Test
    public void testAcceptUser() throws Exception {
        String uuid = RND.intStr(30);
        String out = userRegisterBeanGetter.get().acceptUser(uuid);
        String check = userTestDaoBeanGetter.get().getUserIdFromAccept(out);
        Assertions.assertThat(out).isNotNull();
        Assertions.assertThat(check).isNotNull();
        Assertions.assertThat(uuid).isEqualTo(check);
    }
}