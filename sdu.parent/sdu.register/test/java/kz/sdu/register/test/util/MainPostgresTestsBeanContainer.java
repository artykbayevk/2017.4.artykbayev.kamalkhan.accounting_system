package kz.sdu.register.test.util;

import kz.greetgo.depinject.core.BeanContainer;
import kz.greetgo.depinject.core.Include;


@Include(BeanConfigMainPostgresTests.class)
public interface MainPostgresTestsBeanContainer extends BeanContainer{}
