package kz.sdu.register.beans.all.postgres;

import kz.greetgo.depinject.core.BeanConfig;
import kz.greetgo.depinject.core.BeanScanner;
import kz.greetgo.depinject.core.Include;
import kz.sdu.register.beans.all.any_db.BeanConfigAll;

@BeanConfig
@BeanScanner
@Include({BeanConfigAll.class})
public class BeanConfigAllPostgres {
}
