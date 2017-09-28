package kz.sdu.stand.register_stand_impl;

import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.education.controller.model.IntroductionInfo;
import kz.greetgo.education.controller.register.IntroductionRegister;
import kz.greetgo.education.stand.register_stand_impl.db.Db;

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