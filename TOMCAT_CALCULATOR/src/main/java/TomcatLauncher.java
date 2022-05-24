import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.Wrapper;
import org.apache.catalina.startup.Tomcat;

public class TomcatLauncher {


        public static void main(String[] args) throws LifecycleException {
            Tomcat tomcat = new Tomcat();
            tomcat.setPort(8085);
            tomcat.getConnector();

            Context ctx = tomcat.addContext("", null);

            Wrapper servletFirst = Tomcat.addServlet(ctx, "myServlet", new HelloServlet());
            servletFirst.setLoadOnStartup(1);
            servletFirst.addMapping("/");

            Wrapper servletAnother = Tomcat.addServlet(ctx, "anotherServlet", new AnotherServlet());
            servletAnother.setLoadOnStartup(1);
            servletAnother.addMapping("/another");

            tomcat.start();
        }

}
