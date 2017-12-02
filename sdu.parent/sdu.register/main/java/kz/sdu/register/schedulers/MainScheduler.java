package kz.sdu.register.schedulers;


import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.scheduling.*;

import java.util.List;

@Bean
public class MainScheduler {
    public BeanGetter<List<HasScheduled>> scheduleBeanList;

    private Scheduler scheduler = null;

    public void startSchedulers(){
        if(scheduler != null) return ;

        String configDir = System.getProperty("user.home")+"/sdu.d/schedule";

        TaskCollector taskCollector = new TaskCollector(configDir);

        for (HasScheduled scheduleBean: scheduleBeanList.get()){
            taskCollector.collect(scheduleBean);
        }

        List<Task> tasks = taskCollector.getTasks();

        scheduler = new Scheduler(tasks, ExecutionPool.poolsForTasks(tasks));

        scheduler.startup();
    }
}
