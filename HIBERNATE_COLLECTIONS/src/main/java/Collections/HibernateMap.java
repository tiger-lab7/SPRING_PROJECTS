package Collections;

import Operate.HibernateConnection;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.Session;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

public class HibernateMap {

    public static void testHibernateMap() {
        Country usa = new Country("USA", Map.of(
                "New York", 8622357L,
                "Los Angeles", 4085014L,
                "Chicago", 2670406L));
        Country australia = new Country("Australia", Map.of(
                "Sydney", 4627345L,
                "Melbourne", 4246375L,
                "Brisbane", 2189878L));
        Country indonesia = new Country("Indonesia", Map.of(
                "Jakarta", 8540121L,
                "Surabaya", 2374658L,
                "Medan", 1750971L));
        List<Country> countries = List.of(usa, australia, indonesia);

        Session session = HibernateConnection.getSession();
        session.beginTransaction();
        countries.forEach(session::saveOrUpdate);
        session.getTransaction().commit();

        session.createQuery("from Country").list().forEach(System.out::println);

        session.close();

        HibernateConnection.closeSessionFactory();
    }

}

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
class Country {
    @Id
    private String name;

    @ElementCollection
    @CollectionTable(name = "cities")
    @MapKeyColumn(name = "city")
    @Column(name = "population")
    protected Map<String, Long> citiesPopulation;
}


