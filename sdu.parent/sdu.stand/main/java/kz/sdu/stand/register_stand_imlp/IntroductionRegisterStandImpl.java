package kz.sdu.stand.register_stand_imlp;

import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.sdu.controller.model.IntroductionInfo;
import kz.sdu.controller.register.IntroductionRegister;
import kz.sdu.stand.register_stand_imlp.db.*;

@Bean
public class IntroductionRegisterStandImpl implements IntroductionRegister {

    public BeanGetter<Db> db;

    @Override
    public IntroductionInfo getIntroductionInfo() {
        IntroductionInfo introductionInfo = new IntroductionInfo();
        introductionInfo.introductionText = db.get().introductionText;
        return introductionInfo;
    }

}