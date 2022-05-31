package Collections;

import Operate.HibernateConnection;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;
import org.hibernate.Session;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class HibernateMap {
    private static final String DATA_PATH = "src/main/resources/countries_data.json";

    @SneakyThrows
    public static void testHibernateMap() {

        List<Country> countries = readJsonData();

        Session session = HibernateConnection.INSTANCE.getSession();
        session.beginTransaction();
        countries.forEach(session::saveOrUpdate);
        session.getTransaction().commit();

        session.createQuery("from Country").list().forEach(System.out::println);

        //SimpleOperations.dropAllTables(session);

        session.close();
        HibernateConnection.INSTANCE.closeSessionFactory();
    }

    @SneakyThrows
    private static void writeJsonData(List<Country> countries) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(DATA_PATH), countries);
    }

    @SneakyThrows
    private static List<Country> readJsonData() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true);
        return Arrays.asList(objectMapper.readValue(new File(DATA_PATH), Country[].class));
    }
}

@Entity
@NoArgsConstructor
@Data
class Country {
    @Id
    private String name;

    @ElementCollection
    @CollectionTable(name = "cities")
    @MapKeyColumn(name = "city")
    @Column(name = "population")
    private Map<String, Long> citiesPopulation;

    @CollectionTable(name = "attraction_list")
    @OneToMany(fetch = FetchType.EAGER)
    @Column(name = "attraction")
    @Cascade(CascadeType.ALL)
    private List<Attraction> attractionsList;
}

@Entity
@NoArgsConstructor
@ToString
class Attraction {
    @Id
    @GeneratedValue
    private long id;

    @Column
    @Setter
    @Getter
    private String name;

    public Attraction(String name) {
        this.name = name;
    }
}


