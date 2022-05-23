import Entities.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;


public class Main {

    public static void main(String[] args) {

        HibernateSessionProvider hibernateSessionProvider =
                new HibernateSessionProvider(HibernateConfigLoadVariant.XMLConfig);

        SessionFactory sessionFactory = hibernateSessionProvider.getHibernateSession();
        Session session = sessionFactory.openSession();
        System.out.println("Session created");


        Customer customer = new Customer();
        customer.setFirstName("Joshua");
        customer.setLastName("Bloch");
        customer.setContactNumber("+7-177-78-87-44");

        session.beginTransaction();
        session.save(customer);
        session.getTransaction().commit();

        Query<Customer> query = session.createQuery("From Entities.Customer", Customer.class);

        List<Customer> resultList = query.list();

        System.out.println("Total customers amount " + resultList.size());
        for(Customer cs : resultList) {
            System.out.println("customer: " + cs);
        }

        session.close();
        sessionFactory.close();

    }
}



