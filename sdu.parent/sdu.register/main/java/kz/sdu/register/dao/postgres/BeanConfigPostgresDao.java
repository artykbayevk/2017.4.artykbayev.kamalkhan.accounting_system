package kz.sdu.register.dao.postgres;

import kz.greetgo.depinject.core.BeanConfig;
import kz.greetgo.depinject.core.BeanScanner;
import kz.sdu.register.beans.all.any_db.DaoImplFactory;

@BeanScanner
@BeanConfig(defaultFactoryClass = DaoImplFactory.class)
public class BeanConfigPostgresDao {}
