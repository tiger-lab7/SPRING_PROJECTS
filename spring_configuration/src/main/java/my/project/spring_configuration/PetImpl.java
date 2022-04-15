package my.project.spring_configuration;

import java.util.Random;

public class PetImpl implements Pet {
    private Random random;

    public PetImpl(Random random) {
        this.random = random;
    }

    public String greet() {
        return random.nextBoolean()? "Hello, I am cat!" : "Hello, I am dog!";
    }
}
