package kz.sdu.stand.register_stand_imlp.scheduler;

import kz.greetgo.conf.hot.HotConfigFactory;
import kz.greetgo.depinject.core.Bean;

@Bean
public class MyConfigFactory extends HotConfigFactory {

    @Bean
    public MyConfig getMyConfig(){
        return createConfig(MyConfig.class);
    }

    @Override
    protected String getBaseDir(){
        return System.getProperty("user.home")+"/sdu.d";
    }
}
