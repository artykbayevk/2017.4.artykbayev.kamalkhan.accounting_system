package kz.sdu.register.test.util;


import kz.greetgo.depinject.core.BeanConfig;
import kz.greetgo.depinject.core.Include;
import kz.sdu.register.beans.all.any_db.BeanConfigAnyDbAll;

@BeanConfig
@Include({BeanConfigAnyDbAll.class})
public class BeanConfigMainServerPostgresTest {
}
