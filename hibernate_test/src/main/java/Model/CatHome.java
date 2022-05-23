package Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CatHome {
    
    @Id
    @Getter
    @Setter
    private long apartamentNo;

    @OneToOne
    @Getter
    @Setter
    private Cat cat;
}
