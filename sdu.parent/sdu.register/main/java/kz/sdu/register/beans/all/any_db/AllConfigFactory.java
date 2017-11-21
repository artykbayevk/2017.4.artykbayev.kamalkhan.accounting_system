package kz.sdu.register.beans.all.any_db;

import kz.greetgo.depinject.core.Bean;
import kz.sdu.register.config.DbConfig;
import kz.sdu.register.util.LocalConfigFactory;

@Bean
public class AllConfigFactory extends LocalConfigFactory {

  @Bean
  public DbConfig createPostgresDbConfig() {
    return createConfig(DbConfig.class);
  }

}
