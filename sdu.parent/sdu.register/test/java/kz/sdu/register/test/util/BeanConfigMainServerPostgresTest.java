package kz.sdu.register.test.util;


import kz.greetgo.depinject.core.BeanConfig;
import kz.greetgo.depinject.core.Include;
import kz.sdu.register.beans.all.any_db.BeanConfigAll;

@BeanConfig
@Include({BeanConfigAll.class})
public class BeanConfigMainServerPostgresTest {
}
