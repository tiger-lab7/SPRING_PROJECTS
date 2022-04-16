package my.project.spring_configuration;

import java.util.Random;

public class CatOliver implements Pet {
    private Random random;

    public CatOliver(Random random) {
        this.random = random;
    }

    public String greet() {

        return random.nextBoolean()? "Hello, I am cat Oliver!" : "Meeew!";
    }
}
