package kz.sdu.register.config;


import kz.greetgo.conf.hot.DefaultStrValue;
import kz.greetgo.conf.hot.Description;

@Description("Параметры доступа к БД (используется только БД Postgresql)")
public interface DbConfig {

  @Description("URL доступа к БД")
  @DefaultStrValue("jdbc:postgresql://localhost:5432/postgres")
  String url();

  @Description("Пользователь для доступа к БД")
  @DefaultStrValue("patrick")
  String username();

  @Description("Пароль для доступа к БД")
  @DefaultStrValue("qwerty12")
  String password();

  @DefaultStrValue("crm.kamalkhan@gmail.com")
  @Description("Логин Аккаунта")
  String loginAccount();


  @DefaultStrValue("Systemofadown12")
  @Description("Пароль Аккаунта")
  String accountPassword();
}
