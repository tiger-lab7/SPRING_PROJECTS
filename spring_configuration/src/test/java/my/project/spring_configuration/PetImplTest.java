package my.project.spring_configuration;

import org.junit.*;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@ContextConfiguration("/applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class PetImplTest {

    @Autowired
    private ApplicationContext context;

    @Test
    public void testSpring() {
        Pet pet = context.getBean(PetImpl.class);
        Assertions.assertTrue(pet.greet().startsWith("Hello"));
    }

    @Test
    public  void testPetClinic() {
        PetClinic petClinic = (PetClinic) context.getBean("PetClinic");
        Assertions.assertEquals("My Pet Clinic", petClinic.clinicName);
    }
}

