package kz.sdu.register.test.util;

import kz.greetgo.depinject.Depinject;
import kz.greetgo.depinject.NoImplementor;
import kz.greetgo.depinject.gen.DepinjectUtil;

import java.util.Date;

public class MainPostgresTestBeanContainerCreator {
  public static MainPostgresTestsBeanContainer create(){
    try {
      return Depinject.newInstance(MainPostgresTestsBeanContainer.class);
    }catch (NoImplementor ignore){
      try {
        DepinjectUtil.implementAndUseBeanContainers("kz.sdu.register.test",
            "build/create/recreate_src/"+new Date().getTime());
      } catch (Exception e) {
        throw new RuntimeException(e);
      }

      return Depinject.newInstance(MainPostgresTestsBeanContainer.class);
    }
  }
}
