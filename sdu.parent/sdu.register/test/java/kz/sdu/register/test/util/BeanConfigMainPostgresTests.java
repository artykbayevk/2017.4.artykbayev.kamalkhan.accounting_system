package kz.sdu.register.test.util;

import kz.greetgo.depinject.core.BeanConfig;
import kz.greetgo.depinject.core.Include;
import kz.sdu.register.beans.all.postgres.BeanConfigAllPostgres;
import kz.sdu.register.dao.postgres.BeanConfigPostgresDao;
import kz.sdu.register.test.dao.postgres.BeanTestConfigPostgresDao;

@BeanConfig
@Include({BeanConfigAllPostgres.class,BeanConfigPostgresDao.class, BeanTestConfigPostgresDao.class})
public class BeanConfigMainPostgresTests {
}
