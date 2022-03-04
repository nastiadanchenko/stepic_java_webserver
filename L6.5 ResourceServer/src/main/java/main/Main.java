package main;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import resourceServer.ResourceServer;
import resourceServer.ResourceServerController;
import resourceServer.ResourceServerControllerMBean;
import resourceServer.ResourceServerImpl;
import servlet.ResourceServlet;

import javax.management.*;
import java.lang.management.ManagementFactory;

public class Main {
    public static void main(String[] args) throws Exception {

        ResourceServer resourceServer = new ResourceServerImpl();

        ResourceServerControllerMBean serverControllerMBean = new ResourceServerController(resourceServer);
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName name = new ObjectName("Admin:type=ResourceServerController");
        mbs.registerMBean(serverControllerMBean, name);

        Server server = new Server(8080);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(new ResourceServlet(resourceServer)), ResourceServlet.PAGE_URL);

        server.setHandler(context);

        server.start();
        context.getLogger().info("Server started");
        server.join();

    }
}
