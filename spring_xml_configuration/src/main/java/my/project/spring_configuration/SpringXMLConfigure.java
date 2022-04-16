package my.project.spring_configuration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringXMLConfigure {

    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("/applicationContext.xml");
        PetGreeter petGreeter = context.getBean(PetGreeter.class);

        petGreeter.greetAll();
    }
}
