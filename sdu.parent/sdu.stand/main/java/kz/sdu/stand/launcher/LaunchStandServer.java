package kz.sdu.stand.launcher;

import kz.greetgo.depinject.Depinject;
import kz.greetgo.depinject.gen.DepinjectUtil;
import kz.sdu.stand.bean_containers.StandBeanContainer;
import kz.sdu.stand.util.Modules;

public class LaunchStandServer {
    public static void main(String[] args) throws Exception {

        new LaunchStandServer().run();
    }

    public void run() throws Exception {
        DepinjectUtil.implementAndUseBeanContainers("kz.sdu.stand",
                Modules.standDir() + "/build/src_bean_container");

        StandBeanContainer container = Depinject.newInstance(StandBeanContainer.class);
        container.standServer().start().join();
    }
}