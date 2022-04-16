package my.project.spring_configuration;

public class PetGreeter {
    private CatHome catHome;

    PetGreeter(CatHome catHome) {
            this.catHome = catHome;
    }

    public void greetAll() {
        for (Pet pet: catHome.petList)
            System.out.println(pet.greet());
    }
}
