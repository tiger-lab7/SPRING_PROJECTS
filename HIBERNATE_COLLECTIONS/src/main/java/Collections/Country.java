package Collections;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Entity // обязательная аннотация сущности Hibernate
@NoArgsConstructor // Требуется для Hibernate
@Getter
@Setter
@ToString
public class Country {
    @Id // Обязательная аннотация первичного ключа
    private String name;


    @CollectionTable(name = "cities") // Создание таблицы с именем cities для содержимого Map
    @ElementCollection // Аннотация для элементов "примитивных" коллекций
    @MapKeyColumn(name = "city") // Имя колонки в таблице для ключей Map
    @Column(name = "population") // Имя колонки в таблице для значений Map
    private Map<String, Long> citiesPopulation;

    @CollectionTable(name = "attraction_list") // Имя промежуточной таблицы ссылок на таблицы country и attraction
    @OneToMany(fetch = FetchType.LAZY) // Содержимое списка будет загружно при необходимости отдельным sql-запросом
    @Cascade(org.hibernate.annotations.CascadeType.ALL) // Изменение, удаление объектов коллекции каскадно зависит от объекта сountry
    @ToString.Exclude // Аннотация Lombok для печати списка
    private List<Attraction> attractionsList;
}