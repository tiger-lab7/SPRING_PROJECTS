package my.project.spring_configuration;

import java.util.LinkedList;
import java.util.List;

public class PetClinic {
    public String clinicName;

    List<Pet> petList = new LinkedList<>();

    PetClinic(Pet pet) {
        petList.add(pet);
    }

    public void setClinicName(String clinicName) {
        this.clinicName = clinicName;
    }
}
