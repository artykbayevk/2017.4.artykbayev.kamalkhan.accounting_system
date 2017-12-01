package kz.sdu.register.impl;

import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.depinject.testng.AbstractDepinjectTestNg;
import kz.greetgo.depinject.testng.ContainerConfig;
import kz.greetgo.util.RND;
import kz.sdu.controller.model.UserCtrlModel;
import kz.sdu.controller.register.UserRegister;
import kz.sdu.register.test.dao.UserTestDao;
import kz.sdu.register.test.util.BeanConfigMainPostgresTests;
import org.fest.assertions.api.Assertions;
import org.testng.annotations.Test;

@ContainerConfig(BeanConfigMainPostgresTests.class)
public class UserRegisterImplTest extends AbstractDepinjectTestNg{

    public BeanGetter<UserTestDao> userTestDaoBeanGetter;
    public BeanGetter<UserRegister> userRegisterBeanGetter;


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
    public void testGetUserInfo() throws Exception {
    }

    @Test
    public void testRegisterUser() throws Exception {
    }

    @Test
    public void testCheckUser() throws Exception {
    }

    @Test
    public void testAcceptUser() throws Exception {
    }

}