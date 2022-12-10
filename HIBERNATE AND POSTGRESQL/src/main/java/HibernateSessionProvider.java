import Entities.Customer;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateSessionProvider {
    private static SessionFactory sessionFactory;
    private static HibernateConfigLoadVariant hclv;

    public HibernateSessionProvider(HibernateConfigLoadVariant hclv) {
        HibernateSessionProvider.hclv = hclv;
    }

    public SessionFactory getHibernateSession() {
        if (sessionFactory == null) {
            switch (hclv) {
                case XMLConfig:
                    return configHibernateByXML();

                case JavaConfig:
                    return configHibernateByJava();
            }
            throw new RuntimeException("Wrong configuration constant");
        }
        return sessionFactory;
    }

    private SessionFactory configHibernateByXML() {
        Configuration cfg = new Configuration()
                .configure("hibernate.cfg.xml");

        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();

        return cfg.buildSessionFactory(standardServiceRegistry);
    }


    private SessionFactory configHibernateByJava() {
            try {
                // Hibernate settings equivalent to hibernate.cfg.xml's properties
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "org.postgresql.Driver");
                settings.put(Environment.URL, "jdbc:postgresql://localhost:5432/postgres");
                settings.put(Environment.USER, "postgres");
                settings.put(Environment.PASS, "password");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQL82Dialect");

                settings.put(Environment.SHOW_SQL, "true");
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                settings.put(Environment.HBM2DDL_AUTO, "update"); // update, create-drop, create, drop

                Configuration configuration = new Configuration();
                configuration.setProperties(settings);

                configuration.addAnnotatedClass(Customer.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        return sessionFactory;
    }
}
