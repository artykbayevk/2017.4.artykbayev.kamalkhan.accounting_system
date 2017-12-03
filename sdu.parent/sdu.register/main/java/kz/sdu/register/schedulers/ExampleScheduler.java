package kz.sdu.register.schedulers;

import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.email.EmailSenderController;
import kz.greetgo.scheduling.HasScheduled;
import kz.greetgo.scheduling.Scheduled;

import java.io.File;
import java.io.IOException;

@Bean
public class ExampleScheduler implements HasScheduled {

    public BeanGetter<EmailSenderController> emailSenderControllerBeanGetter;

    @Scheduled("repeat every 200 sec")
    public void example() throws IOException {
//        File parentFile;
//        File file = new File(""+System.getProperty("user.home") + "/sdu.d/" + System.currentTimeMillis());
//        parentFile = file.getParentFile();
//        if(!parentFile.exists()){
//            parentFile.mkdirs();
//        }
//        file.createNewFile();

        emailSenderControllerBeanGetter.get().sendAllExistingEmails();
        System.out.println("schedule running and email sent");
    }
}
