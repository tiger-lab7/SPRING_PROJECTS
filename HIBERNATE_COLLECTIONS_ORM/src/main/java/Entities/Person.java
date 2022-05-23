package Entities;

import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity(name = "Person")
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private long id;

    @ManyToMany (cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Phone> phonesList = new ArrayList<>();

    public Person(List<Phone> phonesList) {
        this.phonesList = phonesList;
    };

    public List<Phone> getPhonesList() {
        return phonesList;
    }

    public void setPhonesList(List<Phone> phonesList) {
        this.phonesList = phonesList;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", phonesList=" + phonesList +
                '}';
    }
}


