package Collections;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@ToString
public class Attraction {
    @Id
    @GeneratedValue
    @Setter
    @Getter
    private long id;

    @Column
    @Setter
    @Getter
    private String name;
}
