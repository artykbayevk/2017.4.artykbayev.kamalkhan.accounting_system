package kz.sdu.register.impl;

import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.depinject.testng.AbstractDepinjectTestNg;
import kz.greetgo.depinject.testng.ContainerConfig;
import kz.greetgo.depinject.testng.DepinjectTestNg;
import kz.sdu.controller.register.SendEmailRegister;
import kz.sdu.register.test.util.BeanConfigMainServerPostgresTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;


@ContainerConfig(BeanConfigMainServerPostgresTest.class)
public class SendEmailRegisterImplTest extends AbstractDepinjectTestNg{

    public BeanGetter<SendEmailRegister> sendEmailRegister;

    @Test
    public void testToSend() throws Exception {
        sendEmailRegister.get().toSend();
    }

    @Test
    public void testPrepareSendEmail() throws Exception {
        sendEmailRegister.get().prepareSendEmail();
    }

}