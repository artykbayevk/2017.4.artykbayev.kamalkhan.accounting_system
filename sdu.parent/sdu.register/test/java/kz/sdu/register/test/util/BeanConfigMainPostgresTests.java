package kz.sdu.register.test.util;

import kz.greetgo.depinject.core.BeanConfig;
import kz.greetgo.depinject.core.Include;
import kz.sdu.register.beans.all.postgres.BeanConfigAllPostgres;

@BeanConfig
@Include({BeanConfigAllPostgres.class})
public class BeanConfigMainPostgresTests {
}
