package Entities;

import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Phone")
@NoArgsConstructor
public class Phone {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private long id;

    @Column(name = "number")
    private String number;

    @ManyToMany (cascade = CascadeType.ALL, mappedBy = "phonesList", fetch = FetchType.LAZY)
    private List<Person> personList = new ArrayList<>();

    public Phone(String number, List<Person> personList) {
        this.number = number;
        this.personList = personList;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", number='" + number + '\'' +
                '}';
    }
}
