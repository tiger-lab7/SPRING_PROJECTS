package my.project.spring_configuration;

import java.util.LinkedList;
import java.util.List;

public class CatHome {
    public String homeName;

    List<Pet> petList = new LinkedList<>();

    CatHome(Pet pet) {
        petList.add(pet);
    }

    public void setHomeName(String homeName) {
        this.homeName = homeName;
    }
}
