package kz.sdu.stand.register_stand_imlp;

import kz.greetgo.conf.hot.DefaultBoolValue;
import kz.greetgo.conf.hot.DefaultIntValue;
import kz.greetgo.conf.hot.DefaultStrValue;
import kz.greetgo.conf.hot.Description;


@Description("Параметры доступа к Gmail аккаунту")
public interface MyConfig {

    @DefaultStrValue("crm.kamalkhan@gmail.com")
    @Description("Логин Аккаунта")
    String loginAccount();


    @DefaultStrValue("Systemofadown12")
    @Description("Пароль Аккаунта")
    String accountPassword();


    @DefaultBoolValue(false)
    @Description("Нужно ли отправлять Email?")
    boolean needToSendEmail();

    @DefaultIntValue(10)
    @Description("Дни для хранения почты")
    int getEmailSaveDays();

}
