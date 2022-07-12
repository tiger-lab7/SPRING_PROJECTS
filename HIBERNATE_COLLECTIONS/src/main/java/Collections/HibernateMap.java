package Collections;

import Operate.HibernateConnection;
import Operate.SimpleOperations;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;
import org.hibernate.Session;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.io.File;
import java.util.List;
import java.util.Map;

public class HibernateMap {
    private static final String DATA_PATH = "src/main/resources/countries_data.json";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows
    public static void testHibernateMap() {
        //SimpleOperations.dropAllTables();

        List<Country> countries = readJsonData();

        Session session = HibernateConnection.INSTANCE.getSession();
        session.beginTransaction();

        countries.forEach(session::saveOrUpdate);

        session.getTransaction().commit();

        session.createQuery("from Country").list().forEach(System.out::println);



        session.close();
        HibernateConnection.INSTANCE.closeSessionFactory();
    }

    @SneakyThrows
    private static void writeJsonData(List<Country> countries) {
        objectMapper.writeValue(new File(DATA_PATH), countries);
    }

    @SneakyThrows
    private static List<Country> readJsonData() {
        return objectMapper.readValue(new File(DATA_PATH), new TypeReference<>() {
        });
    }
}

@Entity // обязательная аннотация сущности Hibernate
@NoArgsConstructor // Требуется для Hibernate
@Getter
@Setter
@ToString
class Country {
    @Id // Обязательная аннотация первичного ключа
    private String name;


    @CollectionTable(name = "cities") // Создание таблицы с именем cities для содержимого Map
    @ElementCollection // Аннотация для элементов "примитивных" коллекций
    @MapKeyColumn(name = "city") // Имя левой колонки ссылок в таблице для Map
    @Column(name = "population") // Имя правой колонки ссылок
    private Map<String, Long> citiesPopulation;

    @CollectionTable(name = "attraction_list")
    @OneToMany(fetch = FetchType.LAZY) // Содержимое списка будет загружно при необходимости отдельным sql-запросом
    @Column(name = "attractions") // Имя колонки ссылок
    @Cascade(CascadeType.ALL) // Изменение, удаление объектов коллекции зависит от объекта Country
    @ToString.Exclude // Аннотация Lombok для печати списка
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
}


