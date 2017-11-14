package kz.sdu.stand.bean_containers;

import kz.greetgo.depinject.core.BeanContainer;
import kz.greetgo.depinject.core.Include;
import kz.sdu.stand.beans.StandServer;
import kz.sdu.stand.register_stand_imlp.scheduler.MainScheduler;
import kz.sdu.stand.register_stand_imlp.scheduler.MyConfig;
import kz.sdu.stand.register_stand_imlp.scheduler.MyTask;

@Include(BeanConfigForStandBeanContainer.class)
public interface StandBeanContainer extends BeanContainer {
    StandServer standServer();

    MyConfig myConfig();

    MainScheduler getMainScheduler();

    MyTask myTask();
}