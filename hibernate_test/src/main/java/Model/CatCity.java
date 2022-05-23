package Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CatCity {

    @Id
    @Getter
    @Setter
    private String cityName;

    @OneToMany
    @Getter
    @Setter
    private List<CatHome> cityHomes;
}
