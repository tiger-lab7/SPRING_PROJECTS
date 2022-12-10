package org.hiber;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class HibernateNativeSQLQuery {

    public static void main(String... args) {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(ResultRow.class);

        try(SessionFactory sf = configuration.buildSessionFactory(); Session session = sf.openSession()) {
            List<ResultRow> resultList =
                    session.createNativeQuery("SELECT passenger_name, COUNT(*) FROM tickets GROUP BY passenger_name", ResultRow.class)
                            .list();

            resultList.forEach(System.out::println);
        }

    }
}

@Entity
@Getter
@Setter
@ToString
class ResultRow {
    @Id
    String passenger_name;
    int count;
}
