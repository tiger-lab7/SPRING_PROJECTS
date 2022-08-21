package spring.com.Repository;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cats")
@NoArgsConstructor
@Getter
@Setter
public class Cat {
    @Id
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private int type;
}
