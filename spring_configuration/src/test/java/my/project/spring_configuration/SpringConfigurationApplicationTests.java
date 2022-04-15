package my.project.spring_configuration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

// Not works, context configuration needed
@SpringBootTest("/applicationContext.xml")
class SpringConfigurationApplicationTests {

    @Autowired
    private ApplicationContext context;

    @Test
    void contextLoads() {
        PetImpl pet = context.getBean(PetImpl.class);
        Assertions.assertTrue(pet.greet().endsWith("PetImpl Clinic!"));
    }

}
