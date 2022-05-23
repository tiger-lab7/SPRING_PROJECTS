import Entities.Person;
import Entities.Phone;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(Entities.Person.class);
        configuration.addAnnotatedClass(Entities.Phone.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.openSession();

        //session.beginTransaction();
        /*Query query = session.createQuery("delete Entities.Person");
        query.executeUpdate();
        query = session.createQuery("delete Entities.Phone");
        query.executeUpdate();*/
        //Query query = session.createSQLQuery("DROP TABLE phone CASCADE");
        //query.executeUpdate();
        //session.getTransaction().commit();


        Person person0 = new Person();
        Phone phone1 = new Phone("6596565345", List.of(person0));
        Person person1 = new Person(List.of(phone1));
        Phone phone2 = new Phone("7989898797", List.of(person1));
        Phone phone3 = new Phone("35345345345", List.of(person1));
        Phone phone4 = new Phone("2342342423", List.of(person1));
        person0.setPhonesList(List.of(phone2, phone3, phone4));

        session.beginTransaction();
        session.save(person0);
        session.save(person1);
        session.getTransaction().commit();


        session.beginTransaction();
        List result = session.createQuery("from Person").list();
        for(Person p : (List<Person>)result){
            System.out.println(p);
        }
        session.getTransaction().commit();

        session.close();
        sessionFactory.close();
    }
}
