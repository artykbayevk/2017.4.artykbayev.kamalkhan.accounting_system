package kz.sdu.stand.register_stand_imlp;

import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.sdu.controller.errors.RestError;
import kz.sdu.controller.model.AuthInfo;
import kz.sdu.controller.register.AuthRegister;
import kz.sdu.stand.register_stand_imlp.db.Db;
import kz.sdu.stand.register_stand_imlp.model.PersonDot;

@Bean
public class AuthRegisterStandImpl implements AuthRegister {
    public BeanGetter<Db> db;
    @Override
    public AuthInfo getAuthInfo(String accountName, String password) {{
        if (!"111".equals(password)) {
            throw new RestError(470, "Пароль 111");
        }

        AuthInfo ret=new AuthInfo();

        StringBuilder err = new StringBuilder();
        err.append("Use one of: ");

        for (PersonDot personDot : db.get().personStorage.values()) {
            if (!personDot.disabled) err.append(personDot.accountName).append(", ");
            if (accountName == null) continue;
            if (accountName.equals(personDot.accountName)) {
                if (personDot.disabled) throw new RestError(470, "Account " + accountName + " is disabled");
                ret.token="token:personId=" + personDot.id;
                ret.personId=personDot.id;
                return ret;
            }
        }

        err.setLength(err.length() - 2);

        throw new RestError(470, err.toString());
    }
    }
}
