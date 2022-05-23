import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;

public class ClearComputerDB {

    public static void main(String[] args) {

        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(Computer.class);
        configuration.addAnnotatedClass(Processor.class);
        configuration.addAnnotatedClass(ComputerOrder.class);
            SessionFactory sessionFactory = configuration.buildSessionFactory();
                Session session = sessionFactory.openSession();
                    Transaction transaction = session.beginTransaction();
                        Query query = session.createQuery("delete ComputerOrder");
                        query.executeUpdate();
                    transaction.commit();
                session.close();
        sessionFactory.close();

    }
}
