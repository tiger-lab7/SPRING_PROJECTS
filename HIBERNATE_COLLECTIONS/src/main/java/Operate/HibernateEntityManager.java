package Operate;

import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateEntityManager {

    private EntityManagerFactory entityManagerFactory;

    public EntityManager getEntityManager() {
        if (entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory("my_jpa");
        }
        return entityManagerFactory.createEntityManager();
    }
}
