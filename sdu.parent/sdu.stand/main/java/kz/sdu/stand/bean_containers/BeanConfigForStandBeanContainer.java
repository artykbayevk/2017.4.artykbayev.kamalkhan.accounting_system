package kz.sdu.stand.bean_containers;

import kz.greetgo.depinject.core.BeanConfig;
import kz.greetgo.depinject.core.BeanScanner;
import kz.greetgo.depinject.core.Include;
import kz.sdu.controller.controller.BeanConfigControllers;
import kz.sdu.stand.beans.BeanConfigStand;
import kz.sdu.stand.register_stand_imlp.BeanConfigRegisterStandImpl;

@BeanConfig
@BeanScanner
@Include({BeanConfigStand.class, BeanConfigControllers.class, BeanConfigRegisterStandImpl.class})
public class BeanConfigForStandBeanContainer {
}