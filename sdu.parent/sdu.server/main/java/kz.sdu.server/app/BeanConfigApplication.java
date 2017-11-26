package kz.sdu.server.app;

import kz.greetgo.depinject.core.BeanConfig;
import kz.greetgo.depinject.core.Include;
import kz.sdu.register.beans.all.postgres.BeanConfigAllPostgres;
import kz.sdu.register.dao.postgres.BeanConfigPostgresDao;
import kz.sdu.server.beans.BeanConfigServer;

@BeanConfig
@Include({BeanConfigServer.class, BeanConfigAllPostgres.class, BeanConfigPostgresDao.class})
public class BeanConfigApplication {}
