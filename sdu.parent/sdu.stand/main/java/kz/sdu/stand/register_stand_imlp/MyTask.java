package kz.sdu.stand.register_stand_imlp;

import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.email.EmailSenderController;
import kz.greetgo.scheduling.FromConfig;
import kz.greetgo.scheduling.HasScheduled;
import kz.greetgo.scheduling.Scheduled;

import java.io.File;
import java.io.IOException;

@Bean
public class MyTask implements HasScheduled{

    public BeanGetter<EmailSenderController> emailSenderControllerBeanGetter;

    @FromConfig("Параметры запуска таска по файлам")
    @Scheduled("repeat every 90 sec after pause in 30 sec")
    public void doAJob() throws IOException {
//        File parentFile;
//        File file = new File(""+System.getProperty("user.home") + "/education.d/" + System.currentTimeMillis());
//        parentFile = file.getParentFile();
//        if(!parentFile.exists()){
//            parentFile.mkdirs();
//        }
//        file.createNewFile();

        emailSenderControllerBeanGetter.get().sendAllExistingEmails();
    }

    @Scheduled("23:00")
    public void task2(){
        //Nothing for check
    }
}
