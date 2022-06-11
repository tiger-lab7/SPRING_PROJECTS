package TransactionTest;

import Operate.HibernateConnection;
import lombok.ToString;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class HibernateTransactionTest {
    private static final Logger logger = LogManager.getLogger(HibernateTransactionTest.class);

    public static void main(String[] args) {
        logger.info("Start application");

        MyClass object1 = new MyClass();
        object1.name = "CAT BARSIK";

        Session session = HibernateConnection.INSTANCE.getSession();

        session.beginTransaction();
        //session.saveOrUpdate(object1);
        //object1.name = "CAT OLIVER";
        session.getTransaction().commit();

        session.createQuery("from MyClass").list().forEach(System.out::println);
        session.close();
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
