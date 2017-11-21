package kz.sdu.register.config;


import kz.greetgo.conf.hot.DefaultStrValue;
import kz.greetgo.conf.hot.Description;

@Description("Параметры доступа к БД (используется только БД Postgresql)")
public interface DbConfig {

  @Description("URL доступа к БД")
  @DefaultStrValue("jdbc:postgres:localhost:5432/postgres")
  String url();

  @Description("Пользователь для доступа к БД")
  @DefaultStrValue("test")
  String username();

  @Description("Пароль для доступа к БД")
  @DefaultStrValue("test")
  String password();
}
