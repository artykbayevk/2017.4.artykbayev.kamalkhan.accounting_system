package kz.sdu.register.impl;

import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.depinject.testng.AbstractDepinjectTestNg;
import kz.greetgo.depinject.testng.ContainerConfig;
import kz.sdu.controller.register.SendEmailRegister;
import kz.sdu.register.test.util.BeanConfigMainPostgresTests;
import org.testng.annotations.Test;

@ContainerConfig(BeanConfigMainPostgresTests.class)
public class SendEmailRegisterImplTest extends AbstractDepinjectTestNg{

  public BeanGetter<SendEmailRegister> sendEmailRegister;

  @Test
  public void testToSend() throws Exception {
    sendEmailRegister.get().toSend();
  }

  @Test
  public void testPrepareEmail() throws Exception {
    sendEmailRegister.get().prepareSendEmail();
  }

}