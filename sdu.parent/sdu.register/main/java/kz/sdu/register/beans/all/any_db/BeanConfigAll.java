package kz.sdu.register.beans.all.any_db;

import kz.greetgo.depinject.core.BeanConfig;
import kz.greetgo.depinject.core.BeanScanner;
import kz.greetgo.depinject.core.Include;
import kz.sdu.controller.controller.BeanConfigControllers;
import kz.sdu.register.impl.BeanConfigRegisterImpl;

@BeanConfig
@BeanScanner
@Include({BeanConfigRegisterImpl.class, BeanConfigControllers.class})
public class BeanConfigAll {
}
