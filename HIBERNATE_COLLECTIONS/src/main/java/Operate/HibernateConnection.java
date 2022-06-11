package Operate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public enum HibernateConnection {
    INSTANCE;
    private SessionFactory sessionFactory;

    public Session getSession() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration(); // reading hibernate.properties
            configuration.configure(); // reading hibernate.cfg.xml
            sessionFactory = configuration.buildSessionFactory();
        }
        return sessionFactory.openSession();
    }
    public void closeSessionFactory() {
        if (sessionFactory != null && sessionFactory.isOpen())
            sessionFactory.close();
    }
}
