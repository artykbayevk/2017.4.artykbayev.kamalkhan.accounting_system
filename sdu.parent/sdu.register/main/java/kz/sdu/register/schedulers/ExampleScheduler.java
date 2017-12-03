package kz.sdu.register.schedulers;

import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.email.EmailSenderController;
import kz.greetgo.scheduling.HasScheduled;
import kz.greetgo.scheduling.Scheduled;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;

@Bean
public class ExampleScheduler implements HasScheduled {

    public BeanGetter<EmailSenderController> emailSenderControllerBeanGetter;
    private static Logger LOG = Logger.getLogger(ExampleScheduler.class);


    @Scheduled("repeat every 200 sec")
    public void example() throws IOException {
//        File parentFile;
//        File file = new File(""+System.getProperty("user.home") + "/sdu.d/" + System.currentTimeMillis());
//        parentFile = file.getParentFile();
//        if(!parentFile.exists()){
//            parentFile.mkdirs();
//        }
//        file.createNewFile();

        LOG.info("[SCHEDULED__001] НАЧАЛО ПРОЦЕССА ОТПРАВКИ ПИСЬМА");
        emailSenderControllerBeanGetter.get().sendAllExistingEmails();
        LOG.info("[SCHEDULED__002] КОНЕЦ ПРОЦЕССА ОТПРАВКИ ПИСЬМА");
        System.out.println("schedule running and email sent");
    }
}
