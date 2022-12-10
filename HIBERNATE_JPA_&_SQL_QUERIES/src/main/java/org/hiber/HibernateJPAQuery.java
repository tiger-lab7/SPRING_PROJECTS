package org.hiber;

import org.hiber.Entities.Ticket;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HibernateJPAQuery {
    public static void main(String... args) {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(Ticket.class);

        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            Query<Ticket> query = session.createQuery("from Ticket", Ticket.class);
            Map<String, List<Ticket>> passengerTickets =
                    query.getResultStream()
                            .collect(Collectors.groupingBy(Ticket::getPassenger_name));

            passengerTickets.forEach((k,v) -> {System.out.println(k + " " + v.size() + " " + v.get(0));});
        }
    }
}