package kz.sdu.server.app;

import kz.greetgo.depinject.core.BeanContainer;
import kz.greetgo.depinject.core.Include;
import kz.sdu.register.schedulers.MainScheduler;
import kz.sdu.server.beans.AppInitializer;

@Include(BeanConfigApplication.class)
public interface ApplicationBeanContainer extends BeanContainer {
  AppInitializer appInitializer();

  MainScheduler getMainScheduler();

}
