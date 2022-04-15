package my.project.spring_configuration;

public class PetGreeter {
    private PetClinic petClinic;

    PetGreeter(PetClinic petClinic) {
            this.petClinic = petClinic;
    }

    public void greetAll() {
        for (Pet pet: petClinic.petList)
            System.out.println(pet.greet());
    }
}
