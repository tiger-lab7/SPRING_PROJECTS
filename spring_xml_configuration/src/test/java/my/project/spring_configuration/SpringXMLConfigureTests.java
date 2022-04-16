package my.project.spring_configuration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

// Not works, context configuration needed
@SpringBootTest("/applicationContext.xml")
class SpringXMLConfigureTests {

    @Autowired
    private ApplicationContext context;

    @Test
    void contextLoads() {
        CatOliver pet = context.getBean(CatOliver.class);
        Assertions.assertTrue(pet.greet().endsWith("CatOliver Clinic!"));
    }

}
