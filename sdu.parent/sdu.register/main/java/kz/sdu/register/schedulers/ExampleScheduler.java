package kz.sdu.register.schedulers;

import kz.greetgo.depinject.core.Bean;
import kz.greetgo.scheduling.HasScheduled;
import kz.greetgo.scheduling.Scheduled;

import java.io.File;
import java.io.IOException;

@Bean
public class ExampleScheduler implements HasScheduled {

    @Scheduled("repeat every 100 sec")
    public void example() throws IOException {
//        File parentFile;
//        File file = new File(""+System.getProperty("user.home") + "/sdu.d/" + System.currentTimeMillis());
//        parentFile = file.getParentFile();
//        if(!parentFile.exists()){
//            parentFile.mkdirs();
//        }
//        file.createNewFile();
        System.out.println("schedule running");
    }
}
