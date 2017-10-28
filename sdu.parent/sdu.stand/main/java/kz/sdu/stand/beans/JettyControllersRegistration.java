package kz.sdu.stand.beans;

import com.google.common.collect.Lists;
import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.sdu.controller.utils.Controller;
import kz.sdu.stand.util.WebAppContextRegistration;
import kz.greetgo.mvc.JettyWarServlet;
import kz.greetgo.mvc.interfaces.TunnelExecutorGetter;
import kz.greetgo.mvc.interfaces.Views;
import org.eclipse.jetty.webapp.WebAppContext;

import java.util.List;

@Bean
public class JettyControllersRegistration extends JettyWarServlet implements WebAppContextRegistration {

    public BeanGetter<List<Controller>> controllerList;

    @Override
    protected List<Object> getControllerList() {
        return Lists.newArrayList(controllerList.get());
    }

    public BeanGetter<Views> views;

    @Override
    protected Views getViews() {
        return views.get();
    }

    @Override
    protected void afterRegistered() {
        System.err.println("[WebAppContext] --------------------------------------");
        System.err.println("[WebAppContext] -- USING CONTROLLERS:");
        for (TunnelExecutorGetter teg : tunnelExecutorGetters) {
            System.err.println("[WebAppContext] -- " + teg.infoStr());
        }
        System.err.println("[WebAppContext] --------------------------------------");
        printRegistration();
    }

    @Override
    protected String mappingBase() {
        return "/api/*";
    }

    @Override
    protected String getTargetSubContext() {
        return "/api";
    }

    @Override
    public double priority() {
        return 0;
    }
}