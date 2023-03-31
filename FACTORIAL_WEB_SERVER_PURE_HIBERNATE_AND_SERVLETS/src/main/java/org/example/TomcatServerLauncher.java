package org.example;

import org.apache.catalina.Context;
import org.apache.catalina.Wrapper;
import org.apache.catalina.startup.Tomcat;
import org.example.Servlets.StopperServlet;
import org.example.Servlets.WebFactorialCounter;

public class TomcatServerLauncher {
    public static void main(String[] args) {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        tomcat.getConnector(); // Must be!
        Context context = tomcat.addContext("", null);

        WebFactorialCounter webFactorialCounter = new WebFactorialCounter();
        Wrapper firstServlet = Tomcat.addServlet(context, "webFactorialCounter", webFactorialCounter);
        firstServlet.setLoadOnStartup(1);
        firstServlet.addMapping("/fact");

        Wrapper stopServlet = Tomcat.addServlet(context, "stopServlet", new StopperServlet(webFactorialCounter));
        stopServlet.setLoadOnStartup(1);
        stopServlet.addMapping("/stop");

        try { // Do not delegate exception throwing to method main, because it broke main class signature!
            tomcat.start();
        } catch (Exception ex) {ex.printStackTrace();}
    }
}