package Operate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConnection {
    private static SessionFactory sessionFactory;

    public static Session getSession() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();
            configuration.configure();
            sessionFactory = configuration.buildSessionFactory();
        }
        return sessionFactory.openSession();
    }
    public static void closeSessionFactory() {
        if (sessionFactory != null && sessionFactory.isOpen())
            sessionFactory.close();
    }
}
