package kz.sdu.register.beans.all.any_db;

import kz.greetgo.depinject.core.BeanConfig;
import kz.greetgo.depinject.core.BeanScanner;
import kz.greetgo.depinject.core.Include;
import kz.sdu.register.impl.BeanConfigRegisterServerImpl;

@BeanConfig
@BeanScanner
@Include({BeanConfigRegisterServerImpl.class})
public class BeanConfigAnyDbAll {
}
