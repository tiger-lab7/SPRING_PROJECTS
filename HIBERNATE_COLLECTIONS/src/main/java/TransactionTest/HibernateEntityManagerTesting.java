package TransactionTest;

import Operate.HibernateEntityManager;
import lombok.ToString;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import javax.persistence.*;

public class HibernateEntityManagerTesting {
    private static final Logger logger = LogManager.getLogger(HibernateEntityManagerTesting.class);

    public static void main(String[] args) {
        logger.info("Start application");

        MyClass object1 = new MyClass();
        object1.name = "CAT BARSIK";

       /* Session session = HibernateConnection.INSTANCE.getSession();

        session.beginTransaction();
        //session.saveOrUpdate(object1);
        //object1.name = "CAT OLIVER";
        session.getTransaction().commit();

        session.createQuery("from MyClass").list().forEach(logger::info);
        session.close();*/

        EntityManager entityManager = HibernateEntityManager.INSTANCE.getEntityManager();
        entityManager.persist(object1);
        entityManager.close();


    }
}

@Entity
@ToString
class MyClass {

    @Id
    @GeneratedValue
    long id;

    @Column(nullable = false, length = 30)
    String name;
}
